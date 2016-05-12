package javapro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ZZ on 2016/5/12.
 * 员工信息管理
 */
public class staffInfoMangment extends JFrame implements ActionListener {
    JFrame f= new JFrame("员工信息管理");
    JButton b1 = new JButton("录入");
    JButton b2 = new JButton("修改");
    JButton b3 = new JButton("删除");
    JButton b4 = new JButton("查询");
    JButton b5 = new JButton("查询所有");
    JButton b6 = new JButton("返回");
    void create() {
        String[] cloum = { "职工号", "姓名","性别", "工作等级","部门","基础工作","练习方式"};//表格标题

        Object[][] row = new Object[50][7];
        JTable table = new JTable(row, cloum);
        JScrollPane scrollpane = new JScrollPane(table);//添加滚动条
        JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JPanel p = (JPanel)getContentPane();
        p.setLayout(new FlowLayout());
        p.add(scrollpane);
        p.add(splitpane);
        JPanel p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.cyan);
        p2.add(scrollpane);

        splitpane.add(p1, splitpane.TOP);
        splitpane.add(p2, splitpane.BOTTOM);
        splitpane.setDividerLocation(50);
        p.setBackground(Color.CYAN);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        add(splitpane);
        setBounds(200, 100, 500, 600);
        setResizable(true);// 可以调整界面大小
        setVisible(true);
    }
    public  void receive(StaffInfo SI)
    {
        String[] cloum = { "职工号", "姓名","性别", "工作等级","部门","基础工资","联系方式"};//表格标题
        Object[][] a ={
                {SI.getNum(), SI.getName(), SI.getSex(), SI.getLevel(), SI.getDepartment(), SI.getBaseSalary(),SI.getContact()}
        };

        JTable table = new JTable(a,cloum);

        JScrollPane scrollpane = new JScrollPane(table);//添加滚动条
        JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JPanel p = (JPanel)getContentPane();
        p.setLayout(new FlowLayout());
        p.add(scrollpane);
        p.add(splitpane);
        JPanel p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.cyan);
        p2.add(scrollpane);

        splitpane.add(p1, splitpane.TOP);
        splitpane.add(p2, splitpane.BOTTOM);
        splitpane.setDividerLocation(50);
        p.setBackground(Color.CYAN);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        add(splitpane);
        setBounds(200, 100, 500, 600);
        setResizable(true);// 可以调整界面大小
        setVisible(true);
    }

    public  void queryAll(DefaultTableModel tablemodel )
    {

        JTable table = new JTable(tablemodel);

        JScrollPane scrollpane = new JScrollPane(table);//添加滚动条
        JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JPanel p = (JPanel)getContentPane();
        p.setLayout(new FlowLayout());
        p.add(scrollpane);
        p.add(splitpane);
        JPanel p1 = new JPanel();
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        p1.add(b5);
        p1.add(b6);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.cyan);
        p2.add(scrollpane);

        splitpane.add(p1, splitpane.TOP);
        splitpane.add(p2, splitpane.BOTTOM);
        splitpane.setDividerLocation(50);
        p.setBackground(Color.CYAN);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        add(splitpane);
        setBounds(200, 100, 500, 600);
        setResizable(true);// 可以调整界面大小
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (b1.equals(e.getSource())) { // 录入
            new addStaffInfo();
            this.dispose();
        }
        if (b2.equals(e.getSource())) {// 修改
            new updateSalary();
            this.dispose();
        }


    }
    public static void main(String [] ar)
    {
        new staffInfoMangment().create() ;
    }
}
