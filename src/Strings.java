/**
 * Created by aniquedavla on 3/4/17.
 */
public class Strings {


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
