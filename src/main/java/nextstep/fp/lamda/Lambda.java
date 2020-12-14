package nextstep.fp.lamda;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");
        numbers.forEach(System.out::println);
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");
        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(() -> System.out.println("Hello from thread"))
                .start();
    }

    public static int printSum(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
                .mapToInt(number -> number)
                .filter(conditional::test)
                .sum();
    }
}