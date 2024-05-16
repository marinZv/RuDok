package errors;

import javax.swing.*;

public class SlideAddError implements RuError{

    @Override
    public void showMessageError() {
        JOptionPane.showMessageDialog(null,"Ne mozete dodavati u slide","Slide error",JOptionPane.ERROR_MESSAGE);
    }
}
