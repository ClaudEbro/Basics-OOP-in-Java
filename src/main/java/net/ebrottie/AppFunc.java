package net.ebrottie;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppFunc {
    public static void main(String[] args) {

        //A function which receives a parameter and returns nothing.
        Consumer<String> consumer= System.out::println;
        consumer.accept("Hello"); //We can use it by its method accept().


        Supplier<String> supplier=()-> { // A function which hasn't a parameter but returns something.
            return "Claude";
        };
        System.out.println(supplier.get()); //We can use it by its method get().


        Function<Integer, Integer> function=a->a*7; //A function which has 2 parameters.
        System.out.println(function.apply(9));

    }
}
