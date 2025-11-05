import java.util.Scanner;
import java.util.Arrays;

public class question3 {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        // for each spot in array
        while (true) {
            // store each positive integer input in the array, exit loop if -1
            System.out.print("enter an int ");
            int num = scanner.nextInt();

            if (num == -1) {
                break;
            } else if (num > 0) {
                // if the array is full, create a new array called newNumbers with 5 more spaces
                if (i >= numbers.length) {
                    int[] newNumbers = Arrays.copyOf(numbers, numbers.length + 5);
                    numbers = newNumbers;
                }

                numbers[i] = num;
                i++;
            }

            System.out.println(Arrays.toString(numbers));
        }

    }
}
