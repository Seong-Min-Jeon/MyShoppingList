package javaTermProjectPackage;
import java.util.ArrayList;

public class ClearList {
	ArrayList<Item> ary;
	public ArrayList<Item> Clear(ArrayList<Item> ary) {
		this.ary = ary;
		ary.clear();
		return ary;
	}
}
