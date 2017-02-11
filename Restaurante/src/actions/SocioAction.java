package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Empleado;
import beans.Socio;
import daos.EmpleadoDAO;
import daos.Factory;
import daos.SocioDAO;

@WebServlet("/socio")
public class SocioAction extends HttpServlet {
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
		
		String nom=request.getParameter("nombre");
		String apPat=request.getParameter("apePaterno");
		String apMat=request.getParameter("apeMaterno");
		String ruc=request.getParameter("genero");
		String dni=request.getParameter("dni");
		String dir=request.getParameter("direccion");
		String emp=request.getParameter("empresa");
	
		try {
              
			  Socio soc= new Socio();
		      soc.setStrNombreSocio(nom);
		      soc.setStrApePaterno(apPat);
		      soc.setStrApeMaterno(apMat);
		      soc.setStrRucSocio(ruc);
		      soc.setStrDni_Socio(dni);
		      soc.setStrDireccionSocio(dir);
		      soc.setStrEmpresaSocio(emp);
		      
		    
	    Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
	    SocioDAO dao= subFabrica.getSocio();
		dao.registrar(soc);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		request.getRequestDispatcher("/Socios.jsp").forward(request, response); 

	}
	
	protected void modificar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
	}
	
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
	}
	
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
	}
	
	
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
	}
	
	
	
	
	
	

}
