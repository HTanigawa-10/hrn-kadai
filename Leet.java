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
	public static String leet(String beforeLeet){
		//文字数チェック
		if (beforeLeet.length() < 1  || 100 <= beforeLeet.length()) 
			throw new IllegalArgumentException("文字列は1～100字以内である必要があります。");
		//変換結果
		StringBuffer afterLeet = new StringBuffer();
		//入力文字(1文字単位)がkeyと一致する場合は、対応するvalueに変換します。
		for (int i = 0 ; i < beforeLeet.length() ; i++) {
			String Str = String.valueOf(beforeLeet.charAt(i)); 
			//大文字アルファベット以外の場合はエラーとします。
			if (!Str.matches("^[A-Z]+$"))
				throw new IllegalArgumentException("文字列は大文字アルファベットである必要があります。：" + i + "文字目 = " + Str);
			//keyと一致する場合は、対応するvalueに変換します。
			if (leetMap.containsKey(Str)) {
				Str = leetMap.get(Str);
			}
			afterLeet.append(Str);
		}
		return afterLeet.toString();
	}
	
	//leet変換の対応付けを追加します。
	public static void addLeet(String key, String value){
		leetMap.put(key, value);
	}
}
