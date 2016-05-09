package javapro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
/**
 * Created by ZZ on 2016/5/8.
 */
public class updateSalary extends JFrame implements ActionListener{

    private static final String ADD = "ADD";
    private static final String CANCEL = "CANCEL";
    private static final long serialVersionUID = -196950585230726337L;
    private JLabel num_lab,welfare_lab;
    private JLabel name_lab, warn;
    private JLabel baseSalary_lab;
    private JLabel jobsalary;
    private JTextField numLabel_jtf,jobsalary_jf,welfare_jtf;
    private JTextField name_jtf;
    private JTextField baseSalary_jtf;
    private JButton add;
    private JButton cancel;

    private ButtonGroup bg = new ButtonGroup();

    private void initComponents() {
        this.setTitle("修改信息");
        setLayout(null);
        add(getNum_lab());
        add(getName_lab());
        add(getNumLabel_jtf());
        add(getName_jtf());
        add(getSalary_lab());
        add(getBaseSalary_jtf());
        add(getJobsalary());
        add(getJobsalary_jf());
        add(getWelfare_lab());
        add(getWelfare_jtf());
        add(getWarn());
        add(getAdd());
        add(getCancel());
        setBounds(500,200,316,320);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    private JLabel getNum_lab() {
        if (num_lab == null) {
            num_lab = new JLabel();
            num_lab.setText("工号");
            num_lab.setBounds(15, 11, 41, 20);
        }
        return num_lab;
    }
    private JTextField getNumLabel_jtf() {
        if (numLabel_jtf == null) {
            numLabel_jtf = new JTextField();
            numLabel_jtf.setText("");
            numLabel_jtf.setBounds(62, 10, 178, 22);
        }
        return numLabel_jtf;
    }
    private JLabel getName_lab() {
        if (name_lab == null) {
            name_lab = new JLabel();
            name_lab.setText("姓名");
            name_lab.setBounds(14, 42, 41, 18);
        }
        return name_lab;
    }
    private JTextField getName_jtf() {
        if (name_jtf == null) {
            name_jtf = new JTextField();
            name_jtf.setText("");
            name_jtf.setBounds(62, 41, 178, 22);
        }
        return name_jtf;
    }
    private JLabel getSalary_lab() {
        if (baseSalary_lab == null) {
            baseSalary_lab = new JLabel();
            baseSalary_lab.setText("基本工资");
            baseSalary_lab.setBounds(14, 72, 41, 18);
        }
        return baseSalary_lab;
    }
    private JLabel getJobsalary() {
        if (jobsalary== null) {
            jobsalary = new JLabel();
            jobsalary.setText("工作提成");
            jobsalary.setBounds(14, 102, 41, 18);
        }
        return jobsalary;
    }
    private JTextField getJobsalary_jf() {
        if (jobsalary_jf== null) {
            jobsalary_jf= new JTextField();
            jobsalary_jf.setText("");
            jobsalary_jf.setBounds(62, 102, 178, 22);
        }
        return jobsalary_jf;
    }
    private JLabel getWelfare_lab() {
        if (welfare_lab== null) {
            welfare_lab= new JLabel();
            welfare_lab.setText("福利");
            welfare_lab.setBounds(14,132, 41, 18);
        }
        return welfare_lab;
    }
    private JTextField getWelfare_jtf() {
        if (welfare_jtf== null) {
            welfare_jtf= new JTextField();
            welfare_jtf.setText("");
            welfare_jtf.setBounds(62, 132, 178, 22);
        }
        return welfare_jtf;
    }
    private  JLabel getWarn()
    {
        if(warn ==null)
        {
            warn = new JLabel();
            warn.setText("修改工资信息");
            warn.setBounds(62,162,120,18);
        }
        return warn;
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





    private JTextField getBaseSalary_jtf() {
        if (baseSalary_jtf == null)

        {
            baseSalary_jtf = new JTextField();
            baseSalary_jtf.setText("");
            baseSalary_jtf.setBounds(62, 71, 178, 22);
        }
        return baseSalary_jtf;
    }




    public updateSalary() {
        initComponents();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == getAdd())// 判断触发源是否是按钮1
        {
            String num;
            String name;
            float baseSalary;
            float jobSalary;
            float welfare;
            float total;

            if (getNumLabel_jtf().getText() != null) {
                num = new String(getNumLabel_jtf().getText());
                name =new String(getName_jtf().getText());
                baseSalary = Float.parseFloat(getBaseSalary_jtf().getText());
                jobSalary = Float.parseFloat(getJobsalary_jf().getText());
                welfare = Float.parseFloat(getWelfare_jtf().getText());
                total = welfare + jobSalary + baseSalary;

                Connection conn = null;
                try {
                    conn = (new mysqlConnection()).mysqlconnecion();//声明一个数据库连接的对象
                } catch (Exception e1) {

                    e1.printStackTrace();
                }
                Statement stmt = null;
                String sql;//sql语句
                sql = "UPDATE salary SET " + "id='" + num + "',name='" + name + "',basesalary='" + baseSalary + "',jobsalary='" + jobSalary + "',welfare='"+welfare+"',total='"+ total+"' WHERE id='"+ num+"'";
                try {
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    warn.setText("修改成功");
                    conn.close();
                    stmt.close();
                    this.dispose();

                } catch (SQLException e2) {
                    e2.printStackTrace();
                }

            } else {
                warn.setText("用户名为空，请输入！");
            }

        }
        if(e.getSource()==getCancel())
        {
            this.dispose();
        }
    }

}
