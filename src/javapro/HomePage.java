package javapro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by ZZ on 2016/5/3.
 */
public class HomePage extends JFrame implements ActionListener {
    String picPath = "d:"+ File.separator+"1.jpg";
    JFrame frame = new JFrame("欢迎进入企业工资管理系统");
    JLabel label = new JLabel("", JLabel.CENTER);
    JButton button1 = new JButton("进入系统");
    JButton button2 = new JButton("退出系统");
    Icon im = new ImageIcon(picPath);
    JLabel a1 = new JLabel(im);



    void Create() {
        JPanel pcontentPane = (JPanel) frame.getContentPane();
        pcontentPane.add(a1);
        pcontentPane.add(label);
        pcontentPane.setLayout(new FlowLayout());
        pcontentPane.add(button1);
        pcontentPane.add(button2);
        pcontentPane.setVisible(true);
        button1.addActionListener(this);
        button2.addActionListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(200, 100, 500, 220);
        frame.setSize(new Dimension(600,350));//设置边框面板的大小
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            (new secondPage()).create();
            frame.dispose();//释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源
        }
        if (button2.equals(e.getSource())) {// 退出
            System.exit(0);

        }
    }


}
