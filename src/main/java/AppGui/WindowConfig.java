package AppGui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WindowConfig {

    @Bean
    public TableModel tableModel(){
        return new TableModel();
    }

    @Bean
    public Table table(){
        return new Table(tableModel());
    }

    @Bean
    public ScrollPane scrollPane(){
        return new ScrollPane(table());
    }

    @Bean
    public ButtonAddRow buttonAddRow(){
        return new ButtonAddRow(table(),tableModel());
    }

    @Bean
    public ButtonRemoveRow buttonRemoveRow(){
        return new ButtonRemoveRow(table(),tableModel());
    }

    @Bean
    public ButtonsPanel buttonsPanel(){
        return new ButtonsPanel(buttonAddRow(),buttonRemoveRow());
    }

    @Bean
    public MainFrame mainFrame(){
        return new MainFrame(scrollPane(),buttonsPanel());
    }
}