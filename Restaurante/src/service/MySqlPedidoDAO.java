package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MySqlDBConn;
import beans.DetallePedido;
import beans.Pedido;
import beans.Producto;
import daos.PedidoDAO;

public class MySqlPedidoDAO implements PedidoDAO {

	@Override
	public int registrarPedido(Pedido obj) {
		
			int salida = -1;
			Connection conn= null;
			
			PreparedStatement pstm = null;
			 
			try {
				
				 conn = new MySqlDBConn().getConnection();
				 String sql ="insert into pedido values(null,curdate(),?,?)";
				 pstm = conn.prepareStatement(sql);
				 pstm.setString(1, "pendiente");
				 pstm.setString(2, obj.getStrMesa());
				
				 salida = pstm.executeUpdate();
		
			    } catch (Exception e) {
			    	e.printStackTrace();
			    } 
			    finally{
		          try {
					   if(pstm!= null) pstm.close();
					   if(conn!= null) conn.close();
				  }catch (Exception e2) {   
				 }
			}
			
			    return salida;
	}

	@Override
	public int registrarDetallePedido(DetallePedido dp) {
		
		
		int salida = -1;
		Connection conn= null;
		
		PreparedStatement pstm = null;
		 
		try {
			
			 conn = new MySqlDBConn().getConnection();
			 String sql ="insert into detalle_pedido values(null,?,?,?,?,?)";
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, dp.getIntCodigoPedido());
			 pstm.setInt(2, dp.getIntCodigoProducto());
			 pstm.setInt(3, dp.getIntCodigoEmpleado());
			 pstm.setString(4, dp.getStrCantidadPedido());
			 pstm.setString(5, dp.getStrPrecioTotal());
			
			 salida = pstm.executeUpdate();
	
		    } catch (Exception e) {
		    	e.printStackTrace();
		    } 
		    finally{
	          try {
				   if(pstm!= null) pstm.close();
				   if(conn!= null) conn.close();
			  }catch (Exception e2) {   
			 }
		}
		
		    return salida;
		
	}

	@Override
	public int codigoPedido() {
		
		Connection con= null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int codigo=0;
		
		try {
			con= new MySqlDBConn().getConnection();
			String sql="Select Max(idpedido)  from pedido ";
			pst=con.prepareStatement(sql);
			rs = pst.executeQuery();
			Pedido bean = null;
			rs.next();
				bean = new Pedido();
				bean.setIntCodigoPedido(rs.getInt(1));
				
				 codigo = bean.getIntCodigoPedido();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (Exception e2) {}
		}
		
		return codigo;
	}

}
