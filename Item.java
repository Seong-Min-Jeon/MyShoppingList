package javaTermProject;

public class Item {
	String name; //�׸��� �̸�
	int num; //����
	
	public Item(String name) {
		this.name = name;
		this.num = 1;
	}
	public Item(String name, int num) {
		this.name = name;
		this.num = num;
	}
	public String toString() {
		return name + "(" + num + ")";
	}
	
}
