package beans;

public class DetalleProducto {
	
	
	
	/**  ===================================================================
	  *  ================ DECLARACION DE VARIABLES ========================= 
	     ===================================================================   **/	
	
          private int intCodeDetProducto;   //=== Variable para mostrar el identificador del detalle de un producto(PRIMARIA).
	
	      private String StrSTKProducto;       //=== Variable para mostrar la cantidad del producto.
	      
	      private String intCodigoProducto;    //=== Variable para el identificador del producto (FOR�NEA).
	     
	      
	 /**  ===================================================================
	   *  ======================= METODOS GET =============================== 
		  ===================================================================   **/ 

	     
	      public int getIntCodeDetProducto() { return intCodeDetProducto; }
		 
		  public String getStrSTKProducto() { return StrSTKProducto; }

	      public String getIntCodigoProducto() { return intCodigoProducto; }
		  
		  
		  
		  
     /**  ===================================================================
	   *  ======================= METODOS SET =============================== 
		  ===================================================================   **/ 	  
		  
		  
		  public void setIntCodeDetProducto(int intCodeDetProducto) { this.intCodeDetProducto = intCodeDetProducto; }
		  
		  public void setStrSTKProducto(String strSTKProducto) { StrSTKProducto = strSTKProducto;}

		  public void setIntCodigoProducto(String intCodigoProducto) { this.intCodigoProducto = intCodigoProducto;}

        
		

		



		


		

	      
	      
	      
	      
	      
	      
	      
	      
	      
}
