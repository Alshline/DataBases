package AppGui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.*;

public class GuiApplication {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ApplicationContext applicationContext = new AnnotationConfigApplicationContext(WindowConfig.class);
                MainFrame mainFrame = applicationContext.getBean(MainFrame.class);
            }
        };
        EventQueue.invokeLater(runnable);
    }
}
