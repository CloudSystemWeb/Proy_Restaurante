package daos;

import java.util.ArrayList;
import java.util.List;

import beans.DetalleProducto;
import beans.Producto;

public interface ProductoDAO {

	
	/**
	 * ===============================================================================================
	 * ========= DECLARAMOS LOS METODOS NECESARIOS PARA EL MANTENIMIENTO DEL PRODUCTO ================
	 * ===============================================================================================
	                                                                                                  ***/

	public abstract int registra(Producto p);
	
    public abstract List<Producto> listaProductos();
    
	public abstract Producto buscaProductos(int idProductos);
	
	public abstract int eliminaProductos(int idProductos);
	
	public abstract int modificaProductos(Producto obj);
	
	public List<Producto> consulta(String 	nombre);
	
	public int codigoProducto();
	
	public int insertaDetalleProducto(DetalleProducto obj);
	
	public abstract ArrayList<String> listar(String productos);
	
	public abstract int traeStock(DetalleProducto bean) throws Exception;
	
	
	
}
