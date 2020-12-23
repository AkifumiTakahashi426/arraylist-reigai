package enshu;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListScanner {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		int number = 0;

		while (true) {
			System.out.print("1から100までの好きな数字を入力してください：");

			try {
				if (scan.hasNextInt()) {//入力内容が数字かどうか判断

					number = scan.nextInt();//numberに入力した数字を代入

					if (0 <= number && number <= 100) {//入力内容が0～100なら
						numbers.add(number);
						scan.nextLine();
					} else if (number == -1) {//-1なら
						break;
					} else {//-1～100でないなら
						System.out.println("対象範囲外です。");
						scan.nextLine();
					}

				} else {//入力が数字でない場合
					throw new MyException("文字やで");
					///数字やのに文字エラー
				}
			}
			catch (MyException e) {
				System.out.println("例外だよ");
				System.out.println(e);
				scan.nextLine();
				break;
			}

		}

		System.out.println("要素数：" + numbers.size());
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		System.out.println("～完～");

	}

}
