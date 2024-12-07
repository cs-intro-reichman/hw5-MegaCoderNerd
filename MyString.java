/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            // we check every char in str and compare them to ch
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        // we check all chars for instances in str1 and in str2 
        // if we find a single char in str1 that is not in str2 return false
        // also if the number of occurences of each char in str1 is less than in str2 return false
        int[] countChars = new int[26];
        for (int i = 0; i < countChars.length; i++){
            // counting each and every letter's num of occurences
            countChars[i] = countChar(str2, (char) ('a' + i));
        }
        for(int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) == -1) return false;
            if (countChars[str1.charAt(i)-'a'] == 0) return false;
            // as the character is in str2 we remove one of its occurences
            // so we still check for anymore duplicates over the rest of the string
            countChars[str1.charAt(i)-'a']--;
        }
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newStr = "";
        // if the string is empty we just return an empty string
        if (str.isEmpty()) return newStr;
        for (int i = 0; i < str.length() - 1; i++) {
            // we add the spacing excluding the last char
            newStr += str.charAt(i) + " "; 
        }
        // we add the last char
        newStr += str.charAt(str.length() - 1);
        
        return newStr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            // will always floor the values meaning we won't get any character above z
            // by the ascii table
            char ch = (char) ('a' + (int) (Math.random() * 26));
            result += ch;
        }
        return result;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String editedStr = "";
        // counter for each and every letter for str2
        int[] countChars = new int[26];
        for (int i = 0; i < countChars.length; i++){
            // we count the number of occurences of the current character
            // we use the ascii table to go over all the alphabet
            countChars[i] = countChar(str2, (char) ('a' + i));
        }
        for (int i = 0; i < str1.length(); i++) {
            // we want to insert only the unique chars of str1
            if (str2.indexOf(str1.charAt(i)) == -1) {
                editedStr += str1.charAt(i);
            } else{
                if (countChars[str1.charAt(i)-'a'] == 0){
                    // if the number of occurences removed of this char 
                    // is the number of occurences in str2
                    editedStr += str1.charAt(i);
                } else{
                    // we remove an occurence of a char that was deleted
                    countChars[str1.charAt(i)-'a']--;
                }
            }
        }
        return editedStr;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
