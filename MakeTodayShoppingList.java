package javaTermProject;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//이번 쇼핑리스트를 구성하는 클래스입니다. Minimum Functions 3
public class MakeTodayShoppingList {
	
	public void CheckIn(Item item, ArrayList<Item> ary, ArrayList<Item> today) { //ary의 name이름을 가진 Item이 today의 끝으로 이동
		if(ary.contains(item)) {
			if(!today.contains(item)) {ary.remove(item); today.add(item);} 
			else JOptionPane.showMessageDialog(null, "Items Not Included!"); 
		} else JOptionPane.showMessageDialog(null, "Items Already Included!");
	}
	public void OutputItem(Item item, ArrayList<Item> today) { //name이 항목이름인 Item을 Output합니다. 
		if(today.contains(item))
			today.remove(item);
		else JOptionPane.showMessageDialog(null, "Items Not Included!");
	}
}
