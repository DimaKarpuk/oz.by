# Используем базовый образ с предустановленным Gradle и JDK 11
FROM gradle:6.7-jdk11

# Создаем каталог /usr/src/app в контейнере
RUN mkdir -p /usr/src/app

# Задаем рабочую директорию
WORKDIR /usr/src/app

# Копируем все файлы в директорию
COPY . /usr/src/app

# Устанавливаем права на выполнение для gradlew
RUN chmod +x ./gradlew

# Выполняем команду сборки и тестирования с помощью Gradle
CMD ["./gradlew", "clean", "test"]





