package ClassRoomQuestions.Stack;

import java.util.Stack;
/*
Q2. Double Character Trouble
Problem Description

You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
 */

public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        String doubleCharacterString ="abccbc";
        //String answer = removeDoubleCharString(doubleCharacterString);
        String answer = anotherApproch(doubleCharacterString);
        System.out.println(answer);
    }
    public static String removeDoubleCharString(String givenString){
        Stack<Character> origStack = new Stack<>();

        for(int i=0;i<givenString.length();i++){
            char ch = givenString.charAt(i);
            if(!origStack.isEmpty() && origStack.peek() == ch){

                origStack.pop();
            }
            else{
                origStack.push(ch);
            }
        }
        String answer =reverseStack(origStack);
        return answer;
    }
    public static String reverseStack(Stack<Character> origStack){
        Stack<Character> auxStack = new Stack<>();
        String ans ="";
       while (!origStack.isEmpty()){
           char temp = origStack.pop();
           auxStack.push(temp);
       }
       while (!auxStack.isEmpty()){
           char ca = auxStack.pop();
           ans +=String.valueOf(ca);
       }
       return ans;
    }
    public static String anotherApproch(String A){
        Stack<Character> stack = new Stack<>();
        for(int i=A.length() -1;i>=0;i--){
            char c=A.charAt(i);
            if(stack.size()==0 || stack.peek()!=c)
                stack.push(c);
            else
                stack.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(stack.size()>0){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
