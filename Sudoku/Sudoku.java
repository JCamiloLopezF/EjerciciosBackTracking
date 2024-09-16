package Sudoku;

public class Sudoku {

    public static void main(String[] args) {

        int[][] tableroSudoku = {
                {6, 0, 9, 0, 5, 0, 7, 2, 0},
                {3, 0, 0, 4, 0, 7, 9, 0, 6},
                {0, 8, 7, 1, 9, 6, 0, 0, 3},
                {4, 9, 0, 2, 0, 1, 3, 0, 5},
                {0, 0, 3, 0, 0, 4, 0, 0, 2},
                {8, 7, 0, 5, 0, 0, 6, 1, 0},
                {5, 0, 1, 8, 0, 3, 0, 0, 0},
                {0, 6, 4, 9, 0, 0, 2, 3, 8},
                {0, 3, 0, 0, 4, 2, 1, 0, 7}
        };

        //Si el sudoku dado en la matriz se puede resolver:
        if (resolverSudoku(tableroSudoku, 0, 0)) {
            imprimirTablero(tableroSudoku);
        } else {
            System.out.println("No se pudo resolver el Sudoku.");
        }
    }

    //Metodo que llena las casillas faltantes del tablero
    //El metodo hace uso de rescursividad
    private static boolean resolverSudoku(int[][] tablero, int fila, int col) {

        //Si llega al final de las filas el tablero termina
        if (fila == 9) {
            return true;
        }

        //Si llega al final de la columna, pasa a la siguiente fila
        if (col == 9) {
            return resolverSudoku(tablero, fila + 1, 0);
        }

        // Seguir con la siguiente selda si ya esta llena
        if (tablero[fila][col] != 0) {
            return resolverSudoku(tablero, fila, col + 1);
        }

        //El codigo tiene un comportamiento de recorrido de arriba a abajo de izquierda a derecha


        // Inserta un numero del 1 al 9 en la celda vacia
        // Haciendo uso del metodo
        for (int numero = 1; numero <= 9; numero++) {

            //Si el numero es valido en la celda, se coloca
            if (numeroValido(tablero, fila, col, numero)) {
                tablero[fila][col] = numero;

                //Llamada para seguir con el resto del tablero
                if (resolverSudoku(tablero, fila, col + 1)) {
                    return true;
                }

                //Backtracking, si no se puede y o no es valido con cualquier numero, la celda se reemplaza por 0 (vaciar)
                tablero[fila][col] = 0;
            }
        }

        // Si no se puede colocar ningún número válido, se retrocede
        return false;
    }


    //Metodo que verifica si el numero es valido en colocar en la posicion
    //Verificando fila, columna y matriz 3x3
    public static boolean numeroValido(int[][] tablero, int fila, int columna, int numero) {

        //verifica la fila
        for (int x = 0; x < 9; x++) {

            if (tablero[fila][x] == numero) {
                return false;
            }
        }

        //verifica la columna
        for (int x = 0; x < 9; x++) {

            if (tablero[x][columna] == numero) {
                return false;
            }
        }

        //Comprueba la matriz o cuadricula en 3x3
        int inicioFila = fila - fila % 3;
        int inicioCol = columna - columna % 3;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (tablero[i + inicioFila][j + inicioCol] == numero) {
                    return false;
                }
            }
        }
        //Si llega hasta aqui quiere decir que el numero es valido en dicha posicion
        //Es válido colocar el número
        return true;
    }



    //Imprime el sudoku en caso de ahber solucion
    public static void imprimirTablero(int[][] tablero) {
        for (int fila = 0; fila < 9; fila++) {

            for (int columna = 0; columna < 9; columna++) {

                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}

