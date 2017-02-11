package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.MySqlDBConn;
import beans.Empleado;
import daos.EmpleadoDAO;

public class MySqlEmpleadoDAO implements EmpleadoDAO{

	@Override
	public int registraEmpleado(Empleado obj) {
		int salida = -1;
		Connection conn= null;
		
		PreparedStatement pstm = null;
		Random rnd = new Random();
		 
		try {
			
			 conn = new MySqlDBConn().getConnection();
			 String sql ="insert into empleado values(null,?,?,?,?,?,?,?,?)";
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, obj.getStrNomEmpleado());
			 pstm.setString(2, obj.getStrApePatEmpleado());
			 pstm.setString(3, obj.getStrApeMatEmpleado());
			 pstm.setString(4, obj.getStrGeneroEmpleado());
			 pstm.setString(5, obj.getStrDNI_Empleado());
			 pstm.setString(6, obj.getStrDirEmpleado());
			 pstm.setString(7, obj.getStrApePatEmpleado().substring(0, 3));
			 pstm.setString(8, obj.getStrApeMatEmpleado().substring(0, 3) + rnd.nextInt(900)+100);
			 
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
	public List<Empleado> listaEmpleado() {
		
		List<Empleado> data = new ArrayList<Empleado>();
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Empleado obj = null;
		try {
			
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from empleado";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				obj = new Empleado();
				obj.setIntCodigoEmpleado(rs.getInt("idEmpleado"));
				obj.setStrNomEmpleado(rs.getString("nombre"));
				obj.setStrApePatEmpleado(rs.getString("apePaterno"));
				obj.setStrApeMatEmpleado(rs.getString("apeMaterno"));
				obj.setStrGeneroEmpleado(rs.getString("genero"));
				obj.setStrDNI_Empleado(rs.getString("dni"));
				obj.setStrDirEmpleado(rs.getString("direccion"));
				obj.setStrLoginEmpleado(rs.getString("login"));
				obj.setStrPassngEmpleado(rs.getString("password"));
				
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
	public int DarBaja(int id) {
		
        int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = new MySqlDBConn().getConnection();;
			String sql ="delete from empleado where idEmpleado=?";
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
	public int modificaDatos(Empleado obj) {
		
		int salida = -1;
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = new MySqlDBConn().getConnection();
			String sql ="update empleado set nombre=?, apePaterno=?, apeMaterno=?, genero=?, dni=?, direccion=? where idEmpleado=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getStrNomEmpleado());
			pstm.setString(2, obj.getStrApePatEmpleado());
			pstm.setString(3, obj.getStrApeMatEmpleado());
			pstm.setString(4, obj.getStrGeneroEmpleado());
			pstm.setString(5, obj.getStrDNI_Empleado());
			pstm.setString(6, obj.getStrDirEmpleado());
			pstm.setInt(7, obj.getIntCodigoEmpleado());
			
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
	public Empleado buscaEmpleado(int id) {
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Empleado obj = null;
		try {
			
			conn = new MySqlDBConn().getConnection();
			String sql ="select * from empleado where idEmpleado=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				obj = new Empleado();
				obj.setIntCodigoEmpleado(rs.getInt("idEmpleado"));
				obj.setStrNomEmpleado(rs.getString("nombre"));
				obj.setStrApePatEmpleado(rs.getString("apePaterno"));
				obj.setStrApeMatEmpleado(rs.getString("apeMaterno"));
				obj.setStrGeneroEmpleado(rs.getString("genero"));
				obj.setStrDNI_Empleado(rs.getString("dni"));
				obj.setStrDirEmpleado(rs.getString("direccion"));
				
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

}
