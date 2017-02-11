<%@page import="beans.*" %>
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
                
                <%
                   Empleado eps = (Empleado) request.getAttribute("empleado");
                %>
                  <form action="empleado" method="post">
                     <input type="hidden" name="metodo" value="actualiza">
	                  <input type="hidden" name="id" value="<%= eps.getIntCodigoEmpleado()%>">
                      
                  <div class="row">
                     <div class="col-md-10">
                        <div class="form-group">
                          <label class="control-label" for="nombre">Nombres</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="nombre" 
                                 name="nombre" 
                                 value="<%=eps.getStrNomEmpleado()%>"
                                 disabled="disabled"
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
                                 value="<%=eps.getStrApePatEmpleado() %>"
                                 disabled="disabled"
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
                                 disabled="disabled"
                                 value="<%=eps.getStrApeMatEmpleado()%>"
                                 onkeypress="return soloNumeros(event)" >
                        </div>
                     </div>
                  </div>
             
                   <div class="row">
                     <div class="col-md-5">
                        <div class="form-group">
                          <label class="control-label" for="genero">Genero</label>
                         <input type="text" 
                                 class="form-control" 
                                 id="genero" 
                                 name="genero" 
                                 value="<%=eps.getStrGeneroEmpleado()%>"
                                 disabled="disabled"
                                 onkeypress="return soloNumeros(event)" >
                        </div>
                     </div>
                     
                      <div class="col-md-5">
                        <div class="form-group">
                          <label class="control-label" for="nombres">DNI</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="dni" 
                                 name="dni"
                                 disabled="disabled"
                                 value="<%=eps.getStrDNI_Empleado()%>" 
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
                                 value="<%=eps.getStrDirEmpleado()%>"
                                 onkeypress="return soloLetras(event)" >
                        </div>
                     </div>   
                   </div>  
           
     
              <!-- FIN -->  
                  
                 <div class="row">
                     <div class="col-md-12" style="margin-top:30px">
                        <input type="submit" class="btn btn-primary" value="Actualizar" id="procesar">
                        <button class="btn btn-default">Salir</button>
                    </div>
                 </div> <br><br>  
 
                  </form>
                  
                   
                  
               </div>
             </div>
           </div>
        </div>
     </div>  
    <br>
    
  
</body>
</html>