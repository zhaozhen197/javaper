package javapro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ZZ on 2016/5/13.
 */
public class QuarySttaffInfo extends JFrame implements ActionListener {
    private JLabel num_lab;
    private JTextField num_jtf;
    private JLabel warn_lab;
    private JButton survey_jb;
    private JButton back_jb;
    public void quaryWage()
    {
        this.setLayout(null);
        this .setTitle("查询");
        this.add(getNum_jtf());
        this.add (getNum_lab());
        this.add(getWarn_lab());
        this.add(getSurvey_jb());
        this.add(getBack_jb());
        setBounds(500,200,316,320);
        this.setVisible(true);
        this.setResizable(false);
    }

    public JLabel getNum_lab() {
        if(num_lab == null)
        {
            num_lab = new JLabel();
            num_lab.setText("工号");
            num_lab.setBounds(50,80, 50, 25);
        }
        return num_lab;
    }

    public JTextField getNum_jtf() {
        if(num_jtf == null)
        {
            num_jtf = new JTextField();
            num_jtf.setText("");
            num_jtf.setBounds(92,80,150,32);
        }
        return num_jtf;
    }

    public JLabel getWarn_lab() {
        if(warn_lab == null)
        {
            warn_lab = new JLabel();
            warn_lab.setText("请输入所要查询的工号");
            warn_lab.setForeground(Color.RED);
            warn_lab.setBounds(82,132,150,31);
        }
        return warn_lab;
    }

    public JButton getSurvey_jb() {
        if(survey_jb == null)
        {
            survey_jb = new JButton();
            survey_jb.setText("查询");

            survey_jb.addActionListener(this);
            survey_jb.setBounds(62, 162, 80, 32);
        }
        return survey_jb;
    }

    public JButton getBack_jb() {
        if(back_jb == null)
        {
            back_jb = new JButton();
            back_jb.setText("返回");
            back_jb.addActionListener(this);
            back_jb.setBounds(152,162,80,32);
        }
        return back_jb;
    }

    public static void main(String[]art)
    {
        new QuarySttaffInfo().quaryWage();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getSurvey_jb()) {
            if (num_jtf.getText() != null) {
                Connection conn = null;
                String num;
                StaffInfo SI = new StaffInfo();

                try {
                    conn = new mysqlConnection().mysqlconnecion();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                num = num_jtf.getText();
                String sql = " SELECT id,name,sex ,stafflevel,department,basesalary,adress FROM staffinfo WHERE id =" + num;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    rs = stmt.executeQuery(sql);


                } catch (SQLException e1) {
                    warn_lab.setText("该员工不存在");
                    e1.printStackTrace();
                }
                try {
                    while (rs.next()) {

                        SI.setNum(rs.getString(1));
                        SI.setName(rs.getString(2));
                        SI.setSex(rs.getString(3));
                        SI.setLevel(rs.getString(4));
                        SI.setDepartment(rs.getString(5));
                        SI.setBaseSalary(rs.getFloat(6));
                        SI.setContact(rs.getString(7));

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                new staffInfoMangment().receive(SI);
                try {
                    rs.close();
                    conn.close();
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                this.dispose();
            } else {
                warn_lab.setText("用户名为空");
            }
        }
if(e.getSource().equals(getBack_jb()))
{
    this.dispose();
    new staffInfoMangment().create();
}
    }
    }

