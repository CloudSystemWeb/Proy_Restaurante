package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import util.MySqlDBConn;



public class Producto {

	
    /**  ===================================================================
      *  ================ DECLARACION DE VARIABLES ========================= 
         ===================================================================   **/
	
	     private int intCodigoProducto;    //=== Variable para el identificador del producto (PRIMARIA).
	
	     private String StrdescrProducto;  //=== Variable para mostrar el nombre del producto.
	     
	     private int intCodigoCategoria;   //=== Variable para mostrar el codigo de la categoria.
	     
         private double DblPrecio;        //=== Variable para mostrar el precio del producto.
	     
	     
	     
	   /**  ===================================================================
	     *  ======================= METODOS GET =============================== 
	        ===================================================================   **/ 
	     
	     public int getIntCodigoProducto() { return intCodigoProducto; }

		 public String getStrdescrProducto() { return StrdescrProducto; }
		 
	     public int getIntCodigoCategoria() { return intCodigoCategoria; }

		 public double getDblPrecio() { return DblPrecio;}

		
		 
	/**  ===================================================================
		 *  ======================= METODOS SET =============================== 
		    ===================================================================   **/  
		 
		 public void setIntCodigoProducto(int intCodigoProducto) { this.intCodigoProducto = intCodigoProducto; }

		 public void setStrdescrProducto(String strdescrProducto) { StrdescrProducto = strdescrProducto; }
		 
		 public void setIntCodigoCategoria(int intCodigoCategoria) { this.intCodigoCategoria = intCodigoCategoria;}

		 public void setDblPrecio(double dblPrecio) { DblPrecio = dblPrecio; }

		 
		 
		    private int totalProductos;
			private String data = "Select * from producto";
			private List<String> productos;
		
		 public Producto(){
			 
			 productos = new ArrayList<String>();
				StringTokenizer st = new StringTokenizer(data, ",");
				
				while(st.hasMoreTokens()) {
					productos.add(st.nextToken().trim());
				}
				totalProductos = productos.size();
			 
			 
			 
		 }
		 
		 
		 public List<String> getData(String query) {
				String country = null;
				query = "Select * from producto where nombre like ? ";
				List<String> matched = new ArrayList<String>();
				for(int i=0; i<totalProductos; i++) {
					country = productos.get(i).toLowerCase();
					if(country.startsWith(query)) {
						matched.add(productos.get(i));
					}
				}
				return matched;
			}

	
}
