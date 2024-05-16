package errors;

import javax.swing.*;

public class AddError implements RuError{
    @Override
    public void showMessageError() {
        JOptionPane.showMessageDialog(null,"Ne mozete dodati u neselektovano","Selekcija error",JOptionPane.ERROR_MESSAGE);
    }


}
