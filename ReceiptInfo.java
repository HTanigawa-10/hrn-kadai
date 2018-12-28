package kadai_12;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/** �w�����*/
@XmlRootElement(name="reciept")
public class ReceiptInfo {

    /** ���i��񃊃X�g*/
    @XmlElementWrapper(name="items")
    @XmlElement(name="item")
    private List<ItemInfo> items;

    /** �w������*/
    @XmlElement(name="purchasetime")
    private String time;

    /******************************************************
     * ���i��񃊃X�g���擾����
     * @return ���i��񃊃X�g
     ******************************************************/
    public List<ItemInfo> getItems() {
        return items;
    }

    /******************************************************
     * �w�����Ԃ��擾����
     * @return �w������
     ******************************************************/
    public String getTime() {
        return time;
    }
}
