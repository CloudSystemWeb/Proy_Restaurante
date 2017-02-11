package beans;

public class Empleado {

	
	  private int IntCodigoEmpleado;         //=== Variable para el identificador del empleado(PRIMARIA).
	  
	  private String StrDNI_Empleado;       //=== Variable para mostrar el dni del empleado.
	  
	  private String StrNomEmpleado;       //=== Variable para mostrar el nombre del empleado.

	  private String StrApePatEmpleado;    //=== Variable para mostrar el apellido paterno del empleado.
	  
	  private String StrApeMatEmpleado;    //=== Variable para mostrar el apellido materno del empleado.
	  
	  private String StrGeneroEmpleado;    //=== Variable para mostrar el genero del empleado.
	  
	  private String StrDirEmpleado;       //=== Variable para mostrar la direccion del empleado.
	  
	  private String StrFecIngEmpleado;    //=== Variable para mostrar la fecha de ingreso del empleado.
	  
	  private String StrLoginEmpleado;    //=== Variable para mostrar la fecha de ingreso del empleado.
	  
	  private String StrPassngEmpleado;    //=== Variable para mostrar la fecha de ingreso del empleado.

	
	  
	/**  ===================================================================
	  *  ======================= METODOS GET =============================== 
	     ===================================================================   **/ 
	      
	  
	  public int getIntCodigoEmpleado() { return IntCodigoEmpleado; }

	  public String getStrNomEmpleado() { return StrNomEmpleado; }

	  public String getStrApePatEmpleado() { return StrApePatEmpleado; }
	  
	  public String getStrApeMatEmpleado() { return StrApeMatEmpleado;}
	  
	  public String getStrGeneroEmpleado() { return StrGeneroEmpleado; }
	  
	  public String getStrDirEmpleado() { return StrDirEmpleado; }
	  
	  public String getStrFecIngEmpleado() { return StrFecIngEmpleado; }
	  
	  public String getStrLoginEmpleado() { return StrLoginEmpleado; }

	  public String getStrPassngEmpleado() { return StrPassngEmpleado; }

      public String getStrDNI_Empleado() { return StrDNI_Empleado; }

	  public void setStrDNI_Empleado(String strDNI_Empleado) { StrDNI_Empleado = strDNI_Empleado; }
	  
	  
	  

	/**  ===================================================================
	  *  ======================= METODOS SET =============================== 
		 ===================================================================   **/ 
	  
	  public void setIntCodigoEmpleado(int IntCodigoEmpleado) { this.IntCodigoEmpleado = IntCodigoEmpleado; }

	  public void setStrNomEmpleado(String strNomEmpleado) { StrNomEmpleado = strNomEmpleado; }

	  public void setStrApePatEmpleado(String strApePatEmpleado) {StrApePatEmpleado = strApePatEmpleado;}

	  public void setStrApeMatEmpleado(String strApeMatEmpleado) { StrApeMatEmpleado = strApeMatEmpleado;}

	  public void setStrGeneroEmpleado(String strGeneroEmpleado) { StrGeneroEmpleado = strGeneroEmpleado;}
	  
	  public void setStrDirEmpleado(String strDirEmpleado) { StrDirEmpleado = strDirEmpleado; }

	  public void setStrFecIngEmpleado(String strFecIngEmpleado) { StrFecIngEmpleado = strFecIngEmpleado; }
	  
	  public void setStrLoginEmpleado(String strLoginEmpleado) { StrLoginEmpleado = strLoginEmpleado; }
	  
	  public void setStrPassngEmpleado(String strPassngEmpleado) { StrPassngEmpleado = strPassngEmpleado;	}
	  
	  
	  
	  
	  
	  
	  
	  
}
