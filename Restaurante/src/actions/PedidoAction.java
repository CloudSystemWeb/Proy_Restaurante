package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.DetallePedido;
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
   
   	int codeProducto = Integer.parseInt(request.getParameter("producto"));
   	
   /*	int codeDetaPedido = Integer.parseInt(request.getParameter("detapedido"));*/
   	
   	int codePedido = Integer.parseInt(request.getParameter("pedido"));
   	
   	
   	int codeEmpleado = Integer.parseInt(request.getParameter("empleado"));
         
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
   	    		for (String string : pedido) {
   	    				String[] pedidos = string.split(",");
   	    				int item;
   	    				String cantidad,umedida,pre;
   	    				
   	    				if(num>=2){
   	    					item =Integer.parseInt(pedidos[1]);
   	    					cantidad = pedidos[2];
   	    					pre = pedidos[3];
   	    					umedida=pedidos[4];
   	    					
   	    				}else{
   	    					item =Integer.parseInt(pedidos[0]);
   	    					cantidad = pedidos[1];
   	    					pre = pedidos[2];
   	    					umedida = pedidos[3];
   	    				} 
   	    				
   	    				dp.setItem(item);
   	    				dp.setIntCodigoPedido(codePedido+1);
   	    				dp.setIntCodigoProducto(codeProducto);
   	    				dp.setIntCodigoEmpleado(codeEmpleado);
   	    				dp.setStrCantidadPedido(cantidad);
   	    				dp.setStrPrecioTotal(pre);
   	    				dp.setStrUnidMedida(umedida);
   	    				num++;
   	    				
   	    				//3 El metodo(El SQL que se va enviar)
   	    			    dao.registrarDetallePedido(dp);	
   	    				
   	    				
   	    		}
   	    		
   	    		
   	    	}
   	    	    
   		    

   	
   	        request.getRequestDispatcher("/Pedido.jsp").forward(request, response);
	 
	}
	
	
}
