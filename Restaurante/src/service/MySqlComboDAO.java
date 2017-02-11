package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.ComboDAO;
import util.MySqlDBConn;
import beans.ComboBean;

public class MySqlComboDAO implements ComboDAO {

	@Override
	public ArrayList<ComboBean> lista(String sql) throws Exception {
		
		ArrayList<ComboBean> lista = new ArrayList<ComboBean>();
		ComboBean bean = null;
		Connection conn = null;
		try {
			
			conn = new MySqlDBConn().getConnection();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new ComboBean();
				bean.setValue(rst.getString(1));
		    	bean.setDescripcion(rst.getString(2));
				lista.add(bean);
			}
			rst.close();
			pstm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return lista;
	}
	

}
