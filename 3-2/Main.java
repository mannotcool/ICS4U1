public class Main {
    public static void main(String[] args) {
        int[] numbs = new int[10];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int count = 0;
        while (count < 10) {
            System.out.print("enter an integer between 1 and 100: ");
            int num = scanner.nextInt();
            if (num < 1 || num > 100) {
                System.out.println("number out of range");
                continue;
            }
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
        }
        // sort it 
        java.util.Arrays.sort(numbs);

        // print
        System.out.println("unique numbers in sorted order:");
        for (int i = 0; i < numbs.length; i++) {
            System.out.println(numbs[i]);
        }
    }
}
