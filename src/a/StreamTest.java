package a;

import a.HumanGenerator;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;



public class StreamTest {


    public static void main(String[] args) {
 //      first();
//        second();
 //      third();
        //       fouth();;
//        five();
 //       six();
        seven();

    }

    public static void seven() {
        HumanGenerator hg = new HumanGenerator();
        Collection<Human> humans1 = hg.generate(5);
        Collection<Human> humans2 = hg.generate(5);

        List<Collection<Human>> humans= new ArrayList<>();
        humans.add(humans1);
        humans.add(humans2);

        humans.stream()
                .flatMap(Collection::stream)
                .peek(System.out::println)
                .filter(h -> h.getSalary() > 1000)
                .collect(Collectors.toList());


    }

    public static void six(){
        HumanGenerator hg = new HumanGenerator();
        Collection<Human> humans = hg.generate(30);


        double asDouble = humans.stream()
                .peek(System.out::println)
                .mapToLong(h -> h.getSalary())
                .average()
                .getAsDouble();

        System.out.println(asDouble);

    }

    public  static void five() {

        HumanGenerator hg = new HumanGenerator();
        Collection<Human> humans = hg.generate(30);

        Optional<String> res = humans.stream()
                .peek(System.out::println)
                .filter(StreamTest::check)
                .sorted((h1, h2) -> h2.getSalary() - h1.getSalary())
                .map(h -> h.getSalary() + "- " + h.getName())
                .distinct()
                .skip(0)
                .limit(1)
                .findFirst();
        System.out.println("res.isPresent() = " + res.isPresent());
        System.out.println("res.get() = " + res.get());


        System.out.println(res);


    }

    public static boolean check(Human h){
        return h.getSalary() >1000;
    }

    public  static void fouth() {

        HumanGenerator hg = new HumanGenerator();
        Collection<Human> humans = hg.generate(30);

        long res = humans.stream()
                .filter(h -> h.getSalary() > 1000)
                .peek(h -> h.setlName("Goga"))
                .count();


            System.out.println(res);


    }
    public  static void third(){
        HumanGenerator hg = new HumanGenerator();
        Collection<Human> humans = hg.generate(30);

        List<Human> res = humans.stream()
                .filter(h -> h.getSalary() > 1000)
                .filter(h -> h.getSalary() < 1500)
                .filter(h -> h.getName().toLowerCase().startsWith("i"))
                .collect(Collectors.toList());

        for (Human h: res) {
            System.out.println(h);

        }
    }
    public  static void second(){
        HumanGenerator hg = new HumanGenerator();
        Collection<Human> humans = hg.generate(30);

        List<String> res = humans.stream()
                .filter(h -> h.getSalary() > 1000)
                .filter(h -> h.getSalary() < 1500)
                .filter(h -> h.getName().toLowerCase().startsWith("i"))
                .map(h -> h.getSalary() + "- " + h.getName())
                .collect(Collectors.toList());

        for (String h: res) {
            System.out.println(h);

        }
    }
    public  static void first(){
        HumanGenerator hg = new HumanGenerator();
        Collection<Human> humans = hg.generate(10);

        List<Human> collect= humans.stream()
                .filter((h ->h.getSalary() > 800))
                .collect(Collectors.toList());




   }
}

