package kadai_12;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class FileReadAndOutPut {
	public static void main(String args[]) throws Exception{
		
		/** 出力処理用のMap ※自動ソートを利用する  */
		Map<String, OutputInfo> outputMap = new TreeMap<>();
		/** 合計金額  */
		long amounts = 0;
		/** XMLファイルの拡張子(.xml) */
		String XML = ".xml";
		/** 対象ディレクトリパス 　*/
		String path = args[0];
		/** 対象ディレクトリ配下のファイル一覧　 */
		File files[] = (new File(path)).listFiles();
		/** ファイル一覧の中からXMLファイルのパスのみ抽出したリスト　*/
		ArrayList<String> xmlFileList = null;
		
		//指定のパスがディレクトリであり、かつ配下にファイルが存在することを確認します。
		if ( files == null ) {
			System.out.println("指定のパスはディレクトリではありません。");
			System.exit(1);
		} else if ( files.length == 0 ) {
			System.out.println("指定のディレクトリ配下にファイルが存在しません。");
			System.exit(1);
		}
		
		xmlFileList = new ArrayList<String>();
		
		//ファイル一覧の中から、XMLファイルのフルパスのみ取得します。
		for ( int i = 0 ; i < files.length ; i++ ) { 
			String fileName = files[i].getName();
			
			if ( !files[i].isDirectory() ) {
				if ( fileName.endsWith(XML) )
					xmlFileList.add( path + "/" + fileName );
			}
		}
		
		//XMLファイルが存在しない場合は処理を終了します。
		if ( xmlFileList.size() == 0 ) {
			System.out.println("XMLファイルが存在しませんでした。");
			System.exit(1);
		}

		//XMLファイルのファイル数分、処理を繰り返し行います。
		for ( int i = 0 ; i < xmlFileList.size() ; i++ ) {
			ReceiptInfo recieptInfo = null;
			
			//XMLをオブジェクトに変換します。
			try {
				recieptInfo = ReadFile.readXmlWithPath(xmlFileList.get(i), ReceiptInfo.class);
			} catch (Exception e) {
				System.out.println("XMLファイルの内容が正しくありません。指定の形式と一致していることを確認してください。");
				System.out.println("対象ファイル　「" + xmlFileList.get(i) + "」");
				e.printStackTrace();
				System.exit(1);
			}
			
			//変換したオブジェクトから情報を取得します。
			for (ItemInfo itemInfo : recieptInfo.getItems()) {
				String id = itemInfo.getId();
				if (!outputMap.containsKey(id)) {
				    outputMap.put(id, new OutputInfo(itemInfo.getName()));
				} else {
				    outputMap.get(id).increaseItemCounts();
				}
				amounts += itemInfo.getPrice();
			}
		}

		//結果を出力します。
		for (String key : outputMap.keySet()) {
			System.out.println("商品名：" + outputMap.get(key).getItemName() + "　購入個数：" + outputMap.get(key).getItemCounts());
		}
		System.out.println("合計金額：" + amounts + "円");
	  }
}
