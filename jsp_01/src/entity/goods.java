package entity;

public class goods {
	String goodsId;//��Ʒ���
	String goodsName;//��Ʒ����
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	String className;//��Ʒ����
	String type;//��Ʒ�ͺ�
	String price;//����
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassId(String classId) {
		this.className = classId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public goods(String goodsId, String goodsName, String className, String type, String price) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.className = className;
		this.type = type;
		this.price = price;
	}
	public goods() {
		
	}
	
}
