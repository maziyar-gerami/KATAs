package explain;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * ============================================================
 * Functional Interfaces in Java (JDK 21)
 * ============================================================
 *
 * This single file demonstrates the most commonly used
 * Functional Interfaces in Java.
 *
 * Run this file and read the comments while following the output.
 */
public class FunctionalInterfacesDemo {

    public static void main(String[] args) {

        System.out.println("========== Supplier ==========");

        /*
         * Supplier<T>
         *
         * Purpose:
         * Produces a value without receiving any input.
         *
         * Method:
         * T get()
         *
         * Input:
         * None
         *
         * Output:
         * T
         *
         * Real-world analogy:
         * A coffee vending machine.
         */

        Supplier<String> supplier = () -> "Fresh Coffee";
        System.out.println(supplier.get());


        System.out.println("\n========== Consumer ==========");

        /*
         * Consumer<T>
         *
         * Purpose:
         * Consumes a value.
         *
         * Method:
         * void accept(T value)
         *
         * Input:
         * T
         *
         * Output:
         * Nothing
         *
         * Real-world analogy:
         * A printer receives a document and prints it.
         */

        Consumer<String> consumer = message ->
                System.out.println("Printing: " + message);

        consumer.accept("Hello Functional Interfaces");


        System.out.println("\n========== Function ==========");

        /*
         * Function<T,R>
         *
         * Purpose:
         * Converts one object into another.
         *
         * Method:
         * R apply(T value)
         */

        Function<String, Integer> length = String::length;

        System.out.println(length.apply("Java"));


        System.out.println("\n========== BiFunction ==========");

        /*
         * BiFunction<T,U,R>
         *
         * Accepts two inputs and returns one result.
         */

        BiFunction<Integer, Integer, Integer> add = Integer::sum;

        System.out.println(add.apply(5, 10));


        System.out.println("\n========== Predicate ==========");

        /*
         * Predicate<T>
         *
         * Returns true or false.
         *
         * Commonly used for filtering.
         */

        Predicate<Integer> even = number -> number % 2 == 0;

        System.out.println(even.test(8));
        System.out.println(even.test(7));


        System.out.println("\n========== BiPredicate ==========");

        /*
         * BiPredicate<T,U>
         *
         * Accepts two values and returns boolean.
         */

        BiPredicate<String, Integer> longerThan =
                (text, size) -> text.length() > size;

        System.out.println(longerThan.test("Functional", 5));


        System.out.println("\n========== UnaryOperator ==========");

        /*
         * UnaryOperator<T>
         *
         * Receives T
         * Returns T
         *
         * Used when input and output types are identical.
         */

        UnaryOperator<String> upper = String::toUpperCase;

        System.out.println(upper.apply("java"));


        System.out.println("\n========== BinaryOperator ==========");

        /*
         * BinaryOperator<T>
         *
         * Receives two Ts
         * Returns one T
         */

        BinaryOperator<Integer> max = Integer::max;

        System.out.println(max.apply(15, 8));


        System.out.println("\n========== Runnable ==========");

        /*
         * Runnable
         *
         * Method:
         * void run()
         *
         * No input.
         * No output.
         */

        Runnable task = () -> System.out.println("Running task...");

        task.run();


        System.out.println("\n========== Comparator ==========");

        /*
         * Comparator<T>
         *
         * Used for sorting.
         */

        List<String> names = List.of("John", "Alice", "Bob", "David");

        names.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);


        System.out.println("\n========== Predicate Composition ==========");

        Predicate<Integer> positive = n -> n > 0;

        Predicate<Integer> positiveEven =
                positive.and(even);

        System.out.println(positiveEven.test(8));
        System.out.println(positiveEven.test(-8));


        System.out.println("\n========== Function Composition ==========");

        Function<Integer, Integer> multiplyBy2 = n -> n * 2;
        Function<Integer, Integer> add10 = n -> n + 10;

        System.out.println(
                multiplyBy2.andThen(add10).apply(5)
        ); // (5 * 2) + 10

        System.out.println(
                multiplyBy2.compose(add10).apply(5)
        ); // (5 + 10) * 2


        System.out.println("\n========== Passing Behavior ==========");

        executePredicate(15, n -> n > 10);

        executeFunction("java", String::toUpperCase);

        executeConsumer("Learning Functional Interfaces",
                System.out::println);

        executeSupplier(() -> "Generated value");


        System.out.println("\n========== Streams ==========");

        List<String> languages =
                List.of("Java", "Python", "Go", "Rust", "JavaScript");

        languages.stream()

                // filter expects Predicate<T>
                .filter(lang -> lang.length() > 4)

                // map expects Function<T,R>
                .map(String::toUpperCase)

                // sorted expects Comparator<T>
                .sorted()

                // forEach expects Consumer<T>
                .forEach(System.out::println);


        System.out.println("\n========== Method References ==========");

        // Static method reference
        Function<String, Integer> parse = Integer::parseInt;

        // Instance method reference
        String prefix = "Hello ";
        Consumer<String> greet = prefix::concat;

        // Constructor reference
        Supplier<StringBuilder> builder = StringBuilder::new;

        System.out.println(parse.apply("123"));

        System.out.println(prefix.concat("World"));

        System.out.println(builder.get().append("Builder"));
    }


    static void executePredicate(Integer value,
                                 Predicate<Integer> predicate) {

        System.out.println(predicate.test(value));
    }

    static void executeFunction(String text,
                                Function<String, String> function) {

        System.out.println(function.apply(text));
    }

    static void executeConsumer(String text,
                                Consumer<String> consumer) {

        consumer.accept(text);
    }

    static void executeSupplier(Supplier<String> supplier) {

        System.out.println(supplier.get());
    }
}