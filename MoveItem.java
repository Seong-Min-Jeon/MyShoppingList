package javaTermProject;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//Item�� �ٸ� �з� slot(ī�װ�)�� �ű�� ����Դϴ�. Minimum Functions 2
public class MoveItem {
	
	public void Move(Item item, ArrayList<Item> ary1, ArrayList<Item> ary2) { //ary1�� name�̸��� ���� Item�� ary2�� ������ �̵�
		if(ary1.contains(item)) {
			if(!ary2.contains(item)) {ary1.remove(item); ary2.add(item);} 
			else JOptionPane.showMessageDialog(null, "Items Not Included!"); 
		} else JOptionPane.showMessageDialog(null, "Items Already Included!");
	}
}
