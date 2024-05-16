package errors;

import javax.swing.*;

public class EditAuthorButtonError implements RuError{
    @Override
    public void showMessageError() {
        JOptionPane.showMessageDialog(null, "Morate selektovati prezentaciju pre pritiska na ovo dugme!",
                "Unselected presentation author error", JOptionPane.ERROR_MESSAGE);
    }
}
