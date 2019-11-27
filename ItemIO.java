package javaTermProject;
import java.util.ArrayList;

import javax.swing.JOptionPane;
// Item을 input output하는 클래스입니다. Minimum Functions 1
public class ItemIO {
	
	public void InputItem(Item item, ArrayList<Item> ary) { //Item을 input하는 method입니다.
		//만약 ary안에 있는 Item 중 item과 같은 이름을 가진 원소가 있다면 ary에 input이 안되도록 함.
		FileIO fileIO = new FileIO();
		try {
			fileIO.InputItem("Past List.txt",item);
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Can't create files.");
		}
	}
	public Item OutputItem(String name, ArrayList<Item> ary) { //name이 항목이름인 Item을 Output합니다. 
		//만약 ary안에 name이라는 이름을 가진 Item이 없다면 없다고 경고문을 띄우고 return null;
		return null; //Output당한 Item이 return됩니다. 후에 'name'이 삭제되었습니다. 메세지에 이용.
	}
}