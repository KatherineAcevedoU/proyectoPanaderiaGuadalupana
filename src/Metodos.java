import java.util.Scanner;

public class Metodos{  //Se crea una clase metodos, el cual contiene un menu de inventario, cuyos casos se utilizan para añadir, eliminar, mostrar datos en el inventario y regresar al menu principal
                      
    static Scanner entrada = new Scanner(System.in);  //Se crea un scanner global por que se utilza en diferentes metodos
    
    
    public void Menu(){   //Se crea el mentodo de menu
    
        int opcion = 0;
        int repeticiones = 0;

        do {

            while(repeticiones < 3){

                System.out.println("..............................");
                System.out.println("             MENU            ");
                System.out.println("..............................");
                System.out.println("1. Añadir panes al inventario");
                System.out.println("2. Eliminar panes del inventario");
                System.out.println("3. Mostrar inventario");
                System.out.println("4. Volver al menu Principal");
                System.out.println("..............................");

                try {

                    System.out.print("Digite la opcion que desee: ");
                    opcion = Integer.parseInt(entrada.nextLine());
                    System.out.println();

                    switch (opcion) {
            
                        case 1:
                            Añadir();
                            break;
                    
                        case 2:
                            Eliminar();
                            break;
                    
                        case 3:
                            System.out.println(Inventario_Padre.todoelInventario());
                            break;
                    
                        case 4:
                            System.out.println("Volviendo al menu principal");
                            break;
                    
                        default:
                            break;
                        
                        }

                        if(opcion > 0 && opcion <= 4){

                            System.out.println("Numero valido.");
    
                            break;
    
                        }else{
    
                            repeticiones++;
    
                            if(repeticiones < 3){
    
                                System.out.println();
                                System.out.println("No existe esta opcion.");
                                System.out.println();
    
                            }else if(repeticiones == 3){
     
                                System.out.println();
                                System.out.println("Error! se intento varias veces.");
    
                            }
    
                        }
                    
                } catch (java.lang.NumberFormatException e) {

                    repeticiones++;
    
                    if(repeticiones < 3){
    
                        System.out.println();
                        System.out.println("No existe esta opcion.");
                        System.out.println();
    
                    }else if(repeticiones == 3){
     
                        System.out.println();
                        System.out.println("Error! se intento varias veces.");
    
                    }
                    
                }
               
            }

        } while (opcion != 4);
        
    }
    
    public void Añadir() {  //Se crea el metodo añadir
    
        String nombre;
        int cantidadTipoDePan = 0;
        int cantidadDeCadaPan = 0;
        double precio = 0.0;
        int repeticiones1 = 0;

        while(repeticiones1 < 3){

            try {

                System.out.print("Ingrese la cantidad de los distintos tipos de panes: ");
                cantidadTipoDePan = Integer.parseInt(entrada.nextLine());

                if(cantidadTipoDePan > 0){

                    System.out.println();

                    repeticiones1 = 3;

                }else{

                    repeticiones1++;

                        if(repeticiones1 < 3){

                            System.out.println();
                            System.out.println("No existe esta opcion.");
                            System.out.println();

                        }else if(repeticiones1 == 3){
 
                            System.out.println();
                            System.out.println("Error! se intento varias veces.");

                        }

                }
                
            } catch (java.lang.NumberFormatException e) {

                repeticiones1++;

                        if(repeticiones1 < 3){

                            System.out.println();
                            System.out.println("No existe esta opcion.");
                            System.out.println();

                        }else if(repeticiones1 == 3){
 
                            System.out.println();
                            System.out.println("Error! se intento varias veces.");

                        }
                
            }

        }

        
        for (int i = 0; i < cantidadTipoDePan; i++) {

            System.out.print("Ingrese el nombre que desee del pan " + (i+1) + ": ");
            nombre = entrada.nextLine();
            System.out.println();

            int repeticiones2 = 0;

            while(repeticiones2 < 3){

                try {

                    System.out.print("Ingrese la cantidad del pan " + (i+1) + ": ");
                    cantidadDeCadaPan = Integer.parseInt(entrada.nextLine()); 
                    System.out.println();
                    System.out.print("Ingrese el precio del pan " + (i+1) + ": ");
                    precio = Double.parseDouble(entrada.nextLine());
                    System.out.println();

                    if(cantidadDeCadaPan > 0 && precio > 0){

                        System.out.println();
                        break;

                    }else{

                        repeticiones2++;

                        if(repeticiones2 < 3){

                            System.out.println();
                            System.out.println("No ingrese numeros negativos.");
                            System.out.println();
                            break;


                        }else if(repeticiones2 == 3){
 
                            System.out.println();
                            System.out.println("Error! se intento varias veces.");
                            break;

                        }

                    }
                    
                } catch (java.lang.NumberFormatException e) {

                    repeticiones2++;

                        if(repeticiones2 < 3){

                            System.out.println();
                            System.out.println("Ingrese valores numericos.");
                            System.out.println();
            

                        }else if(repeticiones2 == 3){
 
                            System.out.println();
                            System.out.println("Error! se intento varias veces.");
                            

                        }
                    
                }

            }

            Inventario_Padre.getTodos().add(new Inventario_Padre(nombre, cantidadDeCadaPan, precio));  
        }
    } 
    

    public void Eliminar()  {   //Se crea un metodo eliminar
    
        int numero_de_producto_a_eliminar;
        
        System.out.print("Ingrese el numero del pan a eliminar: ");
        numero_de_producto_a_eliminar = Integer.parseInt(entrada.nextLine());
        System.out.println();
        
        for (int i = 0; i < Inventario_Padre.getTodos().size(); i++) {
        
            if (numero_de_producto_a_eliminar == i) {
            
                Inventario_Padre.getTodos().remove(i);

            }else {
            
                System.out.println("No se pudo eliminar el producto.");
            }
        }
    }

}
