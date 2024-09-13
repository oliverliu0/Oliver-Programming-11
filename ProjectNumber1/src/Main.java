import java.util.Scanner;

public class Main {
    //Code your solution to problem number one here
    static int problemOne(String s){ 
        int vowelCount = 0; //initialize a variable to count the amount of vowels in a string

        // Looping through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i); // Get current character at index i

            //Checking if each character in the string is a vowel (a, e, i, o, u)
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                vowelCount++; //If yes, vowelCount variable will increase by one

            }
        }
        
        return vowelCount; //return total amount of vowels in a particular string
    }
    //Code you problem number two here
    static int problemTwo(String s){ 
        int bobCount = 0; //Initialize a variable to count the number of times "bob" occurs in a string

        // Loop through the string, checking whether the substring equals "bob"
        // The loop stops when there are fewer than 3 characters remaining to prevent out of bounds error. 
        for (int i = 0; i + 2 < s.length(); i++) { 
            // Check if the substring starting at index i in the string equals "bob"
            if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'o' && s.charAt(i + 2) == 'b') {
                bobCount++; //if so, increase the counter by 1.
            }

        }
        
        return bobCount;
    }
    //Code your solution to problem number 3 here
    static String problemThree(String s){
        String my_string = ""; //Create empty string because return type is string
        int start = 0; //starting index of our return substring

        for (int i = 1; i < s.length(); i++) { //i is the ending index
            if (s.charAt(i) < s.charAt(i-1)) { //if it's in alphabetical order
                if (i - start > my_string.length()) { //if current substring is longer than string
                    my_string = s.substring(start, i); //update substring
                }
                start = i; //Using previous end point as our new starting point
            }

            }



        if (s.length() - start > my_string.length()) { //checking last element of string s
        my_string = s.substring(start); //to handle the case where the longest alphabetical subtring is at the end of the string
        }
        //TODO
        return my_string;
    }
    public static void main(String[] args) {
        /*
        Set s to a string and run your method using s as the parameter
        Run your method in a println statement to determine what the output was
        Once you think you have it working try running the tests.
        These tests will put your methods through several, different Strings to test
        all possible cases.  If you have 100% success then there is no bugs in your methods.
         */
        String s = "iueuaondjmhoiuxj";
        int result = problemOne(s);
        System.out.println("Number of vowels: " + result);

    }
}
