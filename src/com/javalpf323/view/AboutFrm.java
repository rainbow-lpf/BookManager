package com.javalpf323.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AboutFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutFrm frame = new AboutFrm();
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
	public AboutFrm() {
		getContentPane().setBackground(Color.ORANGE);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setBounds(100, 100, 450, 300);
		
		JLabel lblversion = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDFversion1.0.0");
		lblversion.setIcon(new ImageIcon(AboutFrm.class.getResource("/images/logo.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(99)
					.addComponent(lblversion)
					.addContainerGap(123, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(lblversion)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
