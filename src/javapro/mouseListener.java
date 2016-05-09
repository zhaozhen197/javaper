package javapro;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by ZZ on 2016/4/26.
 */
public class mouseListener implements MouseListener {

        public mouseListener() {

    }

        public void mouseClicked(MouseEvent e) {
/**鼠标点击事件(包括按下和弹起两个动作)处理方法.**/
            System.out.println("你点了我!");
        }

        public void mouseEntered(MouseEvent e) {
/**鼠标移到组件上方法时事件处理方法.**/}

        public void mouseExited(MouseEvent e) {
/**鼠标移开组件时事件处理方法.**/}

        public void mousePressed(MouseEvent e) {
/**鼠标在组件上按下(但没弹起)时事件处理方法.**/}

        public void mouseReleased(MouseEvent e) {
/**鼠标在组件上弹起事件处理方法.**/}

}
