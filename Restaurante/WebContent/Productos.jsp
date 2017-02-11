<%@taglib uri="misLibrerias" prefix="lp" %>
<%@page import="daos.ProductoDAO"%>
<%@page import="daos.CategoriaDAO"%>
<%@page import="daos.Factory"%>
<%@page import="beans.Producto"%>
<%@page import="beans.Categoria"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurante...</title>

<link rel="stylesheet" href="css/jquery-ui.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/estilo.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<!-- <body style="background-image:url('http://www.anawalls.com/images/other/restaurant-table-interior-modern-style.jpg');"> -->
<body>
<br><br>

  <form action="Productos" method="post">
     <input type="hidden" name="metodo" value="inserta">
     
      <% 
           Factory subFabrica = Factory.getTipo(Factory.TIPO_MYSQL);
           ProductoDAO dao = subFabrica.getProducto();
           int codigo = dao.codigoProducto();
        %>
           
      <input type="hidden" name="cod-prod" value="<%=codigo+1%>">   
      
    
                   
    <div class="container" style="margin-top:180px; ">
      <div class="row">
         <div class="col-md-3">
            <!-- MENU -->
         </div>
         <div class="col-md-9">
            <div class="row">
               <div class="col-md-8">
                  <h2>PRODUCTO</h2>
    
                  <div class="row">
                     <div class="col-md-9">
                        <div class="form-group">
                          <label class="control-label" for="nombres">Descripcion</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="desPro" 
                                 name="descripcion" 
                                 onkeypress="return soloLetras(event)" >
                        </div>
                     </div>
                  </div>
    
                  
                  <div class="row">
                     <div class="col-md-6">
                        <div class="form-group">
                          <label class="control-label" for="categoria">Categoria</label>
                           <lp:cboDinamico sql="SQL_IdCategoria" name="cod-cat" clase="form-control" id="categoria"/> 
                        </div>
                     </div>
                     
                   <div class="col-md-3">
                      <div class="form-group" style="margin-left:-30px; margin-top:20px;margin-right:0;">
                      
                     <a href="#" data-toggle="tooltip" title="Pulsa para Ingresar una nueva categoria" onclick="mostrar();">
                         <span class="glyphicon glyphicon-cog"></span>
                     </a>
                      </div>
                    </div> 
                    
                     <div class="col-md-3" style="margin-left:-150px;">
                        <div class="form-group">
                          <label class="control-label" for="precio">Precio</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="precio" 
                                 name="precio" 
                                 onkeypress="return soloNumeros(event)" >
                        </div>
                     </div>
                  </div>
    
             <!-- -
              =====================================================================================
              ============ Para mostrar el formulario del detalle =============================
              =====================================================================================
              -->
                <div id="div-detalle" style="display:none;">
                 <form>
                   <div class="row">
                     <div class="col-md-9">
                        <div class="form-group">
                          <label class="control-label" for="nombres">Cantidad</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="cantidad" 
                                 name="cantidad" 
                                 onkeypress="return soloLetras(event)" >
                        </div>
                     </div>                  
                     </div>
                 
                  
                  <div class="row">
                     <div class="col-md-12" style="margin-top:30px">
                        <input type="submit" class="btn btn-primary" value="Registrar" id="detalle_hidden">
                    </div>
                 </div>
                </form>  
              </div>    
                
              <!-- FIN -->  
                  
                  <div class="row">
                     <div class="col-md-12" style="margin-top:30px">
                        <input type="submit" class="btn btn-primary" value="Registrar" id="procesar">
                        <input type="reset" class="btn btn-primary" value="Limpiar">
                        <a  href="#" class="btn btn-info">Listar</a>
                        <button class="btn btn-Primary">Salir</button>
                        <a href="#" class="btn btn-warning " data-toggle="tooltip" title="Pulsa para agregar un detalle al producto" onclick="mostrarDetalle();">
                         <span class="glyphicon glyphicon-pencil"></span> Detalle
                        </a>
                    </div>
                 </div>    
  
    
                  </div>
             </div>
           </div>
        </div>
     </div>  
    <br>
 </form>
 
   <!-- -
   =====================================================================================
   ============ Para mostrar el formulario de la categoria =============================
   =====================================================================================
    -->
   
 <div id="div-categoria" style="display:none;">
  <form action="categoria" method="post">
  <input type="hidden" name="metodo" value="inserta">
       <br>
         <div class="container" style="margin-top:10px; ">
      <div class="row">
         <div class="col-md-3">
            <!-- MENU -->
         </div>
         <div class="col-md-9">
            <div class="row">
               <div class="col-md-8">
                  <h2>CATEGORIA</h2>
    
                  <div class="row">
                     <div class="col-md-12">
                        <div class="form-group">
                          <label class="control-label" for="nombres">Descripcion</label>
                          <input type="text" 
                                 class="form-control" 
                                 id="desCate" 
                                 name="categoria" 
                                 onkeypress="return soloLetras(event)" >
                        </div>
                     </div>
                  </div>
    
                 <div class="row">
                     <div class="col-md-12" style="margin-top:30px">
                        <input type="submit" class="btn btn-primary" value="Registrar" id="procesar">
                        <input type="reset" class="btn btn-primary" value="Limpiar">
                        <a  href="#" class="btn btn-info">Listar</a>
                        <button class="btn btn-Primary">Salir</button>
                  
                    </div>
                 </div>    
    
                  </div>
             </div>
           </div>
        </div>
     </div>  
   </form><br><br>
</div>  
   
   <!-- FIN   -->
   
 <script type="text/javascript">
       
   function mostrar() {
            div = document.getElementById('div-categoria');
            div.style.display = 'block';
        }

</script>

<script type="text/javascript">
       
   function mostrarDetalle() {
            div = document.getElementById('div-detalle');
            div.style.display = 'block';
        }

</script>

  <script>
         $(document).ready(function(){
          $('[data-toggle="tooltip"]').tooltip(); 
        });
</script>

</body>
</html>