/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IGU;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Crisfalt
 */
public class TopologiaIgu extends JFrame implements ActionListener {
    
        //componentes de la interfaz
        private JMenuBar barMenu;
	private JMenu menuAyuda[] , menuArchivo;
	private JPopupMenu popup;
	private JMenuItem itemsAyuda[] , itemsArchivo[] , itemsCaracteristicas[];
	private JPanel panelCentro;
	private JFrame objFrame;
        
        public TopologiaIgu() {
                super( "TOPOLOGIAS DE RED" );
		//objManagerFrame = new ManagerFrame();
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		setResizable( false );
		inicializarControles();
		acomodarControles();
        }
        
        private void inicializarControles() {
                barMenu = new JMenuBar();
		menuArchivo = new JMenu( "Archivo" );
                itemsArchivo = new JMenuItem[2];
                itemsArchivo[ 0 ] = new JMenuItem( "Nuevo" );
                itemsArchivo[ 0 ].addActionListener(this);
                itemsArchivo[ 1 ] = new JMenuItem( "Salir" );
                itemsArchivo[ 1 ].addActionListener(this);
                menuAyuda = new JMenu[2];
                menuAyuda[ 0 ] = new JMenu("Caracteristicas");
                menuAyuda[ 1 ] = new JMenu("Ayuda");
                itemsCaracteristicas = new JMenuItem[2];
                itemsCaracteristicas[ 0 ] = new JMenuItem( "Ventajas" );
                itemsCaracteristicas[ 0 ].addActionListener(this);
                itemsCaracteristicas[ 1 ] = new JMenuItem( "Desventajas" );
                itemsCaracteristicas[ 1 ].addActionListener(this);
                itemsAyuda = new JMenuItem[ 2 ];
                itemsAyuda[ 0 ] = new JMenuItem("Ayuda");
                itemsAyuda[ 0 ].addActionListener(this);
                itemsAyuda[ 1 ] = new JMenuItem("Acerca De");
                itemsAyuda[ 1 ].addActionListener(this);
                
        }
        
        private void acomodarControles() {
                menuArchivo.add( itemsArchivo[ 0 ] );
                menuArchivo.add( itemsArchivo[ 1 ] );
                menuAyuda[ 0 ].add(itemsCaracteristicas[0]);
                menuAyuda[ 0 ].add(itemsCaracteristicas[1]);
                menuAyuda[ 1 ].add(itemsAyuda[ 0 ]);
                menuAyuda[ 1 ].add(itemsAyuda[1]); 
                barMenu.add( menuArchivo );
                barMenu.add( menuAyuda[ 0 ] );
                barMenu.add( menuAyuda[ 1 ] );
                add( barMenu , BorderLayout.NORTH );
                setVisible( true );
		setSize( 700 , 600 );
        }
        
        public void actionPerformed( ActionEvent evento ) {
                if( evento.getSource() == itemsArchivo[ 1 ] ) {
                        System.exit( 0 );
                }
        }
}
