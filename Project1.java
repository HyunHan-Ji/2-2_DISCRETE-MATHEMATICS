public class Project1 {

	public static void main(String[] args) {
		int[][] arr1 = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 0, 0, 0 } };
		int[][] arr2 = { { 1, 0, 0, 0 }, { 0, 1, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 } };

		System.out.println("arr1");
		System.out.println("반사관계: " + bansa(arr1));
		System.out.println("대칭관계: " + daching(arr1));
		System.out.println("반대칭관계: " + bandaching(arr1));
		System.out.println("추이관계: " + chooi(arr1));
		System.out.println("동치관계: " + dongchi(arr1));
		System.out.println("부분순서관계: " + bubun(arr1));
		System.out.println("선형순서관계: " + linear(arr1));

		System.out.println("arr2");
		System.out.println("반사관계: " + bansa(arr2));
		System.out.println("대칭관계: " + daching(arr2));
		System.out.println("반대칭관계: " + bandaching(arr2));
		System.out.println("추이관계: " + chooi(arr2));
		System.out.println("동치관계: " + dongchi(arr2));
		System.out.println("부분순서관계: " + bubun(arr2));
		System.out.println("선형순서관계: " + linear(arr2));
	}

	public static boolean bansa(int[][] arr) { // 반사 관계
		if (arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1 && arr[3][3] == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean daching(int[][] arr) { // 대칭 관계
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] != arr[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean bandaching(int[][] arr) { // 반대칭 관계
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == 1 && arr[j][i] == 1) {
					if (i != j) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean chooi(int[][] arr) { // 추이 관계
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						if (arr[j][k] == 1) {
							if (arr[i][k] != 1) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}

	public static boolean dongchi(int[][] arr) { // 동치 관계
		if (bansa(arr) && daching(arr) && chooi(arr)) {
			return true;
		}
		return false;
	}

	public static boolean bubun(int[][] arr) { // 부분순서 관계
		if (bansa(arr) && bandaching(arr) && chooi(arr)) {
			return true;
		}
		return false;
	}

	public static boolean linear(int[][] arr) { // 선형순서 관계
		if (bubun(arr)) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if ((arr[i][j] == 1 && arr[j][i] == 1) || i == j) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
