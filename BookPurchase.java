import java.util.*;
import java.util.Map.Entry;

public class BookPurchase {

	    public static void main(String args[] ) throws Exception {
	    
	        int N = 0;//社員数
	        int M = 0;//本の冊数
	        String o_j = null; //購入履歴　社員名
	        Integer p_j = 0; //購入金額
	        Map<String, Integer> map = new HashMap<>(); 
	    	Scanner sc = new Scanner(System.in);
	        
	        System.out .println("社員数を入力してください。");
	  
	  //社員数を取得する。      
	        try {
	        	N = sc.nextInt();
	        	//入力値チェック(半角数値)
	        	checkNumRange(N);
	        }catch(InputMismatchException e) {
	        	sc.close();
	        	throw new IllegalArgumentException(MSG.EMSG1);
	        }
	        
	        System.out .println("社員名を半角スペース区切りで入力してください。");
	        
	        String[] s_N = new String[N];
	        
	  //社員名を半角スペース区切りで取得する。 
	        sc = new Scanner(System.in);
	        String s = sc.nextLine();
	        s_N = s.split(" ");
	        
	        for(String n : s_N ) {
	        	int count = 0;
	        //文字数チェック
	        	checkName(n);
	        //重複チェック
	        	for(String same_name : s_N ) {
	        		if(same_name.equals(n))count++;
	        			if(count == 2) {
	        				sc.close();
	        				throw new IllegalArgumentException(MSG.EMSG4);
	        			}
	        	}
	    	}
	        
	  //hashmapにキー：社員名、値：0として設定、
	        for(String a: s_N) {
	        	map.put(a, 0);  
	        }
	        
	        System.out .println("履歴の数を入力してください。");
	        
          //社員たちが購入した本の冊数Mを取得する。      
	        try {
	            sc = new Scanner(System.in);
	        	M = sc.nextInt();
	        	checkNumRange(M);
	        }catch(InputMismatchException e) {
	        	//入力値が半角数値以外の場合
	        	sc.close();
	        	throw new IllegalArgumentException(MSG.EMSG1);
	        }
	        System.out .println("社員名と購入金額を半角スペース区切りで入力してください。");
	   //社員たちが購入した本の購入金額p_jを半角スペース区切りで取得する。　　社員名  購入金額
	        
	        String[] s_M = new String[M];
	        for (int i = 0; i < M; i++) {
	        	sc = new Scanner(System.in);
	            String s4 = sc.nextLine(); 
	            sc.close();
	            
	            s_M = s4.split(" ",-1);
	            o_j = s_M[0];
	            //文字数チェック
	            checkName(o_j);
	            
	            //入力値チェック(半角数値,範囲)
	            try {
	            	p_j = Integer.valueOf(s_M[1]);
	            	checkNumRange2(p_j);
	            }catch(NumberFormatException e) {
	            	throw new IllegalArgumentException("購入金額は" + MSG.EMSG1);
	            }
	            
	            
	            //社員名がkeyと一致する場合は、購入金額をvalに加算
	            for(String key: map.keySet()) {
	            	if(o_j.equals(key)){
	            		 Integer val = map.get(key);
	            		 map.put(key, val+p_j);
	            	}
	            }
	        }
	        
	    //購入金額が高い順に社員名を出力
	        
	        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());	        
	        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
	            //compareを使用して値を比較する
	            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
	            {
	                //降順
	                return obj2.getValue().compareTo(obj1.getValue());
	            }
	        });
	        
	        System.out.println("書籍購入者一覧(降順)");
	        // 7. ループで要素順に値を取得する
	        for(Entry<String, Integer> entry : list_entries) {
	            System.out.println(entry.getKey() + " : " + entry.getValue());
	        }
	    }
	    
	    /* 社員数、本の数入力チェック
	     * パラメータが半角数字かつ最小値以上、最大値以下であればその値を返却する。
	    */
	    public static int checkNumRange(int n) {
			// 最小値以上、最小値以下の判定
			if (1 <= n && n <= 100) {
				// 判定OKならその値を返却する
				return n;
			}
			// 判定NGならエラー
			throw new IllegalArgumentException(MSG.EMSG2);
		}
	    
	    /* 購入金額入力チェック
	     * パラメータが半角数字かつ最小値以上、最大値以下であればその値を返却する。
	    */
	    public static int checkNumRange2(int n) {
			// 最小値以上、最小値以下の判定
			if (1 <= n && n <= 10000) {
				// 判定OKならその値を返却する
				return n;
			}
			// 判定NGならエラー
			throw new IllegalArgumentException(MSG.EMSG3);
		}
	    
	    /* 社員名入力チェック
	     * 文字数が最小値以上、最大値以下であればその値を返却する。
	    */
	    public static void checkName(String name) {
			// 最小値以上、最小値以下の判定
			if (1 <= name.length() && name.length() <= 20) {
				return;
			}
			// 判定NGならエラー
			throw new IllegalArgumentException(MSG.EMSG4);
		}
	       
public class MSG{
	public static final String EMSG1 = "半角数字で入力してください。";
	public static final String EMSG2 = "1以上100以下の数値を入力して下さい。";
	public static final String EMSG3 = "1以上10000以下の数値を入力して下さい。";
	public static final String EMSG4 = "社員名はを20字以内で入力して下さい。"; 
	public static final String EMSG5 = "社員名が重複しています。"; 
}
}

	    

