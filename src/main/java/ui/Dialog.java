package ui;

import javax.swing.*;
import java.awt.*;

public class Dialog {
    public static void showDialog(String title, String info) {
        JFrame frame = new JFrame(title);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("    " + info);
        label.setFont(Main.DEFAULT_FONT);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

}
