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
		/** �w�����i���X�g */
		Items items = null;
		/** ���̓t�@�C���p�X */
		String fileName = args[0];
		/** id�ʏW�v���ʁ@���z*/
		Map<String, Integer> priceMap = new LinkedHashMap<>();
		/** id�ʏW�v���ʁ@���i��*/
		Map<String, String> nameMap = new LinkedHashMap<>();
		/** id�ʏW�v���ʁ@�w����*/
		Map<String, Integer> countMap = new LinkedHashMap<>();
		
		//�����Ŏw�肵��XML�t�@�C����ǂݍ��݁AJava�C���X�^���X�𐶐����܂��B
		InputStream is = new FileInputStream(fileName);
		items = JAXB.unmarshal(is, Items.class);
		//���������C���X�^���X����A�w�����Ԃƍw�����i���X�g���擾���܂��B
		String purchaseTime = items.getPurchaseTime();
		List<Item> itemList = items.getItems();
		//�w�����i���X�g ��itemId�ŏ����Ƀ\�[�g���܂��B
		itemList.sort(Comparator.comparing(Item::getItemId, Comparator.nullsLast(Comparator.naturalOrder())));
		
		//itemId��key�Ƃ��āA���z�E���i���E�w���������ꂼ���map�Ɋi�[���܂��B
		for (int i = 0 ; i < itemList.size() ; i++) {
			Item item = itemList.get(i);
			String itemId = item.getItemId();
			int price = item.getPrice();
			//map�ɓ���itemId�����݂��Ȃ��ꍇ
			if (!priceMap.containsKey(itemId)) {
				//���z�E���i���E�w������map�ɐV�K�ǉ����܂��B
				String itemName = item.getItemName();
				nameMap.put(itemId, itemName);
				priceMap.put(itemId, price);
				countMap.put(itemId, 1);
			//map�ɓ���itemId�����݂���ꍇ
			} else {
				//Price�ƍw���������Z���܂��B
				priceMap.put(itemId, new Integer(priceMap.get(itemId) + price));
				countMap.put(itemId, countMap.get(itemId) + 1);
			}
		}
		
		//���v���z���v�Z���܂��B
		int total = 0;
		for (String key : priceMap.keySet()) {
			total += priceMap.get(key);
		}
		
		//���t�̌`����ϊ����܂��B
		//yyyyMMddHHmmss �� yyyy�NMM��dd��HH��mm��ss�b
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = sdf.parse(purchaseTime);
        sdf.applyPattern("yyyy�NMM��dd��HH��mm��ss�b");
        purchaseTime = sdf.format(date);
		
		//���ʂ��o�͂��܂��B
		System.out.println("�w�����ԁF" + purchaseTime);
		for (String key : priceMap.keySet()) {
			System.out.println("���i���F" + nameMap.get(key) + "�@�w�����F" + countMap.get(key));
		}
		System.out.println("���v���z�F" + total + "�~");
	}
}
