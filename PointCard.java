package kadai_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PointCard {
	/** レシートの枚数 */
	private int N = 0;
	/** key:日付 ,value:購入金額 */
	private HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	/** 合計購入金額 */
	private int m = 0;
	/** 合計ポイント */
	private int s = 0;
	
	/**
	 * 標準入力で引数を受け取り、maｐに格納します。
	 * @param receipts 引数のレシート情報
	 */
	public void inputArgs(String[] receipts){
		Scanner sc = null;
		boolean errFlag = false;
		try {
			System.out.println("----------入力開始----------");
			//標準入力
			sc = new Scanner(System.in);
			//レシート枚数の取得
			N = Integer.parseInt(sc.nextLine());
			//レシート数が0以下の場合は処理終了
			if(N <= 0) {
				System.out.println("レシートの数が不正です。");
				System.exit(0);
			}
			//key:日付 ,value:購入金額を取得、範囲チェックを行う
			for (int i = 0; i < N; i++) {
	            String s = sc.nextLine();
	            String[] array = s.split(" ");
	            
				//入力値チェック
				checkArgs(N ,Integer.parseInt(array[0]), Integer.parseInt(array[1]));
	            
	            //key:日付 ,value:購入金額として取得する。すでに日付キーが存在した場合は、購入金額を加算する。
	            if(map.containsKey(Integer.valueOf(array[0]))) {
	            	map.put(Integer.valueOf(array[0]), Integer.valueOf(map.get(array[0]) + array[1]));
	            } else {
		            map.put(Integer.valueOf(array[0]), Integer.valueOf(array[1]));
	            }
			}
			System.out.println("----------入力終了----------");
		} catch(Exception e) {
			//その他例外
			e.printStackTrace();
			System.out.println("引数の形式が不正です。");
			errFlag = true;
		} finally {
			if(sc != null) {sc.close();};
			if(errFlag) {System.exit(0);}
		}
	}
	
	/**
	 * 入力値の範囲チェックを行います。エラー発生時は処理を終了します。
	 * 
	 */
	public void checkArgs(int N,int day ,int price) {
		String errMsg = null; 
		
		//レシートの数　1～100
		if (!(1 <= N && N <= 100)) {
			errMsg = "レシートの数が不正です。";
		}
		//レシートの発行日付 1～31
		if (!(1 <= day && day <= 31)) {
			errMsg = "レシートの発行日付が不正です。"; 
		}
		//その日付のレシートの購入金額　1～10000
		if (!(1 <= price && price <= 10000)) {
			errMsg = "購入金額が不正です。"; 
		}
		//エラーメッセージの表示
		if (errMsg != null) {
			System.out.println(errMsg);
			System.exit(0);
		}
	}
	
	/** メイン処理を行います。*/
	public void execute() {
		for (Map.Entry<Integer, Integer> map : map.entrySet()) {
			/** ポイント係数　*/
			double dayPint = 0.01;
			double three_dayPint = 0.03;
			double five_dayPint = 0.05; 

			String day_s = map.getKey().toString();
			int price = map.getValue().intValue();
			
			//5の付く日と3の付く日はそれぞれのポイント係数を設定
			if (day_s.contains("5")) {
				dayPint = five_dayPint;
			} else if (day_s.contains("3")) {
				dayPint = three_dayPint;
			}
			//購入金額とポイントを加算
			m += price;
			s += price * dayPint ;
		}
	}
	/** 結果を出力します。*/
	public void println() {
		System.out.println("----------出力開始----------");
		System.out.println(m + "円");
		System.out.println(s + "ポイント");
		System.out.println("----------出力終了----------");
	}
	
	/**
	 * メイン処理を行います。
	 * @param args
	 */
	public static void main (String[] args) {
		PointCard pointcard = new PointCard();
		
		//標準入力を行う。入力値をmapに代入していく。
		pointcard.inputArgs(args);
		
		//合計金額とポイントの計算を行うメイン処理
		pointcard.execute();
		
		//結果を表示する出力処理
		pointcard.println();
	}
}
