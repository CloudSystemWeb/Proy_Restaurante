package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Empleado;
import daos.EmpleadoDAO;
import daos.Factory;

/**== La etiqueta @WebServlet nos sirve para referenciar nuestro action del formulario jsp ===**/
@WebServlet("/empleado")
public class EmpleadoAction extends HttpServlet {
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
		
		
		int salida=-1;
		
		String nom=request.getParameter("nombre");
		String apPat=request.getParameter("apePaterno");
		String apMat=request.getParameter("apeMaterno");
		String gen=request.getParameter("genero");
		String dni=request.getParameter("dni");
		String dir=request.getParameter("direccion");
	
		try {
              
			  Empleado e= new Empleado();
		      e.setStrNomEmpleado(nom);
		      e.setStrApePatEmpleado(apMat);
		      e.setStrApeMatEmpleado(apPat);
		      e.setStrGeneroEmpleado(gen);
		      e.setStrDNI_Empleado(dni);
		      e.setStrDirEmpleado(dir);
		    
	    Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
	    EmpleadoDAO dao= subFabrica.getEmpleado();
		dao.registraEmpleado(e);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		String mensaje;
		
		if(salida!=-1){
			
			mensaje="Se registro correctamente";
			
		}else{
			
			mensaje="No se registro.verifique los datos a enviar";
		}
		
		request.setAttribute("MENSAJE",mensaje);
		request.getRequestDispatcher("/Empleados.jsp").forward(request, response); 
	      
	
	}
	
	protected void modificar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String cod=request.getParameter("id");
		String nom=request.getParameter("nombre");
		String apPat=request.getParameter("apePaterno");
		String apMat=request.getParameter("apeMaterno");
		String gen=request.getParameter("genero");
		String dni=request.getParameter("dni");
		String dir=request.getParameter("direccion");
		

			  Empleado e= new Empleado();
			  e.setIntCodigoEmpleado(Integer.parseInt(cod));
		      e.setStrNomEmpleado(nom);
		      e.setStrApePatEmpleado(apPat);
		      e.setStrApeMatEmpleado(apMat);
		      e.setStrGeneroEmpleado(gen);
		      e.setStrDNI_Empleado(dni);
		      e.setStrDirEmpleado(dir);
	
		      
	    Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
	    
	    EmpleadoDAO dao= subFabrica.getEmpleado();
	    
	    dao.modificaDatos(e);
		
		listar(request, response);
		
		
	
	}
	
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	   
        Factory subFabrica=Factory.getTipo(Factory.TIPO_MYSQL);
		
		EmpleadoDAO dao= subFabrica.getEmpleado();
			
		List<Empleado> lista = dao.listaEmpleado();
		
		request.setAttribute("DATA", lista);
		
		request.getRequestDispatcher("/Empleados.jsp").forward(request, response);
	
	}
	
	protected void buscar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
        String cod=request.getParameter("id");
		
        Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
        
        EmpleadoDAO dao= subFabrica.getEmpleado();
		
        Empleado e = dao.buscaEmpleado(Integer.parseInt(cod));
		
		request.setAttribute("empleado", e);
		
		request.getRequestDispatcher("/ActEmpleado.jsp").forward(request, response);
	
	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	   
        String id =request.getParameter("id");
		
        Factory  subFabrica= Factory.getTipo(Factory.TIPO_MYSQL);
        
        EmpleadoDAO dao= subFabrica.getEmpleado();
        
		dao.DarBaja(Integer.parseInt(id));
		
		listar(request,response);
		
	}
	

}
