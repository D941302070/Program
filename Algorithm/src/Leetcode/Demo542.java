package Leetcode;

public class Demo542 {
    public static int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) continue;
                int floor = 1;
                while (floor < Math.max(i, matrix.length - i) + 1
                        || floor < Math.max(j, matrix[0].length - j) + 1) {
                    int temp = (i - floor >= 0 && matrix[i - floor][j] == 0 ? 0 : 1)
                            + (i + floor < matrix.length && matrix[i + floor][j] == 0 ? 0 : 1)
                            + (j - floor >= 0 && matrix[i][j - floor] == 0 ? 0 : 1)
                            + (j + floor < matrix[0].length && matrix[i][j + floor] == 0 ? 0 : 1);
                    if (temp < 4) {
                        matrix[i][j] = floor;
                        break;
                    }
                    floor++;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] a = {{0,0,1,0,1,1,1,0,1,1},{1,1,1,1,0,1,1,1,1,1},{1,1,1,1,1,0,0,0,1,1},{1,0,1,0,1,1,1,0,1,1},{0,0,1,1,1,0,1,1,1,1},{1,0,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,0,1,0,1},{0,1,0,0,0,1,0,0,1,1},{1,1,1,0,1,1,0,1,0,1},{1,0,1,1,1,0,1,1,1,0}};
        updateMatrix(a);
    }
}
