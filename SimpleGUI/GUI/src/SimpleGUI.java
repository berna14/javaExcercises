import javax.swing.*;
import java.awt.*;

public class SimpleGUI {
    public static void main(String[] args){
        JFrame jFrame = new JFrame("Simple GUI");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 500);
        jFrame.add(new JLabel("¡Hola mundo!"));
        jFrame.add(new JButton("Click"));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}