package com.javalpf323.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.javalpf323.dao.BookDao;
import com.javalpf323.dao.BookTypeDao;
import com.javalpf323.model.Book;
import com.javalpf323.model.BookType;
import com.javalpf323.util.DbUtil;
import com.javalpf323.util.StringUtil;

public class BookAddIFram extends JInternalFrame {
	private JTextField BookNameTextField;
	private JTextField authorTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTextField;
	private JTextArea bookDescTextArea;
	private JComboBox bookTypeComboBox;
	private JRadioButton radioButton ;
	private JRadioButton radioButton_1;
	private BookDao bookDao=new BookDao();
	private BookTypeDao bookTypeDao=new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddIFram frame = new BookAddIFram();
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
	public BookAddIFram() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 580, 421);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\uFF1A");
		
		JLabel label_2 = new JLabel("\u6027   \u522B\uFF1A");
		
		JLabel label_3 = new JLabel("\u4EF7\u683C\uFF1A");
		
		JLabel label_4 = new JLabel("\u63CF  \u8FF0\uFF1A");
		
		BookNameTextField = new JTextField();
		BookNameTextField.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setColumns(10);
		
		 radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		buttonGroup.add(radioButton);
		
		 radioButton_1 = new JRadioButton("\u5973");
		buttonGroup.add(radioButton_1);
		
		priceTextField = new JTextField();
		priceTextField.setColumns(10);
		
		 bookDescTextArea = new JTextArea();
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addActionPreformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddIFram.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPefforme(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAddIFram.class.getResource("/images/reset.png")));
		
		JLabel label_5 = new JLabel("\u56FE\u4E66\u7C7B\u578B\uFF1A");
		
		 bookTypeComboBox = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_5)
						.addComponent(label_2)
						.addComponent(label)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(BookNameTextField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(radioButton)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(radioButton_1))
									.addComponent(button))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(label_1)
											.addComponent(label_3))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
											.addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(22)
										.addComponent(button_1))))
							.addComponent(bookDescTextArea))
						.addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(BookNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(label_3)
						.addComponent(radioButton)
						.addComponent(radioButton_1)
						.addComponent(priceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(bookDescTextArea, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1)
								.addComponent(button))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(bookTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addComponent(label_4)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.fillBookType();
	}

	/**
	 * 重置按钮
	 * @param e
	 */
	private void resetActionPefforme(ActionEvent evt) {
		this.BookNameTextField.setText("");
		this.bookDescTextArea.setText("");
		this.authorTextField.setText("");
		this.priceTextField.setText("");
	}

	/**
	 * 添加图书
	 * @param evt
	 */
	private void addActionPreformed(ActionEvent evt) {
		String bookName=this.BookNameTextField.getText();
		String bookDesc=this.bookDescTextArea.getText();
		String author=this.authorTextField.getText();
		String price= this.priceTextField.getText();
		String sex="";
		if(StringUtil.IsEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空");
			return;
		}
		if(StringUtil.IsEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者不能为空");
			return;
		}
		if(StringUtil.IsEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空");
			return;
		}
		if(this.radioButton.isSelected()) {
			sex="男";
		}else {
			sex="女";
		}
		BookType bookType=(BookType)this.bookTypeComboBox.getSelectedItem();
		Book book=new Book(bookName,author,sex,Float.parseFloat(price),bookDesc,bookType.getId());
		Connection conn=null;
		try {
			conn=DbUtil.getConnection();
			int result=bookDao.addBook(conn, book);
			if(result>0) {
				JOptionPane.showMessageDialog(null, "添加成功");
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
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
	 * 绑定combox
	 */
	private void fillBookType() {
		Connection conn=null;
		BookType bookType=null;
		try {
			conn=DbUtil.getConnection();
			ResultSet rs=bookTypeDao.GetBookTypeList(conn, new BookType("",""));
			while(rs.next()){
				bookType=new BookType();
			  	bookType.setId(rs.getInt("id"));
			  	bookType.setBookTypeName(rs.getString("bookTypeName"));
			  	this.bookTypeComboBox.addItem(bookType);
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
