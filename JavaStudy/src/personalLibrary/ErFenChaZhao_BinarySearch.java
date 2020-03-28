package PersonalLibrary;

/**
 * ErFenChaZhao(BinarySearch)二分查找
 * 
 * @author 淺い空
 */
public class ErFenChaZhao_BinarySearch {

	public ErFenChaZhao_BinarySearch() {

	}

	public static int BinarySearch(int[] a, int key) {// key要查找的数字
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key < a[mid])
				high = mid - 1;
			else if (key > a[mid])
				low = mid + 1;
			else
				return mid;
		}
		return -1;// 未找到或错误返回-1
	}

}