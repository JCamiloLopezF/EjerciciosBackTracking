/**
 * La clase NReina es una implementación en Java para resolver el problema de las N-Reinas
 * utilizando retroceso recursivo. El objetivo es colocar N reinas en un tablero de ajedrez de N×N
 * de manera que ninguna reina amenace a otra.
 */
public class NReina {

    private int tamanio;     // Tamaño del tablero.
    private int[] reinas;    // Arreglo para almacenar las posiciones de las reinas en el tablero.

    /**
     * Constructor para inicializar el tamaño del tablero y el arreglo para almacenar las posiciones de las reinas.
     *
     * @param tamanio El tamaño del tablero.
     */
    public NReina(int tamanio) {
        this.tamanio = tamanio;
        reinas = new int[tamanio];
    }

    /**
     * Método para comenzar a resolver el problema de las N-Reinas.
     *
     * @return true si se encuentra una solución, false en caso contrario.
     */
    public boolean solucionar() {  
        return posicionReina(0);
    }

    /**
     * Método recursivo para colocar las reinas fila por fila.
     *
     * @param posicion La fila actual para colocar la reina.
     * @return true si las reinas pueden colocarse exitosamente, false en caso contrario.
     */
    private boolean posicionReina(int posicion) {
        if (posicion == tamanio) {
            imprimirSolucion();
            return true; 
        }
        return posicionColumna(posicion, 0);
    }

    /**
     * Intenta colocar la reina en la fila actual verificando cada columna.
     * 
     * @param fila La fila actual para colocar la reina.
     * @param columna La columna actual que se está verificando.
     * @return true si la reina puede colocarse, false en caso contrario.
     */
    private boolean posicionColumna(int fila, int columna) {
        if (columna == tamanio) {
            return false; 
        }
        if (esCorrecta(fila, columna)) {
            reinas[fila] = columna;
            if (posicionReina(fila + 1)) {
                return true;
            }
        }
        return posicionColumna(fila, columna + 1);
    }

    /**
     * Verifica si colocar una reina en la posición dada es válido.
     *
     * @param fila La fila a verificar.
     * @param columna La columna a verificar.
     * @return true si la posición es válida, false en caso contrario.
     */
    private boolean esCorrecta(int fila, int columna) {
        return checkFilaPrevia(fila, columna, 0);
    }

    /**
     * Verifica todas las reinas colocadas previamente para asegurar que ninguna amenace a otra.
     *
     * @param fila La fila a verificar.
     * @param columna La columna a verificar.
     * @param i Índice para filas anteriores.
     * @return true si no se encuentra conflicto, false en caso contrario.
     */
    private boolean checkFilaPrevia(int fila, int columna, int i) {
        if (i >= fila) {
            return true;
        }
        if (reinas[i] == columna || reinas[i] - i == columna - fila || reinas[i] + i == columna + fila) {
            return false;
        }
        return checkFilaPrevia(fila, columna, i + 1);
    }

    /**
     * Imprime la solución actual en el tablero.
     */
    private void imprimirSolucion() {
        printFila(0);
        System.out.println();
    }

    /**
     * Imprime cada fila del tablero.
     *
     * @param i La fila actual a imprimir.
     */
    private void printFila(int i) {
        if (i >= tamanio) {
            return;
        }
        printColumna(i, 0);
        System.out.println();
        printFila(i + 1);
    }

    /**
     * Imprime cada columna de una fila específica.
     *
     * @param i El índice de la fila.
     * @param j El índice de la columna.
     */
    private void printColumna(int i, int j) {
        if (j >= tamanio) {
            return;
        }
        if (reinas[i] == j) {
            System.out.print("R ");
        } else {
            System.out.print("* ");
        }
        printColumna(i, j + 1);
    }

    /**
     * Método principal para ejecutar el solucionador de las N-Reinas.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        int n = 17; 
        NReina nReinas = new NReina(n);
        if (!nReinas.solucionar()) {
            System.out.println("No se encontró solución ");
        }
    }
}