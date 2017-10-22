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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookTypeManagerIFram extends JInternalFrame {
	private JTable table;
	private JScrollPane JScroll;
	private JTextField searchTextField;

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
		setBounds(100, 100, 638, 443);
		
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(137, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchButton)
							.addGap(139))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(JScroll, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
							.addGap(129))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(JScroll, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(93))
		);
		
		table = new JTable();
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
	
	protected void SearchActionPerform(ActionEvent evt) {
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
