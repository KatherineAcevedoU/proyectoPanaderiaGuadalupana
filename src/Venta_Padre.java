import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

//Se crea una clase padre de ventas
public class Venta_Padre{

    //Se crea un scanner global
    static Scanner entrada = new Scanner(System.in);
    
    //Se crean los atributos
    public String Nombre_Cliente;
    public int Cantidad_a_Vender;
    
    //Se crean un vector de ventas
    public static Vector<Venta_Padre> todosVenta = new Vector<Venta_Padre>();
    
    //Se crean un constructor de la clase venta padre 
    public Venta_Padre(String _nombreCliente, int _cantidadVendido) {
        this.Nombre_Cliente = _nombreCliente;
        this.Cantidad_a_Vender = _cantidadVendido;
    }
    
    //Metodos get y set del vector
    public static Vector<Venta_Padre> getTodosVenta() {
        return todosVenta;
    }

    public void setTodosVenta(Vector<Venta_Padre> todosVenta) {
        Venta_Padre.todosVenta = todosVenta;
    }
    
    //Metodos getter y setter de los atributos
    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public int getCantidad_a_Vender() {
        return Cantidad_a_Vender;
    }

    public void setCantidad_a_Vender(int Cantidad_a_Vender) {
        this.Cantidad_a_Vender = Cantidad_a_Vender;
    }

    //Se crea un metodo para mostrar todas la ventas
    public static String todoInvVentas() {
        String todoelInvVentas = "";
        
        for(int i = 0; i < Venta_Padre.getTodosVenta().size(); i++) {
            todoelInvVentas +=  "Nombre del cliente: " + Venta_Padre.getTodosVenta().get(i).getNombre_Cliente() + "\n"
                                +  "Nombre del pan: " + Inventario_Padre.getTodos().get(i).getNombre() + "\n"
                                +  "La cantidad vendida es: " + Venta_Padre.getTodosVenta().get(i).getCantidad_a_Vender()+ "\n"
                                +  "El precio es: " + Inventario_Padre.getTodos().get(i).getPrecio()+ "\n"
                                +  "El precio total es: " +(Venta_Padre.getTodosVenta().get(i).getCantidad_a_Vender()*Inventario_Padre.getTodos().get(i).getPrecio())+ "\n";
            
            //Esta condicional indica que si se vende algo, la cantidad del producto en el inventario disminuye
            if (Venta_Padre.getTodosVenta().get(i).getCantidad_a_Vender()>0) 
            {   
                //Reducir
                int cantidadin=Inventario_Padre.getTodos().get(i).getCantidad();
                int cantidad_a_vender=Venta_Padre.getTodosVenta().get(i).getCantidad_a_Vender();
                
                cantidadin-=cantidad_a_vender;
                
                Inventario_Padre.getTodos().get(i).setCantidad(cantidadin);
           }
        }
        return todoelInvVentas;
    }
    
    //Metodo para mostrar el producto vendido 
    public static String recorrerInventario()
    {
        String PresentarTodo="";
        
        int numero = 0;
        
        int intentos5 = 0;

        while(intentos5 <3){
            try{
                System.out.println("Digite el pan que ya vendio");
                numero =Integer.parseInt(entrada.nextLine());


                if(numero > 0){
                    System.out.println("");
                    break;
                }else{
                    throw new Exception("Numero no valido");

                }

                }catch(InputMismatchException e){
                    intentos5++;
                    System.out.println("Error! debe ingresar un numero entero");

                }catch(NumberFormatException e){

                    intentos5++;
                    System.out.println("Error! debe ingresar un numero entero");


                }catch(Exception e){

                    intentos5++;
                    System.out.println("Error! debe ingresar un numero entero");

                }

                if(intentos5 == 3){

                    System.out.println("La cantidad de intentos se ha agotado.");
                    break;

                }
            

               
            }
        
       
        
       
        
        for (int i = 0; i < Inventario_Padre.getTodos().size(); i++) {

            if (numero == i) {

                PresentarTodo+="El producto que vendio es: " +Inventario_Padre.getTodos().get(i).getNombre();
            }
        }
        return PresentarTodo;
    }
    
    //Metodo de validacion de entero
}