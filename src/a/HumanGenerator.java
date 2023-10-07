package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class HumanGenerator {
    public Collection<Human> generate(int count) {
        Random random = new Random();
        List<String> firstNames = List.of("Iva", "Ivan", "Ivor", "Igor", "Vova", "Dmytro");
        List<String> lastNames = List.of("Ivanish", "Ivanosh", "Ivorevich", "Igorvich", "Vovanov", "Dmytrovich");

        Collection<Human> resalt = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String fName = firstNames.get(random.nextInt(firstNames.size()));
            String lName = lastNames.get(random.nextInt(lastNames.size()));

            int salary = 600 + random.nextInt(2001);
            resalt.add(new Human(fName, lName, salary));

         }
       return resalt;
    }
}
