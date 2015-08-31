/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IGU;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.*;

/**
 *
 * @author Crisfalt
 */
public class ConfiguracionIgu extends JDialog implements ActionListener {

        private SpinnerNumberModel model;
        private JSpinner spnNodos;
        private JComboBox cmbTopologia;
        private JLabel lblTopologia , lblNodos;
        private JButton btnAceptar , btnLimpiar , btnSalir;
        private JPanel panCentral , panelInferior;
	private Container contenedor;
        private FlowLayout miFlow;
        private String topologias;
        private int nodos;
        private int nodosCA;
        private Vector numNodos;
        
        
        private Vector<String> listaTopologias;
        
        public ConfiguracionIgu( java.awt.Frame parent, boolean modal ) {
                super(parent , modal);
                topologias = new String();
                nodos = 0;
                inicializarControles();
                acomodarControles();
                conectarControles();
                
        }
        
        private void inicializarControles() {
                 model = new SpinnerNumberModel(
                        new Integer(2), // Dato visualizado al inicio en el spinner
                        new Integer(2), // Límite inferior
                        new Integer(10), // Límite superior
                        new Integer(1) // incremento-decremento
                ); 
                listaTopologias = new Vector<>();
                listaTopologias.add("Estrella");
                listaTopologias.add("Bus");
                listaTopologias.add("Malla");
                listaTopologias.add("Anillo");
                listaTopologias.add("Doble Anillo");
                listaTopologias.add("Arbol");
                cmbTopologia = new JComboBox( listaTopologias );
                spnNodos = new JSpinner( model );
                lblTopologia = new JLabel("Topologia : ");
                lblNodos = new JLabel("Cantidad de Nodos :");
                btnAceptar = new JButton("Aceptar");
                btnLimpiar = new JButton("Limpiar");
                btnSalir= new JButton("Salir");
                miFlow=new FlowLayout();
                contenedor=getContentPane();
                panCentral = new JPanel(new GridLayout( 2 , 2 ));
                panelInferior = new JPanel( new GridLayout( 1 , 2 ) );
        }
        
        private void acomodarControles() {
                
                panCentral.add(lblTopologia);
                panCentral.add(cmbTopologia);
                panCentral.add(lblNodos);
                panCentral.add(spnNodos);
                panelInferior.add(btnAceptar);
                panelInferior.add(btnLimpiar);
                panelInferior.add(btnSalir);
                contenedor.add(panCentral);
                contenedor.add(panelInferior);
                contenedor.setLayout(miFlow);
                //pack();
                setSize(400, 150);
                setTitle("CONFIGURACION");
                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                //setVisible(true);
                //this.show();
        }
        
        private void conectarControles() {
                cmbTopologia.addActionListener(this);
                btnAceptar.addActionListener(this);
                btnLimpiar.addActionListener(this);
                btnSalir.addActionListener(this);
        }
        
        @Override
        public void actionPerformed(ActionEvent evento) {
                if(evento.getSource() == btnAceptar ) {
                        topologias = cmbTopologia.getSelectedItem().toString();
                        nodos = (int)spnNodos.getValue();
                        if( topologias.equals("Arbol") ) {
                                numNodos = new Vector();
                                for( int i = 0 ; i < nodos+1 ; i++ ) {
                                        String in = "";
                                        if( i == 0 ) {
                                                in = JOptionPane.showInputDialog(this, "Nodos conectados al Concentrador Activo");
                                                nodosCA = Integer.parseInt(in);
                                        }
                                        else {
                                                in = JOptionPane.showInputDialog(this, "Nodos conectados al Concentrador Pasivo " + (i) );
                                                numNodos.add( Integer.parseInt(in) );
                                        }
                                }
                        }
                        System.out.println(topologias);
                        System.out.println(nodos);
                        System.out.println(nodosCA);
                        //this.setVisible(false);
                        this.dispose();
                }
                if( evento.getSource() == cmbTopologia ) {
                        if( (topologias = cmbTopologia.getSelectedItem().toString()).equals("Arbol") ) {
                             lblNodos.setText("# Concentradores Pasivos:  ");
                             
                        }
                }
        }
        
        public String getTopologia() {
                return topologias;
        }
        
        public int getNodos() {
                return nodos;
        }
        
        public int getNodosA() {
                return nodosCA;
        }
        
        public Vector getNodosP() {
                return numNodos;
        }
        
        
}
