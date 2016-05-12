package javapro;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class login extends JFrame implements ActionListener{
        private static final String ADD = "ADD";
	private static final String CANCEL = "CANCEL";
	private static final long serialVersionUID = -196950585230726337L;
	private JLabel name_lab;
	private JLabel password_lab;
	private JLabel adminOrStaff_lab;
	private JLabel explain;
	private JRadioButton madmin_JRB;
	private JRadioButton staff_JRB;
	private JTextField name_jf;
	private JPasswordField password_jtf;
	private JButton Login;
	private JButton cancel;

	private ButtonGroup bg = new ButtonGroup();
    static String flag;

	private String initComponents() {
		this.setTitle("用户登陆");
		setLayout(null);
		add(getName_lab());
		add(getPassword_lab());
		add(getAdminOrStaff_lab());
		add(getMadmin_JRB());
		add(getStaff_JRB());
		add(getName_jf());
		add(getPassword_jtf());
		add(getExplain());
		add(getLogin());
		add(getCancel());
		setSize(316, 320);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        return flag;
	}

	private JLabel getExplain() {
		if (explain == null) {
			explain = new JLabel();
			explain.setText("用户登陆");
			explain.setBounds(100, 130, 80, 18);
		}
		return explain;
	}

	private JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton();
			cancel.setText("取消");
			cancel.setActionCommand(CANCEL);
			cancel.setBounds(177, 180, 81, 28);
			cancel.addActionListener(this);
		}
		return cancel;
	}

	private JButton getLogin() {
		if (Login == null) {
			Login = new JButton();
			Login.setText("登陆");
			Login.setActionCommand(ADD);
			Login.setBounds(49, 180, 81, 28);
			Login.addActionListener(this);
		}
		return Login;
	}

	private JPasswordField getPassword_jtf() {
		if (password_jtf == null) {
			password_jtf = new JPasswordField();
			password_jtf.setText("");
			password_jtf.setBounds(62,71, 178, 22);
		}
		return password_jtf;
	}

	private JTextField getName_jf() {
		if (name_jf == null) {
			name_jf = new JTextField();
			name_jf.setText("");
			name_jf.setBounds(62, 41, 178, 22);
		}
		return name_jf;
	}



	private JRadioButton getStaff_JRB() {
		if (staff_JRB == null) {
			staff_JRB = new JRadioButton();
			bg.add(staff_JRB);
			staff_JRB.setSelected(true);
			staff_JRB.setText("员工");
			staff_JRB.setBounds(145, 100, 75, 26);
		}
		return staff_JRB;
	}

	private JRadioButton getMadmin_JRB() {
		if (madmin_JRB == null) {
			madmin_JRB = new JRadioButton();
			bg.add(madmin_JRB);
			madmin_JRB.setText("管理员");
			madmin_JRB.setBounds(66, 100, 75, 26);
		}
		return madmin_JRB;
	}

	private JLabel getAdminOrStaff_lab() {
		if (adminOrStaff_lab == null) {
			adminOrStaff_lab = new JLabel();
			adminOrStaff_lab.setText("类型");
			adminOrStaff_lab.setBounds(14, 100, 41, 18);
		}
		return adminOrStaff_lab;
	}

	private JLabel getPassword_lab() {
		if (password_lab == null) {
			password_lab = new JLabel();
			password_lab.setText("密码");
			password_lab.setBounds(14, 72, 41, 18);
		}
		return password_lab;
	}



	private JLabel getName_lab() {
		if (name_lab == null) {
			name_lab = new JLabel();
			name_lab.setText("工号");
			name_lab.setBounds(15, 41, 41, 20);
		}
		return name_lab;
	}

	public login() {
		initComponents();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getLogin())// 判断触发源是否是按钮1
		{
			if(getMadmin_JRB().isSelected())
			{
			String name = name_jf.getText();
			String pass = new String(getPassword_jtf() .getPassword());
			String sql = "SELECT username,password FROM  administrators WHERE username='"+name+"'and stand=1";
			Connection  conn= null;
			try {
				conn= (new mysqlConnection()).mysqlconnecion();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			ResultSet rs = null;
			try {rs = pstmt.executeQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				while(rs.next()){
					String na =rs.getString(1);

					String pa =rs.getString(2);
					if(name.equals(na)&&pass.equals(pa))
					{
						explain.setText("登陆成功!");
						conn.close();
						pstmt.close();

						new adminPage().create();
						this.dispose();
						break;
					}else
					{
						explain.setText("用户名不存在或密码错误!");
					}
				}

			} catch (SQLException e2) {

				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}
			else {
				String name = name_jf.getText();
                flag = name;
				String pass = new String(getPassword_jtf() .getPassword());
				String sql = "SELECT username,password FROM  administrators WHERE username='"+name+"'and stand=0";
				Connection  conn= null;
				try {
					conn= (new mysqlConnection()).mysqlconnecion();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PreparedStatement pstmt = null;
				try {
					pstmt = conn.prepareStatement(sql);
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				ResultSet rs = null;
				try {
                    rs = pstmt.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					while(rs.next()){
						String na =rs.getString(1);
						String pa =rs.getString(2);
						if(name.equals(na)&&pass.equals(pa))
						{
							explain.setText("登陆成功!");
							conn.close();
							pstmt.close();
                            new staffPage().create(flag);
                            this.dispose();
							break;
						}else
						{
							explain.setText("用户名不存在或密码错误!");
						}
					}

				} catch (SQLException e2) {

					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
	}



}
