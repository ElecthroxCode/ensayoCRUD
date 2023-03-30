
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
  private final String nameBD = "concesionario";
  private final String url = "jdbc:mysql://localhost:3306/" + nameBD;
  private final String user = "electhrox";
  private final String pass = "root";
  
  public Connection conectar() {
    Connection con = null;
    try {
      con = DriverManager.getConnection(url, user, pass);
    } catch (SQLException ex) {
      Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return con;
  }
  
  
}
