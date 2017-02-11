package util;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ComboBean;
import daos.ComboDAO;
import daos.Factory;


@SuppressWarnings("serial")
public class TagComboDinamico extends TagSupport{
	
	private String name, sql , clase , id;
	
	public int doStartTag() throws JspException {
		//Permite leer archivos properties
		ResourceBundle rb = ResourceBundle.getBundle("tags");
		
		JspWriter out = pageContext.getOut();

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ComboDAO  dao = bd.getCombo();
		
		try {
			out.print("<select class='"+ clase +"' name='" + name + "' id='" + id + "'>");
		    out.print("<option value='-1'>[Todos]</option>");
			
			List<ComboBean>  lista = dao.lista(rb.getString(sql));
				for (ComboBean obj : lista) {
					out.print("<option value='" +obj.getValue()+ "'>");
					out.print(obj.getDescripcion());
					out.print("</option>");
				}
			out.print("</select>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}




	public String getname() {
		return name;
	}




	public void setname(String name) {
		this.name = name;
	}




	public String getSql() {
		return sql;
	}




	public void setSql(String sql) {
		this.sql = sql;
	}




	public String getClase() {
		return clase;
	}




	public void setClase(String clase) {
		this.clase = clase;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}

	 
	


}
