/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IGU.GraficadorAutomata;

/*import IGU.AutomataIGU;
import LogicaNegocio.AFD;
import LogicaNegocio.AFN;
import LogicaNegocio.E_Transiciones;
import LogicaNegocio.Nodo;*/
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
//import edu.uci.ics.jung.visualization.layout.PersistentLayout.Point;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Administrador
 */
public class GraficadorAutomata extends JFrame implements ActionListener {

        /*private AFD objAfd;
        private AFN objAfn;
        private E_Transiciones objE_Transiciones;*/
        private List<Integer> listaEstadosFinales;
        private Object automata;
        private String tipoAutomata;
        private int numeroEstados;
        private List<Estado> estadosAsignados;
        //private List<Nodo> nodosAutomata;
        private String nombreFrame;
        private int numEstadosFinales;
        private JMenuBar menuBar;
        private JMenu modeMenu;
        private JMenu menuArchivo;
        private JMenuItem itemsArchivo;
        private Graphics imagenAutomata;
        private String tipoTopologia;
        private int cantNodos;

        public GraficadorAutomata( final int nodos , final String tipoTopologia ) {
                setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
                this.cantNodos = nodos;
                this.tipoTopologia = tipoTopologia;
                estadosAsignados = new ArrayList<Estado>();
                //nodosAutomata = new ArrayList<Nodo>();
                construirAutomata();
        }

        

        private void construirAutomata() {
                Graph<Estado , Enlace> grafo = new DirectedSparseMultigraph<Estado , Enlace>();
                if( tipoTopologia == "Malla" || tipoTopologia == "MALLA" || tipoTopologia == "malla" ) {
                        for( int indiceEstados = 0 ; indiceEstados < cantNodos ; indiceEstados++ ) {
                                Estado estado = new Estado( indiceEstados );
                                estadosAsignados.add( estado );
                        }
                        int contEnlace = 1;
                        for( int indiceNA = 0 ; indiceNA < cantNodos ; indiceNA++ ) {
                                Estado estado = estadosAsignados.get( indiceNA );
                                for( int indiceNS = indiceNA+1 ; indiceNS < (cantNodos) ; indiceNS++ ) {
                                        Estado estadoSiguiente = estadosAsignados.get( indiceNS );
                                        grafo.addEdge( new Enlace( indiceNA , indiceNS , "Enlace "+contEnlace ) , estado , estadoSiguiente , EdgeType.DIRECTED );
                                        contEnlace++;
                                }
                        }
                }
                if( tipoTopologia == "Estrella" || tipoTopologia == "estrella" || tipoTopologia == "ESTRELLA" ) {
                        for( int indiceEstados = 0 ; indiceEstados < cantNodos+1 ; indiceEstados++ ) {
                                Estado estado = new Estado( indiceEstados );
                                estadosAsignados.add( estado );
                        }
                        int contEnlace = 1;
                        Estado estado = estadosAsignados.get( 0 );
                        for( int indiceNS = 1 ; indiceNS < (cantNodos+1) ; indiceNS++ ) {
                                Estado estadoSiguiente = estadosAsignados.get( indiceNS );
                                grafo.addEdge( new Enlace( 0 , indiceNS , "Enlace "+contEnlace ) , estado , estadoSiguiente , EdgeType.DIRECTED );
                                contEnlace++;
                        }
                }
                if( tipoTopologia == "Anillo" || tipoTopologia == "anillo" || tipoTopologia == "ANILLO" ) {
                        for( int indiceEstados = 0 ; indiceEstados < cantNodos+1 ; indiceEstados++ ) {
                                Estado estado = new Estado( indiceEstados );
                                estadosAsignados.add( estado );
                        }
                        int contEnlace = 1;
                        int contEstado = 0;
                        for( int indiceNS = 1 ; indiceNS < (cantNodos) ; indiceNS++ ) {
                                Estado estado = estadosAsignados.get( contEstado );
                                Estado estadoSiguiente = estadosAsignados.get( indiceNS );
                                grafo.addEdge( new Enlace( 0 , indiceNS , "Enlace "+contEnlace ) , estado , estadoSiguiente , EdgeType.DIRECTED );
                                contEnlace++;
                                contEstado++;
                        }
                        grafo.addEdge( new Enlace( 0 , cantNodos , "Enlace "+contEnlace ) , estadosAsignados.get(cantNodos-1) , estadosAsignados.get(0) , EdgeType.DIRECTED );
                }
                if( tipoTopologia == "Doble Anillo" || tipoTopologia == "doble anillo" || tipoTopologia == "DOBLE ANILLO" ) {
                        for( int indiceEstados = 0 ; indiceEstados < cantNodos+1 ; indiceEstados++ ) {
                                Estado estado = new Estado( indiceEstados );
                                estadosAsignados.add( estado );
                        }
                        int contEnlace = 1;
                        int contEstado = 0;
                        for( int indiceNS = 1 ; indiceNS < (cantNodos) ; indiceNS++ ) {
                                Estado estado = estadosAsignados.get( contEstado );
                                Estado estadoSiguiente = estadosAsignados.get( indiceNS );
                                grafo.addEdge( new Enlace( 0 , indiceNS , "Enlace "+contEnlace ) , estado , estadoSiguiente , EdgeType.DIRECTED );
                                contEnlace++;
                                contEstado++;
                        }
                        grafo.addEdge( new Enlace( 0 , cantNodos , "Enlace "+contEnlace ) , estadosAsignados.get(cantNodos-1) , estadosAsignados.get(0) , EdgeType.DIRECTED );
                        contEnlace = 1;
                        contEstado = cantNodos-1;
                        for( int indiceNS = cantNodos-2 ; indiceNS >= 0 ; indiceNS-- ) {
                                Estado estado = estadosAsignados.get( contEstado );
                                Estado estadoSiguiente = estadosAsignados.get( indiceNS );
                                grafo.addEdge( new Enlace( 0 , indiceNS , "Enlace "+contEnlace ) , estado , estadoSiguiente , EdgeType.DIRECTED );
                                contEnlace++;
                                contEstado--;
                        }
                        grafo.addEdge( new Enlace( 0 , cantNodos , "Enlace "+contEnlace ) , estadosAsignados.get(0) , estadosAsignados.get(cantNodos-1) , EdgeType.DIRECTED );
                }
                Layout<Estado , Enlace> layout = new CircleLayout<Estado , Enlace>( grafo );
                layout.setSize( new Dimension( 300 , 300 ) );
                VisualizationViewer<Estado , Enlace> visualizador = new VisualizationViewer( layout );
                visualizador.setPreferredSize( new Dimension( 350 , 350 ) );
                /*Transformer<Estado , Paint> pintarVertices = new Transformer<Estado , Paint>() {
                        public Paint transform( Estado i ) {
                                for( int indiceEstados = 0 ; indiceEstados < cantNodos ; indiceEstados++ ) {
                                        if( listaEstadosFinales.get( indiceEstados ) == i.getIdEstado() ) {
                                                return Color.LIGHT_GRAY;
                                        }
                                }
                                if( i.getIdEstado() == 0 ) {
                                        return Color.GREEN;
                                }
                                else {
                                        return Color.ORANGE;
                                }
                        }
                };
                Transformer<Estado , Paint> pintarBordeEstados = new Transformer<Estado, Paint>() {
                        public Paint transform( Estado i ) {
                                Color colorBorde = new Color( 100 );
                                for( int indiceEstados = 0 ; indiceEstados < numEstadosFinales ; indiceEstados++ ) {
                                        if( listaEstadosFinales.get( indiceEstados ) == i.getIdEstado() && i.getIdEstado() == 0 ) {
                                                        colorBorde = Color.GREEN;
                                        }
                                         else {
                                                colorBorde = Color.BLACK;
                                         }
                                }
                                return colorBorde;
                        }
                };*/
                Transformer<Enlace , Paint> pintarEnlaces = new Transformer<Enlace , Paint>() {
                        public Paint transform( Enlace i ) {
                                return Color.RED;
                        }
                };
                Transformer<Enlace , Font> cambiarFuenteEnlaces = new Transformer<Enlace , Font>() {

                        public Font transform( Enlace i ) {
                                Font fuenteEnlaces = new Font( Font.SANS_SERIF , Font.ITALIC , 12 );
                                return fuenteEnlaces;
                        }
                        
                };
                Transformer<Estado , Font> cambiarFuenteEstado = new Transformer<Estado , Font>() {
                        public Font transform( Estado i ) {
                                Font fuenteEstados = new Font( Font.SANS_SERIF , Font.ITALIC , 10 );
                                return fuenteEstados;
                        }

                };
                visualizador.getRenderContext().setEdgeDrawPaintTransformer( pintarEnlaces );
                visualizador.getRenderContext().setEdgeFontTransformer( cambiarFuenteEnlaces );
                visualizador.getRenderContext().setEdgeLabelTransformer( new ToStringLabeller() );
//                visualizador.getRenderContext().setVertexFillPaintTransformer( pintarVertices );
//                visualizador.getRenderContext().setVertexDrawPaintTransformer( pintarBordeEstados );
                visualizador.getRenderContext().setVertexLabelTransformer( new ToStringLabeller() );
                visualizador.getRenderContext().setVertexFontTransformer( cambiarFuenteEstado );
                visualizador.getRenderContext().setArrowFillPaintTransformer( pintarEnlaces );
                visualizador.getRenderer().getVertexLabelRenderer().setPosition( Position.CNTR );
                DefaultModalGraphMouse modoUsoMouse = new DefaultModalGraphMouse();
//                modoUsoMouse.setMode( ModalGraphMouse.Mode.TRANSFORMING );
                visualizador.addKeyListener ( modoUsoMouse.getModeKeyListener () );
                visualizador.setGraphMouse( modoUsoMouse );
                visualizador.setBackground( Color.WHITE );
                visualizador.setForeground( Color.BLACK );
                getContentPane().add( visualizador );
                // Let's add a menu for changing mouse modes
                menuBar = new JMenuBar();
                menuArchivo = new JMenu( "Archivo" );
                itemsArchivo = new JMenuItem( "Salir" );
                itemsArchivo.addActionListener( this );
                menuArchivo.add( itemsArchivo );
                modeMenu = modoUsoMouse.getModeMenu(); // Obtain mode menu from the mouse
                modeMenu.setText( "Modo Seleccion Mouse" );
                modeMenu.setIcon( null ); // I'm using this in a main menu
                modeMenu.setPreferredSize( new Dimension( 160 ,20 ) ); // Change the size
                menuBar.add( menuArchivo );
                menuBar.add( modeMenu );
                setJMenuBar( menuBar );
                modoUsoMouse.setMode( ModalGraphMouse.Mode.EDITING );
                pack();
                setTitle( nombreFrame );
                setVisible(true);
        }

        public void actionPerformed( ActionEvent evento ) {
                if( evento.getSource() == itemsArchivo ) {
                        //AutomataIGU.menuInicial();
                        this.dispose();
                }
        }

}
