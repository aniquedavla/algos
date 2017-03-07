/**
 * Created by aniquedavla on 3/4/17.
 */
public class Strings {

    /*IN:"HELLO WORLD"
    OUT:"WORLD HELLO"*/
    static String reverseWords(String s){
//        find index of first space
//                copy the work before the space after the word after the space?
        //substring the first word to the add.
        int spaceI = s.indexOf(" ");
        String reversedWord ="";
        reversedWord += s.subSequence(spaceI,s.length()-1);
        reversedWord += " " + s.subSequence(0,spaceI-1);
        return reversedWord;
    }
    /*
    O(n)
    IN: anique
    Out: euqina
    */
    static String reverseString(String s){
        int strength = s.length();
        String reversedString = "";
        for(int i = strength -1;i>=0;i--){
            reversedString += s.charAt(i);
        }
        return reversedString;
    }

}
