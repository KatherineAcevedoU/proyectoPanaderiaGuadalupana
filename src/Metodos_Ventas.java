import java.util.InputMismatchException;
import java.util.Scanner;

public class Metodos_Ventas {  //Se crea una clase metodo para ventas

    Scanner entrada = new Scanner(System.in);
    
    public void Menu_Ventas() { //Se crea un metodo menu de ventas
     
        int opcion = 0;
        int repeticiones = 0;

        do {

            while(repeticiones < 3){ 
        
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println("            MENU            ");
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println("Digite la opcion que desee");
                System.out.println("      1. Añadir Ventas");
                System.out.println("      2. Mostrar Ventas");
                System.out.println("      3. Volver al menu principal");
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");

                try {

                    System.out.print("Digite la opcion que desee: ");
                    opcion= Integer.parseInt(entrada.nextLine());

                    switch (opcion) {
            
                        case 1:
                            Añadir_Ventas();
                            break;
                    
                        case 2:
                            System.out.println(Venta_Padre.todoInvVentas());
                            break;
                    
                        case 3:
                            System.out.println("Volviendo al menu principal");
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

        } while (opcion != 3);
    }
    
    public void Añadir_Ventas() {  //Metodo añadir ventas
    
        String Nombre_Clientes;
        int Cantidad_Vender = 0;//esta es la cantidad a vender
        double PrecioTotal;
        int limite = 0;
        int intentos3 = 0;

        while(intentos3< 3){ 

            try {

                System.out.print("Ingrese el limite de registro de ventas: ");
                limite = Integer.parseInt(entrada.nextLine());
                
                if(limite > 0){

                   System.out.println("");
                   break;

                }else{
                    throw new Exception("Numero no valido");

                }   
                  
                
            } catch (InputMismatchException e) {
                intentos3++;
                System.out.println("Error! debe ingresar un numero entero");
                
            }catch(NumberFormatException e){
                intentos3++;
                System.out.println("Error! debe ingresar un numero entero");
            }catch(Exception e){
                intentos3++;
                System.out.println("Error! debe ingresar un numero entero");
            }

            if(intentos3 == 3){
                System.out.println("La cantidad de intentos se han agotado");
                break;
            }

        }
        
        for (int i = 0; i < limite ; i++) {

        
            System.out.print("Ingrese el nombre del cliente " + (i+1) + ": " );
            Nombre_Clientes = entrada.next();
            System.out.println("");
            
        
            System.out.println(Inventario_Padre.todoelInventario());
            System.out.println(Venta_Padre.recorrerInventario());
            
           
            int intentos4 = 0;
            while(intentos4 <3){
                try{
                    System.out.println("Ingrese la cantidad de pan vendido" + "" + (1+i));
                    Cantidad_Vender = Integer.parseInt(entrada.next());
                    if(Cantidad_Vender > 0){
                        System.out.println("");
                        break;
                    }else{
                        throw new Exception("Numero no valido");
                    }

                }catch(InputMismatchException e){
                    intentos4++;
                    System.out.println("Error! debe ingresar un numero entero");

                }catch(NumberFormatException e){

                    intentos4++;
                    System.out.println("Error! debe ingresar un numero entero");


                }catch(Exception e){

                    intentos4++;
                    System.out.println("Error! debe ingresar un numero entero");

                }

                if(intentos4 == 3){

                    System.out.println("La cantidad de intentos se ha agotado.");
                    break;

                }
            
            }
            
            System.out.println("La cantidad es: " + Cantidad_Vender);
            
            Venta_Padre.getTodosVenta().add(new Venta_Padre(Nombre_Clientes,Cantidad_Vender));
        }
    }
    
}