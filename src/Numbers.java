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
}