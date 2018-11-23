package kadai_11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leet {
	//leet�ϊ��Ή��t��map
	static Map<String, String> leetMap = new HashMap<String, String>();

	public static void main(String[] args) throws Exception{
		
		System.out.println("----------���͊J�n----------");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		//leet�ϊ��Ή��t����ǉ����܂��B
		addLeet("A", "4");
		addLeet("E", "3");
		addLeet("G", "6");
		addLeet("I", "1");
		addLeet("O", "0");
		addLeet("S", "5");
		addLeet("Z", "2");
		//���ʂ��o�͂��܂��B
		System.out.println("----------���͏I��----------");
		System.out.println(leet(line));
		
		sc.close();
	}
	
	//leet�ϊ����ʂ�Ԃ��܂��B
	public static String leet(String strLine){
		//�ϊ�����
		String leetStr = "";
		//���͕���(1�����P��)��key�ƈ�v����ꍇ�́A�Ή�����value�ɕϊ����܂��B
		for (int i = 0 ; i < strLine.length() ; i++) {
			String Str = String.valueOf(strLine.charAt(i)); 
			if (leetMap.containsKey(Str)) {
				Str = leetMap.get(Str);
			}
			leetStr += Str;
		}
		return leetStr;
	}
	
	//leet�ϊ��̑Ή��t����ǉ����܂��B
	public static void addLeet(String key, String value){
		leetMap.put(key, value);
	}
}
