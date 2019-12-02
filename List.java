package javaTermProjectPackage;	
import java.util.ArrayList;

public class List {
	String name;
	ArrayList<Item> ary;

	public List(String name, ArrayList<Item> ary) {
		this.name = name; this.ary = ary;
	}
	public String toString() {	
		return name + ary.toString() ;
	}
}
