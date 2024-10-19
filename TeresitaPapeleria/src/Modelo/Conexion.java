package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;  //LIBRERÍAS UTILIZADAS
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controlador.metodosTeresita;


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


/*
public int existeUsuario(metodosTeresita mt) {
	PreparedStatement ps=null;
	ResultSet rs=null;
	int cli=0;
	try {
	ps= conectar().prepareStatement("SELECT COUNT(*) cuantos FROM usuario WHERE id_u=?");
	ps.setInt(1, mt.getIdU());
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



public boolean insertarUsuario(KirikoLRS k) {
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


public boolean consultarUsuario(KirikoLRS k) {
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

public boolean eliminarUsuario(KirikoLRS k) {
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
	 
	 
	 public boolean actualizarUsuario(KirikoLRS k) {
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
*/
	 
}
	 