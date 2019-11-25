package javaTermProject;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileIO {
	//파일을 쓰는 함수입니다.
	public void Input(String filename, ArrayList ary) throws IOException {
		File fn  = new File(filename);
		try {
			FileWriter fw = new FileWriter(fn);
			Writer output = new BufferedWriter(fw);
			int size = ary.size();
			for (int i = 0 ; i < size ; i++) {
				output.write(ary.get(i).toString() + "\n");
			}
			output.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//파일을 읽는 함수입니다. (Total List)
		public ArrayList<List> OutputFinal(String filename, ArrayList<List> ary) throws IOException {
			String line;
			try {
				BufferedReader input = new BufferedReader(new FileReader(filename));
				if (!input.ready()) 
					throw new IOException();
				while ((line = input.readLine()) != null) {	 
					ArrayList<Item> group = new ArrayList<>();
					String Listname =  line.split("\\[")[0];
		            String remainder = line.split("\\[")[1];
		            remainder = remainder.split("\\]")[0];
		            String[] splitStr = remainder.split(", ");
		            for(int i=0; i<splitStr.length; i++){
		            	//System.out.println(splitStr[i]);
		                String name =  splitStr[i].split("\\(")[0];
			            String subRemainder = splitStr[i].split("\\(")[1];
			            String num = subRemainder.split("\\)")[0];
			            Item item = new Item(name, Integer.parseInt(num));
			            group.add(item);
		            }
		            List list = new List(Listname,group);
		            ary.add(list);
				}
				input.close();
			} catch (Exception e) {
				File fn  = new File("List.txt");
			}
			return ary;
		}
}
