package javaTermProjectPackage;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//Item을 다른 분류 slot(카테고리)로 옮기는 기능입니다. Minimum Functions 2
public class MoveItem {
	
	public void Move(Item item, ArrayList<Item> ary1, ArrayList<Item> ary2) { //ary1의 name이름을 가진 Item이 ary2의 끝으로 이동
		ary1.remove(item); ary2.add(item);
	}
	public void Dup(Item item, ArrayList<Item> ary2) { //ary1의 name이름을 가진 Item이 ary2의 끝으로 복사
		ary2.add(item);
	}
}
