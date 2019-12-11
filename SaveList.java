package javaTermProjectPackage;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SaveList {
	public SaveList(ArrayList<List> listAry) {
		FileIO fileIO = new FileIO();
		try {
			fileIO.Input("List.txt", listAry);
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Can't create files.");
		}
	}
}
