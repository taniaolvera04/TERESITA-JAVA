package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;  //LIBRERÍAS UTILIZADAS
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controlador.MetodosTeresita;



public class Conexion {
  private static final String controlador="com.mysql.cj.jdbc.Driver"; 
  private static final String url="jdbc:mysql://localhost:3306/teresita"; //NOMBRE DE BASE DE DATOS
  private static final String usuario="root";
  private static final String password="";


  
static {
	try {
		Class.forName(controlador);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}




public Connection conectar() {
	Connection cx=null;
	try {
		cx=DriverManager.getConnection(url, usuario, password);
		System.out.println("Se logró conectar a BD");
	} catch (SQLException e) {
		System.out.println("No se logró coneexión");
		e.printStackTrace();
	}
	return cx;
}

public static void main(String[]args) {
	Conexion c=new Conexion();
	c.conectar();
}



//MÉTODOS DE PRODUCTO

public boolean insertarProducto(MetodosTeresita mt) {
	PreparedStatement ps=null;
	try {
		ps=conectar().prepareStatement("INSERT INTO producto(id_p, nombrep, costoc, costov, tamano, stock) VALUES(?, ?, ?, ?, ?, ?)");
	ps.setInt(1, mt.getIdp());
		ps.setString(2, mt.getNombrep());
		ps.setDouble(3, mt.getCostoc());
		ps.setDouble(4, mt.getCostov());
		ps.setString(5, mt.getTamano());
		ps.setInt(6, mt.getStock());
		ps.executeUpdate();
		return true;
		
	}catch(SQLException e) {
		return false;
		
	}
	
}


public boolean actualizarProducto(MetodosTeresita mt) {
 PreparedStatement ps=null;
 System.out.println("Entró, actualizar");
 try {
	 System.out.println("CONEXIÓN ACTUALIZAR");
 ps=conectar().prepareStatement("UPDATE producto SET nombrep=?, costoc=?, costov=?, tamano=?, stock=? WHERE id_p=?");
 
 
 ps.setString(1, mt.getNombrep());
 ps.setDouble(2, mt.getCostoc());
 ps.setDouble(3, mt.getCostov());
 ps.setString(4, mt.getTamano());
 ps.setInt(5, mt.getStock());
 ps.setInt(6, mt.getIdp());
  ps.executeUpdate();
  
  return true;
 }catch(SQLException e) {
  return false;
 }
}





//MÉTODOS DE DIRECCIÓN

public boolean insertarDir(MetodosTeresita mt) {
	PreparedStatement ps=null;
	try {
		ps=conectar().prepareStatement("INSERT INTO direccion(id_dir, calle, col, numero, cp) VALUES(?, ?, ?, ?, ?)");
	ps.setInt(1, mt.getIddir());
		ps.setString(2, mt.getCalle());
		ps.setString(3, mt.getCol());
		ps.setInt(4, mt.getNumero());
		ps.setInt(5, mt.getCp());
		ps.executeUpdate();
		return true;
		
	}catch(SQLException e) {
		return false;
		
	}
	
}


public boolean actualizarDir(MetodosTeresita mt) {
PreparedStatement ps=null;
System.out.println("Entró, actualizar");
try {
	 System.out.println("CONEXIÓN ACTUALIZAR D");
ps=conectar().prepareStatement("UPDATE direccion SET calle=?, col=?, numero=?, cp=? WHERE id_dir=?");


ps.setString(1, mt.getCalle());
ps.setString(2, mt.getCol());
ps.setInt(3, mt.getNumero());
ps.setInt(4, mt.getCp());
ps.setInt(5, mt.getIddir());
ps.executeUpdate();

return true;
}catch(SQLException e) {
return false;
}
}





public int existeUsuario(MetodosTeresita mt) {
	PreparedStatement ps=null;
	ResultSet rs=null;
	int cli=0;
	try {
	ps= conectar().prepareStatement("SELECT COUNT(*) cuantos FROM usuario WHERE id_u=?");
	ps.setInt(1, mt.getIdu());
	rs=ps.executeQuery();
	if(rs.next()) {
	cli=(rs.getInt("cuantos"));
	System.out.println("Cuantoossss "+ cli);
	mt.setCuantos(cli);
	}
	return cli;
	 }catch (SQLException e) {
	e.printStackTrace();
	 }
	return 0;
	 }



public boolean insertarU(MetodosTeresita mt) {
	PreparedStatement ps=null;
	try {
		ps=conectar().prepareStatement("INSERT INTO usuario(id_u, nombre, ap, ussername, password, tipo, codigo) VALUES(?, ?, ?, ?, ?, ?, ?)");
	ps.setInt(1, k.getId());
		ps.setString(2, k.getNombre());
		ps.setString(3, k.getAp());
		ps.setString(4, k.getNombreu());
		ps.setString(5, k.getContra());
		ps.setString(6, k.getTipo());
		ps.setString(7, k.getCodigo());
		ps.executeUpdate();
		return true;
		
	}catch(SQLException e) {
		return false;
		
	}
	
}


public boolean consultarU(MetodosTeresita mt) {
	PreparedStatement ps=null;
	ResultSet rs=null;
	System.out.println("Entro");
	Conexion c=new Conexion();
	c.existe(k);
	
	if(k.getCuantos()==1)	{
	try {
	ps=conectar().prepareStatement("SELECT * FROM usuario WHERE id_u=?");
	ps.setInt(1, k.getId());
	rs=ps.executeQuery();
	if(rs.next()) {
		
		k.setId(rs.getInt("id_u"));
	
	}
	return true;
	}catch (Exception e2) {
	return false;
	}
	 }else {
	return false;
	 }
	 }

public boolean eliminarU(MetodosTeresita mt) {
	PreparedStatement ps=null;
	Conexion c=new Conexion();
	c.existe(k);
	
	if(k.getCuantos()==1)	{
	try {
	ps=conectar().prepareStatement("DELETE FROM usuario WHERE id_u=?");
	ps.setInt(1, k.getId());
	ps.executeUpdate();
	return true;
	}catch (SQLException e) {
	return false ;
	}
	}else {
		return false;
	}
	 }
	 
	 
	 public boolean actualizarU(MetodosTeresita mt) {
	 PreparedStatement ps=null;
	 System.out.println("Entro");
	 try {
		 System.out.println("Entro");
	 ps=conectar().prepareStatement("UPDATE usuario SET nombre=?, ap=?, ussername=?,password=?, WHERE id_u=?");
	 
	 ps.setInt(5, k.getId());
	 ps.setString(1, k.getNombre());
	 ps.setString(2, k.getAp());
	 ps.setString(3, k.getNombreu());
	 ps.setString(4, k.getContra());
	  ps.executeUpdate();
	  
	  return true;
	 }catch(SQLException e) {
	  return false;
	 }
	}

	 
}
	 