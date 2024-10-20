package Controlador;

import Modelo.Conexion;

public class MetodosTeresita {
	
	//VARIABLES DE USUARIO
	int idu;
	String nombre;
	String ap;
	String am;
	String username;
	String password;
	int tf;
	String tc;
	String tipo;
	int iddir;
	
	int cuantos;
	
	//VARIABLES DE PRODUCTO

	String nombrep;
	String tamano;
	double costoc;
	double costov;
	int stock;
	int idp;
	
	//VARIABLES DE DIRECCIÓN
	
	String calle;
	String col;
	int numero;
	int cp;

	
	
	//MÉTODOS PRODUCTO
	
	Conexion cx=null;
	public MetodosTeresita() {
		cx=new Conexion();
	}


public boolean insertarProducto() {
	if(cx.insertarProducto(this)) {
	return true;
	}else {
		return false;
	}
}


public boolean actualizarProducto() {
	if(cx.actualizarProducto(this)) {
	return true;
	}else {
		return false;
	}
}
	

public boolean insertarDir() {
	if(cx.insertarDir(this)) {
	return true;
	}else {
		return false;
	}
}


public boolean actualizarDir() {
	if(cx.actualizarDir(this)) {
	return true;
	}else {
		return false;
	}
}
	
public boolean insertarU() {
	if(cx.insertarU(this)) {
	return true;
	}else {
		return false;
	}
}


public boolean actualizarU() {
	if(cx.actualizarU(this)) {
	return true;
	}else {
		return false;
	}
}

//SETTERS Y GETTERS DE VARIABLES
	
	public int getIdu() {
		return idu;
	}
	public void setIdu(int idu) {
		this.idu = idu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAp() {
		return ap;
	}
	public void setAp(String ap) {
		this.ap = ap;
	}
	public String getAm() {
		return am;
	}
	public void setAm(String am) {
		this.am = am;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTf() {
		return tf;
	}
	public void setTf(int tf) {
		this.tf = tf;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIddir() {
		return iddir;
	}
	public void setIddir(int iddir) {
		this.iddir = iddir;
	}
	public int getCuantos() {
		return cuantos;
	}
	public void setCuantos(int cuantos) {
		this.cuantos = cuantos;
	}
	
	
	
	
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	
	public String getNombrep() {
		return nombrep;
	}
	public void setNombrep(String nombrep) {
		this.nombrep = nombrep;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public double getCostoc() {
		return costoc;
	}
	public void setCostoc(double costoc) {
		this.costoc = costoc;
	}
	public double getCostov() {
		return costov;
	}
	public void setCostov(double costov) {
		this.costov = costov;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	

}
