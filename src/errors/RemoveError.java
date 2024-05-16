package errors;

import javax.swing.*;

public class RemoveError implements RuError{

    @Override
    public void showMessageError() {
        JOptionPane.showMessageDialog(null,
                "Ne mozete brisati neselektovan cvor",
                "Selection error",JOptionPane.ERROR_MESSAGE);
    }
}
