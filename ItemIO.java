package javaTermProjectPackage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
// Item�� input output�ϴ� Ŭ�����Դϴ�. Minimum Functions 1
public class ItemIO {
	boolean b = true;
	
	public void InputItem(Item item, ArrayList<Item> ary) { //Item�� input�ϴ� method�Դϴ�.
		ary.add(item);
		
		FileIO fileIO = new FileIO();
		try {
			fileIO.Input2("Last List.txt",item);
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Can't create files.");
		}
	}
}