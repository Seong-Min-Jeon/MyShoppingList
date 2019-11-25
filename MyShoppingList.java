package javaTermProject;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


public class MyShoppingList extends JFrame{
	
	public MyShoppingList() {
		setTitle("Test");
		Start st = new Start();
		
		ArrayList<List> ListAry = st.getList();

		System.out.println(ListAry);
		
		String name =  line.split("\\[")[0];
        String remainder = line.split("\\[")[1];
        remainder = remainder.split("//]")[0];
        String[] splitStr = remainder.split(",");
        for(int i=0; i<splitStr.length; i++){
            .add(splitStr[i]);
        }
        */
		

		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileIO fileIO = new FileIO();
				try {
					fileIO.Input("List.txt",ListAry);
					
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Can't create files.");
				}
				System.exit(0);
			}
		});
		
		Container c = getContentPane();
		Item i = new Item("name",3);
		c.add(new JCheckBox(i.name));
		
		setSize(500,700);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyShoppingList();
	}
}
