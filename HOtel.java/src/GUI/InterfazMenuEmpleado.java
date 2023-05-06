package GUI;

import javax.swing.*;
import java.awt.*;

public class InterfazMenuEmpleado extends JFrame{

    JLabel lbmenu;

    public void inicializar(){

        lbmenu = new JLabel();


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(lbmenu, BorderLayout.NORTH);

        setTitle("Menu Empleados");
        setSize(1000, 750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String args[]){
        InterfazMenuEmpleado menu = new InterfazMenuEmpleado();
        menu.inicializar();
    }
}
