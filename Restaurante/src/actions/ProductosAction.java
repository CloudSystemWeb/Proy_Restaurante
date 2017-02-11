package actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import daos.Factory;
import daos.ProductoDAO;
import beans.DetalleProducto;
import beans.Producto;


/**== La etiqueta @WebServlet contiene el nombre con el cual se referenciará al formulario .jsp ==**/
@WebServlet("/Productos") 
public class ProductosAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		 String metodo = request.getParameter("metodo");
			
			if(metodo.equals("inserta"))		registrar(request, response);
			else if(metodo.equals("actualiza"))	modificar(request, response);
			else if(metodo.equals("elimina"))	eliminar(request, response);
			else if(metodo.equals("lista"))		listar(request, response);
			else if(metodo.equals("busca"))		buscar(request, response);
			
	}
	
	
	/** =======================================================================================================
	 * ================ METODO PARA REGISTRAR UN PRODUCTO Y/O SU DETALLE  =====================================
	 * ======================================================================================================== **/	
	
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		

	 /** =========================================================================
    	 * ****************  Declaración de variables globales *******************
    	 * ======================================================================= **/
		
    	String desc = request.getParameter("descripcion");
    
    	String cant = request.getParameter("cantidad");

    	int codigo = Integer.parseInt(request.getParameter("cod-prod"));
    	
    	int codeCategoria = Integer.parseInt(request.getParameter("cod-cat"));
          
    	double precio = Double.parseDouble(request.getParameter("precio"));
    
    	
    	Factory subFabrica = Factory.getTipo(Factory.TIPO_MYSQL); /**==== Obtengo el motor de base de datos ========== */
		
		ProductoDAO dao = subFabrica.getProducto();              /**===== Instancio el objeto DAO con la base de datos ======*/
    	
    	
       /** =====================================================
    	 * ****************   Objeto Producto *******************
    	 * ====================================================== **/
    	
		    Producto p = new Producto();
            p.setIntCodigoCategoria(codeCategoria);
    	    p.setStrdescrProducto(desc);
    	    p.setDblPrecio(precio);
    
    		dao.registra(p);                                 /**===== Obtengo el metodo SQL que me ejecuta la acción a realizar*/
   
    	/**==FIN ==**/	
    		
    	   /** =============================================================
        	 * ****************   Objeto DetalleProducto *******************
        	 * ============================================================= **/
    		
    	if(cant!=  ""){
    		
    		             DetalleProducto dp = new DetalleProducto();
    		             dp.setIntCodigoProducto(codigo);
    		             dp.setStrSTKProducto(cant);
    		
    	                 dao.insertaDetalleProducto(dp);	/**===== Obtengo el metodo SQL que me ejecuta la acción a realizar*/
    	
    	    /**==FIN ==**/	
    	} 
    	
    	   request.getRequestDispatcher("/Productos.jsp").forward(request, response);
	 
	}
	
	
	
	
	/** =======================================================================================================
	 * ================ METODO PARA LISTAR UN PRODUCTO Y/O SU DETALLE   =======================================
	 * ======================================================================================================== **/	
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		    Factory subFabrica=Factory.getTipo(Factory.TIPO_MYSQL);
			
			ProductoDAO dao= subFabrica.getProducto();
				
			List<Producto> lista = dao.listaProductos();
			
			request.setAttribute("DATA", lista);
			
			request.getRequestDispatcher("/Productos.jsp").forward(request, response);
	}
	

   /** =======================================================================================================
	 * ================ METODO PARA MODIFICAR UN PRODUCTO Y/O SU DETALLE  ====================================
	 * ======================================================================================================== **/	
	
	protected void modificar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
              String descripcion =request.getParameter("desc");

			  Producto p= new Producto();
		      p.setStrdescrProducto(descripcion);
	   
	          Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);  //Llamamos el tipo de base de datos.
	         
	          ProductoDAO dao= subFabrica.getProducto();                 //Se instancia la interface DAO de trabajo.
		      
	          dao.modificaProductos(p);                                  //Llamanos al método del DAO que se va a ejecutar.
	          
	          listar(request, response);
	    	
	}	
	
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		      String cod=request.getParameter("id");
			
		      Factory subFabrica=Factory.getTipo(Factory.TIPO_MYSQL);
		
		      ProductoDAO dao= subFabrica.getProducto();
		
		      dao.eliminaProductos(Integer.parseInt(cod));
		
		      listar(request, response);	
			
		
	}
	
	
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
             String cod=request.getParameter("id");
		
             Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
        
             ProductoDAO dao= subFabrica.getProducto();
		
             Producto a = dao.buscaProductos(Integer.parseInt(cod));
		
		     request.setAttribute("proveedor", a);
		
		     request.getRequestDispatcher("/ModificarProducto.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		try {
			
			String term = request.getParameter("term");
			
			System.out.println("Data from ajax call " + term);

			Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
	        
            ProductoDAO dao= subFabrica.getProducto();
			
			ArrayList<String> list = dao.listar(term);
	
			String searchList = new Gson().toJson(list);
			
			response.getWriter().write(searchList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
		
		
		
	
	

}
