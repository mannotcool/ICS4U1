public class FunWithStrings {
     
    public static void main(String[] args) {
        System.out.println(isOnlyLetters("aadDsa2dad"));
        System.out.println(countChars('E', "heeeeello"));
        System.out.println(reverseString("sup"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(findFirstHTMLTag("racecar"));
             
    }
     
    // Takes a String parameter and returns true if the string contains only 
    // letters (a-z or A-Z), or false if it contains any non-letters
    // (e.g., digits 0-9 or punctuation like $, !.) 
    public static boolean isOnlyLetters( String str ) {
        for (int i = 0; i < str.length(); i++) {
            if ( !Character.isLetter(str.charAt(i)) ) {
                return false;
            }
        }
        return true;  
    }
    
    // Takes a char and String parameter and counts and returns the number
    // of times the character occurs in the given string (0 if no matches).
    public static int countChars( char ch, String str ) {
        int tally = 0;
        for (int i = 0; i < str.length(); i++) {
            if ( Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(ch)) {
                tally += 1;
            }
        }

        return tally;   
    }
    
    // Takes a String parameter and returns a reference to a new String object
    // that contains the same characters as the parameter String except in
    // reverse order.  The original parameter String should not be changed.
    public static String reverseString( String str ) {
        String newString = "";
        for ( int count = str.length() - 1; count >= 0; count-- ) {
            newString = newString + str.charAt( count);
        }
        return newString;
    }
    
    // A palindrome is a word or phrase that is spelled the same way forward and
    // backward.  For example, "mom", "racecar", "able was I ere I saw elba".
    //
    // This method takes a String parameter and returns true if the String
    // is pallindromic or false otherwise.  Hint: Can you reuse one of your 
    // other methods to simplify this?
    public static boolean isPalindrome( String str) {
        String newString = "";
        for ( int count = str.length() - 1; count >= 0; count-- ) {
            newString = newString + str.charAt( count);
        }
        
        if (newString.equals(str)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Returns a string containing the first HTML tag found in text (including
    // the < and > brackets) or null if no valid tag is found. A tag is any 
    // substring starting with < and ending with the closest >.
    public static String findFirstHTMLTag(String text) {
        int firstBracketPos = text.indexOf( '<' );
        int secondBracketPos = text.indexOf( '>' );
        if (firstBracketPos != -1 && secondBracketPos != -1 ) {
            System.out.println(text.substring( firstBracketPos, secondBracketPos + 1));
            return text.substring( firstBracketPos, secondBracketPos + 1 );
        } else {
            return null;
        }
             
    }
     
}