/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IGU.GraficadorAutomata;

/**
 *
 * @author Administrador
 */
public class Enlace {

        private String simbolo; // should be private for good practice
        private double capacity; // should be private
        private double weight; // should be private for good practice

        public Enlace( final double weight , final double capacity ,
                final String simbolo ) {
                this.simbolo = simbolo;
                this.weight = weight;
                this.capacity = capacity;
        }
        public String toString() { // Always good for debugging
                if( simbolo.equals( "_" ) ) {
//                        return "Excilon";
                        return "ε";
                }
                else {
                        return simbolo;
                }
        }

}
