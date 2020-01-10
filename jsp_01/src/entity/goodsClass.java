package entity;

public class goodsClass {
	String id;//类别id
	String name;//类别名称
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
