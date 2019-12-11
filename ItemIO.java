package javaTermProjectPackage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
// Item을 input output하는 클래스입니다. Minimum Functions 1
public class ItemIO {
	boolean b = true;
	
	public void InputItem(Item item, ArrayList<Item> ary) { //Item을 input하는 method입니다.
		ary.add(item);
		
		FileIO fileIO = new FileIO();
		try {
			fileIO.Input2("Last List.txt",item);
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Can't create files.");
		}
	}
}