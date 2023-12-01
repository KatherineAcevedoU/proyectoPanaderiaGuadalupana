import java.util.Scanner;

public class App {  //Se crea una clase la cual contiene el metodo main
    public static void main(String[] args) {  //En el metodo main se crea el menu principal, el cual cotendra a los otros menus
    
        //creacion de objetos, para mandar a llamar los otros menus 
        Metodos metodo = new Metodos();
        Metodos_Ventas metodo_ventas = new Metodos_Ventas();

        Scanner entrada = new Scanner(System.in);

        int repeticiones = 0;
        int opcion = 0;

        do{

            while(repeticiones < 3){

                System.out.println("--------------------------");
                System.out.println("Bienvenidos a la panaderia");
                System.out.println("--------------------------");
                System.out.println("          Menu            ");
                System.out.println("      1.Inventario        ");
                System.out.println("      2.Ventas            ");
                System.out.println("      3.Salir             ");
                System.out.println("--------------------------");

                try {

                    System.out.print("Elija la opcion: ");
                    opcion = Integer.parseInt(entrada.nextLine());

                    switch (opcion) {
            
                        case 1:
                        //mandamos a llamar con el objeto nuestra clase metodo y metodo menu que esta en la misma clase 
                            metodo.Menu();

                            break;
                    
                        case 2:
                            metodo_ventas.Menu_Ventas();

                            break;
                    
                        case 3:
                            System.out.println("Saliendo de la app.");

                            break;
                    
                        default:
                            
                        break;
                    }

                    if(opcion > 0 && opcion <= 3){

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

                    //se utiliza esta excepcion en una cadena solo permitiendo numeros y no letras.
                } catch (java.lang.NumberFormatException e) {

                    repeticiones++;

                    if(repeticiones < 3){

                        System.out.println();
                        System.out.println("Porfavor ingrese el valor numerico.");
                        System.out.println();

                    }else if(repeticiones == 3){
 
                        System.out.println();
                        System.out.println("Error! se intento varias veces.");

                    }

            
                }

            } 

        }while(opcion != 3);

        entrada.close();
        
    }

}