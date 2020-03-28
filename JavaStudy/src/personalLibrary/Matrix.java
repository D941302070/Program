package PersonalLibrary;

/**
 * Matrix:矩阵运算 
 * 1.MatrixOut数组输出 
 * 2.dot向量点乘 
 * 3.mult矩阵与矩阵之积
 *  4.transpose转置矩阵
 * 
 * @author 淺い空
 */

public class Matrix {
	public Matrix() {

	}

	public static void MatrixOut(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	public static Object dot(double[] x, double[] y) {// 向量点乘
		int a = 0;
		if (x.length != y.length) {
			return -1;
		} else {
			for (int i = 0; i < x.length; i++) {
				a += x[i] * y[i];
			}
			return a;
		}
	}

	public static Object mult(double[][] a, double[][] b) {// 矩阵与矩阵之积
		double[][] c = new double[a.length][b[0].length];
		if (a[0].length != b.length) {// 数据有误，报错
			return -1;
		} else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					for (int k = 0; k < a[0].length; k++) {
						c[i][j] += a[i][k] * b[k][j];
					}
				}
			}
			return c;
		}
	}

	public static double[][] transpose(double[][] a) {// 转置矩阵
		double[][] b = new double[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
}