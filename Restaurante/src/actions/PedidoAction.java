package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DetallePedido;
import beans.DetalleProducto;
import beans.Pedido;
import beans.Producto;
import daos.Factory;
import daos.PedidoDAO;
import daos.ProductoDAO;

@WebServlet("/pedido")
public class PedidoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	 /** =========================================================================
   	 * ****************  Declaración de variables globales *******************
   	 * ======================================================================= **/
		
   	String mesa = request.getParameter("mesa");
 
	String fec = request.getParameter("fecha");
   
   	String cant = request.getParameter("cantidad");

   	int codigo = Integer.parseInt(request.getParameter("producto"));
   	
   	int codePedido = Integer.parseInt(request.getParameter("pedido"));
         
   	String precio = request.getParameter("precio");
   
   	
   	   Factory subFabrica = Factory.getTipo(Factory.TIPO_MYSQL); /**==== Obtengo el motor de base de datos ========== */
		
		PedidoDAO dao = subFabrica.getPedido();              /**===== Instancio el objeto DAO con la base de datos ======*/
   	
   	
      /** =====================================================
   	 * ****************   Objeto Pedido *******************
   	 * ====================================================== **/
   	
		    Pedido p = new Pedido();
   	        p.setStrEstado("pendiente");
   	        p.setStrFecPedido(fec);
   	        p.setStrMesa(mesa);
   
   		    dao.registrarPedido(p);                                 /**===== Obtengo el metodo SQL que me ejecuta la acción a realizar*/
  
   	/**==FIN ==**/	
   		
   	   /** =============================================================
       	 * ****************   Objeto DetallePedido *******************
       	 * ============================================================= **/
   		
   	if(cant!=  ""){
   		
   		             DetallePedido dp = new DetallePedido();
   		             dp.setIntCodigoPedido(codePedido);
   		             dp.setIntCodigoProducto(codigo);
   		             dp.setStrCantidadPedido(cant);
   		             dp.setStrPrecioTotal(precio);
   		            
   		
   	                 dao.registrarDetallePedido(dp);	/**===== Obtengo el metodo SQL que me ejecuta la acción a realizar*/
   	
   	    /**==FIN ==**/	
   	} 
   	
   	   request.getRequestDispatcher("/Pedido.jsp").forward(request, response);
	 
	}
	
	
}
