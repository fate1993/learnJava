package day0503.arrayex;

class ObjArrayEx5 {
	public static void main(String[] args) {
		int[][] test;
		test = new int[2][3];
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;
		// ---------------------1행 초기화 끝
		test[1][0] = 500;
		test[1][1] = 600;
		test[1][2] = 700;
		// --------------------- 2행 초기화 끝

		for (int i = 0; i < test.length; i++)
			for (int j = 0; j < test[i].length; j++) {//
				System.out.println("test[" + i + "][" + j + "]=" + test[i][j]);
			}
		System.out.println("=============");

		for (int[] i : test) {
			for (int i2 : i) {
				System.out.println(i2);
			}
		}

	}
}
