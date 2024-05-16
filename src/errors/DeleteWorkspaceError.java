package errors;

import javax.swing.*;

public class DeleteWorkspaceError implements RuError{

    @Override
    public void showMessageError() {
        JOptionPane.showMessageDialog(null,"Pokusavate da obrisete Workspace","Workspace error",JOptionPane.ERROR_MESSAGE);
    }
}
