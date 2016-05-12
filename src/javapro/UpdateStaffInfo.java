package javapro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ZZ on 2016/5/12.
 */
public class UpdateStaffInfo extends JFrame implements ActionListener {
    private JLabel name_lab;
    private JLabel num_lab;
    private JLabel sex_lab;
    private JLabel level_lab;
    private ButtonGroup bg = new ButtonGroup();
    public String[] level={"第一级","第二级","第三级","第四级","第五级","第六级","第七级"};



    private JLabel departmentLab;
    private JTextField departmentJtf;
    private JComboBox levelJCB;
    private JLabel explain;
    private JLabel baseSalaryLbl;
    private JLabel contactLbl;
    private JRadioButton man_JRB;
    private JRadioButton woman_JRB;
    private JTextField name_jf;
    private JTextField numJF;
    private JTextField baseSalaryJtf;
    private JTextField contactJtf;
    private JButton add;
    private JButton cancel;
    public JLabel getDepartmentLab() {
        if(departmentLab == null)
        {
            departmentLab = new JLabel();
            departmentLab.setText("部门");
            departmentLab.setBounds(15,131,41,20);
        }
        return departmentLab;
    }

    public JTextField getDepartmentJtf() {
        if (departmentJtf == null)
        {
            departmentJtf = new JTextField();
            departmentJtf.setText("");
            departmentJtf.setBounds(75,131,178,22);
        }
        return departmentJtf;
    }
    public JComboBox getLevelJCB() {
        if(levelJCB == null)
        {
            levelJCB = new JComboBox(level);
            levelJCB .setBounds(75,101,81,20);
        }
        return levelJCB;
    }
    public JLabel getName_lab() {
        if(name_lab == null)
        {
            name_lab = new JLabel();
            name_lab.setText("姓名");
            name_lab.setBounds(15, 41, 41, 18);
        }
        return name_lab;
    }

    public JLabel getNum_lab() {
        if(num_lab== null)
        {
            num_lab= new JLabel();
            num_lab.setText("工号");
            num_lab.setBounds(15, 11, 41, 20);
        }
        return num_lab;
    }

    public JLabel getSex_lab() {
        if(sex_lab== null)
        {
            sex_lab= new JLabel();
            sex_lab.setText("性别");
            sex_lab.setBounds(15, 71, 41, 20);
        }
        return sex_lab;
    }

    public JLabel getLevel_lab() {
        if(level_lab == null)
        {
            level_lab = new JLabel();
            level_lab .setText("等级");
            level_lab.setBounds(15,101,41,20);


        }
        return level_lab;
    }

    public JLabel getExplain() {
        if(explain == null)
        {
            explain = new JLabel();
            explain.setText("用户信息添加");
            explain.setBounds(100,220,100,20);

        }
        return explain;
    }

    public JLabel getBaseSalaryLbl() {
        if(baseSalaryLbl == null)
        {
            baseSalaryLbl = new JLabel();
            baseSalaryLbl .setText("基本工资");
            baseSalaryLbl .setBounds(15,161,60,20);

        }
        return baseSalaryLbl;
    }

    public JLabel getContactLbl() {
        if(contactLbl == null )
        {
            contactLbl = new JLabel();
            contactLbl .setText("联系方式");
            contactLbl.setBounds(15,191,60,20);
        }
        return contactLbl;
    }

    public JRadioButton getMan_JRB() {
        if(man_JRB == null)
        {
            man_JRB = new JRadioButton();
            man_JRB.setText("男");
            bg.add(man_JRB);
            man_JRB.setBounds(75,71,41,20);
        }
        return man_JRB;
    }

    public JRadioButton getWoman_JRB() {
        if(woman_JRB == null)
        {
            woman_JRB = new JRadioButton();
            woman_JRB.setText("女");
            bg.add(woman_JRB);
            woman_JRB.setBounds(120,71,41,20);
        }
        return woman_JRB;
    }

    public JTextField getName_jf() {
        if(name_jf == null)
        {
            name_jf= new JTextField();
            name_lab.setText("姓名");
            name_jf.setBounds(75, 40, 178, 20);
        }
        return name_jf;
    }

    public JTextField getNumJF() {
        if(numJF ==null)
        {
            numJF = new JTextField();
            numJF.setText("");
            numJF.setBounds(75,11,178,20);
        }
        return numJF;
    }

    public JTextField getBaseSalaryJtf() {
        if(baseSalaryJtf == null)
        {
            baseSalaryJtf = new JTextField();
            baseSalaryJtf.setText("");
            baseSalaryJtf.setBounds(75,161,178,22);
        }
        return baseSalaryJtf;
    }

    public JTextField getContactJtf() {
        if(contactJtf == null)
        {
            contactJtf = new JTextField();
            contactJtf.setText("");
            contactJtf.setBounds(75,191,178,20);
        }
        return contactJtf;
    }

    public JButton getAdd() {
        if(add == null)
        {
            add = new JButton();
            add.setText("修改");
            add.setBounds(75,250,61,20);
            add.addActionListener(this);
        }
        return add;
    }

    public JButton getCancel() {
        if (cancel == null)
        {
            cancel = new JButton();
            cancel.setText("取消");
            cancel.setBounds(155,250,61,20);
            cancel.addActionListener(this);
        }
        return cancel;
    }
    public void creat()
    {
        this.setLayout(null);
        this.add(getNum_lab());
        this.add(getNumJF());
        this.add(getName_lab());
        this.add(getName_jf());
        this.add(getSex_lab());
        this.add(getMan_JRB());
        this.add(getWoman_JRB());
        this.add(getDepartmentJtf());
        this.add(getDepartmentLab());
        this.add(getExplain());
        this.add(getCancel());
        this.add(getAdd());
        this.add(getContactJtf());
        this.add(getContactLbl());
        this.add(getBaseSalaryJtf());
        this.add(getLevelJCB());
        this.add(getBaseSalaryLbl());
        this.add(getLevel_lab());
        this.setSize(316,370);
        this.setVisible(true);

    }

    public static void main(String [] a)
    {
        new  UpdateStaffInfo().creat();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getAdd())
        {
            if(getNumJF().getText()!=null)
            {
                /**
                 * 获取文本框中的内容
                 */
                String num = getNumJF().getText();
                String name = getName_jf().getText();
                String level =(String) getLevelJCB().getSelectedItem();
                String department  =getDepartmentJtf().getText();
                float basesalary  =Float.parseFloat( getBaseSalaryJtf().getText());
                String contact = getContactJtf().getText();
                Connection conn = null;
                Statement stmt = null;
                String sql;//sql语句

                try {
                    conn = (new mysqlConnection()).mysqlconnecion();//声明一个数据库连接的对象
                } catch (Exception e1) {

                    e1.printStackTrace();
                }

                if(getMan_JRB().isSelected()) {
                    sql = "UPDATE staffinfo SET (id,name,sex,stafflevel,department,basesalary,adress)" + "VALUES('" + num + "','" + name + "', '男','" + level + "','" + department + "','" + basesalary + "','" + contact + "') WHERE id="+num;

                }else {

                    sql = "UPDATE staffinfo SET (id,name,sex,stafflevel,department,basesalary,adress)" + "VALUES('" + num + "','" + name + "', '女','" + level + "','" + department + "','" + basesalary + "','" + contact + "')WHERE id="+num;
                }

                try {
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                    explain.setText("修改成功");
                    conn.close();
                    stmt.close();

                } catch (SQLException e2) {
                    e2.printStackTrace();
                }


            }
            else {
                explain.setText("用户名为空，请输入！");
            }
        }
        if(e.getSource() == getCancel())
        {

            new staffInfoMangment().create();
            this.dispose();
        }
    }



    }

