package javaTermProject;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//�̹� ���θ���Ʈ�� �����ϴ� Ŭ�����Դϴ�. Minimum Functions 3
public class MakeTodayShoppingList {
	
	public void CheckIn(Item item, ArrayList<Item> ary, ArrayList<Item> today) { //ary�� name�̸��� ���� Item�� today�� ������ �̵�
		if(ary.contains(item)) {
			if(!today.contains(item)) {ary.remove(item); today.add(item);} 
			else JOptionPane.showMessageDialog(null, "Items Not Included!"); 
		} else JOptionPane.showMessageDialog(null, "Items Already Included!");
	}
	public void OutputItem(Item item, ArrayList<Item> today) { //name�� �׸��̸��� Item�� Output�մϴ�. 
		if(today.contains(item))
			today.remove(item);
		else JOptionPane.showMessageDialog(null, "Items Not Included!");
	}
}
