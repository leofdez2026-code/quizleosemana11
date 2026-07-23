/*
 * Clase de tienda
 */
public class Tienda {
 
    public String productos[];
    public int ventas[][];
    public int n;
 
    public static final String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
 
    /**
     * Constructor Tienda.
     * @param n productos tienda.
     */
    public Tienda(int n) {
    this.n = n;
    productos = new String[n];
    ventas = new int[7][n];
    }
 
    /**
     * nombre de cada producto y  almacen
     */
    public void llenarproductos() {
    for (int x = 0; x < n; x++) {
    productos[x] = JOptionPane.showInputDialog("Digite nombre de producto " + (x + 1));
        }
    }
 
    /**
     * Llena la matriz con números aleatorios entre 0 y 9
     */
    public void llenarventas() {
    for (int i = 0; i < 7; i++) {
     for (int j = 0; j < n; j++) {
     ventas[i][j] = (int) (Math.random() * 10);
            }
        }
    }
 
    /**
     * total ventas de cada producto, sumando ventas de cada columna de la matriz.
     * @return arreglo con el total de ventas por producto.
     */
    public int[] calculartotalporproducto() {
        int totales[] = new int[n];
        for (int j = 0; j < n; j++) {
        int suma = 0;
        for (int i = 0; i < 7; i++) {
        suma = suma + ventas[i][j];
       }
         totales[j] = suma;
      }
        return totales;
    }
 
    /**
     * día con mayores ventas sumando cada fila de la matriz,comparando los totales entre sí.
     * @return posición (0 a 6) del día con mayor total de ventas.
     */
    public int calculardiamayorventas() {
        int diamayor = 0;
        int mayortotal = 0;
        for (int i = 0; i < 7; i++) {
        int suma = 0;
        for (int j = 0; j < n; j++) {
        suma = suma + ventas[i][j];
            }
            if (suma > mayortotal) {
            mayortotal = suma;
            diamayor = i;
            }
        }
        return diamayor;
    }
 
    /**
     * producto más vendido durante la semana, suma más alta 
     * @return nombre del producto más vendido.
     */
    public String calcularproductomasvendido() {
        int totales[] = calculartotalporproducto();
        int posicionmayor = 0;
        int mayortotal = totales[0];
        for (int j = 1; j < n; j++) {
        if (totales[j] > mayortotal) {
         mayortotal = totales[j];
         posicionmayor = j;
            }
        }
        return productos[posicionmayor];
    }
 
    /**
     * matriz de ventas semanales.
     */
    public void mostrarventas() {
    for (int i = 0; i < 7; i++) {
    String linea = dias[i] + ": ";
    for (int j = 0; j < n; j++) {
    linea = linea + ventas[i][j] + " ";
        }
        System.out.println(linea);
        }
    }
 
    /**
     * total de ventas de cada producto.
     */
    public void mostrartotalporproducto() {
        int totales[] = calculartotalporproducto();
        for (int j = 0; j < n; j++) {
            System.out.println(productos[j] + ": " + totales[j]);
        }
    }
 
    /**
     * Muestra en pantalla el día con mayores ventas totales.
     */
    public void mostrardiamayorventas() {
    int dia = calculardiamayorventas();
    System.out.println("día con mayores ventas es: " + dias[dia]);
    }
 
    /**
     * Muestra en pantalla el producto más vendido de la semana.
     */
    public void mostrarproductomasvendido() {
        System.out.println("producto más vendido es: " + calcularproductomasvendido());
    }

  
    }

 