package kadai_10;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "receipt")
public class Items {

	private List<Item> items = null;
	private String purchaseTime = null;
	
	public List<Item> getItems() {
		return items;
	}
    @XmlElementWrapper(name = "items")
	@XmlElement(name = "item")
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getPurchaseTime() {
		return purchaseTime;
	}
	@XmlElement(name = "purchasetime")
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
}

