

package main;

import java.util.ArrayList;
import modelo.Funciones;
import modelo.Persona;
import controlador.PersonaControl;
import java.util.Scanner;


public class Crud {

    public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      Persona persona;
      PersonaControl personaControl = new PersonaControl();
      ArrayList<Persona>listaPer = new ArrayList<>();
      Funciones fuc = new Funciones();
      
      boolean ejecucion = true;
      String btn = "";
      int opcMenu;
      while(ejecucion) {
       String nombre, apellido, tlf, email;
       int id;
       boolean res = false;
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("Hola, Bievenido a este 'mini aplicación' de gestión de Base de Datos de Clientes.");
        System.out.println("Presion 'I' para ingresar al menú de opciones...  O presione 'F' para finalizar el programa.");
        btn = teclado.next();
        if(btn.equalsIgnoreCase("I")) {
          opcMenu = fuc.menuOpc();
          switch(opcMenu) {
            case 1:
                  listaPer = personaControl.motrarLista("");
                  System.out.println("ID | Nombre | Apellido | Télefono | E-mail");
                  for(Persona lista : listaPer) {
                    
                    System.out.printf("%d | %s | %s | %s | %s%n", lista.getId(), lista.getNombre(), lista.getApellido(),
                            lista.getTelefono(),lista.getEmail());
                  }
                  System.out.println("================================================");
                  break;
            case 2:
                  
                  System.out.println("Ingrese los siguientes datos de la persona al insertar:");
                  nombre =  fuc.escribirNombre();
                  apellido = fuc.escribirApellido();
                  tlf = fuc.escribirTelefono();
                  email = fuc.escribirEmail();
                  if(nombre != "" && apellido != "" && tlf != "" && email != "") {
                    persona = new Persona(0, nombre, apellido, tlf, email);
                    res = personaControl.insertar(persona);
                  }else {
                    System.out.println("Falta rellenar campos.");
                  }
                  System.out.println("==========================================");
                  break;
            case 3:
              
              System.out.println("Escriba el ID de la persona a modificar: ");
              id = teclado.nextInt();
              System.out.println("Esciba los Nuevos datos: ");
              nombre =  fuc.escribirNombre();
              apellido = fuc.escribirApellido();
              tlf = fuc.escribirTelefono();
              email = fuc.escribirEmail();
                  if(nombre != "" && apellido != "" && tlf != "" && email != "") {
                    persona = new Persona(id, nombre, apellido, tlf, email);
                    res = personaControl.modificar(persona);
                  }else {
                    System.out.println("Falta rellenar campos.");
                  }
                  System.out.println("==========================================");
                  break;
            case 4:
                  System.out.println("Escriba el ID de la persona a eliminar: ");
                  id = teclado.nextInt();
                  res = false;
                  res = personaControl.eliminar(id);
                 break;
                 
            default: System.out.println("FIN");
                   break;   
          }
        } else {
          System.out.println("No quieres ingresar al menu :( .");
        }
        System.out.println("Escriba la 'F' para finalizar todo el programa. O [PRESIONE CUALQUIER LETRA] para volver al inicio.");
        String f = teclado.next();
        if(f.equalsIgnoreCase("F")) {
          ejecucion = false;
        }
      } 
     fuc.fin();
    }
}
