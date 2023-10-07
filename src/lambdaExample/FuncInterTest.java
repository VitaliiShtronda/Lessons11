package lambdaExample;

import a.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FuncInterTest {

    public static void main(String[] args) {

        List<Human> h1 = new ArrayList<>();
        Function<Human, Integer> function = new Function<>() {

            @Override
            public Integer apply(Human h) {

                return h.getSalary();
            }
        };

        BiFunction<Human, Human, Integer> function2 = (Human h, Human b) -> {


                return h.getSalary();
            };

        BiFunction<Human, Human, Integer> function3 = (h, b) -> {


            return h.getSalary();
        };
        Function<Human, Integer> function4 = h -> {


            return h.getSalary();
        };

        Function<Human, Integer> function5 = h -> h.getSalary();


        Human human = new Human("a", "b", 1000);
        Integer salary = function.apply(human);
        System.out.println(salary);
    }
}
