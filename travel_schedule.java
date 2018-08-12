package kadai_06;

import java.util.Scanner;

public class travel_schedule {
	/**連休の日数**/
	private int M = 0;
	/**旅行の日数**/
	private int N = 0;
	/**連休の日付**/
	private int[] consecutiveHolidays;
	/**連休の降水確率**/
	private int[] rainfallProbability;
	
	public static travel_schedule ts = null;
	
	Scanner sc = null;
	
	public static void main(String ars[]) {
		
		System.out.println("連休の日数と旅行の日数を入力してください。(半角スペース区切り)");

		try {
			ts = new travel_schedule();
			//[0]連休日数Mと[1]旅行日数Nを取得する。
			String s[] = ts.getSchedule(); 
			ts.M = Integer.parseInt(s[0]);
			ts.N = Integer.parseInt(s[1]);
		
			//入力チェック
			ts.checkInputNum(ts.M,ts.N);
		
			System.out.println("連休の日付と各日の降水確率(%)を半角スペース区切りで入力してください。");
		
			//連休の日付と、各日にちの降水確率を取得。	
			ts.setRainfallProbability(ts.M ,ts.N);
		} catch (Exception e){
			System.out.println("入力値の読み取りに失敗しました。");
			e.printStackTrace();
		} finally {
			//インスタンスのクローズ処理
			if (ts.sc != null) {ts.sc.close();};
		}
			
		//入力チェック
		ts.checkRainfallProbability(ts.consecutiveHolidays, ts.rainfallProbability);
		
		//旅行期間中に降水確率が最も低くなる期間を計算、出力する。
		String result = ts.getTravelDays(ts.M, ts.N, ts.consecutiveHolidays, ts.rainfallProbability);
		System.out.println("降水確率が最も低くなる期間");
		System.out.println(result);
	}
	
	/*
	 * 連休日数と旅行日数の入力処理をします。
	 * @return s 連休日数と旅行日数を格納する配列
	 */
	public String[] getSchedule() throws Exception {
		/**入力値を一時的に格納**/
		String[] s = null;
		
		ts.sc = new Scanner(System.in);
		String N = ts.sc.nextLine();
		s = N.split(" ");
						
		return s;
	}
	
	/*
	 * 連休日数と旅行日数の入力値チェック。エラーの場合は処理終了。
	 * @param M 連休の日数
	 * @param N　旅行の日数
	 */
	public void checkInputNum(int M ,int N) { 
		
		//1<=N<=M<=30であること。
		if (1 <= N && N <= 30 && 1 <= M && M <= 30 ) {
			if (!(N <= M)) {
				System.out.println("旅行の日数は連休の日数より小さい値を指定してください。。");
				System.exit(1);
			}
		} else {
			System.out.println("連休の日数と旅行の日数は30以下の数値を指定してください。");
			System.exit(1);
		}
	}
	
	/*
	 * 連休の日付と降水確率の入力処理を行います。
	 * @param M 連休の日数
	 * @param N　旅行の日数
	 */
	public void setRainfallProbability (int M ,int N ) {
		/**入力値を一時的に格納**/
		String[] s = null;
		ts.consecutiveHolidays = new int[M];
		ts.rainfallProbability = new int[M];
			
		//半角スペース区切りで連休の日付と降水確率を、それぞれの配列に取得
		for (int i = 0 ; i < M ; i++) {
			String str = ts.sc.nextLine();
			s = str.split(" ");
			
			consecutiveHolidays[i] = Integer.parseInt(s[0]);
			rainfallProbability[i] = Integer.parseInt(s[1]);
		}
	}
	
	/*
	 * 連休の日付と降水確率の入力値チェック。エラーの場合は処理終了。
	 * @param ch 連休の日付
	 * @param rp　降水確率
	 */
	public void checkRainfallProbability(int[] ch , int[] rp) {
		boolean errorFlag = true;
		
		for (int i :ch) {
			if(!(1 <= i && i <= 30)) errorFlag = false;
		}
		
		if (errorFlag == false) {
			System.out.println("連休の日付が不正です。1以上30以下の値を入力してください。");
			System.exit(1);
		}
		
		for (int i :rp) {
			if (!(0 <= i && i <= 100)) errorFlag = false;
		}
		
		if (errorFlag == false) {
			System.out.println("降水確率の値が不正です。1以上100以下の値を入力してください。");
			System.exit(1);
		}
	}
	
	/*
	 * 旅行期間中に降水確率が最も低くなる期間を計算、出力する。
	 * 
	 * @param M 連休の日数
	 * @param N　旅行の日数
	 * @param ch 連休の日付
	 * @param rp　降水確率
	 * @return startDate + " " + endDate 降水確率が最も低くなる、旅行の開始・終了日
	 */
	String getTravelDays(int M ,int N ,int[] ch, int[] rp) {
		//oからM-1までの平均をとる
		//1からMまでの平均をとる
		//比較する。
		//低いほうを残す。
		//2からM+1までの平均をとる
		//比較する。
		//低いほうを残す。
		//3からM+2までの平均をとる
		
		int bestRainfallProbability = 0;
		
		//連休初日から旅行した場合の降水確率の平均を取得する。
		bestRainfallProbability = getAverage(0,N-1,rp);
		int startDate = ch[0];
		int endDate = ch[N-1];
		
		//連休2日目以降の降水確率の平均と比較していく。
		for (int i = 1 ; i < (M-N) ; i++) {
			int ave = getAverage(i,i+N-1,rp);
		
			if (ave < bestRainfallProbability) {
				startDate = ch[i];
				endDate = ch[i+N-1];
			}
		}
		return startDate + " " + endDate;
	}
	
	/*
	 * int型配列の要素番号aからbまでの平均を計算する。
	 * @param a 処理始めの要素番号
	 * @param b 処理終わりの要素番号
	 * @param list[] 降水確率のリスト
 	 * @return total/(b-a+1) int型配列の要素番号aからbまでの平均
	 */
	int getAverage(int a , int b ,int[] list) {
		int total = 0; 
		
		for (int i = a ; i <= b ; i++) {
			total += list[i];
		}
				
		return total/(b-a+1);
	}
	
}