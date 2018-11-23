package kadai_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leet {
	//leet変換対応付けmap
	static Map<String, String> leetMap = new HashMap<String, String>();

	public static void main(String[] args) throws Exception{
		
		System.out.println("----------入力開始----------");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		//leet変換対応付けを追加します。
		addLeet("A", "4");
		addLeet("E", "3");
		addLeet("G", "6");
		addLeet("I", "1");
		addLeet("O", "0");
		addLeet("S", "5");
		addLeet("Z", "2");
		//結果を出力します。
		System.out.println("----------入力終了----------");
		System.out.println(leet(line));
		
		sc.close();
	}
	
	//leet変換結果を返します。
	public static String leet(String strLine){
		//変換結果
		String leetStr = "";
		//入力文字(1文字単位)がkeyと一致する場合は、対応するvalueに変換します。
		for (int i = 0 ; i < strLine.length() ; i++) {
			String Str = String.valueOf(strLine.charAt(i)); 
			if (leetMap.containsKey(Str)) {
				Str = leetMap.get(Str);
			}
			leetStr += Str;
		}
		return leetStr;
	}
	
	//leet変換の対応付けを追加します。
	public static void addLeet(String key, String value){
		leetMap.put(key, value);
	}
}
