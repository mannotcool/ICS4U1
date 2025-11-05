import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valone = scanner.nextInt();
        int valtwo = scanner.nextInt();

        int[][] mainArray = new int[valone][valtwo];
        for (int i = 0; i < valone; i++) {
            for (int j = 0; j < valtwo; j++) {
                mainArray[i][j] = (int)(Math.random() * 99) + 1;
            }
        }

        // find biggest and smallest in array
        int largest = mainArray[0][0];
        int smallest = mainArray[0][0];

        for (int i = 0; i < valone; i++) {
            for (int j = 0; j < valtwo; j++) {
                if (mainArray[i][j] > largest) {
                    largest = mainArray[i][j];
                }
                if (mainArray[i][j] < smallest) {
                    smallest = mainArray[i][j];
                }
            }
        }

        // print array
        for (int i = 0; i < valone; i++) {
            for (int j = 0; j < valtwo; j++) {
                System.out.print(mainArray[i][j] + "     ");
            }
            System.out.println();
        }

        // larg and smal
        System.out.println("largest: " + largest);
        System.out.println("smallest: " + smallest);

    }
}
