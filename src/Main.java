package src;
import java.awt.*;

import javax.swing.*;

public class Main{
    static JFrame window;
    public static void main(String[] args) {
        GamePanel gp = new GamePanel();
        window = new JFrame("ONLY ONE");
        window.add(gp);
        window.pack();
        window.setSize(gp.screenWidth,gp.screenHeight);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.WHITE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.startThread();
        
    }
}