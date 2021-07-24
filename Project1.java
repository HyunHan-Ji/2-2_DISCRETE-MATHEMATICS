public class Project1 {

	public static void main(String[] args) {
		int[][] arr1 = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 0, 0, 0 } };
		int[][] arr2 = { { 1, 0, 0, 0 }, { 0, 1, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 } };

		System.out.println("arr1");
		System.out.println("�ݻ����: " + bansa(arr1));
		System.out.println("��Ī����: " + daching(arr1));
		System.out.println("�ݴ�Ī����: " + bandaching(arr1));
		System.out.println("���̰���: " + chooi(arr1));
		System.out.println("��ġ����: " + dongchi(arr1));
		System.out.println("�κм�������: " + bubun(arr1));
		System.out.println("������������: " + linear(arr1));

		System.out.println("arr2");
		System.out.println("�ݻ����: " + bansa(arr2));
		System.out.println("��Ī����: " + daching(arr2));
		System.out.println("�ݴ�Ī����: " + bandaching(arr2));
		System.out.println("���̰���: " + chooi(arr2));
		System.out.println("��ġ����: " + dongchi(arr2));
		System.out.println("�κм�������: " + bubun(arr2));
		System.out.println("������������: " + linear(arr2));
	}

	public static boolean bansa(int[][] arr) { // �ݻ� ����
		if (arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1 && arr[3][3] == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean daching(int[][] arr) { // ��Ī ����
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (arr[i][j] != arr[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean bandaching(int[][] arr) { // �ݴ�Ī ����
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

	public static boolean chooi(int[][] arr) { // ���� ����
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

	public static boolean dongchi(int[][] arr) { // ��ġ ����
		if (bansa(arr) && daching(arr) && chooi(arr)) {
			return true;
		}
		return false;
	}

	public static boolean bubun(int[][] arr) { // �κм��� ����
		if (bansa(arr) && bandaching(arr) && chooi(arr)) {
			return true;
		}
		return false;
	}

	public static boolean linear(int[][] arr) { // �������� ����
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
