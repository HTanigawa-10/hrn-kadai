package blackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJmain {

	public static void main (String args[]) {
		String message = null; //出力メッセージ
		String sInput = null; //Stringコマンドライン引数
	   	String result = null; //合計判定メッセージ
	   	String cont = "y"; //3回目以降の続行判定用
		ArrayList<Integer> InputNumArray = new ArrayList<Integer>(); //入力値の配列。入力した回数と要素番号が一致
		int iInput = 0; //intコマンドライン引数
		int count = 1;  //入力回数カウント
		int total = 0;  //入力値合計
		
		
		System.out.println("BlackJackを開始します。");
		
		//3回目以降続行するかどうか判定
		while(cont.equals("y")){
		
			//1回目と2回目の入力を行うループ
			for(int i=1; i < 3;){
			
				System.out.println( count + "つ目の数を入力してください。");
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
				try {
					//入力待ち
					sInput = br1.readLine();
		
					//int型に変換
					//入力値が数値以外の場合、NumberFormatException
					iInput = Integer.parseInt(sInput)  ;
		
					//入力値の判定結果表示
					message = inputNumberCheck(iInput);
					System.out.println(message);
		
					if(message == "入力値OK!") {
						//引数を(i-1,iInput)から(iInput)に修正。→128～131も修正
						InputNumArray.add(iInput);
						i = ++count;
					}
			
				}catch (NumberFormatException e){
					message = "入力した値が不正です。1以上13以下の整数値を入力してください。";
					System.out.println(message);
				}catch(IOException e){
					System.out.println("入力エラー:");
					e.printStackTrace();
				}
			}
		
			//合計を計算
			total = inputNumberCul(InputNumArray);
			//"BlackJack!!!","Pig!!","Hit","STAND!!"のいずれかを判定(result)
			result = inputNumberMes(total);
			
			//resultが"BlackJack!!!"または"Pig!!"の場合は、メッセージを表示してゲーム終了。
   	 		if(result == "BlackJack!!!" || result == "Pig!!") {
   	 			System.out.println("合計:" + total + result);
   	 			cont = "n";
   	 		}else{
   	 			
   	 			System.out.println("合計:" + total);
   	 			//"HOLD"の場合は、3回目以降のの入力を行うかどうか判定させる　y/n
   	 			//不正な文字を入力した場合は再入力（メッセージなし）
   	 			do  {
   	 				System.out.println("さらに数を追加しますか？ y/n");
   	 				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
   	 	    
   	 				try {
   	 					//入力待ち
   	 					cont = br2.readLine();
   	 					if(cont.equals("n")) {
   	 						System.out.println("合計:" + total + "STAND!!!");
   	 					}else {
   	 					System.out.println("Hit!!!");
   	 					}
   	 					}catch(IOException e){
   	 						System.out.println("入力エラー:");
   	 						e.printStackTrace();
   	 					}
   	 			//3回目以降の続行判定用のcontが"y","n"のいずれでもない場合は再入力
   	 			}while(!(cont.equals("y") || cont.equals("n")));	
   	 		}
		}
   	 	System.out.println("BlackJackを終了します。");
	}	
	
	
	
	
	
	//入力値の判定を行う
	//未入力、入力値が数字以外、または範囲外の数値の場合はNG

	public static String inputNumberCheck(int iInput) {
		
		String message = null;
	    
			//入力値が1以上、13以下の整数値であることを確認
			if(iInput < 1 ) {
				message = "入力値が小さすぎます。1以上13以下の整数値を入力してください。";
			}
		    else if(13 < iInput){
		    	message = "入力値が大きすぎます。1以上13以下の整数値を入力してください。";
		    }
		    else {
		        message = "入力値OK!";
			}
			return message;
		}

	
	
     //i回目の数値の出力と、合計を計算する。
     public static int inputNumberCul(ArrayList<Integer> InputNumArray) {
    	 int total = 0;
    	 String message = null;

     //修正済み
    		 for (int i = 0 ; i < (InputNumArray.size()) ; i++) {  			 
    			 message = (1 + i) + "回目：" + InputNumArray.get(i);
    			 System.out.println(message);
    			 total = total + InputNumArray.get(i);			 
    		 }
    	 return total;
     }
     
    	 
    	 
     //入力値の合計判定を行う。それぞれの結果メッセージを返す。
     public static String inputNumberMes(int total) {
    	 
    	 String result = null; 
     
    	 if(total == 21) {
       		 result = ("BlackJack!!!");
    	 }else if (21 < total) {
    		 result = ("Pig!!");
    	 }else {
    		 result = ("HOLD");
    	 }
    	 
         return result;
     }
}

	
	
	
	
	
	





















