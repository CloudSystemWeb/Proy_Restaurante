package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.MySqlDBConn;
import beans.DetalleProducto;
import beans.Producto;
import daos.ProductoDAO;


public class MySqlProductoDAO implements ProductoDAO {

	@Override
	public int registra(Producto obj) {
		
		int salida = -1;
		Connection conn= null;
		
		PreparedStatement pstm = null;
		
		try {
			 conn = new MySqlDBConn().getConnection();
			 String sql ="insert into producto values(null,?,?,?)";
			 pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, obj.getIntCodigoCategoria());
			 pstm.setString(2, obj.getStrdescrProducto());
			 pstm.setDouble(3, obj.getDblPrecio());
			
			 salida = pstm.executeUpdate();
	
			
		    } catch (Exception e) { e.printStackTrace();} 
		
		    finally{
		    	
			      try {
				       if(pstm!= null) pstm.close();
				       if(conn!= null) conn.close();
			          } 
			      
			      catch (Exception e2) { }
		}
		
		System.out.print("ingresado");
		return salida;
		
	}

	@Override
	public List<Producto> listaProductos() {
		
		List<Producto> data = new ArrayList<Producto>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Producto obj = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from producto";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				obj = new Producto();
				obj.setIntCodigoProducto(rs.getInt("codigo"));
				obj.setStrdescrProducto(rs.getString("nombre"));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return data;
	}

	@Override
	public Producto buscaProductos(int idProductos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminaProductos(int idProductos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificaProductos(Producto obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Producto> consulta(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int codigoProducto() {
		
		Connection con= null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int codigo=0;
		
		try {
			con= new MySqlDBConn().getConnection();
			String sql="Select Max(idproducto)  from producto ";
			pst=con.prepareStatement(sql);
			rs = pst.executeQuery();
			Producto bean = null;
			rs.next();
				bean = new Producto();
				bean.setIntCodigoProducto(rs.getInt(1));
				
				 codigo = bean.getIntCodigoProducto();
	
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

	@Override
	public int insertaDetalleProducto(DetalleProducto obj) {
		
        int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = new MySqlDBConn().getConnection();
			String sql ="insert into detalle_producto values(null,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getIntCodigoProducto());
			pstm.setString(2, obj.getStrSTKProducto());
			
			salida = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close(
						);
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		
		return salida;
	}

	@Override
	public ArrayList<String> listar(String productos) {
	
		
			ArrayList<String> list = new ArrayList<String>();
			Connection conn = new MySqlDBConn().getConnection();    
			PreparedStatement ps = null;
			String data;
			try {
				ps = conn.prepareStatement("Select * from producto where nombre like ?");
				ps.setString(1, productos + "%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					data = rs.getString("nombre");
					list.add(data);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return list;
		}

	@Override
	public int traeStock(DetalleProducto bean) throws Exception {
		
		int salida = -1;
		Connection conn= null;
		
		PreparedStatement pstm = null;
		
		try {
			 conn = new MySqlDBConn().getConnection();
			 String sql ="Select dp.stock from detalle_producto dp inner join producto p On dp.idproducto=p.idproducto where dp.idproducto=?";
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, bean.getStrSTKProducto());
		
			 salida = pstm.executeUpdate();
	
			
		    } catch (Exception e) { e.printStackTrace();} 
		
		    finally{
		    	
			      try {
				       if(pstm!= null) pstm.close();
				       if(conn!= null) conn.close();
			          } 
			      
			      catch (Exception e2) { }
		}
		
		System.out.print("ingresado");
		return salida;
		
		
		
	}

         
	
}
