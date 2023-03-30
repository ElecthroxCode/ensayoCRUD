
package datos;

import java.util.ArrayList;


public interface IDAO {
  public ArrayList motrarLista(String condicion);
  public boolean insertar(Object o);
  public boolean modificar (Object o);
  public boolean eliminar(int id);
}
