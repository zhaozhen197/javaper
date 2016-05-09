package javapro;

import javax.swing.*;
import java.awt.*;   //导入必要的包
import java.awt.event.*;
import java.sql.*;


public class adminLogin extends JFrame{
    JTextField jTextField = null;//定义文本框组件
    JPasswordField jPasswordField = null;//定义密码框组件
    JLabel jLabel1,jLabel2,jLabel3;
    JPanel jp1,jp2,jp3,jp4;
    JButton jb1,jb2;//创建按钮
    public adminLogin(){
        jTextField = new JTextField(12);
        jPasswordField = new JPasswordField(13);
        jLabel1 = new JLabel("用户名",JLabel.CENTER);
        jLabel2 = new JLabel("密  码",JLabel.CENTER);
		jLabel3 = new JLabel("注册",JLabel.RIGHT);
        JLabel jlabel3 = new JLabel ("欢迎来到企业工资管理系统",JLabel.CENTER);
        jb1 = new JButton("确认");
        jb2 = new JButton("取消");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 =new JPanel(); 
        jp4 = new JPanel();
        //设置布局
        this.setLayout(new GridLayout(3,1));
        
        jp1.add(jLabel1); 
        jp1.add(jTextField);//第一块面板添加用户名和文本框 

        jp2.add(jLabel2);
        jp2.add(jPasswordField);//第二块面板添加密码和密码输入框
        
        jp3.add(jb1);
        jp3.add(jb2); //第三块面板添加确认和取消
        
        jp4.add(jlabel3);
        //        jp3.setLayout(new FlowLayout());  　　//因为JPanel默认布局方式为FlowLayout，所以可以注销这段代码.
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);  //将三块面板添加到登陆框上面
        this.add(jp4);
        //设置显示
		this.setBounds(200, 100, 500, 220);
        this.setSize(500,200);
        this.setTitle("管理员登陆");
        this.setVisible(true);
        JFrame jfraeme = this;
        jfraeme.addWindowListener(new WindowAdapter(){
        	//复写窗口关闭的方法
        	public void windowClosing(WindowEvent arg0)
        	{
        		System.exit(1);
        	}
        });

		//登陆按钮的监听事件
        jb1.addActionListener( new ActionListener()
      {
		  @Override
		  public void actionPerformed(ActionEvent arg) {

    	  if(arg.getSource() == jb1)// 判断触发源是否是按钮1
        		{
        			String name = jTextField.getText();
        			String pass = new String(jPasswordField.getPassword());
        			String sql = "SELECT username,password FROM  administrators WHERE username='"+name+"'and stand=1";
        			Connection  conn= null;
					try {
						conn= (new mysqlConnection()).mysqlconnecion();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			 PreparedStatement pstmt = null;
					try {
						pstmt = conn.prepareStatement(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					try {
//						pstmt.setString(1,"%"+name+"%");//设置第一个?
//					} catch (SQLException e3) {
//						// TODO Auto-generated catch block
//						e3.printStackTrace();
//					}
//					try {
//						pstmt.setString(2,"%" +pass+ "%"); //设置第二个?
//					} catch (SQLException e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
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
							    jlabel3.setText("登陆成功!");
								conn.close();
								pstmt.close();

								new adminPage().create();
								jfraeme.dispose();
								break;
							}else
							{
								jlabel3.setText("用户名不存在或密码错误!");
							}
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			
        		}
        	
        	}



        });
        jb2.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
        	
        });


    }

}
