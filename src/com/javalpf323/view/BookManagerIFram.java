package com.javalpf323.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.javalpf323.dao.BookDao;
import com.javalpf323.dao.BookTypeDao;
import com.javalpf323.model.Book;
import com.javalpf323.model.BookType;
import com.javalpf323.util.DbUtil;
import com.javalpf323.util.StringUtil;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManagerIFram extends JInternalFrame {
	private JTextField bookAuthorTextField;
	private JTextField bookNameTextField;
	private JTable bookTable;
	private JComboBox bookTypeComboBox;
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JTextField upBookIdTextField;
	private JTextField upBookNameTextField;
	private JTextField upBookAuthorTextField;
	private JTextField upBookPriceTextField;
	private JComboBox upBookTypeComboBox;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JTextArea upBookDescTextArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerIFram frame = new BookManagerIFram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookManagerIFram() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7EF4\u62A4");
		setBounds(100, 100, 782, 621);
		
		JLayeredPane panel = new JLayeredPane();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u641C\u7D22\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBookActionPerforme(e);
			}
		});
		button.setIcon(new ImageIcon(BookManagerIFram.class.getResource("/images/modify.png")));
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 resetAcionPerForme(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookManagerIFram.class.getResource("/images/delete.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(button)
							.addGap(82)
							.addComponent(button_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 691, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel label_5 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u4EF7\u683C\uFF1A");
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u7C7B\u578B\uFF1A");
		
		JLabel label_8 = new JLabel("\u4F5C\u8005\u6027\u522B\uFF1A");
		
		JLabel label_9 = new JLabel("\u56FE\u4E66\u63CF\u8FF0\uFF1A");
		
		 upBookDescTextArea = new JTextArea();
		
		upBookIdTextField = new JTextField();
		upBookIdTextField.setEditable(false);
		upBookIdTextField.setColumns(10);
		
		upBookNameTextField = new JTextField();
		upBookNameTextField.setColumns(10);
		
		upBookAuthorTextField = new JTextField();
		upBookAuthorTextField.setColumns(10);
		
		upBookPriceTextField = new JTextField();
		upBookPriceTextField.setColumns(10);
		
		 upBookTypeComboBox = new JComboBox();
		 
		radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		
	    radioButton_1 = new JRadioButton("\u5973");
		buttonGroup.add(radioButton_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(upBookPriceTextField)
								.addComponent(upBookIdTextField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
							.addGap(28)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_7))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(upBookTypeComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(upBookNameTextField, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(radioButton_1))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(upBookAuthorTextField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(upBookDescTextArea, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)))
					.addGap(72))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(upBookIdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(upBookNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(upBookAuthorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(label_7)
						.addComponent(label_8)
						.addComponent(upBookPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(upBookTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton)
						.addComponent(radioButton_1))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9)
						.addComponent(upBookDescTextArea, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectUpdateMousePress(e);
				
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u578B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(77);
		scrollPane.setViewportView(bookTable);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		bookNameTextField = new JTextField();
		bookNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		bookAuthorTextField = new JTextField();
		bookAuthorTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		
	    bookTypeComboBox = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setIcon(new ImageIcon(BookManagerIFram.class.getResource("/images/search.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBookActionPerforme(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookNameTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookAuthorTextField, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnNewButton)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(bookAuthorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillBook(new Book("","","",0,"",-1));
	}

	/**
	 * 重置按钮实现
	 * @param e
	 */
	private void resetAcionPerForme(ActionEvent e) {
		String id= this.upBookIdTextField.getText();
		if(StringUtil.IsEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择数据删除");
			return;
		}
		Connection conn=null;
		try {
			conn=DbUtil.getConnection();
			int select=JOptionPane.showConfirmDialog(null, "是否确认删除");
			if(select==0) {
			int result=bookDao.deleteBook(conn,new Integer(id));
			if(result>0) {
				JOptionPane.showMessageDialog(null,"删除成功");
				this.fillBook(new Book("","","",0,"",-1));
				this.upBookNameTextField.setText("");
				this.upBookAuthorTextField.setText("");
				this.upBookPriceTextField.setText("");
				this.upBookDescTextArea.setText("");
				this.upBookIdTextField.setText("");
			}else {
				JOptionPane.showMessageDialog(null,"删除失败");
			}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				DbUtil.CloseConnection(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

	private void selectUpdateMousePress(MouseEvent e) {
		int row=bookTable.getSelectedRow();
		this.upBookNameTextField.setText((String)this.bookTable.getValueAt(row, 1));
		this.upBookAuthorTextField.setText((String)this.bookTable.getValueAt(row, 2));
		this.upBookPriceTextField.setText((Float)this.bookTable.getValueAt(row, 4)+"");
		this.upBookIdTextField.setText((int)this.bookTable.getValueAt(row, 0)+"");
		this.upBookDescTextArea.setText((String)this.bookTable.getValueAt(row, 5));
		String sex=(String)this.bookTable.getValueAt(row, 3);
		String bookTypeName=(String)this.bookTable.getValueAt(row, 6);
		if("男".equals(sex)) {
			this.radioButton.setSelected(true);
		}else {
			this.radioButton_1.setSelected(true);
		}
		int rowsCount=this.bookTypeComboBox.getItemCount();
		for(int i=0;i<rowsCount;i++) {
			BookType bookType=(BookType)this.upBookTypeComboBox.getItemAt(i);
			if(bookType.getBookTypeName().equals(bookTypeName)) {
				this.upBookTypeComboBox.setSelectedIndex(i);
			}
		}
		
	}

	/**
	 * 修改图书
	 * @param evt
	 */
	private void updateBookActionPerforme(ActionEvent evt) {
		String bookName=this.upBookNameTextField.getText();
		String bookAuthor=this.upBookAuthorTextField.getText();
		String sex="";
		if(this.radioButton.isSelected()) {
			sex="男";
		}else {
			sex="女";
		}
		String price=this.upBookPriceTextField.getText();
		String bookDesc=this.upBookDescTextArea.getText();
		BookType bookType=(BookType)this.upBookTypeComboBox.getSelectedItem();
		String bookId=this.upBookIdTextField.getText();
		if(StringUtil.IsEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "ID不能为空");
			return;
		}
		if(StringUtil.IsEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		
		Book book=new Book(bookName,bookAuthor,sex,Float.parseFloat(price),bookDesc,bookType.getId());
		book.setId(new Integer(bookId));
		Connection conn=null;
		try {
			conn=DbUtil.getConnection();
			int result=bookDao.updateBook(conn, book);
			if(result>0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.fillBook(new Book("","","",0,"",-1));
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtil.CloseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询事件
	 * @param evt
	 */
	private  void searchBookActionPerforme(ActionEvent evt) {
	
		String bookName=this.bookNameTextField.getText();
		String bookAuthor=this.bookAuthorTextField.getText();
		BookType bookType=(BookType)this.bookTypeComboBox.getSelectedItem();
		Book book=new Book(bookName,bookAuthor,"",0,"",bookType.getId());
		this.fillBook(book);
	}
	
	private void fillBook(Book book) {
		DefaultTableModel dtm=(DefaultTableModel)bookTable.getModel();
		//初始化设置为0行
		dtm.setRowCount(0);

		Connection conn=null;
		try {
			conn=DbUtil.getConnection();
			ResultSet rs=bookDao.getBookList(conn, book);
			while(rs.next()) {
				Vector vc=new Vector();
				vc.add(rs.getInt("id"));
				vc.add(rs.getString("bookName"));
				vc.add(rs.getString("author"));
				vc.add(rs.getString("sex"));
				vc.add(rs.getFloat("price"));
				vc.add(rs.getString("bookDesc"));
				vc.add(rs.getString("bookTypeName"));
				dtm.addRow(vc);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtil.CloseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void fillBookType(String type) 
	{
		Connection conn=null;
		 BookType bookType=null;
		try {
			 conn=DbUtil.getConnection();
			 ResultSet rs=bookTypeDao.GetBookTypeList(conn, new BookType("",""));
			 if("search".equals(type)) {
				 bookType=new BookType();
				 bookType.setBookTypeName("请选择");
				 bookType.setId(-1);
				 bookType.setBookDesc("");
				 this.bookTypeComboBox.addItem(bookType);
			 }
			 while(rs.next()) {
				  bookType=new BookType();
				 bookType.setBookTypeName(rs.getString("bookTypeName"));
				 bookType.setId(rs.getInt("id"));
				 if("modify".equals(type)) {
					 this.upBookTypeComboBox.addItem(bookType);
				 }else {
					 this.bookTypeComboBox.addItem(bookType);
				 }
				 //this.bookTypeComboBox.addItem(bookType);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DbUtil.CloseConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
