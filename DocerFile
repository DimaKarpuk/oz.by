FROM openjdk:17-jdk-slim
COPY build.gradle /oz.by/build.gradle
WORKDIR /oz.by
RUN ./gradlew build --no-daemon || true
COPY src /oz.by/src
RUN mkdir /app/build/allure-results
RUN apt-get update && apt-get install -y wget gnupg2
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
RUN apt-get update && apt-get install -y google-chrome-stable
RUN wget -qO- https://dl.bintray.com/qameta/generic/io/qameta/allure/allure/2.13.6/allure-2.13.6.tgz | tar -xz -C /opt/
ENV PATH="/opt/allure-2.13.6/bin:${PATH}"
CMD ["gradle", "clean", "test", "allureReport"]