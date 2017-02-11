    package daos;

import service.MySqlFactory;

    public abstract class  Factory {

	
	/**
	 * =============================================================================
	 * =================== DECLARAMOS LAS INTERFACES DE TRABAJO ====================
	 * =============================================================================
	                                                                                  ***/
	   public abstract ComboDAO             getCombo();
	    
	   public abstract ProductoDAO          getProducto();
	    
	   public abstract CategoriaDAO         getCategoria();
	
	   public abstract EmpleadoDAO          getEmpleado();
	   
	   public abstract SocioDAO             getSocio();
	   
	   public abstract PedidoDAO            getPedido();
	   
	   
	  /**
	   * =============================================
	   * ========= FIN DE LA DECLARACION =============
	     ============================================= ***/
	   
	
	   public static final int TIPO_MYSQL =1; // Inicializamos la variable TIPO_MYSQL a 1 .
	   
	   
	
	   public static Factory getTipo(int tipo) 
	   
	   {
		   
		
		   switch (tipo) {
		                    case TIPO_MYSQL:return new MySqlFactory();
		                 }
		
		                    return null;
	   }
	
	
}
