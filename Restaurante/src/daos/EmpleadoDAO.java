package daos;

import java.util.List;

import beans.Empleado;

public interface EmpleadoDAO {

	
	/**
	 * ===============================================================================================
	 * ========= DECLARAMOS LOS METODOS NECESARIOS PARA EL MANTENIMIENTO DEL EMPLEADO ================
	 * ===============================================================================================
	                                                                                                  ***/
	
	public abstract int registraEmpleado(Empleado obj);
	
	public abstract List<Empleado> listaEmpleado ();
	
    public abstract int DarBaja(int id);
	
	public abstract int modificaDatos(Empleado obj);
	
	public abstract Empleado buscaEmpleado(int id);
	
}
