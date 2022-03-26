package AppGui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(ScrollPane scrollPane,ButtonsPanel buttonsPanel){
        super("Test Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        getContentPane().add(buttonsPanel,"South");
    }
}
