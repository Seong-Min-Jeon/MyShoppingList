package javaTermProjectPackage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
// Item을 input output하는 클래스입니다. Minimum Functions 1
public class ItemIO {
	boolean b = true;
	
	public void InputItem(Item item, ArrayList<Item> ary) { //Item을 input하는 method입니다.
		/*
		for(int i = 0 ; i < ary.size() ; i++) {
			String name = ary.get(i).name;
			if(name.equals(item.name)) {
				JOptionPane.showMessageDialog(null, "Items Already Included!");
				b = false;
				break;
			}
		}
		if(b == true)
			ary.add(item);
		*/
		ary.add(item);
		
		FileIO fileIO = new FileIO();
		try {
			fileIO.Input2("Past List.txt",item);
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Can't create files.");
		}
	}
	/**
	public void OutputItem(Item item, ArrayList<Item> ary) { //name이 항목이름인 Item을 Output합니다. 
		if(ary.contains(item))
			ary.remove(item);
		else JOptionPane.showMessageDialog(null, "Items Not Included!");
	}
	*/
}