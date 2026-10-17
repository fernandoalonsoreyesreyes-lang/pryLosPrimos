package losprimos;

/**
 *
 * @author Programa elaborado por los alumnos Uriel Castillo Ramos y Fernando Alonso Reyes Reyes de la 
 *         carrera de Ingeniería en TICS del Instituto Tecnológico del Valle de Oaxaca del grupo T3A
 *         Fecha de entrega: 16/10/2026
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String[] ingredientes;

    public Producto(int id, String nombre, double precio,
                    String[] ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void mostrarDatos() {
        System.out.println("----------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.printf("Precio: $%.2f%n", precio);
        System.out.println("Ingredientes:");

        for (int i = 0; i < ingredientes.length; i++) {
            System.out.println(
                "  " + (i + 1) + ". " + ingredientes[i]
            );
        }
    }
}
