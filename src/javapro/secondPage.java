package javapro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;



/**
 * Created by ZZ on 2016/5/5.
 */
public class secondPage extends JFrame implements ActionListener{

        String picPath = "d:"+ File.separator+"1.jpg";
        Icon im = new ImageIcon(picPath);
        JLabel a2 = new JLabel(im);
        JFrame frame = new JFrame("职工/管理员登陆");
        JButton logonButton1 = new JButton("管理员登录");
        JButton logonButton2 = new JButton("职工登录");
        JButton cancelButton = new JButton("退出");


        JTextField username = new JTextField(9);
        JPasswordField password = new JPasswordField(9);

        public void create()
        {
            JPanel p = (JPanel) frame.getContentPane();
            JPanel p1 = new JPanel();
            p.setLayout(new FlowLayout());
            p.add(a2);
            p.add(logonButton1);

            p.add(logonButton2);

            p.add(cancelButton);

            p.setBackground(Color.cyan);
            p.setVisible(true);
            logonButton1.addActionListener(this);
            logonButton2.addActionListener(this);
            cancelButton.addActionListener(this);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setBounds(200, 100, 500, 220);
            frame.setSize(new Dimension(600,350));//设置边框面板的大小
            frame.setVisible(true);
        }

        public void actionPerformed(ActionEvent e)
        {

            if(e.getSource()==logonButton1)
            {
               new adminLogin();
                frame.dispose();//让父窗口消失

            }
            if (e.getSource()==logonButton2)
            {

                   }

            if (cancelButton.equals(e.getSource())) // 退出

            {
                System.exit(0);
            }
        }
    }

