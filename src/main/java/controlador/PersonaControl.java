
package controlador;

import datos.IDAO;
import java.util.ArrayList;


public class PersonaControl implements IDAO{

  @Override
  public ArrayList motrarLista(String condicion) {
    return new PersonaDAO().motrarLista(condicion);
  }

  @Override
  public boolean insertar(Object o) {
   return new PersonaDAO().insertar(o);
  }

  @Override
  public boolean modificar(Object o) {
    return new PersonaDAO().modificar(o);
  }

  @Override
  public boolean eliminar(int id) {
    return new PersonaDAO().eliminar(id);
  }
  
  
  
}
