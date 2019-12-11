package javaTermProjectPackage;
import java.io.IOException;
import java.util.ArrayList;

public class LoadLastItem {
	ArrayList<Item> ListAry = new ArrayList<>();

	public LoadLastItem() {
		FileIO fileIO = new FileIO();
		try {
			ArrayList<Item> ListAry = fileIO.Output("Last List.txt");
			this.ListAry = ListAry;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<Item> getList(){
		return ListAry;
	}
}
