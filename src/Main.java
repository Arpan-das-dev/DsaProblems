import Hashing.ContainsDuplicate;
import Stack.ValidParenthesis;
import TwoPointers.ValidPalindrome;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ValidPalindrome palindrome = new ValidPalindrome();
        ContainsDuplicate duplicate = new ContainsDuplicate();
        System.out.println(palindrome.palindrome("race a car"));
        System.out.println("31/12/2025 next contains duplicate -->");
        int [] duplicateArray = {1,2,3,4};
        System.out.println("Ans -> "+duplicate.containsDuplicate(duplicateArray));

        ValidParenthesis parenthesis = new ValidParenthesis();
        System.out.println("31/12/2025 check if a string contains valid parenthesis");
        System.out.println(parenthesis.isValid("([)]"));
    }
}