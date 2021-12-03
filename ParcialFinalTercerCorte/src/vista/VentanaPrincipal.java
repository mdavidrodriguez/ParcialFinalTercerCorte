
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame implements ActionListener {
    
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemMenuRegistro, itemMenuConsulta;

    public VentanaPrincipal() {
        
        this.initComponentes();
        this.setTitle("Aplicacion de registro de goleadores - FPC - Ventana Principal");
        //this.setSize(300, 600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    
    public void initComponentes(){
        
        this.barraMenu = new JMenuBar();
        this.setJMenuBar(this.barraMenu);
        
        this.menu = new JMenu("Opciones");
        this.barraMenu.add(this.menu);
        
        this.itemMenuRegistro = new JMenuItem("Consulta");
        this.itemMenuRegistro.addActionListener(this);
        this.menu.add(this.itemMenuRegistro);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.itemMenuRegistro){
           
            VentanaConsulta consulta = new VentanaConsulta(this, true);
        
        }
        
    }
    
    
}
