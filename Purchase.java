package kadai_10;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXB;

public class Purchase {
	
	public static void main(String[] args) throws Exception{
		/** 入力ファイルパス */
		String fileName = args[0];
		/** id別集計結果　金額*/
		Map<String, Integer> priceMap = new LinkedHashMap<>();
		/** id別集計結果　商品名*/
		Map<String, String> nameMap = new LinkedHashMap<>();
		/** id別集計結果　購入個数*/
		Map<String, Integer> countMap = new LinkedHashMap<>();
		
		//引数で指定したXMLファイルを読み込み、Javaインスタンスを生成します。
		InputStream is = new FileInputStream(fileName);
		Items items = JAXB.unmarshal(is, Items.class);
		//生成したインスタンスから、購入時間と購入商品リストを取得します。
		String purchaseTime = items.getPurchaseTime();
		List<Item> itemList = items.getItems();
		//購入商品リストをitemIdで昇順にソートします。
		itemList.sort(Comparator.comparing(Item::getItemId, Comparator.nullsLast(Comparator.naturalOrder())));
		
		//itemIdをkeyとして、金額・商品名・購入個数をそれぞれのmapに格納します。
		for (int i = 0 ; i < itemList.size() ; i++) {
			Item item = itemList.get(i);
			String itemId = item.getItemId();
			int price = item.getPrice();
			//mapに同じitemIdが存在しない場合
			if (!priceMap.containsKey(itemId)) {
				//金額・商品名・購入個数をmapに新規追加します。
				String itemName = item.getItemName();
				nameMap.put(itemId, itemName);
				priceMap.put(itemId, price);
				countMap.put(itemId, 1);
			//mapに同じitemIdが存在する場合
			} else {
				//金額と購入個数を加算します。
				priceMap.put(itemId, new Integer(priceMap.get(itemId) + price));
				countMap.put(itemId, countMap.get(itemId) + 1);
			}
		}
		
		//合計金額を計算します。
		int total = 0;
		for (String key : priceMap.keySet()) {
			total += priceMap.get(key);
		}
		
		//日付の形式を変換します。
		//yyyyMMddHHmmss → yyyy年MM月dd日HH持mm分ss秒
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        	Date date = sdf.parse(purchaseTime);
      		sdf.applyPattern("yyyy年MM月dd日HH持mm分ss秒");
        	purchaseTime = sdf.format(date);
		
		//結果を出力します。
		System.out.println("購入時間：" + purchaseTime);
		for (String key : priceMap.keySet()) {
			System.out.println("商品名：" + nameMap.get(key) + "　購入個数：" + countMap.get(key));
		}
		System.out.println("合計金額：" + total + "円");
	}
}
