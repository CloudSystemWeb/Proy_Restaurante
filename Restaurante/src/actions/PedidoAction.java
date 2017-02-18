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
import daos.Factory;
import daos.PedidoDAO;

@WebServlet("/pedido")
public class PedidoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	 /** =========================================================================
   	 * ****************  Declaración de variables globales *******************
   	 * ======================================================================= **/

	   String arreglo =  request.getParameter("arreglo_hidden");
		
   	   String mesa = request.getParameter("mesa");
 
	   String fec = request.getParameter("fecha");
   
   /*	int codeProducto = Integer.parseInt(request.getParameter("producto"));*/
   	
       int codeDetaPedido = Integer.parseInt(request.getParameter("detapedido")); 
   	
   	   int codePedido = Integer.parseInt(request.getParameter("pedido"));
   	
   	
   //	int codeEmpleado = Integer.parseInt(request.getParameter("empleado"));
         
   /*	String precio = request.getParameter("precio");*/
   
   	
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
   		
   			if(arreglo != ""){
		   		
   				DetallePedido dp = new DetallePedido();
   	    		String[] pedido = arreglo.split(";");
   	    		int num = 1;
   	    		String mensaje;
   	    		for (String string : pedido) {
   	    				String[] pedidos = string.split(",");
   	    				int item;
   	    				String cantidad,umedida,pre,idproducto;
   	    				
   	    				if(num>=2){
   	    					item =Integer.parseInt(pedidos[1]);
   	    					idproducto=(pedidos[2]);
   	    					cantidad = pedidos[3];
   	    					pre = pedidos[4];
   	    					umedida=pedidos[5];
   	    					
   	    				}else{
   	    					item =Integer.parseInt(pedidos[0]);
   	    					idproducto=(pedidos[1]);
   	    					cantidad = pedidos[2];
   	    					pre = pedidos[3];
   	    					umedida = pedidos[4];
   	    				} 
   	    				 				
   	    				dp.setIntCodigoPedido(codePedido+1);
   	    				dp.setItem(item);
   	    				dp.setIntCodDetPedido(codeDetaPedido+1);
   	    				dp.setIntCodigoProducto(idproducto);
   	    				dp.setStrCantidadPedido(cantidad);
   	    				dp.setStrPrecioTotal(pre);
   	    				dp.setStrUnidMedida(umedida);
   	    				num++;
   	    			
   	    				
   	    			  dao.registrarDetallePedido(dp);	
   	    		}
   	    		
   	    		
   	    	}
   	    	    
   	        request.getRequestDispatcher("/Pedido.jsp").forward(request, response);
	 
	}
	
	
	
}
