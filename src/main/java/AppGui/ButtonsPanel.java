package AppGui;

import javax.swing.*;

public class ButtonsPanel extends JPanel {

    public ButtonsPanel (ButtonAddRow buttonAddRow, ButtonRemoveRow buttonRemoveRow){
        add(buttonAddRow);
        add(buttonRemoveRow);
    }
}
