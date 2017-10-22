package com.javalpf323.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.javalpf323.dao.UserDao;
import com.javalpf323.model.User;
import com.javalpf323.util.DbUtil;
import com.javalpf323.util.StringUtil;
import javax.swing.JPasswordField;

public class LoginOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private UserDao userDao=new UserDao();
	private JPasswordField passwordText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginOnFrm frame = new LoginOnFrm();
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
	public LoginOnFrm() {
		setResizable(false);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/logo.png")));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/userName.png")));
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801\uFF1A");
		label_2.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/password.png")));
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		
		JButton button = new JButton("\u767B \u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginOnActionFrm(e);
			}
		});
		button.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/login.png")));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionFrm(e);
			}
		});
		button_1.setIcon(new ImageIcon(LoginOnFrm.class.getResource("/images/modify.png")));
		
		passwordText = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(115)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordText)
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(label)
							.addComponent(userNameText, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
					.addGap(185))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addComponent(button)
					.addGap(103)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(label)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//让窗体居中显示
		this.setLocationRelativeTo(null);
	}

	/**
	 * 重置事件
	 * @param e
	 */
	private void ResetActionFrm(ActionEvent e) {
		// TODO Auto-generated method stub
		this.userNameText.setText("");
		this.passwordText.setText("");
		
	}

	/**
	 * 登录事件
	 * @param evt
	 */
	private void LoginOnActionFrm(ActionEvent evt) {
		// TODO Auto-generated method stub
		String userName=this.userNameText.getText();
		String password=new String(this.passwordText.getPassword());
		if(StringUtil.IsEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.IsEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		try {
			User user=new User(userName,password);
			Connection conn=DbUtil.getConnection();
			User result=userDao.Login(conn, user);
			if(result!=null) {
				dispose();
				MainFrm main=new MainFrm();
				main.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "账号或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
