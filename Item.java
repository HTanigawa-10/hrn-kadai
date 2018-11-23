package kadai_10;

import javax.xml.bind.annotation.XmlElement;

public class Item {
	private String itemid = null;
	private String itemName = null;
	private int price = 0;
	
	@XmlElement(name = "itemid")
	public String getItemId() {
		return itemid;
	}
	public void setItemId(String itemid) {
		this.itemid = itemid;
	}
	@XmlElement(name = "itemname")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String name) {
		this.itemName = name;
	}
	@XmlElement(name = "price")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}

