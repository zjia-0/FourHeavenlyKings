package entity;

public class goodsClass {
	String id;//���id
	String name;//�������
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public goodsClass(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
