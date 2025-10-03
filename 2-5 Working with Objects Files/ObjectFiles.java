import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class ObjectFiles {
    public static void main(String[] args) { 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
        
        int result;        
        do {
            result = fileChooser.showOpenDialog( null );
            if ( result == JFileChooser.CANCEL_OPTION ) {
                JOptionPane.showMessageDialog( null, "Please select a file of integers.",
                                              "File Not Selected", JOptionPane.ERROR_MESSAGE );
            }
        } while (result == JFileChooser.CANCEL_OPTION);
        
        File selectedFile = fileChooser.getSelectedFile();
        
        int digitsCount = 0;
        int upperCaseCount = 0;
        int lowerCaseCount = 0;
        int spacesCount = 0;
            
        // Try to open, read, and close the selected file
        try {
            Scanner fileInput = new Scanner( selectedFile );
            String forAnalysis = fileInput.nextLine();
            
            // Actual logic, scan total number of digits, upper case letters, lower case letters, and spaces.
            
            for (int i = 0; i < forAnalysis.length(); i++) {
                // lowercase
                if ( Character.isLowerCase(forAnalysis.charAt(i)) ) {
                    lowerCaseCount += 1;
                // uppercase
                } else if ( Character.isUpperCase(forAnalysis.charAt(i)) ) {
                    upperCaseCount += 1;
                // digit count
                } else if ( Character.isDigit(forAnalysis.charAt(i)) ) {
                    digitsCount += 1;
                // space
                } else if ( Character.isWhitespace(forAnalysis.charAt(i)) ) {
                    spacesCount += 1;
                }
            }
            
            System.out.println("Analysis of filename: " + selectedFile.getName());
            System.out.println(digitsCount + " digits");
            System.out.println(upperCaseCount + " uppercase letters");
            System.out.println(lowerCaseCount + " lowercase letters");
            System.out.println(spacesCount + " spaces");
            fileInput.close();
            
        }
        catch ( IOException ioException ) {
            System.err.println( "Java Exception: " + ioException);
            System.out.println( "Sorry, unable to open the randInt.txt file for reading." );
        }
        
        // write to new file
        try {
            PrintWriter fileOutput = new PrintWriter( "report.txt" ); 
            
            fileOutput.println("Analysis of filename: " + selectedFile.getName());
            fileOutput.println(digitsCount + " digits");
            fileOutput.println(upperCaseCount + " uppercase letters");
            fileOutput.println(lowerCaseCount + " lowercase letters");
            fileOutput.println(spacesCount + " spaces");
            
            fileOutput.close();
        }
        catch ( IOException ioException ) {
            System.err.println( "Java Exception: " + ioException );
            System.out.println( "Sorry, error with output file randInt.txt." );
        }
        
        
        
    }
    
    
}
