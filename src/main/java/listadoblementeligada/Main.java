/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadoblementeligada;

/**
 *
 * @author victo
 */

public class Main {

    private static int prueba = 0;

    static void mostrar(String titulo, ListaDoble l) {
        prueba++;
        System.out.println("\n Prueba " + prueba + ": " + titulo + " ");
        System.out.println("  Adelante : " + l);
        System.out.println("  Reversa  : " + l.toStringReversa());
        System.out.println("  Tamanio  : " + l.getTamanio()
                + " | Cabeza: " + (l.getCabeza() == null ? "null" : l.getCabeza().getDato())
                + " | Cola: " + (l.getCola() == null ? "null" : l.getCola().getDato())
                + " | Enlaces OK: " + l.verificarEnlaces());
    }

    static void seccion(String nombre) {
        System.out.println("  " + nombre);
    }

    public static void main(String[] args) {

        seccion("1. insertarOrdenado(int dato)");
        
        ListaDoble orden = new ListaDoble();
        mostrar("Lista nueva (vacia)", orden);

        orden.insertarOrdenado(50);
        mostrar("insertarOrdenado(50) en lista vacia", orden);

        orden.insertarOrdenado(10);
        mostrar("insertarOrdenado(10), menor que la cabeza", orden);

        orden.insertarOrdenado(90);
        mostrar("insertarOrdenado(90), mayor que la cola", orden);

        orden.insertarOrdenado(30);
        mostrar("insertarOrdenado(30), en medio", orden);

        orden.insertarOrdenado(70);
        mostrar("insertarOrdenado(70), en medio", orden);

        orden.insertarOrdenado(30);
        mostrar("insertarOrdenado(30), valor repetido", orden);

        int[] desordenados = {42, 5, 88, 17, 63, 1};
        for (int d : desordenados) {
            orden.insertarOrdenado(d);
        }
        mostrar("insertarOrdenado de {42, 5, 88, 17, 63, 1}", orden);

        
        seccion("2. insertarEnPosicion(int pos, int dato)");
        
        ListaDoble lista = new ListaDoble();
        lista.insertarEnPosicion(0, 20);
        mostrar("insertarEnPosicion(0, 20) en lista vacia", lista);

        lista.insertarEnPosicion(0, 10);
        mostrar("insertarEnPosicion(0, 10), al inicio", lista);

        lista.insertarEnPosicion(2, 40);
        mostrar("insertarEnPosicion(2, 40), al final (pos == tamanio)", lista);

        lista.insertarEnPosicion(2, 30);
        mostrar("insertarEnPosicion(2, 30), en medio", lista);

        lista.insertarEnPosicion(1, 15);
        mostrar("insertarEnPosicion(1, 15), en medio", lista);

        try {
            lista.insertarEnPosicion(9, 99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n  insertarEnPosicion(9, 99): Excepcion controlada: " + e.getMessage());
        }
        try {
            lista.insertarEnPosicion(-1, 99);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  insertarEnPosicion(-1, 99): Excepcion controlada: " + e.getMessage());
        }
        mostrar("La lista no cambio tras posiciones invalidas", lista);

        
        seccion("3. eliminarEnPosicion(int pos) : int");
        
        int eliminado = lista.eliminarEnPosicion(2);
        System.out.println("\n  eliminarEnPosicion(2) devolvio: " + eliminado);
        mostrar("Despues de eliminar la posicion 2 (en medio)", lista);

        eliminado = lista.eliminarEnPosicion(0);
        System.out.println("\n  eliminarEnPosicion(0) devolvio: " + eliminado);
        mostrar("Despues de eliminar la posicion 0 (cabeza)", lista);

        eliminado = lista.eliminarEnPosicion(lista.getTamanio() - 1);
        System.out.println("\n  eliminarEnPosicion(ultima) devolvio: " + eliminado);
        mostrar("Despues de eliminar la ultima posicion (cola)", lista);

        try {
            lista.eliminarEnPosicion(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\n  eliminarEnPosicion(5): Excepcion controlada: " + e.getMessage());
        }
        try {
            lista.eliminarEnPosicion(-3);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("  eliminarEnPosicion(-3): Excepcion controlada: " + e.getMessage());
        }
        mostrar("La lista no cambio tras posiciones invalidas", lista);

        
        seccion("4. eliminarPorValor(int x) : boolean");
        
        ListaDoble valores = new ListaDoble();
        for (int d : new int[]{7, 3, 9, 3, 5, 1}) {
            valores.insertarAlFinal(d);
        }
        mostrar("Lista base", valores);

        System.out.println("\n  eliminarPorValor(9): " + valores.eliminarPorValor(9));
        mostrar("Despues de eliminar 9 (en medio)", valores);

        System.out.println("\n  eliminarPorValor(7): " + valores.eliminarPorValor(7));
        mostrar("Despues de eliminar 7 (cabeza)", valores);

        System.out.println("\n  eliminarPorValor(1): " + valores.eliminarPorValor(1));
        mostrar("Despues de eliminar 1 (cola)", valores);

        System.out.println("\n  eliminarPorValor(3): " + valores.eliminarPorValor(3));
        mostrar("Despues de eliminar 3 (solo la primera aparicion)", valores);

        System.out.println("\n  eliminarPorValor(100): " + valores.eliminarPorValor(100));
        mostrar("Valor inexistente: la lista no cambia", valores);

        
        seccion("5. eliminarUltimo() : boolean");
        
        ListaDoble ultimos = new ListaDoble();
        ultimos.insertarAlFinal(100);
        ultimos.insertarAlFinal(200);
        ultimos.insertarAlFinal(300);
        mostrar("Lista base", ultimos);

        System.out.println("\n  eliminarUltimo(): " + ultimos.eliminarUltimo());
        mostrar("Despues de eliminar el ultimo", ultimos);

        System.out.println("\n  eliminarUltimo(): " + ultimos.eliminarUltimo());
        mostrar("Queda un solo elemento (cabeza == cola)", ultimos);

        System.out.println("\n  eliminarUltimo(): " + ultimos.eliminarUltimo());
        mostrar("La lista quedo vacia (cabeza y cola en null)", ultimos);

        System.out.println("\n  eliminarUltimo() en lista vacia: " + ultimos.eliminarUltimo());
        mostrar("Sigue vacia, sin NullPointerException", ultimos);

        
        seccion("6. Reutilizar la lista despues de vaciarla");
        
        ultimos.insertarOrdenado(8);
        ultimos.insertarOrdenado(2);
        ultimos.insertarEnPosicion(1, 5);
        mostrar("insertarOrdenado(8), insertarOrdenado(2), insertarEnPosicion(1, 5)", ultimos);

        System.out.println("\n  buscar(5): " + ultimos.buscar(5)
                + " | buscar(8) (la cola): " + ultimos.buscar(8)
                + " | buscar(4): " + ultimos.buscar(4));

        System.out.println("\n  Fin de la bateria de pruebas.");
    }
}
