import java.util.*;
import java.io.*;

/**
 * @author Kunj Mehta
 * @version 1.0
 */

public class Solution{
/**
 * main method
 * @param args
 */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input string of brackets: ");
        String s = sc.nextLine();

        int ans = stackImplementation(s);
        if(ans == 1){
            System.out.println("VALID");
        }
        else{
            System.out.println("INVALID");
        }

        sc.close();
    } // main()
/**
 * 
 * @param s
 * @return flag showing whether stack is empty or if any error occured
 * @throws EmptyStackException
 */
    public static int stackImplementation(String s) throws EmptyStackException{
        Stack<Character> bracketStack = new Stack<>();
        char[] charArray = s.toCharArray();

        int flag = 1;

        for(int i = 0; i < charArray.length; i++){
            if(isOpeningBracket(charArray[i])){
                bracketStack.push(charArray[i]);
                continue;
            }

            if(isClosingBracket(charArray[i])){
                try{
                    char c = bracketStack.pop();
                    boolean matchRound = c == '(' && charArray[i] == ')';
                    boolean matchCurly = c == '{' && charArray[i] == '}';
                    boolean matchSquare = c == '[' && charArray[i] == ']';
                    //c == '(' && charArray[i] == ')')
                    if(!(matchRound || matchCurly || matchSquare)){
                        flag = -1;
                        System.out.println("BRACKET TYPE MISMATCH!");
                        return flag;
                    }
                } // try
                catch(EmptyStackException e){
                    flag = -1;
                    System.out.println("EMPTY STACK EXCEPTION");
                    return flag;
                } // catch
            } // isClosingBracket condition
        } // for loop traversing through the array and checking every element in the stack
        
        if(bracketStack.empty()){
            flag = 1;
        }
        else{
            flag = -1;
            System.out.println("STACK NOT EMPTY");
        }
        return flag;
    } // stackImplementation()
/**
 * 
 * @param c character to check
 * @return boolean to check if flag is opening bracket
 */
    public static boolean isOpeningBracket(char c){
        if(c == '(' || c == '{' || c == '['){
            return true;
        }
        return false;
    }
/**
 * 
 * @param c
 * @return boolean to verify if flag is closing bracket
 */
    public static boolean isClosingBracket(char c){
        if(c == ')' || c == '}' || c == ']'){
            return true;
        }
        return false;
    }
} // class Solution