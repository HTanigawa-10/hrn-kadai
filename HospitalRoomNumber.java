package kadai_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HospitalRoomNumber {

	public static void main(String[] args) {
		
		HospitalRoomNumber hrn = new HospitalRoomNumber();
		
		/** 嫌いな数字*/
		int n = 0;
		/** 部屋番号リスト*/
		List<Integer> roomNumber = new ArrayList<Integer>();
		/** 希望する部屋番号リスト*/
		List<Integer> hopeRoomNumber = new ArrayList<Integer>();
		
 		//嫌いな番号n、病室の総数m、部屋番号r_iの入力。
		//部屋番号のリストroomNumberを作成。NGの場合は処理終了
		if(!hrn.getList(roomNumber)) {
			System.out.println("処理を終了します。");
			System.exit(0);
		};
		
		//嫌いな数字nを取得
		n = roomNumber.get(0);
		
		//部屋番号以外の要素を削除　⇒　嫌いな数字,病室の総数
		roomNumber.remove(0);
		roomNumber.remove(0);
		
		//嫌いな番号nを含まない部屋番号を出力
		hrn.getHopeNumber(n, roomNumber, hopeRoomNumber);
	}
	
	/*部屋番号をm個分読み込んで、List化する。
	*@param AbstractSequentialList<Integer> roomNumber 空いてる部屋番号のリスト
	*@return true 処理が正常終了
	*@return false 入力チェックNG
	*@return false　例外発生
	*/
	public Boolean getList(List<Integer> roomNumber){
		
		InputStreamReader isr = null;
		BufferedReader sr = null;
		try {
			String line = null;
			isr = new InputStreamReader(System.in);
			sr = new BufferedReader(isr);
			
			System.out.println("嫌いな数字を入力して下さい。");
			int count = 0; 
			
			//ループnullまではおかしくない？
			while(((line = sr.readLine()) != null)) {
				int input = 0;
	
				//空文字の場合はNG
				if(line == "") {
					System.out.println(ErrorMsg.EMSG1);
					return false;
				}
				
				//入力値をint型に変換
				input = Integer.parseInt(line);
				
				//入力値をlistに追加
				roomNumber.add(input); 
				count++;
				
				//入力チェック NGの場合は処理終了
				if(!inputNumberCheck(count, Integer.parseInt(line))) {
					return false;
				}
				
				//指定した部屋の数(roomNumberリストの2個目の要素)に達した場合はループ終了
				if (count > 2) {
					if(count > (roomNumber.get(1)+1)) {
						break;
					}
				}
				
				//メッセージ
				if(count == 1) {
					System.out.println("病室の総数を入力して下さい。");
				} else if(count == 2) {
					System.out.println("部屋番号を" + roomNumber.get(1) + "つ入力して下さい。");
				}
			}
			return true;
		}catch(IOException e){	
			//読み込みエラー
			System.out.println(ErrorMsg.EMSG3);
			return false;
		}catch(NumberFormatException e){	
			//入力値が数値では無い場合
			System.out.println(ErrorMsg.EMSG4);
			return false;
		}catch(Exception e){	
			e.printStackTrace();
			return false; 
		}finally {
			//インスタンスのクローズ処理
			try {
				if (sr != null) {
					sr.close();
				}
				if (isr != null) {
					isr.close();
				}
			} catch(Exception e) {}
		}
	}
	
	/*入力値のチェックをする。
	*@param int i 入力順でどの値か判別
	*@param int in　入力値
	*@return true　入力値が正しい場合 
	*@return false 入力値が不正な場合
	*/
	Boolean inputNumberCheck(int count,int in){
		if(count == 1) {
			if(!(0 <= in && in <= 9)) {
				System.out.println(ErrorMsg.EMSG5);
				return false;
			}
		} else if(count == 2) {
			if(!(1 <= in && in <= 100)) {
				System.out.println(ErrorMsg.EMSG6);
				return false;
			}
		} else {
			if(!(0 <= in && in <= 1000)) {
				System.out.println(ErrorMsg.EMSG7);
				return false;
			}
		}
		return true;
	}
	
	/*嫌いな番号が含まれない部屋番号を判別し、出力
	*@param int i 入力順でどの値か判別
	*@param int in　入力値
	*@return true　入力値が正しい場合 
	*@return false 入力値が不正な場合
	*/
	void getHopeNumber(int n, List<Integer> roomNumber,List<Integer> hopeRoomNumber) {
		/**嫌いな数値 String型*/
		final String sn = String.valueOf(n);

		//嫌いな数字を含まない場合は、HopeRoomNumberに加える
		roomNumber.stream()
		.filter(a -> !a.toString().contains(sn))
		.forEach(a -> hopeRoomNumber.add(a));
		
		//希望する部屋番号を出力
		//希望する部屋番号が1つもなければ"none" を出力
		if(hopeRoomNumber.size() == 0) {
			System.out.println("嫌いな番号" + n + "を含まない部屋番号はありませんでした。");
			System.out.println("none");
		} else {
			System.out.println("嫌いな番号" + n + "を含まない部屋番号は以下の通りです。");
			for(int i : hopeRoomNumber) {
				System.out.println(i);
			}
		}
	}
}
	
	

