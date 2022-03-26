package AppGui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

    String[] columnsHeader = {  "emptyCapWeight","fullCapWeight","hitch",
                                "compHeight","fullHeight","actuationTime",
                                "imas","ilin","density"};

    Object[] newRow = {0,0,0,0,0,0,0,0,0};

    public TableModel(){
        super();
        setColumnIdentifiers(columnsHeader);

        String insertRowsCount = JOptionPane.showInputDialog("Count of a rows");
        int rowsCount = Integer.parseInt(insertRowsCount);
        for (int i=0;i<rowsCount;i++){
            addRow(newRow);
        }
    }
}