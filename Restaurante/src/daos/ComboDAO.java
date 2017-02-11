package daos;

import java.util.ArrayList;

import beans.ComboBean;


public interface ComboDAO {

	public ArrayList<ComboBean> lista (String sql) throws Exception;
	
}
