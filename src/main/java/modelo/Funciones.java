
package modelo;

import java.util.Scanner;


public class Funciones {
  Scanner sc = new Scanner(System.in);
  
  public String escribirNombre() {
    String nombre;
    System.out.print("Escriba el Nombre: ");
    nombre = sc.next();
    return nombre;
  }
  
   public String escribirApellido() {
    String apellido;
    System.out.print("Escriba el Apellido: ");
    apellido = sc.next();
    return apellido;
  }
  
    public String escribirTelefono() {
    String tlf;
    System.out.print("Escriba el Télefono: ");
    tlf = sc.next();
    return tlf;
    }
    
    public String escribirEmail() {
    String email;
    System.out.print("Escriba el E-mail: ");
    email = sc.next();
    return email;
  }
    
   public int menuOpc(){
     int opc;
     System.out.println();
     System.out.println("-----------------------------------");
     System.out.println("-----------||  MENU  || -----------");
     System.out.println("-----------------------------------");
     System.out.println("-------- 1. Mostrar Lista ---------");
     System.out.println("-------- 2. Insertar Pers. --------");
     System.out.println("-------- 3. Modificar Pers. -------");
     System.out.println("-------- 4. Eliminar Pers.  -------");
     System.out.println("-------- 5. Salir.         --------");
     System.out.println("-----------------------------------");
     System.out.println("-----------------------------------");
     System.out.printf("Elija una opcion: ");
     opc = sc.nextInt();
     System.out.println();
     return opc;
   }
   
      public void fin(){
      System.out.println("------------------------------------------------------");
      System.out.println("--------------------       ---------------------------");
      System.out.println("---------------   ¯\\_(°°)_/¯   -----------------------");
      System.out.println("---------------- ``    ||    ´´ ----------------------");
      System.out.println("----------------- ``  _/\\_ ´´ ------------------------");
      System.out.println("-------------------- ``¨¨´´ --------------------------");
    }
   }


