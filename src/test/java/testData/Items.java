package testData;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Items {
    Set<String> items = new HashSet<>();

    public Items(){
       items.add(" Кафе на краю земли. Возвращение в кафе");
       items.add("Открытка \"Люксовой малышке\"");
       items.add("Массажный мяч (6 см)");
    }

    public String getRandomItem() {
        int size = items.size();
        int itemIndex = new Random().nextInt(size);
        return items.stream().skip(itemIndex).findFirst().orElse(null);
    }
}
