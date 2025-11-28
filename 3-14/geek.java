import java.util.HashMap;
import java.util.Scanner;

public class geek {

    public static void main(String[] args) {
        HashMap<String, String> geekTerms = new HashMap<>();

        // put all the terms into the hashmap
        geekTerms.put("404", "clueless. From the web error message 404, meaning page not found.");
        geekTerms.put("Googling", "searching the Internet for background information on a person.");
        geekTerms.put("Keyboard Plaque", "the collection of debris found in computer keyboards.");
        geekTerms.put("Link Rot", "the process by which web page links become obsolete.");
        geekTerms.put("Percussive Maintenance", "the act of striking an electronic device to make it work.");
        geekTerms.put("Uninstalled", "having your office job replaced by AI.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("GEEK TRANSLATOR\n");
        System.out.println("1 - Look Up a Geek Term");
        System.out.println("2 - Add a Geek Term");
        System.out.println("3 - Redefine a Geek Term");
        System.out.println("4 - Delete a Geek Term");
        System.out.println("5 - Quit");

        while(true) {
            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Enter the geek term: ");
                String term = scanner.nextLine();
                String definition = geekTerms.get(term);
                if (definition != null) {
                    System.out.println(term + ": " + definition);
                } else {
                    System.out.println("Term not found in the geek dictionary");
                }
            } else if (choice.equals("2")) {
                System.out.print("Enter the geek term: ");
                String term = scanner.nextLine();
                System.out.print("Enter the definition: ");
                String definition = scanner.nextLine();
                geekTerms.put(term, definition);
                System.out.println("Term added successfully");
            } else if (choice.equals("3")) {
                System.out.print("Enter the geek term: ");
                String term = scanner.nextLine();
                if (geekTerms.containsKey(term)) {
                    System.out.print("Enter the new definition: ");
                    String definition = scanner.nextLine();
                    geekTerms.put(term, definition);
                    System.out.println("Term redefined successfully");
                } else {
                    System.out.println("Term not found in the geek dictionary");
                }
                
            } else if (choice.equals("4")) {
                System.out.print("Enter the geek term: ");
                String term = scanner.nextLine();
                if (geekTerms.containsKey(term)) {
                    geekTerms.remove(term);
                    System.out.println("Term deleted successfully");
                } else {
                    System.out.println("Term not found in the geek dictionary");
                }
                
            } else if (choice.equals("5")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }


}
