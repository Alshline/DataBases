package AppGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonRemoveRow extends JButton {

    public ButtonRemoveRow(Table table, TableModel tableModel){
        super("removeRow");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                tableModel.removeRow(selectedRow);
            }
        });
    }
}
