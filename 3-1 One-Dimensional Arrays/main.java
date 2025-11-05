import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] friends = new String[5];
        
        // grab user input 5 times and store in a string array named friends
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter input " + (i + 1) + ": ");
            friends[i] = scanner.nextLine();
        }
        scanner.close();

        // check if in the friends array
        Scanner nameScanner = new Scanner(System.in);
        System.out.print("Enter a name to search: ");
        String nameToSearch = nameScanner.nextLine();
        nameScanner.close();
        
        // loop through friends array by going through each index and checking if the name exists
        boolean found = false;
        for (int i = 0; i < friends.length; i++) {
            // ignore case cuz it don't matter
            if (friends[i].equalsIgnoreCase(nameToSearch)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(nameToSearch + " is in the friends list");
        } else {
            System.out.println(nameToSearch + " is not in the friends list");
        }

        // display the names in the friends array
        System.out.println("real friends List:");
        for (int i = friends.length - 1; i >= 0; i--) {
            System.out.println(friends[i]);
        }
    }
}
