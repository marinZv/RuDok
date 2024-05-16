package errors;

import javax.swing.*;

public class EmptyAuthorError implements RuError{
    @Override
    public void showMessageError() {
        JOptionPane.showMessageDialog(null, "Morate uneti ime autora", "Author Error", JOptionPane.ERROR_MESSAGE);
    }
}
