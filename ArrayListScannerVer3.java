package enshuver2;

import java.util.ArrayList;
import java.util.Scanner;

class Okashiizo extends Exception {//エラー表示クラス
	Okashiizo(String m) {
		super(m);
	}
}

public class ArrayListScannerVer3 {

	//数字を入力し、コレクションを戻すメソッド
	public static ArrayList<Integer> typeNumber() throws Okashiizo {

		ArrayList<Integer> numbers = new ArrayList<>();//コレクションの作成
		Scanner scan = new Scanner(System.in);
		int number = 0;//入力した数を入れる場所

		while (true) {
			System.out.print("1から100までの好きな数字を入力してください：");

			//try {//入力したものが数字以外の例外処理
			if (scan.hasNextInt()) {
				number = scan.nextInt();
			} else {
				throw new Okashiizo("エラー発生");
			}

			if (0 <= number && number <= 100) {//入力内容が0～100なら
				numbers.add(number);
				scan.nextLine();
			} else if (number == -1) {//-1なら
				System.out.println("終了キー「-1」が入力されました。");
				System.out.println("結果表示に移ります。");
				break;
			} else {//-1～100でないなら
				System.out.println("対象範囲外です。");
				scan.nextLine();
			}
		}
		return numbers;
	}

	//結果表示メソッド
	public static void showMethod(ArrayList<Integer> numbers) {
		System.out.println("-------------------");
		System.out.println("入力されたのは" + numbers.size() + "個で、");

		if (numbers.size() == 0) {//一つも入力されなかった場合
			System.out.println("表示する数字はありません。");
		} else {//一つでも入力された場合
			for (int i = 0; i < numbers.size(); i++) {//コレクションの個数分表示
				System.out.println("[" + numbers.get(i) + "]");
			}
		}

	}

	//メイン
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();//コレクション作成
		try {
			numbers = typeNumber();//コレクションを入力してnumbersに代入
		} catch (Okashiizo e) {
			System.out.println(e);
		}
		showMethod(numbers);//結果表示
	}

}
