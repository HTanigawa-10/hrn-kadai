package jisa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cul_WorldTime{
	public static String cont;  //フラグ
	
	public static void main(String args[]) {
		int N = 0;      //計算する都市の総数
		String p_i = null; //都市名(ユーザ側)
		int s_i = 0;    //時差
		
		do{
//計算する都市の数を入力
		System.out.println(message.MSG1);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			try {
			//入力待ち
				String n = null;
				n = br1.readLine();
				
				//int型に変換
				//入力値が数値以外の場合、NumberFormatException
				N = Integer.parseInt(n);
				
				//入力値の判定結果表示
				inputNumberCheck(N);
				
			}catch (NumberFormatException e){
				System.out.println(message.E_MSG1);
			}catch(IOException e) {
				System.out.println(message.E_MSG2);
				e.printStackTrace();
			}
		}while(cont.equals("n"));

//都市名と時差(進み)の情報を入力
		for(int i=0;i < N;i++) {
			
			String IN_p_i = null;
			System.out.println((i+1) + message.MSG3);
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				//入力待ち
				IN_p_i = br2.readLine();
				
			}catch (NumberFormatException e){
				System.out.println("入力エラー:");
			}catch(IOException e){
				System.out.println("入力エラー:");
				e.printStackTrace();
			}
			
		}
	}

	/*public int cul_time_diff() {
		
	//	return int 1
	}
	
	
	
}


	*/

//入力値の判定を行う
//未入力、入力値が数字以外、または範囲外の数値の場合はNG
public static void inputNumberCheck(int N_Input){
	//入力値が1以上、100以下の整数値であることを確認
	if(1 <= N_Input && N_Input <= 100){
		System.out.println(message.MSG2);
		Cul_WorldTime.cont = "y";
	}else{
		Cul_WorldTime.cont = "n";
		System.out.println(message.E_MSG1);
	}
}


public class message{
	public static final String MSG1 = "表示する都市の数を入力してください。";	
	public static final String MSG2 = "入力OK";
	public static final String MSG3 = "つ目の都市名と時差の情報を入力してください。都市名(半角英小文字で20時以内) 時差(1h～24h)";	
	public static final String E_MSG1 = "入力内容が不正です。1～100までの整数を入力してください。";
	public static final String E_MSG2 = "入力内容が不正です。再度入力してください。";
}
}



