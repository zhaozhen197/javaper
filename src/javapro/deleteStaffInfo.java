package javapro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import  java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ZZ on 2016/5/13.
 */
public class deleteStaffInfo extends JFrame implements ActionListener {
    private JLabel num_lab;
    private JTextField num_jtf;
    private JLabel warn_lab;
    private JButton deleteJb;
    private JButton back_jb;


    private void DeleteInfo()
    {
        this.setLayout(null);
        this .setTitle("删除");
        this.add(getNum_jtf());
        this.add (getNum_lab());
        this.add(getWarn_lab());
        this.add(getDeleteJb());
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
            warn_lab.setText("请输入所要删除的工号");
            warn_lab.setForeground(Color.RED);
            warn_lab.setBounds(82,132,150,31);
        }
        return warn_lab;
    }

    public JButton getDeleteJb() {
        if(deleteJb == null)
        {
            deleteJb = new JButton();
            deleteJb.setText("删除");

            deleteJb.addActionListener(this);
            deleteJb.setBounds(62, 162, 80, 32);
        }
        return deleteJb;
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

    public deleteStaffInfo() throws HeadlessException {
        this.DeleteInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==getDeleteJb()) {
            if (num_jtf.getText() != null) {
                Connection conn = null;
                String num;

                try {
                    conn = new mysqlConnection().mysqlconnecion();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                num = num_jtf.getText();
                String sql = "DELETE FROM staffinfo WHERE id =" + num;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    stmt = conn.createStatement();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    stmt.executeUpdate(sql);
                    warn_lab.setText("删除成功");
                    this.dispose();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } else {
                warn_lab.setText("用户名为空");
            }
        }
        if(e.getSource().equals(getBack_jb())){
            new staffInfoMangment();
            this.dispose();

        }
    }
   public  void windowClosing(WindowEvent arg0)
   {
       System.exit(1);
   }
    public static void main(String [] m)
    {
        new deleteStaffInfo();
    }
}
