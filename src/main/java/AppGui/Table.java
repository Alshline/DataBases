package AppGui;

import javax.swing.*;

public class Table extends JTable {

    public Table(TableModel tableModel){
        super();
        setCellSelectionEnabled(true);
        setModel(tableModel);
    }
}
