/**
 * Created by aniquedavla on 10/20/17.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Numbers {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        addNumb(10);
        checkBalance("()");
    }
    public static void addNumb(int numb){
        int sum = 0;
        for(int i=numb; i>=1; i--) {
            //add if numb is not div
            if (!(i % 5 == 0 || i % 7 == 0)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static void checkBalance(String message){
        int openNotSmiley = 0;
        int closeSmiley = 0;
        String isBalanced = "";

        for (int i = 0; i < message.length(); i++) {
            char ithChar = message.charAt(i);
            if (ithChar == '(') {
                closeSmiley++;
                if (i == 0 || message.charAt(i - 1) != ':') {
                    openNotSmiley++;
                }
            } else if (ithChar == ')') {
                openNotSmiley = Math.max(0, openNotSmiley - 1);
                if (i == 0 || message.charAt(i - 1) != ':') {
                    closeSmiley--;
                    if (closeSmiley < 0) break;
                }
            }
        }

        isBalanced = (closeSmiley >= 0 && openNotSmiley == 0) ? "YES": "NO";
        System.out.println(isBalanced);
    }

    public static int countStepUps(int totalSteps){
        //n-1 1 steps at a time
        int steps = totalSteps+1;
        if (totalSteps <= 1)
            return totalSteps;
        return countStepUps(totalSteps-1) + countStepUps(totalSteps-2);
    }

    }

}