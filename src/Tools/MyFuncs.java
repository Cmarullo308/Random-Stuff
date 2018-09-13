package Tools;

public class MyFuncs {
	// Char Class
	public static class Chars {
		public static char switchCase(char c) {
			if (c >= 65 && c <= 90) { // if Uppercase
				return c += 32;
			} else if (c >= 97 && c <= 122) { // if Lowercase
				return c -= 32;
			}

			return c;
		}

		public static char toLower(char c) {
			if (c >= 65 && c <= 90) {
				return c += 32;
			}
			return c;
		}

		public static char toUpper(char c) {
			if (c >= 97 && c <= 122) {
				return c -= 32;
			}
			return c;
		}

		public static void reverseCharArray(char[] c) {
			char temp;

			for (int i = 0; i < c.length / 2; i++) {
				temp = c[i];
				c[i] = c[c.length - 1 - i];
				c[c.length - 1 - i] = temp;
			}
		}

	}

	// Random Class
	public static class Random {
		public static int randomIntBetween(int min, int max) {
			return new java.util.Random().nextInt(max - min + 1) + min;
		}

		public static double randomDoubleBetween(double min, double max) {
			return min + (max - min) * new java.util.Random().nextDouble();
		}

		public static double randomDoubleBetween(double min, double max, int decimalPoints) {
			return Double.parseDouble(
					String.format("%." + decimalPoints + "f", min + (max - min) * new java.util.Random().nextDouble()));
		}
	}

	public static class Strings {
		public static String reverseChars(String str) {
			char[] charArr = new char[str.length()];

			for (int i = 0; i < str.length(); i++) {
				charArr[str.length() - 1 - i] = str.charAt(i);
			}

			return String.valueOf(charArr);
		}
	}

	public static class Arrays {
		public static <T> void reverseArray(T[] arr) {
			T temp;
			for (int i = 0; i < arr.length / 2; i++) {
				temp = arr[i];
				arr[i] = arr[arr.length - 1 - i];
				arr[arr.length - 1 - i] = temp;
			}
		}
	}
}
