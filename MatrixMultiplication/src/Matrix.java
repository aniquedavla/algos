/**
 * Created by aniquedavla on 10/10/16.
 */
public class Matrix {
    private double[][] array2D;

    public Matrix(double[][] array2D){
        this.array2D = array2D;
    }

    public Matrix multiplyStrassen(Matrix m) {

    }

    public Matrix multiply(Matrix m) {
        int[][] array = new int[][]
        for(i = 0;i < m.length;i++) {
            for(j = 0; j < m.length;j++) {
                array[i][j] = 0;
                for(int k = 0;k < m.length;k++) {
                    array[i][j] += m[i][k] * this[k][j];
                }
            }
        }
        return new Matrix(array);
    }

    public double[][] getMatrixArray(){
        return array2D;
    }
}