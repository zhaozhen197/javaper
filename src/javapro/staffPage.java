package javapro;
import javax.swing.*;
import java.awt.*;   //导入必要的包
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by ZZ on 2016/5/12.
 */
public class staffPage extends JFrame implements ActionListener{


    void create(String flag) {
        Connection conn = null;
        salaryinformation SI = new salaryinformation();
        try {
            conn = new mysqlConnection().mysqlconnecion();
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String sql = " SELECT id,name,basesalary ,jobsalary,welfare,total FROM salary WHERE id =" +flag;
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

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        new WageMagement().staff(SI);
        try {
            rs.close();
            conn.close();
            stmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        this.dispose();
    }




    public   static  void main(String[] art)
    {
        new staffPage().create("11");
    }
    public void actionPerformed(ActionEvent e) {


    }


}




