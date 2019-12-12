package PersonalLibrary;

/**
 * 冒泡排序：将数组重新排序，由大到小
 * 
 * @author 淺い空
 */
public class MaoPaoPaiXu {
	public MaoPaoPaiXu() {

	}

	public int[] Int(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] > a[j + 1]) {
					int tem = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tem;
				}
			}
		}
		return a;
	}

	public float[] Float(float[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] > a[j + 1]) {
					float tem = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tem;
				}
			}
		}
		return a;
	}

	public double[] Double(double[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] > a[j + 1]) {
					double tem = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tem;
				}
			}
		}
		return a;
	}

}