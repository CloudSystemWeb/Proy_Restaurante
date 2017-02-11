package service;

import daos.CategoriaDAO;
import daos.EmpleadoDAO;
import daos.Factory;
import daos.ComboDAO;
import daos.ProductoDAO;
import daos.SocioDAO;

public class MySqlFactory  extends Factory{

	@Override
	public ComboDAO getCombo() {return  new MySqlComboDAO();}

	@Override
	public ProductoDAO getProducto() { return new MySqlProductoDAO();}
	
	
	@Override
	public EmpleadoDAO getEmpleado() { return new MySqlEmpleadoDAO();}

	@Override
	public CategoriaDAO getCategoria() { return new MySqlCategoriaDAO();}

	@Override
	public SocioDAO getSocio() { return new MySqlSocioDAO();}



}
