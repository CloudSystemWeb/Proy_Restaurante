package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.MySqlDBConn;
import beans.Categoria;
import daos.CategoriaDAO;

public class MySqlCategoriaDAO implements CategoriaDAO {

	@Override
	public int registar(Categoria c) {
	
		int salida = -1;
		Connection conn= null;
		
		PreparedStatement pstm = null;
		
		try {
			 conn = new MySqlDBConn().getConnection();
			 String sql ="insert into categoria values(null,?)";
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, c.getStrDesCategoria());
			
			 
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
