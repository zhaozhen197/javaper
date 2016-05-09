package javapro;

/**
 * Created by ZZ on 2016/5/7.
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.table.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
public class WageMagement extends JFrame implements ActionListener {

    JFrame f= new JFrame("工资管理");
    JButton b1 = new JButton("录入");
    JButton b2 = new JButton("修改");
    JButton b3 = new JButton("删除");
    JButton b4 = new JButton("查询");
    JButton b5 = new JButton("查询所有");

    void create() {
        String[] cloum = { "职工号", "姓名", "月基本工资","工作提成","将金","总计"};//表格标题

        Object[][] row = new Object[50][6];
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
        add(splitpane);
        setBounds(200, 100, 500, 600);
        setResizable(true);// 可以调整界面大小
        setVisible(true);
    }
    public  void receive(salaryinformation SI)
    {
        String [] col = new String[]{"职工号", "姓名", "月基本工资", "工作提成","津贴", "总计"};//表格标题
        Object[][] a ={
                {SI.getNum(), SI.getName(), SI.getBasesalary(), SI.getJobsalary(), SI.getWelfare(), SI.getTotal()}
        };

        JTable table = new JTable(a,col);

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
        add(splitpane);
        setBounds(200, 100, 500, 600);
        setResizable(true);// 可以调整界面大小
        setVisible(true);
    }
    public   static  void main(String[] art)
    {
        new WageMagement().create();
    }
    public void actionPerformed(ActionEvent e) {
        if (b1.equals(e.getSource())) { // 录入
            new addWage();
        }
        if (b2.equals(e.getSource())) {// 修改
            new updateSalary();
        }

        if (b3.equals(e.getSource())) {// 删除
            new deleteWage();

        }
        if(b4.equals(e.getSource()))
        {
            new querysalary();
            this.dispose();
        }
        if(b5.equals(e.getSource()))
        {
            Connection conn = null;
            salaryinformation SI = new salaryinformation();
            String [] col = new String[]{"职工号", "姓名", "月基本工资", "工作提成","津贴", "总计"};//表格标题
            DefaultTableModel tablemodel = new DefaultTableModel(null,col);

            try {
                conn = new mysqlConnection().mysqlconnecion();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            String sql = " SELECT id,name,basesalary ,jobsalary,welfare,total FROM salary";
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
                e1.printStackTrace();
            }
            try {
                while (rs.next()) {

                    SI.setNum(rs.getString(1));
                    SI.setName(rs.getString(2));
                    SI.setBasesalary(rs.getFloat(3));
                    SI.setJobsalary(rs.getFloat(4));
                    SI.setWelfare(rs.getFloat(5));
                    SI.setTotal(rs.getFloat(6));
                    Object[] a ={
                            SI.getNum(), SI.getName(), SI.getBasesalary(), SI.getJobsalary(), SI.getWelfare(), SI.getTotal()
                    };
                    tablemodel.addRow(a);

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            this.dispose();
            new WageMagement().queryAll(tablemodel);
            try {
                rs.close();
                conn.close();
                stmt.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } else {
            this.setTitle("用户名为空");
        }
        }

/*        if (b4.equals(e.getSource())) {// 查询全部
            Connection con;
            Statement sql;
            ResultSet rs;
            //Vector vector = new Vector();
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
            } catch (ClassNotFoundException e1) {
                JOptionPane.showMessageDialog(this, "连接数据库失败！");
            }
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage management","root","jxb");
                sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                if (b4.equals(e.getSource())) {

                    for (int i = 0; i < 50; i++)
                        for (int j = 0; j < 4; j++)
                            table.setValueAt("", i, j);
                    rs = sql.executeQuery("select distinct * from  wageinfo ,welfare  where   wageinfo.name=welfare.name");
                    int k = -1;
                    while (rs.next()) {

                        ++k;
                        String no = rs.getString(1);
                        String name = rs.getString(2);
                        String jb = rs.getString(3);
                        String jt = rs.getString(6);
                        int  sum=	rs.getInt(3)+rs.getInt(6);


                        table.setValueAt(no, k, 0);
                        table.setValueAt(name, k, 1);
                        table.setValueAt(jb, k, 3);
                        table.setValueAt(jt, k, 2);
                        table.setValueAt(sum,k,4);

                    }
                }
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(this, "查询失败！");
            }
        }*/

/*        if (b5.equals(e.getSource())) {// 返回
            GZGLZJM gl=new GZGLZJM();
            gl.create();

            dispose();

        }*/
    }


