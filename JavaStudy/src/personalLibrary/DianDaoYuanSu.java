package PersonalLibrary;

/**
 * 颠倒数组元素
 * 
 * @author 淺い空
 */

public class DianDaoYuanSu {
	public DianDaoYuanSu() {

	}

	public static float[] Float(float[] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			float temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
		return a;
	}

	public static int[] Int(int[] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
		return a;
	}

	public static double[] Double(double[] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			double temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
		return a;
	}

	public static String[] String(String[] a) {
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			String temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
		return a;
	}
}