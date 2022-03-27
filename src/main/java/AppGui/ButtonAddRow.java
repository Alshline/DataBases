package AppGui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAddRow extends JButton {

    public ButtonAddRow (Table table, TableModel tableModel){
        super("AddRow");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                tableModel.insertRow(selectedRow+1, tableModel.newRow);
            }
        });
    }
}
