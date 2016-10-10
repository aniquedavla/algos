/**
 * Created by aniquedavla on 10/10/16.
 */
public class MatrixMultiplicationTest {
    public static void main(String[] args) {
// create two double 2-D arrays
        double[][] a..
        double[][] b...
        Matrix m1 = new Matrix(a);
        Matrix m2 = new Matrix(b);
        System.out.println(m1);
        Matrix productStrassen=m1.multiplyStrassen(m2);
        Matrix productRegular=m1.multiply(m2);
        System.out.println("Are matrices the same?
                "+productStrassen.equals(productRegular));
                System.out.println(productStrassen);
        ...
}
