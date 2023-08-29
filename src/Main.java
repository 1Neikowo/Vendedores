import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        int[][] tabla = new int[15][12];
        rellenarTabla(tabla);
        mostrarMayorVentas(tabla);
        mostrarMesMasVentas(tabla);
        mostrarPromedioMensual(tabla);
        mostrarPromedioVendedor(tabla);
        mostrarVendedorCinco(tabla);
    }
    public static int[][] rellenarTabla(int[][] tabla){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = (int)(Math.random()*100)+1;
                System.out.print(tabla[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return tabla;
    }
    public static int[] ventasVendedores(int[][] tabla){
        int[] datos = new int[15];
        for (int i = 0; i < tabla.length; i++) {
            int sumatoria = 0;
            for (int j = 0; j < tabla[i].length; j++) {
                sumatoria += tabla[i][j];
            }
            datos[i] = sumatoria;
        }return datos;
    }
    public static int calcularMayorVentas(int[] datos){
        int  mayor = 0;
        int index = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] > mayor){
                mayor = datos[i];
                index = i+1;
            }
        }return index;
    }
    public static void mostrarMayorVentas(int[][] tabla){
        System.out.println("Vendedor que más vendió: "+calcularMayorVentas(ventasVendedores(tabla)));
        System.out.println();
    }
    public static int[] mesMasVentas(int[][] tabla){
        int[] datos = new int[12];
        for (int i = 0; i < tabla[i].length; i++) {
            int sumatoria = 0;
            for (int j = 0; j < tabla.length; j++) {
                sumatoria += tabla[j][i];
            }
            datos[i] = sumatoria;
        }return datos;
    }
    public static int calcularMesMenosVentas(int[] datos){
        int  menor = 2000;
        int index = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] < menor){
                menor = datos[i];
                index = i+1;
            }
        }return index;
    }
    public static void mostrarMesMasVentas(int[][] tabla){
        System.out.println("Mes con menos ventas: "+calcularMesMenosVentas(mesMasVentas(tabla)));
        System.out.println();
    }
    public static double[] calcularPromedioMensual(int[] datosMes){
        double[] promediosMensual = new  double[12];
        for (int i = 0; i < datosMes.length; i++) {
            promediosMensual[i] = (double) (datosMes[i])/15;
        }return promediosMensual;
    }
    public static void mostrarPromedioMensual(int[][] tabla){
        DecimalFormat df = new DecimalFormat("#.00");
        double[] arreglo = calcularPromedioMensual(mesMasVentas(tabla));
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Promedio mes "+(i+1)+": "+df.format(arreglo[i]));
        }
        System.out.println();
    }
    public static double[] calcularPromedioVendedor(int[] datosVendedores){
        double[] promediosVendedor = new  double[15];
        for (int i = 0; i < datosVendedores.length; i++) {
            promediosVendedor[i] = (double) datosVendedores[i]/12;
        }return promediosVendedor;
    }
    public static void mostrarPromedioVendedor(int[][] tabla){
        DecimalFormat df = new DecimalFormat("#.00");
        double[] arreglo = calcularPromedioVendedor(ventasVendedores(tabla));
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Promedio vendedor "+(i+1)+": "+df.format(arreglo[i]));
        }
        System.out.println();
    }
    public static int[] datosVendedorCinco(int[][] tabla){
        int[] vendedorCinco = new int[tabla[4].length];
        for (int i = 0; i < tabla[4].length; i++) {
            vendedorCinco[i] = tabla[4][i];
        }
        return vendedorCinco;
    }
    public static void mostrarVendedorCinco(int[][] tabla){
        int[] arreglo = datosVendedorCinco(tabla);
        System.out.println("Datos vendedor 5:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("["+arreglo[i]+"]");
        }
        System.out.println();
    }

}