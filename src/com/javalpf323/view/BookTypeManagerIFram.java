package com.javalpf323.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javalpf323.dao.BookTypeDao;
import com.javalpf323.model.BookType;
import com.javalpf323.util.DbUtil;
import com.javalpf323.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManagerIFram extends JInternalFrame {
	
	private JTable table;
	private JScrollPane JScroll;
	private JTextField searchTextField;
	private JTextField idTextField;
	private JTextField BookTypeNameTextField;
	private JTextField IdTextField;
	private JTextField BookTypeNameTextField_1;
	private JTextArea BookTypeDescTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerIFram frame = new BookTypeManagerIFram();
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
	public BookTypeManagerIFram() {
		setTitle("\u56FE\u4E66\u7C7B\u578B\u7EF4\u62A4");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 638, 648);
		
	  JScroll = new JScrollPane();
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchActionPerform(e);
		
			}
		});
		searchButton.setIcon(new ImageIcon(BookTypeManagerIFram.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		
		JButton UpdateButton = new JButton("\u4FEE\u6539");
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateBookTypeActionform(e);
			

			}
		});
		UpdateButton.setIcon(new ImageIcon(BookTypeManagerIFram.class.getResource("/images/modify.png")));
		
		JButton DeleteButton = new JButton("\u5220\u9664");
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBookTypeActionform(e);
			}
		});
		DeleteButton.setIcon(new ImageIcon(BookTypeManagerIFram.class.getResource("/images/delete.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchButton))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
							.addComponent(JScroll, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)))
					.addGap(52))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(141)
					.addComponent(UpdateButton)
					.addGap(90)
					.addComponent(DeleteButton)
					.addContainerGap(221, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(36)
					.addComponent(JScroll, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(UpdateButton)
						.addComponent(DeleteButton))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		JLabel label_2 = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel label_4 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		JLabel label_5 = new JLabel("\u56FE\u4E66\u7C7B\u578B\u540D\u79F0\uFF1A");
		
		IdTextField = new JTextField();
		IdTextField.setEditable(false);
		IdTextField.setColumns(10);
		
		BookTypeNameTextField_1 = new JTextField();
		BookTypeNameTextField_1.setColumns(10);
		
		 BookTypeDescTextArea = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(IdTextField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(BookTypeNameTextField_1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(BookTypeDescTextArea, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(label_5)
						.addComponent(IdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BookTypeNameTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(BookTypeDescTextArea, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel label_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		

		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int row=table.getSelectedRow();
				IdTextField.setText((String)table.getValueAt(row, 0));
				BookTypeNameTextField_1.setText((String)table.getValueAt(row, 1));
				BookTypeDescTextArea.setText((String)table.getValueAt(row, 2));
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u578B\u540D\u79F0", "\u7C7B\u578B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(69);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(166);
		JScroll.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		this.FillTalble(new BookType("",""));

	}
	
	/**
	 * 删除图书类型
	 * @param evt
	 */
	private void DeleteBookTypeActionform(ActionEvent evt) {
		// TODO Auto-generated method stub
	    int id=new Integer(this.IdTextField.getText());
		Connection conn=null;
		try {
			BookTypeDao bookTypeDao=new BookTypeDao();
			conn=DbUtil.getConnection();
			int result=bookTypeDao.DeleteBookType(conn, id);
			if(result>0) {
				JOptionPane.showMessageDialog(null, "删除成功");
				 FillTalble(new BookType("",""));
				 this.IdTextField.setText("");
				 this.BookTypeNameTextField_1.setText("");
				 this.BookTypeDescTextArea.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	 * 更新图书类型
	 * @param evt
	 */
	private void updateBookTypeActionform(ActionEvent evt) {
		// TODO Auto-generated method stub
		String name= BookTypeNameTextField_1.getText();
		String desc=BookTypeDescTextArea.getText();
		String id=this.IdTextField.getText();
		if(StringUtil.IsEmpty(name)) {
			JOptionPane.showMessageDialog(null, "图书类型名称不能为空");
			return;
		}
		if(StringUtil.IsEmpty(id)) {
			JOptionPane.showMessageDialog(null, "id不能为空");
			return;
		}
		Connection conn=null;
		try {
			BookTypeDao bookTypeDao=new BookTypeDao();
			BookType bookType=new BookType(name,desc);
			bookType.setId(new Integer(id));
			conn=DbUtil.getConnection();
			int result=bookTypeDao.UpdateBookType(conn, bookType);
			if(result>0) {
				JOptionPane.showMessageDialog(null, "更新成功");
				 FillTalble(new BookType("",""));
			}else {
				JOptionPane.showMessageDialog(null, "更新失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	 * 查询图书类型
	 * @param evt
	 */
	private void SearchActionPerform(ActionEvent evt) {
		// TODO Auto-generated method stub
		String bookName=searchTextField.getText();
		BookType book=new BookType(bookName,"");
		this.FillTalble(book);
		
	}

	/**
	 * 初始化表格
	 * @param bookType
	 */
	private void FillTalble(BookType bookType) {
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		//初始化设置为0行
		dtm.setRowCount(0);
		Connection conn=null;
		try {
			conn=DbUtil.getConnection();
			BookTypeDao bookTypeDao=new BookTypeDao();
			ResultSet rs=bookTypeDao.GetBookTypeList(conn, bookType);
			while(rs.next()) {
				Vector vc=new Vector();
				vc.add(rs.getString("id"));
				vc.add(rs.getString("bookTypeName"));
				vc.add(rs.getString("bookDesc"));
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
}
