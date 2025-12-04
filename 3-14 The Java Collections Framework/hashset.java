import java.util.HashSet;
import java.util.Scanner;

public class hashset {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new java.util.HashSet<>();
        Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Enter 10 integers:");

        while (numbers.size() < 10) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        System.out.println("Unique integers entered:");
        for (int number : numbers) {
            System.out.print(number + " ");
        }

        scanner.close();
    }
}