
package controlador;

import datos.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Persona;

public class PersonaDAO implements IDAO {
  ArrayList<Persona> lista = new ArrayList<>();
  Persona personaObj;
  PreparedStatement ps;
  Connection con = null;
  public PersonaDAO() {
    con = new Conexion().conectar();
  }
  
  @Override
  public ArrayList motrarLista(String condicion) {
    try {
      String isql = "SELECT * FROM persona " + condicion;
      ps = con.prepareStatement(isql);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        personaObj = new Persona(rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("telefono"),
                rs.getString("email"));
        lista.add(personaObj);
      }
      return lista;
     
     
    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally {
      try {
        ps.close();
        con.close();
      } catch (SQLException ex) {
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return null;
  }

  @Override
  public boolean insertar(Object o) {
      int resultado;
      boolean verificador = false;
      personaObj = (Persona) o;
    try {

      String isql = "INSERT INTO persona (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
      ps = con.prepareStatement(isql);
      ps.setString(1, personaObj.getNombre());
      ps.setString(2, personaObj.getApellido());
      ps.setString(3, personaObj.getTelefono());
      ps.setString(4, personaObj.getEmail());
     resultado = ps.executeUpdate();
     if(resultado != 0) {
       System.out.println("Se ha INSERTADO con exito.");
       verificador = true;
     }else {
       System.out.println("NO se ha INSERTADO.");
       verificador = false;
     }
    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally {
      try {
        ps.close();
        con.close();
      } catch (SQLException ex) {
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return verificador;
  }

  @Override
  public boolean modificar(Object o) {
      int resultado;
      boolean verificador = false;
      personaObj = (Persona) o;
    try {

      String isql = "UPDATE persona SET nombre=?, apellido=?, telefono=?, email=? WHERE id=?";
      ps = con.prepareStatement(isql);
      ps.setString(1, personaObj.getNombre());
      ps.setString(2, personaObj.getApellido());
      ps.setString(3, personaObj.getTelefono());
      ps.setString(4, personaObj.getEmail());
      ps.setInt(5, personaObj.getId());
     resultado = ps.executeUpdate();
     if(resultado != 0) {
       System.out.println("Se ha MODIFICADO con exito.");
       verificador = true;
     }else {
       System.out.println("NO se ha MODIFICADO.");
       verificador = false;
     }

    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally {
      try {
        ps.close();
        con.close();
      } catch (SQLException ex) {
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return verificador;
  }

  @Override
  public boolean eliminar(int id) {
      int resultado;
      boolean verificador = false;
      
    try {
      String isql = "DELETE FROM persona WHERE id = ?";
      ps = con.prepareStatement(isql);
      ps.setInt(1, id);
     resultado = ps.executeUpdate();
     if(resultado != 0) {
       System.out.println("Se ha ELIMINADO con exito.");
       verificador = true;
     }else {
       System.out.println("NO se ha ELIMINADO.");
       verificador = false;
     }

    } catch (SQLException ex) {
      Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally {
      try {
        ps.close();
        con.close();
      } catch (SQLException ex) {
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return verificador;
  }
  
}
