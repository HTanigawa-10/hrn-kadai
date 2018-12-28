package kadai_12;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** ���i���*/
@XmlRootElement(name="item")
public class ItemInfo {
    /** ���iID*/
    @XmlElement(name="itemid")
    private String id;

    /** ���i��*/
    @XmlElement(name="itemname")
    private String name;

    /** ���z*/
    @XmlElement(name="price")
    private long price;

    /******************************************************
     * ���iID���擾����
     * @return ���iID
     ******************************************************/
    public String getId() {
        return id;
    }

    /******************************************************
     * ���i�����擾����
     * @return ���i��
     ******************************************************/
    public String getName() {
        return name;
    }

    /******************************************************
     * ���z���擾����
     * @return ���z
     ******************************************************/
    public long getPrice() {
        return price;
    }

}
