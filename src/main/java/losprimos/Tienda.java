package losprimos;

import java.util.Scanner;
/**
 *
 * @author Programa elaborado por los alumnos Uriel Castillo Ramos y Fernando Alonso Reyes Reyes de la 
 *         carrera de Ingeniería en TICS del Instituto Tecnológico del Valle de Oaxaca del grupo T3A
 *         Fecha de entrega: 16/10/2026
 */
public class Tienda {
    private static final int MAX_PRODUCTOS = 10;
    private final Producto[] productos =
            new Producto[MAX_PRODUCTOS];

    private int cantidad = 0;

    public void registrarProductos(Scanner teclado) {
        if (cantidad == MAX_PRODUCTOS) {
            System.out.println(
                "Ya se registraron los 10 productos."
            );
            return;
        }

        System.out.println("\n=== REGISTRO DE PRODUCTOS ===");

        while (cantidad < MAX_PRODUCTOS) {
            System.out.println(
                "\nProducto " + (cantidad + 1)
                + " de " + MAX_PRODUCTOS
            );

            int id = leerEnteroPositivo(
                teclado, "Codigo/ID del producto: "
            );

            String nombre = leerTexto(
                teclado, "Nombre del producto: "
            );

            double precio = leerPrecio(teclado);

            String[] ingredientes = new String[4];

            for (int i = 0; i < ingredientes.length; i++) {
                ingredientes[i] = leerTexto(
                    teclado, "Ingrediente " + (i + 1) + ": "
                );
            }

            productos[cantidad] = new Producto(
                id, nombre, precio, ingredientes
            );

            cantidad++;

            System.out.println(
                "Producto registrado correctamente."
            );
        }

        System.out.println(
            "\nSe registraron los 10 productos."
        );
    }

    public void listarProductos() {
        if (!hayProductos()) {
            System.out.println(
                "Primero debes registrar los productos."
            );
            return;
        }

        System.out.println(
            "\n=== LISTA DE PRODUCTOS: LOS PRIMOS ==="
        );

        for (int i = 0; i < cantidad; i++) {
            productos[i].mostrarDatos();
        }

        System.out.println("----------------------------------------");
        System.out.println("Total de productos: " + cantidad);
    }

    public void mostrarReportes() {
        if (!hayProductos()) {
            System.out.println(
                "Primero debes registrar los productos."
            );
            return;
        }

        Producto mayor = productos[0];
        Producto menor = productos[0];
        double suma = 0;

        for (int i = 0; i < cantidad; i++) {
            Producto actual = productos[i];

            if (actual.getPrecio() > mayor.getPrecio()) {
                mayor = actual;
            }

            if (actual.getPrecio() < menor.getPrecio()) {
                menor = actual;
            }

            suma += actual.getPrecio();
        }

        double promedio = suma / cantidad;

        System.out.println("\n=== REPORTES DE PRECIOS ===");

        System.out.printf(
            "Producto de mayor precio: %s ($%.2f)%n",
            mayor.getNombre(), mayor.getPrecio()
        );

        System.out.printf(
            "Producto de menor precio: %s ($%.2f)%n",
            menor.getNombre(), menor.getPrecio()
        );

        System.out.printf(
            "Promedio de los precios: $%.2f%n",
            promedio
        );
    }

    private boolean hayProductos() {
        return cantidad > 0;
    }

    private int leerEnteroPositivo(
            Scanner teclado, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim();

            try {
                int valor = Integer.parseInt(entrada);

                if (valor > 0) {
                    return valor;
                }

                System.out.println(
                    "El valor debe ser mayor que cero."
                );

            } catch (NumberFormatException e) {
                System.out.println(
                    "Escribe un numero entero valido."
                );
            }
        }
    }

    private double leerPrecio(Scanner teclado) {
        while (true) {
            System.out.print("Precio del producto: $");

            String entrada = teclado.nextLine()
                    .trim().replace(',', '.');

            try {
                double precio = Double.parseDouble(entrada);

                if (Double.isFinite(precio) && precio >= 0) {
                    return precio;
                }

                System.out.println(
                    "El precio no puede ser negativo."
                );

            } catch (NumberFormatException e) {
                System.out.println(
                    "Escribe un precio valido, por ejemplo 15.50."
                );
            }
        }
    }

    private String leerTexto(
            Scanner teclado, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = teclado.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println(
                "Este campo no puede quedar vacio."
            );
        }
    }
}
