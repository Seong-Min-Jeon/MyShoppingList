package javaTermProject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;


public class GUI extends JFrame {
	
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 576;
	private JScrollPane scrollPane;
	private JTable table;
	private Icon rename = new ImageIcon(Main.class.getResource("../image/intro_00001.png"));
	private Icon goToList = new ImageIcon(Main.class.getResource("../image/back1.png"));
	private JButton lastItem = new JButton(new ImageIcon(Main.class.getResource("../image/intro_00001.png")));
	private JButton addList = new JButton(new ImageIcon(Main.class.getResource("../image/intro_00011.png")));
	private JButton today = new JButton(new ImageIcon(Main.class.getResource("../image/intro_00021.png")));
	private JButton bookMark = new JButton(new ImageIcon(Main.class.getResource("../image/intro_00031.png")));
	private JButton addItem = new JButton(new ImageIcon(Main.class.getResource("../image/intro_00031.png")));
	private JButton home = new JButton(new ImageIcon(Main.class.getResource("../image/intro_00001.png")));
	private ArrayList<List> listAry;
	private DefaultTableModel model;
	private int listIdx;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUI frame = new GUI();
				frame.setVisible(true);
			}
		});
	}

	public GUI() {
		setTitle("MyShoppingList");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);
		setVisible(true);
		// setLocationRelativeTo(null);
		setLayout(null);
		Start st = new Start();

		Container c = getContentPane();
		c.setLayout(null);

		listAry = st.getList();
		System.out.println(listAry);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileIO fileIO = new FileIO();
				try {
					fileIO.Input("List.txt", listAry);
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Can't create files.");
				}
				System.exit(0);
			}
		});

		d1(listAry);
	}
	
	public void d1(ArrayList<List> listAry) {
		// ScrollPane for Table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1013, 461);
		getContentPane().add(scrollPane);

		// Table
		table = new JTable();
		// table.setShowHorizontalLines(false);
		// table.setShowVerticalLines(false);
		table.setRowHeight(80);
		scrollPane.setViewportView(table);
		Font font = new Font("Godic", Font.BOLD, 20);
		table.setFont(font);

		// Model for Table
		model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return Icon.class;
				case 2:
					return Icon.class;
				case 3:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		model.addColumn("List Name");
		model.addColumn("Go to List");
		model.addColumn("Modify Name");
		model.addColumn("Select");

		table.getColumnModel().getColumn(0).setPreferredWidth(900);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Data Row
		for (int i = 0; i < listAry.size() - 2; i++) {
			model.addRow(new Object[0]);
			model.setValueAt("      " + listAry.get(i + 2).name, i, 0);
			model.setValueAt(goToList, i, 1);
			model.setValueAt(rename, i, 2);
			model.setValueAt(false, i, 3);
		}
		
		/** JCombo test
		String[] dataItem = { "Item 1", "Item 2", "Item 3", "Item 4" };
		JComboBox countryCombo = new JComboBox(dataItem);
		TableColumn countryColumn = table.getColumnModel().getColumn(1);
		countryColumn.setCellEditor(new DefaultCellEditor(countryCombo));
		*/
		
		lastItem.setBounds(50,20,100,50);
		getContentPane().add(lastItem);
		
		addList.setBounds(450,20,100,50);
		getContentPane().add(addList);
		
		today.setBounds(200,20,100,50);
		getContentPane().add(today);
		
		bookMark.setBounds(330,20,100,50);
		getContentPane().add(bookMark);
		
		
		AddListListener addListListener = new AddListListener();
		addList.addMouseListener(addListListener);
		
		ModifyListener modifyListener = new ModifyListener();
		table.addMouseListener(modifyListener);
		
		TodayListener todayListener = new TodayListener();
		today.addMouseListener(todayListener);
		
		BookMarkListener bookMarkListener = new BookMarkListener();
		bookMark.addMouseListener(bookMarkListener);
		
		GoToListListener goToListListener = new GoToListListener();
		table.addMouseListener(goToListListener);
	}
		
	private class AddListListener extends JFrame implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			JFrame f = new JFrame();
			f.setTitle("Add List");
			f.setSize(300, 190);
			f.setLocationRelativeTo(null);
			f.setResizable(false);
			f.setVisible(true);
			f.setLayout(null);
			JLabel la1 = new JLabel("리스트의 이름");
			la1.setBounds(99,10,120,30);
			f.add(la1);
			JTextField tf1 = new JTextField();
			tf1.setBounds(80,50,120,30);
			f.add(tf1);
			JButton b = new JButton("확인");
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String nameData = tf1.getText();
					ArrayList<Item> ary = new ArrayList<>();
					Item i = new Item(nameData);
					ary.add(i);
					List list = new List(nameData,ary);
					listAry.add(list);
					model.addRow(new Object[0]);
					model.setValueAt("      " + listAry.get(listAry.size() - 1).name, listAry.size() - 3, 0);
					model.setValueAt(goToList, listAry.size() - 3, 1);
					model.setValueAt(rename, listAry.size() - 3, 2);
					model.setValueAt(false, listAry.size() - 3, 3);
					f.setVisible(false);
				}
			});
			b.setBounds(110,90,60,35);
			f.add(b);			
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
		
		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
			
	}
	
	private class ModifyListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if(column == 2) {
				JFrame f = new JFrame();
				f.setTitle("Modify Name");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				JLabel la1 = new JLabel("  수정할 이름");
				la1.setBounds(99,10,120,30);
				f.add(la1);
				JTextField tf1 = new JTextField();
				tf1.setBounds(80,50,120,30);
				f.add(tf1);
				JButton b = new JButton("확인");
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String nameData = tf1.getText();
						listAry.get(row + 2).name = nameData;
						model.setValueAt("      " + listAry.get(row+2).name, row, 0);
						f.setVisible(false);
					}
				});
				b.setBounds(110,90,60,35);
				f.add(b);			
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	private class TodayListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			lastItem.setVisible(false);
			scrollPane.setVisible(false);
			table.setVisible(false);
			addList.setVisible(false);
			today.setVisible(false);
			bookMark.setVisible(false);
			addItem.setVisible(true);
			home.setVisible(true);
			listIdx = 1;
			d2(listIdx);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	private class BookMarkListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			lastItem.setVisible(false);
			scrollPane.setVisible(false);
			table.setVisible(false);
			addList.setVisible(false);
			today.setVisible(false);
			bookMark.setVisible(false);
			addItem.setVisible(true);
			home.setVisible(true);
			listIdx = 0;
			d2(listIdx);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	private class GoToListListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if (column == 1) {
				lastItem.setVisible(false);
				scrollPane.setVisible(false);
				table.setVisible(false);
				addList.setVisible(false);
				today.setVisible(false);
				bookMark.setVisible(false);
				addItem.setVisible(true);
				home.setVisible(true);
				listIdx = row + 2;
				d2(listIdx);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	public void d2(int row) {
	
		// ScrollPane for Table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1013, 461);
		getContentPane().add(scrollPane);

		// Table
		table = new JTable();
		table.setRowHeight(80);
		scrollPane.setViewportView(table);
		Font font = new Font("Godic", Font.BOLD, 20);
		table.setFont(font);

		// Model for Table
		model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Icon.class;
				case 3:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		model.addColumn("Item Name");
		model.addColumn("QTY");
		model.addColumn("Modify Data");
		model.addColumn("Select");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(800);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Data Row
		for (int i = 0; i < listAry.get(row).ary.size() - 1; i++) {
			model.addRow(new Object[0]);
			model.setValueAt("      " + listAry.get(row).ary.get(i+1).name, i, 0);
			model.setValueAt("    " + listAry.get(row).ary.get(i+1).num, i, 1);
			model.setValueAt(rename, i, 2);
			model.setValueAt(false, i, 3);
		}
		
		addItem.setBounds(450,20,100,50);
		getContentPane().add(addItem);
		
		home.setBounds(800,20,100,50);
		getContentPane().add(home);
		
		AddItemListener addItemListener = new AddItemListener();
		addItem.addMouseListener(addItemListener);
		
		ModifyItemListener modifyItemListener = new ModifyItemListener();
		table.addMouseListener(modifyItemListener);
		
		HomeListener homeListener = new HomeListener();
		home.addMouseListener(homeListener);
	}
	
	private class AddItemListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			JFrame f = new JFrame();
			f.setTitle("Add Item");
			f.setSize(300, 190);
			f.setLocationRelativeTo(null);
			f.setResizable(false);
			f.setVisible(true);
			f.setLayout(null);
			JLabel la1 = new JLabel("아이템의 이름");
			la1.setLocation(40, -30);
			la1.setSize(100,100);
			JLabel la2 = new JLabel("수량");
			la2.setLocation(196, -30);
			la2.setSize(100,100);
			f.add(la1);
			f.add(la2);
			JTextField tf1 = new JTextField();
			tf1.setBounds(20,50,120,30);
			JTextField tf2 = new JTextField();
			tf2.setBounds(150,50,120,30);
			f.add(tf1);
			f.add(tf2);
			JButton b = new JButton("확인");
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ItemIO itemIO = new ItemIO();
					String nameData = tf1.getText();
					String qtyData = tf2.getText();
					try {
						Item i = new Item(nameData,Integer.parseInt(qtyData));
						itemIO.InputItem(i,listAry.get(listIdx).ary);
						if (itemIO.b == true) {
							model.addRow(new Object[0]);
							model.setValueAt("      " + listAry.get(listIdx).ary.get(listAry.get(listIdx).ary.size() - 1).name, listAry.get(listIdx).ary.size() - 2, 0);
							model.setValueAt("    " + listAry.get(listIdx).ary.get(listAry.get(listIdx).ary.size() - 1).num, listAry.get(listIdx).ary.size() - 2, 1);
							model.setValueAt(rename, listAry.get(listIdx).ary.size() - 2, 2);
							model.setValueAt(false, listAry.get(listIdx).ary.size() - 2, 3);
							f.setVisible(false);
						}
					} catch (Exception exception) {
						JOptionPane.showMessageDialog(null, "수량에는 정수를 넣어주세요!");
					}
				}
			});
			b.setBounds(110,90,60,35);
			f.add(b);			
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	private class ModifyItemListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if(column == 2) {
				JFrame f = new JFrame();
				f.setTitle("Modify Item");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				JLabel la1 = new JLabel("  수정할 이름");
				la1.setLocation(40, -30);
				la1.setSize(100,100);
				JLabel la2 = new JLabel("수량");
				la2.setLocation(196, -30);
				la2.setSize(100,100);
				f.add(la1);
				f.add(la2);
				JTextField tf1 = new JTextField();
				tf1.setBounds(20,50,120,30);
				JTextField tf2 = new JTextField();
				tf2.setBounds(150,50,120,30);
				f.add(tf1);
				f.add(tf2);
				JButton b = new JButton("확인");
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String nameData = tf1.getText();
						String qtyData = tf2.getText();
						try {
							listAry.get(listIdx).ary.get(row+1).name = nameData;
							listAry.get(listIdx).ary.get(row+1).num = Integer.parseInt(qtyData);
							model.setValueAt("      " + listAry.get(listIdx).ary.get(row+1).name, row, 0);
							model.setValueAt("    " + listAry.get(listIdx).ary.get(row+1).num, row, 1);
							f.setVisible(false);
						}catch(Exception exception) {
							JOptionPane.showMessageDialog(null, "수량에는 정수를 넣어주세요!");
						}
					}
				});
				b.setBounds(110,90,60,35);
				f.add(b);			
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}

	private class HomeListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			lastItem.setVisible(true);
			addList.setVisible(true);
			today.setVisible(true);
			bookMark.setVisible(true);
			scrollPane.setVisible(false);
			table.setVisible(false);
			addItem.setVisible(false);
			home.setVisible(false);
			d1(listAry);
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
}