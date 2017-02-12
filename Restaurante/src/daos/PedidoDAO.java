package daos;

import beans.DetallePedido;
import beans.Pedido;



public interface PedidoDAO {
	
	
	public abstract int registrarPedido(Pedido p);
	public abstract int registrarDetallePedido(DetallePedido dp);
	public int codigoPedido();
	public int codigoDetaPedido();
}
