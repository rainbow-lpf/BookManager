package com.javalpf323.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
    private	JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddFrm about=new BookTypeAddFrm();
				about.setVisible(true);
				table.add(about);
			
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		mnNewMenu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerIFram btm=new BookTypeManagerIFram();
				btm.setVisible(true);
				table.add(btm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu_1.add(menuItem_2);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		mnNewMenu.add(menu);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu.add(menuItem_4);
		
		JMenuItem menuItem = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否推出本系统");
				if(result==0) {
					dispose();
				}
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		mnNewMenu.add(menuItem);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_5 = new JMenuItem("\u7248\u672C");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutFrm about=new AboutFrm();
				about.setVisible(true);
				table.add(about);
			}
		});
		menu_1.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
}
