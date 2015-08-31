/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IGU;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Crisfalt
 */
public class CaracteristicasIGU extends JDialog {

        private String topologia;
        private JTextArea areaResultados;
        private JScrollPane scrollResultados;
        private JPanel panelBoton;
        private Container contenedor;
        private BorderLayout miBorderLayout;
        
        public CaracteristicasIGU( java.awt.Frame parent, boolean modal,final String tipoTopologia  ) {
                super(parent , modal);
                this.topologia = tipoTopologia;

                inicializarControles();
                acomodarControles();
                mostrarMensaje();
        }
        
        private void mostrarMensaje() {
                String mensaje = "";
                if( topologia.equals("Malla") ) {
                        mensaje = "VENTAJAS\n-Enlaces dedicados aseguran el envio de datos entre dos dispositivos";
                        mensaje += "\n-Robusta : Si falla algun enlace , solo se interrumpe la comunicacion"
                                + "\nde los dispositivos afectados , el sistema sigue funcionando";
                        mensaje+="\n-Privacidad (Seguridad) : la informacion solo la vera el receptor adecuado";
                        mensaje+="\n-Se aislan los fallos mas facilmente.";
                        mensaje += "\n\nDESVENTAJAS\n";
                        mensaje += "-Gran Cantidad de cable para la conexion de los dispositivos";
                        mensaje += "\n-Muchos puertos de E/S en cada dispositivo";
                        mensaje += "\n-Reconfiguracion de la red mas dificil";
                        areaResultados.setText(mensaje);
                        
                }
                if( topologia.equals("Estrella") ) {
                        mensaje = "VENTAJAS\n-Mucha mas barata que la topologia malla, instalar menos cableado";
                        mensaje += "\n-Solo se necesita un puerto E/S en cada dispositivo";
                        mensaje += "\nPara la conexion al Concentrador";
                        mensaje += "\n-Reconfiguracion mas sencilla, se agrega un nodo y se conecta al \nconcentrador";
                        mensaje += "\n-Robustez: Si falla un enlace solo se interrumpe la transmision al dispositivo";
                        mensaje += "\ndesconectado, pero la red sigue funcionando";
                        mensaje += "\n-Facil de haya fallos y asilarlos";
                        mensaje += "\n\nDESVENTAJAS";
                        mensaje += "\n-La seguridad , la transmision puede perderse en el concentrador";
                        mensaje += "\n-Concentrador : Si este falla todo la red se Inhabilita";
                        mensaje += "\n-Distancia de Transmision";
                        areaResultados.setText(mensaje);
                }
                if( topologia.equals("Arbol") ) {
                        mensaje = "\nVENTAJAS\n-Menos Costosa : No se cablea al concentrador central\n";
                        mensaje += "Si no a cada concentrador pasivo y este a su vez al central";
                        mensaje += "\n-Numero de Dispositvos: La cantidad de dispositivos amenta gracias";
                        mensaje += "\na los concentradores pasivos";
                        mensaje += "-Distancia de Transmision : La distancia de transmison de la señal aumenta";
                        mensaje += "\n-Robusta";
                        mensaje += "\n-Reconfiguracion de la red mucho mas sencilla";
                        mensaje += "\nDESVENTAJAS";
                        mensaje += "\n-El concentrador Activo falla la red se Inhabilita";
                        mensaje += "\n-Seguridad de la informacion que se envia";
                        mensaje += "\n-Velocidad : el envio de la informacion es mucho mas lento";
                        areaResultados.setText(mensaje);
                }
                if( topologia.equals("Bus") ) {
                        mensaje = "VENTAJAS\n.-Costos : Es la menos costosa de todas las topologias";
                        mensaje += "\n-Instalacion : De muy facil instalacion";
                        mensaje += "\n\nDESVENAJAS";
                        mensaje += "\n-Reconfiguracion: Mas dificil de reconfigurar, ya que se diseña para";
                        mensaje += "\nciertos dispositivos y añadr otro no es conveniente";
                        mensaje += "\n-Aislar y encontrar fallos es mucho mas tedioso";
                        mensaje += "\n-No Robusta:un fallo o rotura en el cable de bus interrumpe toda la red";
                        mensaje += "\npor el ruido en la señal que viaja";
                        mensaje += "\n-Limite de conexion: cuando la señal viaja por el bus, parte de la energia";
                        mensaje += "\nse transforma en calo, esto hace que la seña se debilite; Por ello hay un";
                        mensaje += "\ncierto numeros de conexiones";
                        areaResultados.setText(mensaje);
                }
                if(topologia.equals("Anillo") ) {
                        mensaje += "\nVENTAJAS";
                        mensaje += "\n-Facil Instalacion y Reconfiguracion por su estructura";
                        mensaje += "\n-Los fallos se pueden aislar de una forma sencilla";
                        mensaje += "\n-Menos costosa";
                        mensaje += "\n\nDESVENTAJAS";
                        mensaje += "\n-Debido al trafico unidireccional, la rotura de una conexion del anillo";
                        mensaje += "\nInhabilita toda la red, no es robusta";
                        mensaje += "\n-Seguridad de la informacion es baja ya que esta pasa de nodo a nodo hasta";
                        mensaje += "\nsu destino";
                        mensaje += "\n-La longitud puede ser un problema entre mas grande mas lento se hara el envio";
                        mensaje += "\nde la señal";
                        mensaje += "\n-Robusta : Gracias a las dos vias de sus anillos si en alguno de ellos hay";
                        mensaje += "\nun fallo el otro puede soportar la red sin Inhabilitarla";
                        areaResultados.setText(mensaje);
                }
                if(topologia.equals("Doble Anillo") ) {
                        mensaje += "\nVENTAJAS";
                        mensaje += "\n-Facil Instalacion y Reconfiguracion por su estructura";
                        mensaje += "\n-Los fallos se pueden aislar de una forma sencilla";
                        mensaje += "\nMenos costosa";
                        mensaje += "\n\nDESVENTAJAS";
                        mensaje += "\n-Seguridad de la informacion es baja ya que esta pasa de nodo a nodo hasta";
                        mensaje += "\nsu destino";
                        mensaje += "\n-La longitud puede ser un problema entre mas grande mas lento se hara el envio";
                        mensaje += "\nde la señal";
                        areaResultados.setText(mensaje);
                }
        }
        
        private void inicializarControles() {
                areaResultados = new JTextArea( 500 , 300 );
                scrollResultados = new JScrollPane();
                scrollResultados.setViewportView( areaResultados );
                panelBoton = new JPanel( new GridLayout( 1 , 1 ) );
                miBorderLayout = new BorderLayout();
        }
        
        private void acomodarControles() {
                areaResultados.setEditable( false );
                setLayout( miBorderLayout );
                panelBoton.add(scrollResultados);
                add( panelBoton);
                setSize(500, 300);
                setTitle("CONFIGURACION");
                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        }
        
        
        
                
        
        
}
