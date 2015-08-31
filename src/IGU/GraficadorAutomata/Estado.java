/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IGU.GraficadorAutomata;

/**
 *
 * @author Administrador
 */
public class Estado {

        private int idEstado;

        public Estado( final int id ) {
                this.idEstado = id;
                System.out.println( "id Estado " + id );
        }

        public int getIdEstado() {
                return idEstado;
        }

        public String toString() { // Always a good idea for debuging
                return "PC : " + idEstado; // JUNG2 makes good use of these.
        }

}
