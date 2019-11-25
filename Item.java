package javaTermProject;

public class Item {
	String name; //항목의 이름
	int num; //수량
	
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
