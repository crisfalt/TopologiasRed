/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IGU;

import LogicaNegocio.GuardarArchivo;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author crisfalt
 */
public class RegistrosIGU extends JDialog implements ActionListener {

        private JLabel resultados;
        private JTextArea areaResultados;
        private JScrollPane scrollResultados;
        private JButton guardarLog;
        private JPanel panelEtiqueta;
        private JPanel panelAreaTexto;
        private JPanel panelBoton;
        private Container contenedor;
        private BorderLayout miBorderLayout;
        private String mensajeTotal;

        public RegistrosIGU() {
                setDefaultCloseOperation( JDialog.DO_NOTHING_ON_CLOSE );
                iniciarComponentes();
                acomodarComponentes();
        }

        private void iniciarComponentes() {
                mensajeTotal = "";
                resultados = new JLabel( "LOGS" , JLabel.CENTER );
                areaResultados = new JTextArea( 20 , 18 );
                scrollResultados = new JScrollPane();
                scrollResultados.setViewportView( areaResultados );
                guardarLog = new JButton( "Guardar" );
                panelEtiqueta = new JPanel( new GridLayout( 1 , 1 ) );
                panelAreaTexto = new JPanel( new GridLayout( 1 , 1 ) );
                panelBoton = new JPanel( new GridLayout( 1 , 1 ) );
                miBorderLayout = new BorderLayout();
        }

        private void acomodarComponentes() {
                areaResultados.setEditable( false );
                guardarLog.addActionListener( this );
                setLayout( miBorderLayout );
                panelEtiqueta.add( resultados );
                panelAreaTexto.add( scrollResultados );
                panelBoton.add( guardarLog );
                add( panelEtiqueta , BorderLayout.NORTH );
                add( panelAreaTexto , BorderLayout.CENTER );
                add( panelBoton , BorderLayout.SOUTH );
                //pack();
                setSize(280,300);
                setVisible( true );
                setTitle( ".:Registros Logs:." );
//                setLocationRelativeTo( null );
                setResizable( false );
                setVisible( true );
        }

        public void imprimirMensaje( final String mensaje ) {
                mensajeTotal += mensaje;
                areaResultados.setText( mensajeTotal );
        }

        private void guardarRegistro() {
                JFileChooser guardar = new JFileChooser( System.getProperty( "user.dir" ) );
                FileNameExtensionFilter filtroExtension = new FileNameExtensionFilter("Archivo Log", "log");
                guardar.setFileFilter( filtroExtension );
		guardar.setDialogTitle( "Guardar" );
		guardar.setDialogType( JFileChooser.SAVE_DIALOG );
		guardar.showSaveDialog( this );
                String nombreArchivoSalida = "";
		if( guardar.getSelectedFile()!=null ) {
			nombreArchivoSalida = guardar.getSelectedFile().getAbsolutePath();
                        nombreArchivoSalida += ".log";
                        List<String> listaMensaje = new ArrayList<String>();
                        listaMensaje.add( mensajeTotal );
                        GuardarArchivo objGuardarArchivo = new GuardarArchivo( new File ( nombreArchivoSalida ) , listaMensaje );
		}
		else {
			JOptionPane.showMessageDialog( null , "Debe espicificar un nombre para guardar la imagen" );
		}
        }

        public void actionPerformed( ActionEvent evento ) {
                if( evento.getSource() == guardarLog ) {
                        if( !mensajeTotal.isEmpty() ) {
                                guardarRegistro();
                        }
                }
        }

}
