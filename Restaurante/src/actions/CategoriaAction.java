package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriaDAO;
import daos.Factory;
import beans.Categoria;


@WebServlet("/categoria")
public class CategoriaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		 String metodo = request.getParameter("metodo");
			
			if(metodo.equals("inserta"))		registrar(request, response);
			else if(metodo.equals("actualiza"))	modificar(request, response);
			else if(metodo.equals("elimina"))	eliminar(request, response);
			else if(metodo.equals("lista"))		listar(request, response);
			else if(metodo.equals("busca"))		buscar(request, response);	
		
	}
	
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nom=request.getParameter("categoria");
		try {
              Categoria c= new Categoria();
		      c.setStrDesCategoria(nom);
	    
	   
	    Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
	   CategoriaDAO dao= subFabrica.getCategoria();
		dao.registar(c);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/Productos.jsp").forward(request, response); 
	      
	}

	
	protected void modificar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		
		
	}

	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		
	}

	
	protected void listar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException { 
		
		
	}

	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
	}

}
