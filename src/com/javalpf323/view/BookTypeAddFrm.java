package com.javalpf323.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.javalpf323.dao.BookTypeDao;
import com.javalpf323.model.BookType;
import com.javalpf323.util.DbUtil;
import com.javalpf323.util.StringUtil;

public class BookTypeAddFrm extends JInternalFrame {
	private JTextField bookTypeNameText;
	private JTextArea bookTypeDescTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddFrm frame = new BookTypeAddFrm();
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
	public BookTypeAddFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u578B\u6DFB\u52A0");
		setBounds(100, 100, 503, 362);
		
		JLabel lblNewLabel = new JLabel("\u7C7B\u578B\u540D\u79F0");
		
		JLabel label = new JLabel("\u7C7B\u578B\u63CF\u8FF0");
		
		bookTypeNameText = new JTextField();
		bookTypeNameText.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AddBookTypeActionformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookTypeAddFrm.class.getResource("/images/add.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionfrome(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeAddFrm.class.getResource("/images/reset.png")));
		
		bookTypeDescTextArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeNameText, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addGap(88)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addComponent(bookTypeDescTextArea, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))))
					.addGap(99))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(bookTypeDescTextArea, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 添加图书类型
	 * @param evt
	 */
	private void AddBookTypeActionformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookTypeName=this.bookTypeNameText.getText();
		String bookTypeDesc=this.bookTypeDescTextArea.getText();
		if(StringUtil.IsEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类型不能为空");
			return;
		}
		BookType bookType=new BookType();
		bookType.setBookTypeName(bookTypeName);
		bookType.setBookDesc(bookTypeDesc);
		BookTypeDao bookTypeDao=new BookTypeDao();
		Connection conn=null;
		try {
			 conn=DbUtil.getConnection();
			 int result=bookTypeDao.AddBookType(conn, bookType);
			 if(result>=1) {
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
	 * 重置事件
	 * @param evt
	 */
	private void ResetActionfrome(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.bookTypeNameText.setText("");
		this.bookTypeDescTextArea.setText("");
	

	}
}
