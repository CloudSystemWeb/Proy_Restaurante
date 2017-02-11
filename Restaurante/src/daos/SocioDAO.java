package daos;

import java.util.List;

import beans.Socio;


public interface SocioDAO {
	
	
    public abstract int registrar(Socio p);
	
    public abstract List<Socio> listar();
    
	public abstract Socio buscar(int id);
	
	public abstract int eliminar(int id);
	
	public abstract int modificar(Socio obj);
	
	public List<Socio> consultar(String dni, String ruc);

}
