package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.MySqlDBConn;
import beans.Socio;
import daos.SocioDAO;

public class MySqlSocioDAO implements SocioDAO {

	@Override
	public int registrar(Socio s) {
		
		int salida = -1;
		Connection conn= null;
		
		PreparedStatement pstm = null;
		
		try {
			 conn = new MySqlDBConn().getConnection();
			 String sql ="insert into socios values(null,?,?,?,?,?,?,?)";
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, s.getStrNombreSocio());
			 pstm.setString(2, s.getStrApePaterno());
			 pstm.setString(3, s.getStrApeMaterno());
			 pstm.setString(4, s.getStrDni_Socio());
			 pstm.setString(5, s.getStrRucSocio());
			 pstm.setString(6, s.getStrEmpresaSocio());
			 pstm.setString(7, s.getStrDireccionSocio());
			 
			 salida = pstm.executeUpdate();
	
			
		    } catch (Exception e) { e.printStackTrace();} 
		
		    finally{
		    	
			      try {
				       if(pstm!= null) pstm.close();
				       if(conn!= null) conn.close();
			          } 
			      
			      catch (Exception e2) { }
		}
		
		return salida;
		
		
		
		
	}

	@Override
	public List<Socio> listar() {
		
		List<Socio> data = new ArrayList<Socio>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Socio obj = null;
		try {
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from socios";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				obj = new Socio();
				obj.setIntCodigSocio(rs.getInt("idSocios"));
				obj.setStrNombreSocio(rs.getString("nombres"));
				obj.setStrApePaterno(rs.getString("apPaterno"));
				obj.setStrApeMaterno(rs.getString("apMaterno"));
				obj.setStrDni_Socio(rs.getString("dni"));
				obj.setStrRucSocio(rs.getString("ruc"));
				obj.setStrEmpresaSocio(rs.getString("empresa"));
				obj.setStrDireccionSocio(rs.getString("direccion"));
				
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
	public Socio buscar(int id) {
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Socio obj = null;
		
		
		try {
			
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from socios where idSocios=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				obj = new Socio();
				obj.setIntCodigSocio(rs.getInt("idSocios"));
				obj.setStrNombreSocio(rs.getString("nombres"));
				obj.setStrApePaterno(rs.getString("apPaterno"));
				obj.setStrApeMaterno(rs.getString("apMaterno"));
				obj.setStrDni_Socio(rs.getString("dni"));
				obj.setStrRucSocio(rs.getString("ruc"));
				obj.setStrEmpresaSocio(rs.getString("empresa"));
				obj.setStrDireccionSocio(rs.getString("direccion"));
				
				
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
		
		return obj;
	}

	@Override
	public int eliminar(int id) {
		
		 int salida = -1;
			
			Connection conn= null;
			PreparedStatement pstm = null;
			
			try {
				
				conn = new MySqlDBConn().getConnection();;
				String sql ="delete from socios where idSocios=?";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				
				salida = pstm.executeUpdate();
				
			} catch (Exception e) { e.printStackTrace(); } 
			
			  finally{
				try {
				     if(pstm!= null) pstm.close();
					 if(conn!= null) conn.close();
			     }catch (Exception e2) { }
			   }
			
			   return salida;
		
		
		
	}

	@Override
	public int modificar(Socio obj) {
		
		int salida = -1;
		Connection conn= null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = new MySqlDBConn().getConnection();
			String sql ="update socios set nombres=?, apPaterno=?, apMaterno=?, dni=?, ruc=? , empresa=? , direccion=? where idSocios=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getStrNombreSocio());
			pstm.setString(2, obj.getStrApePaterno());
			pstm.setString(3, obj.getStrApeMaterno());
			pstm.setString(4, obj.getStrDni_Socio());
			pstm.setString(5, obj.getStrRucSocio());
			pstm.setString(6, obj.getStrEmpresaSocio());
			pstm.setString(7, obj.getStrDireccionSocio());
			pstm.setInt(8, obj.getIntCodigSocio());
			
			salida = pstm.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
	    } finally{
			try {
				 if(pstm!= null) pstm.close();
				 if(conn!= null) conn.close();
			}catch (Exception e2) { }
		   }
		
		   return salida;
	}
	
	

	@Override
	public List<Socio> consultar(String dni, String ruc) {
		// TODO Auto-generated method stub
		return null;
	}

}
