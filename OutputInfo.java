package kadai_12;
/** �o�͗p�N���X*/
public class OutputInfo {
    /** ���i��*/
    private String itemName;
    /** ���i�̌�*/
    private int itemCounts = 0;

    /******************************************************
     * �R���X�g���N�^�@���i����ݒ肵�A���i�̌���1���Z����B
     * @param itemId ���iID
     * @param itemName ���i��
     ******************************************************/
    public OutputInfo(String itemName){
        this.itemName = itemName;
        itemCounts++;
    }

    /******************************************************
     * ���i�����擾����
     * @return ���i��
     ******************************************************/
    public String getItemName() {
        return itemName;
    }

    /******************************************************
     * ���i����ݒ肷��
     * @param itemName ���i��
     ******************************************************/
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /******************************************************
     * ���i�̌����擾����
     * @return ���i�̌�
     ******************************************************/
    public int getItemCounts() {
        return itemCounts;
    }

    /******************************************************
     * ���i�̌������Z����
     ******************************************************/
    public void increaseItemCounts(){
        this.itemCounts++;
    }
}
