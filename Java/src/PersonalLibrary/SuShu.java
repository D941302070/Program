package PersonalLibrary;

/**
 * 判断素数,小于0或不是返回false
 * 
 * @author 淺い空
 */
public class SuShu {

	public SuShu() {

	}

	public boolean isPrime(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i * i <= N; i++)
			if (N % i == 0)
				return false;
		return true;
	}
}