import java.util.Vector;

//Se crea una clase padre de inventario
public class Inventario_Padre {

    //Se crea un vector, que es como una especie de lista, que se utiliza para registrar datos de los productos
    public static Vector<Inventario_Padre> todos = new Vector<Inventario_Padre>();

    public String nombre;
    public int cantidad;
    public double precio;
    
    //Se crea un constructor del vector que contendra la informacion
    public Inventario_Padre(String _nombre, int _cantidad, double _precio) {
        this.nombre = _nombre;
        this.cantidad = _cantidad;
        this.precio = _precio;
    }
    
    //Se crea un metodo get del vector
    //getTodos es el nombre del vector, es decir obtener el vector.
    public static Vector<Inventario_Padre> getTodos() {
        return todos;
    }

    //Se crea un metodo set del vector
    //este vector trabaja con la clase metodos los cuales tiene los datos del pan que se agregara al vector
    public void setTodos(Vector<Inventario_Padre> todos) { 
        Inventario_Padre.todos = todos;
    }
   
    
    //Se crean los metodos getter and setter de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    //Se crea un metodo el cual muestra el contenido completo del inventario
    public static String todoelInventario() {
        String todoelInventario = "";
        
        System.out.println("");
        System.out.println("Inventario");
        //i debe ser menor que el tamaño del vector todos, de la clase  Inventario_Padre 
        for(int i = 0; i < Inventario_Padre.getTodos().size(); i++) {
        
            //Esta variable va gauradando datos de cada pan, el mas se utiliza para ir guardando los datos de cada tipo de pan
            //yua que si no lo colocamos solemente se nos guaradara el ulyimo tipo de pan que ingresemos 
            todoelInventario +=  "Nombre del pan: " + Inventario_Padre.getTodos().get(i).getNombre() + "\n"
                                +  "La cantidad es: " + Inventario_Padre.getTodos().get(i).getCantidad() + "\n"
                                +  "El precio es: " + Inventario_Padre.getTodos().get(i).getPrecio()+ "\n"
                                +  "\n";
        }
        return todoelInventario;
    }
}