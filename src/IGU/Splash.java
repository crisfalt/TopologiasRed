/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IGU;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

/**
 *
 * @author Crisfalt
 */
public class Splash extends JWindow {

        private ImageIcon imagenFondo;
        private JLabel etiquetaImagen;
        public static JProgressBar barraProgreso;
        private JPanel panelCentral;

        public Splash() {
                
        }

        public void setImagen( final String urlImagen ) {
                //System.out.println("nombre imagen es: " + urlImagen);
                imagenFondo = new ImageIcon( urlImagen );
        }

        public ImageIcon getImage() {
                return imagenFondo;
        }

        private void inicializarComponentes() {
                etiquetaImagen = new JLabel( imagenFondo );
                panelCentral = new JPanel();
                barraProgreso = new JProgressBar();
        }

        private void acomodarControles() {
                panelCentral.add( etiquetaImagen );
                getContentPane().add( panelCentral , BorderLayout.CENTER );
                barraProgreso.setMaximum(50);
                getContentPane().add( barraProgreso, BorderLayout.SOUTH );
//                setLocationRelativeTo( null );
                pack();
                Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
                Dimension ventana = getSize();
                setLocation( ( ( pantalla.width - ventana.width ) / 2  ) , ( ( pantalla.height - ventana.height ) / 2 ) );
                setVisible( true );
        }

        public void generarSplash() {
                inicializarComponentes();
                acomodarControles();
        }

}
