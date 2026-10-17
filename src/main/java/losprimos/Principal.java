package losprimos;

import java.util.Scanner;
/**
 *
 * @author Programa elaborado por los alumnos Uriel Castillo Ramos y Fernando Alonso Reyes Reyes de la 
 *         carrera de Ingeniería en TICS del Instituto Tecnológico del Valle de Oaxaca del grupo T3A
 *         Fecha de entrega: 16/10/2026
 */
public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tienda tienda = new Tienda();
        int opcion;

        do {
            System.out.println("\n==================================");
            System.out.println("       TIENDA LOS PRIMOS");
            System.out.println("==================================");
            System.out.println("1. Registrar productos");
            System.out.println("2. Listar productos");
            System.out.println("3. Reportes");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");

            String entrada = teclado.nextLine().trim();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    tienda.registrarProductos(teclado);
                    break;

                case 2:
                    tienda.listarProductos();
                    break;

                case 3:
                    tienda.mostrarReportes();
                    break;

                case 4:
                    System.out.println(
                        "Gracias por usar el sistema de LOS PRIMOS."
                    );
                    break;

                default:
                    System.out.println(
                        "Opcion no valida. Selecciona del 1 al 4."
                    );
            }

        } while (opcion != 4);

        teclado.close();
    }
}
