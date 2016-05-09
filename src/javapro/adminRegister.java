package javapro;

/**
 * Created by ZZ on 2016/5/6.
 */
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.*;

        import javax.swing.ButtonGroup;
        import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JRadioButton;
        import javax.swing.JTextArea;
        import javax.swing.JTextField;
        import  javax.swing.JPasswordField;

public class adminRegister extends JFrame implements ActionListener {

    private static final String ADD = "ADD";
    private static final String CANCEL = "CANCEL";
    private static final long serialVersionUID = -196950585230726337L;
    private JLabel name_lab;
    private JLabel password_lab;
    private JLabel adminOrStaff_lab;
    private JLabel rePassword_lab;
    private JLabel explain;
    private JRadioButton madmin_JRB;
    private JRadioButton staff_JRB;
    private JTextArea info_ta;
    private JTextField name_jf;
    private JPasswordField password_jtf;
    private JPasswordField rePassword_jtf;
    private JButton add;
    private JButton cancel;

    private ButtonGroup bg = new ButtonGroup();

    private void initComponents() {
        this.setTitle("用户注册");
        setLayout(null);
        add(getName_lab());
        add(getPassword_lab());
        add(getAdminOrStaff_lab());
        add(getMadmin_JRB());
        add(getStaff_JRB());
        add(getName_jf());
        add(getPassword_jtf());
        add(getRePassword_lab());
        add(reGetPassword_jtf());
        add(getExplain());
        add(getAdd());
        add(getCancel());
        setSize(316, 320);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    private JLabel getExplain() {
        if (explain == null) {
            explain = new JLabel();
            explain.setText("用户注册");
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

    private JButton getAdd() {
        if (add == null) {
            add = new JButton();
            add.setText("添加");
            add.setActionCommand(ADD);
            add.setBounds(49, 180, 81, 28);
            add.addActionListener(this);
        }
        return add;
    }

    private JPasswordField getPassword_jtf() {
        if (password_jtf == null) {
            password_jtf = new JPasswordField();
            password_jtf.setText("");
            password_jtf.setBounds(62, 41, 178, 22);
        }
        return password_jtf;
    }

    private JTextField getName_jf() {
        if (name_jf == null) {
            name_jf = new JTextField();
            name_jf.setText("");
            name_jf.setBounds(62, 10, 178, 22);
        }
        return name_jf;
    }

    private JPasswordField reGetPassword_jtf() {
        if (rePassword_jtf == null)

        {
            rePassword_jtf = new JPasswordField();
            rePassword_jtf.setText("");
            rePassword_jtf.setBounds(62, 71, 178, 22);
        }
        return rePassword_jtf;
    }


    private JTextArea getInfo_ta() {
        if (info_ta == null) {
            info_ta = new JTextArea();
            info_ta.setText("");
        }
        return info_ta;
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
            password_lab.setBounds(14, 42, 41, 18);
        }
        return password_lab;
    }

    private JLabel getRePassword_lab() {
        if (rePassword_lab == null) {
            rePassword_lab = new JLabel();
            rePassword_lab.setText("密码");
            rePassword_lab.setBounds(14, 72, 41, 18);
        }
        return rePassword_lab;
    }

    private JLabel getName_lab() {
        if (name_lab == null) {
            name_lab = new JLabel();
            name_lab.setText("姓名");
            name_lab.setBounds(15, 11, 41, 20);
        }
        return name_lab;
    }

    public adminRegister() {
        initComponents();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getAdd())// 判断触发源是否是按钮1
        {

                if (getName_jf().getText() != null) {
                    String pass = new String(getPassword_jtf().getPassword());
                    String user = getName_jf().getText();
                    if (pass.equals(new String(reGetPassword_jtf().getPassword()))) {
                        Connection conn = null;
                        try {
                            conn = (new mysqlConnection()).mysqlconnecion();//声明一个数据库连接的对象
                        } catch (Exception e1) {

                            e1.printStackTrace();
                        }
                        Statement stmt = null;
                        String sql;//sql语句
                        if(getMadmin_JRB().isSelected()) {
                            sql = "INSERT INTO administrators(username,password,stand)" + "VALUES('" + user + "','" + pass + "','1')";
                        }
                        else{
                            sql ="INSERT INTO administrators(username,password,stand)" + "VALUES('" + user + "','" + pass + "','0')";
                        }
                        try {
                            stmt = conn.createStatement();
                            stmt.executeUpdate(sql);
                            explain.setText("添加成功");
                            conn.close();
                            stmt.close();

                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }

                    }
                } else {
                    explain.setText("用户名为空，请输入！");
                }

            }
        if(e.getSource()==getCancel())
        {
            System.exit(1);
        }
        }
    }





