<%@page import="beans.*" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante...</title>

<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilo.css">


</head>
<body>
     
   <div class="container" style="margin-top:10px; ">
      <div class="row">
         <div class="col-md-3">
            <!-- MENU -->
         </div>
     
     
         <div class="col-md-9">
            <div class="row">
               <div class="col-md-8">
               <br><br>
                  <h2 align="center">EMPLEADO</h2>
                
                  <form action="empleado" method="post">
                      <input type="hidden" name="metodo" value="inserta">
                      
                      <br> 
              <div class="row">     
                <div class="col-md-10" >    
                  <div class="alert alert-success">
                     <%
		                String mensaje =(String)request.getAttribute("MENSAJE");
                    if(mensaje!=null){
                    	 %>
			
			            <%=mensaje %> 
			 
		              <% }%>
		          </div> 
               </div>       
             </div>  <br> 
              
                  
                  <div class="row">
                     <div class="col-md-10">
                        <div class="form-group">
                          <label class="control-label" for="nombre">Nombres</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="nombre" 
                                 name="nombre" 
                                 onkeypress="return soloLetras(event)" >
                        </div>
                     </div>
                  </div>
    
                  
                  <div class="row">
                  
                     <div class="col-md-5">
                        <div class="form-group">
                          <label class="control-label" for="precio">Ap.Paterno</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="paterno" 
                                 name="apePaterno" 
                                 onkeypress="return soloNumeros(event)" >
                        </div>
                     </div>
               
                    
                     <div class="col-md-5">
                        <div class="form-group">
                          <label class="control-label" for="precio">Ape.Materno</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="materno" 
                                 name="apeMaterno" 
                                 onkeypress="return soloNumeros(event)" >
                        </div>
                     </div>
                  </div>
             
                   <div class="row">
                     <div class="col-md-5">
                        <div class="form-group">
                          <label class="control-label" for="genero">Genero</label>
                          <select class="form-control" id="genreo" name="genero">
                              <option value="-1">[Seleccione]</option>
                              <option>Masculino</option>
                              <option>Femenino</option>
                          </select>
                        </div>
                     </div>
                     
                      <div class="col-md-5">
                        <div class="form-group">
                          <label class="control-label" for="nombres">DNI</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="dni" 
                                 name="dni" 
                                 onkeypress="return soloLetras(event)" >
                        </div>
                     </div>                        
                   </div>
                   
                   
                  <div class="row">
                     <div class="col-md-10">
                        <div class="form-group">
                          <label class="control-label" for="genero">Direccion</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="direccion" 
                                 name="direccion" 
                                 onkeypress="return soloLetras(event)" >
                        </div>
                     </div>   
                   </div>  
           
     
              <!-- FIN -->  
                  
                  <div class="row">
                     <div class="col-md-12" style="margin-top:30px">
                        <input type="submit" class="btn btn-primary" value="Registrar" id="procesar" onclick="mostrarMensaje();">
                        <input type="reset" class="btn btn-primary" value="Limpiar">
                        <a  href="empleado?metodo=lista" class="btn btn-info" id="listar">Listar</a>
                        <button class="btn btn-default">Salir</button>
                    </div>
                 </div> <br><br>   
  
                <%
	          
             List<Empleado>listado = (List<Empleado>)request.getAttribute("DATA"); 
        %>	
   <div id="div-table" style="display:block;">    
   <table class="table table-striped">
    <tr style="background: 	#428bca;color:white;">
         <td align="center"> Nombres Completos</td>
         <td> Genero </td>
         <td> DNI</td>
         <td align="center"> Direccion</td>
         <td align="center"> Update</td>
         <td align="center"> Delete</td>
     </tr>
        <%  
	         if(listado!= null){
		         for(Empleado emp: listado){
        %>
	    <tr>
	       
		    <td align="left"><%= emp.getStrNomEmpleado() + " " +  emp.getStrApePatEmpleado() + " " + emp.getStrApeMatEmpleado()%></td>
		    <td align="left"><%= emp.getStrGeneroEmpleado()%></td>
		    <td align="center"><%= emp.getStrDNI_Empleado() %></td>
		    <td align="center"><%= emp.getStrDirEmpleado() %></td>
		    
	
		<td align="center">
			 <a  href="empleado?metodo=busca&id=<%= emp.getIntCodigoEmpleado()%>">
			   <button type="button" class="btn btn-info btn-sm">
                     <span class="glyphicon glyphicon-search"></span> Buscar 
               </button>
            </a>				
		</td>
		
		<td align="center">
			 <a  href="empleado?metodo=elimina&id=<%= emp.getIntCodigoEmpleado()%>">
			   <button type="button" class="btn btn-info btn-sm">
                     <span class="glyphicon glyphicon-trash"></span> Dar de Baja 
               </button>
            </a>				
		</td>
		
	</tr>		
<%}} %>
</table>
</div>   
     
 
                  </form>
               </div>
             </div>
           </div>
        </div>
     </div>  
    <br>
    
   
 
</body>
</html>