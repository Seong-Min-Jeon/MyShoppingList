package javaTermProject;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	private Image introBackground;

	public GUI() {
		setTitle("MyShoppingList");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		setResizable(false);
		setVisible(true);
		Start st = new Start();
		
		ArrayList<List> ListAry = st.getList();

		System.out.println(ListAry);
		
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
		intro();
		
		Item i1 = new Item("°¡°¡");
		Item i2 = new Item("bb",5);
		Item i3 = new Item("c³ªc", 10);
		ArrayList<Item> a = new ArrayList<>();
		ArrayList<Item> b = new ArrayList<>();
		a.add(i1);
		b.add(i2);
		b.add(i3);
		List l1 = new List("name1", a);
		List l2 = new List("name2", b);
		ListAry.add(l1);
		ListAry.add(l2);
		
		introBackground = new ImageIcon(Main.class.getResource("../image/back1.png")).getImage();
	}
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0 ,null);	
	}
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		this.repaint();
	}
	
	
	public void intro() {
		for(int i = 0 ; i < 10 ; i++) {
			introBackground = new ImageIcon(Main.class.getResource("../image/intro_0000"+i+".png")).getImage();
			try {
				Thread.sleep(33);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		for(int i = 10 ; i < 40 ; i++) {
			introBackground = new ImageIcon(Main.class.getResource("../image/intro_000"+i+".png")).getImage();
			try {
				Thread.sleep(33);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		for(int i = 0 ; i < 10 ; i++) {
			introBackground = new ImageIcon(Main.class.getResource("../image/intro_00039.png")).getImage();
			try {
				Thread.sleep(33);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
}
