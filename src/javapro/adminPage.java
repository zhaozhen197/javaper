package javapro;
import javax.swing.*;
import java.awt.*;   //导入必要的包
import java.awt.event.*;
import java.io.File;
/**
 * Created by ZZ on 2016/5/5.
 */
public class adminPage extends JFrame implements ActionListener{
    String picPath = "d:"+ File.separator+"1.jpg";
    Icon im = new ImageIcon(picPath);
    JLabel a2 = new JLabel(im);
    JFrame frame = new JFrame("工资管理系统");
    JButton salaryButton1 = new JButton("工资管理");
    JButton employeeButton2 = new JButton("员工信息管理");
    JButton userAddButton3 = new JButton("添加用户");
    JButton cancelButton = new JButton("退出");
    public void create()
    {
        JPanel p = (JPanel) frame.getContentPane();
        JPanel p1 = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(a2);
        p.add(salaryButton1);

        p.add(employeeButton2);
        p.add(userAddButton3);

        p.add(cancelButton);

        p.setBackground(Color.cyan);
        p.setVisible(true);
        salaryButton1.addActionListener(this);
        employeeButton2.addActionListener(this);
        userAddButton3.addActionListener(this);
        cancelButton.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(200, 100, 500, 220);
        frame.setSize(new Dimension(800,350));//设置边框面板的大小
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == salaryButton1)
        {
            new WageMagement().create();
           frame.dispose();//让父窗口消失

        }
        if (e.getSource()==employeeButton2)
        {
            new staffInfoMangment().create();
            frame.dispose();
        }
        if(e.getSource()==userAddButton3)
        {
            frame.dispose();
            new adminRegister();
        }

        if (cancelButton.equals(e.getSource())) // 退出
        {
            System.exit(1);
        }
    }

}
