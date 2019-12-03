package javaTermProjectPackage;
import java.io.IOException;
import java.util.ArrayList;

public class LoadPastItem {
	ArrayList<Item> ListAry = new ArrayList<>();

	public LoadPastItem() {
		FileIO fileIO = new FileIO();
		try {
			ArrayList<Item> ListAry = fileIO.Output("Past List.txt");
			this.ListAry = ListAry;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<Item> getList(){
		return ListAry;
	}
}
