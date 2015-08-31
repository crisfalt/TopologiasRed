/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import IGU.ConfiguracionIgu;
import IGU.Splash;
import IGU.TopologiaIgu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Crisfalt
 */
public class Principal {
    
    public static void main( String args[]){
        cargarLookAndFeel();
                Splash objSplash = new Splash();
                objSplash.setImagen( "Imagenes/splash.gif" );
                objSplash.generarSplash();
                Splash.barraProgreso.setIndeterminate( true );
                Thread hiloProgreso = new Thread();
                try {
                        Thread.sleep(2000);
                        hiloProgreso.start();
                } catch (InterruptedException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                objSplash.dispose();
                TopologiaIgu objTopologiaIgu = new TopologiaIgu();
                //ConfiguracionIgu objConfiguracionIgu = new ConfiguracionIgu();
    }
    
    private static void cargarLookAndFeel() {
            try{
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch(Exception exc){

            }
        }
    
}
