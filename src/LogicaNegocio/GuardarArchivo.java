/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LogicaNegocio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Crisfalt
 */
public class GuardarArchivo {

        private PrintStream flujoSalida;

        public GuardarArchivo( final File nombreArchivo , final List<String> resultadosTransiciones ) {
                try {
                        flujoSalida = new PrintStream( new FileOutputStream( nombreArchivo ) );
                        for( int indiceRT = 0 ; indiceRT < resultadosTransiciones.size() ; indiceRT++ ) {
                                flujoSalida.println( resultadosTransiciones.get( indiceRT ) );
                        }
                        flujoSalida.close();
                }
                catch( IOException excepcion ) {
                        JOptionPane.showMessageDialog( null , "No se pudo guardar el archivo ERROR : " + excepcion.toString() ,"ERROR EN ARCHIVO", JOptionPane.ERROR_MESSAGE );
                }
        }

}
