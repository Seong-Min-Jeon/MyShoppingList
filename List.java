package javaTermProject;	
import java.util.ArrayList;

public class List {
	String name;
	ArrayList<Item> ary;
	byte[] encrypted;
	public List(String name, ArrayList<Item> ary) {
		this.name = name; this.ary = ary;
	}
	public List(String name, ArrayList<Item> ary,byte[] encrypted) {
		this.name = name; this.ary = ary; this.encrypted = encrypted;
	}
	public String toString() {	
		return name + ary.toString() ;
	}
}
