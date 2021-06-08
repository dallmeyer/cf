import java.util.Scanner;

public class B_div2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		char[] s = in.next().toCharArray();
		int k = in.nextInt();

		int ans = 0;
		if (k >= s.length) {
			ans = k + s.length;
			if (ans % 2 == 1)
				ans--;
		} else {
			tandemLoop: for (int tanLen = 2; tanLen <= s.length + k; tanLen += 2) {
				startLoop: for (int start = 0; start < s.length + k; start++) {
					for (int i = 0; i < (tanLen / 2); i++) {
						if (start + i + (tanLen / 2) >= s.length + k) {
							continue startLoop;
						}

						char a, b;
						if (start + i >= s.length) {
							a = '?';
						} else {
							a = s[start + i];
						}
						if (start + i + (tanLen / 2) >= s.length) {
							b = a;
						} else {
							b = s[start + i + (tanLen / 2)];
						}

						if (a != b) {
							continue startLoop;
						}
					}
					ans = tanLen;
					continue tandemLoop;
				}
			}
		}
		System.out.println(ans);
	}

}
