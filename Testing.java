public class Testing {
    public static void swapper(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = matrix[i].length-1; j > i; j--) {

                int tmp = matrix[i][j];

                matrix[i][j] = matrix[j][i];

                matrix[j][i] = tmp;

            }

        }

    }



    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, { 20, 21, 22 }, { 30, 31, 32 } };

  swapper(matrix);

}
      

}
