package SetMatrixZero;

import java.util.ArrayList;
import java.util.Arrays;

class BFA_SetMatrixZero {
    // ? Used for marking the row zero
    static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
        // * m = no of col
        // * */ n = no of row
        // * */ i = current index
        // * */ setting all the non-zero elements to -1
        for (int j = 0; j < m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    // ? this function will be used for marking the rows
    static void markCol(ArrayList<ArrayList<Integer>> matrix, int m, int n, int j) {
        for (int i = 0; i < n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j, -1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // function will be used to set row and col to -1 where we have 0 present
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, n, m, i);
                    markCol(matrix, m, n, j);
                }
            }
        }
        // making the rest of the elements zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int m = matrix.size(); // no of cols
        int n = matrix.get(0).size(); // no of rows

        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);
        System.out.println("The final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.println(ele + " ");

            }
            System.out.println();
        }
    }
}