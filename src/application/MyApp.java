package application;

import application.MainFrame;

public class MyApp {

    public static void main(String[] args) {

        MainFrame mf = MainFrame.getInstance();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);

    }

}
