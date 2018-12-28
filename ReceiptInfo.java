package kadai_12;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/** 購入情報*/
@XmlRootElement(name="reciept")
public class ReceiptInfo {

    /** 商品情報リスト*/
    @XmlElementWrapper(name="items")
    @XmlElement(name="item")
    private List<ItemInfo> items;

    /** 購入時間*/
    @XmlElement(name="purchasetime")
    private String time;

    /******************************************************
     * 商品情報リストを取得する
     * @return 商品情報リスト
     ******************************************************/
    public List<ItemInfo> getItems() {
        return items;
    }

    /******************************************************
     * 購入時間を取得する
     * @return 購入時間
     ******************************************************/
    public String getTime() {
        return time;
    }
}
