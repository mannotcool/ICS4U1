import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbs = new int[5];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        
        while (count < 5) {
            System.out.print("enter an integer between 1 and 100: ");
            
            int num = scanner.nextInt();
            if (num < 1 || num > 100) {
                System.out.println("number out of range");
                continue;
            }
            
            // dupe checker3
            boolean isDuplicate = false;
            
            for (int i = 0; i < count; i++) {
                if (numbs[i] == num) {
                    isDuplicate = true;
                    break;
                }
            }
            
            if (isDuplicate) {
                System.out.println("duplicate number");
            } else {
                numbs[count] = num;
                count++;
            }
            
            System.out.println(Arrays.toString(numbs));
            
        }
        
        // sort it 
        Arrays.sort(numbs);

        // print
        System.out.println("unique numbers in sorted order:");
        for (int i = 0; i < numbs.length; i++) {
            System.out.println(numbs[i]);
        }
    }
}
