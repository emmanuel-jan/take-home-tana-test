//Question 1
// Please implement the function getLongestString to return the longest string which matches
// the following conditions:
//  1. The string should have non-repetitive identical characters, for example 'AABCD' is
//  not valid since it contains 'AA'.
//  2. The string should only contain the characters among given list of valid characters.
//  Function parameters: - characters - List of valid characters. - strings - Array of Strings
//  Example Scenario:
//  List of characters: "ABCD"
//  List of strings: "AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"
//  The function should return: "ABCDABDCA"
//  Explanation: "AABCDA" contains repetitive characters 'AA'. "ABCDZADC" contains illegal
//  character 'Z' which is not present in the list of valid characters. There are two valid
//  strings "ABCDBCA" and "ABCDABDCA". Between these two, "ABCDABDCA" is the longest one.


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question1_GetLongestString {

    private String[] strings;
    private Set<Character> validChars;
    //initializing the longest valid string with an empty string
    String longestValid = "";

    public Question1_GetLongestString(List<Character> characters, String[] strings){
        this.strings = strings;
        // converting the list of characters into a set for faster lookup
        this.validChars = new HashSet<>(characters);
    }

    public String getLongestString(){
        for(String str : strings){
            // check if each string has only the valid characters
            if(isStringValid(str, validChars)){
                // check if the string is the longest valid string
                if(str.length() > longestValid.length()){
                    // replace the current longest valid string with the new one
                    longestValid = str;
                }
            }
        }
        return longestValid;
    }

    private boolean isStringValid(String str, Set<Character> chars){
        // loop through all the characters in the string
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            // checking for invalid characters
            if(!validChars.contains(c)){
                return false;
            }

            // checking for consecutive identical characters
            if(i > 0 && c == str.charAt(i-1)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        List<Character> characters = Arrays.asList('A','B','C','D');
        String[] strings = {"AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA"};

        // instantiating the class Question1_GetLongestString
        Question1_GetLongestString myQuestion1 = new Question1_GetLongestString(characters,strings);

        // printing the longest valid string
        System.out.println("The longest valid string is: " + myQuestion1.getLongestString());
    }
}
