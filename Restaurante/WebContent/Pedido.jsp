<!DOCTYPE html>
<%@taglib uri="misLibrerias" prefix="lp" %>
<%@page import="daos.ProductoDAO"%>
<%@page import="daos.PedidoDAO"%>
<%@page import="daos.Factory"%>
<%@page import="beans.Producto"%>
<%@page import="beans.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<html lang="es">
<head>
   <meta charset="UTF-8">
   <title>GESTION DE PEDIDOS</title>
   <link rel="stylesheet" href="css/jquery-ui.min.css"> 
   <link rel="stylesheet" href="css/bootstrap.min.css">
   <link rel="stylesheet" href="css/estilo.css">
   
   <script src="autocompleter.js"></script>
</head>
<body >
   <div class="contenedor">
      <div class="row">
         <div class="col-md-6" style="text-align:left">
         
            <br><br>
          <b style="font-size:20px; ">  <p>Hoy es 
               <%
               Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
            sdf.format(d);
               %>
               <%=sdf.format(d) %>
               </p></b>
         </div>
         <div class="col-md-6" style="text-align:right">
         <br>

         </div>
      </div>
      <div class="row">
         <div class="col-md-12">
            <h1 align="center">GESTION DE PEDIDOS</h1>
         </div>
      </div><br><br>
      <div class="row">
         <div class="col-md-12">
            <form action="" method="post">
               <div id="tabla-variada">
                  <table class="table table-striped">
                     
                     
                           
                        
                           <% 
                              Factory subFabrica = Factory.getTipo(Factory.TIPO_MYSQL);
                               ProductoDAO dao = subFabrica.getProducto();
                                 int codigo = dao.codigoProducto();
                             %>
                          
                       
                        <%
                             Date date = new Date();
                             SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
                             SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                             sdf1.format(date);
                             sdf2.format(date);
                         %>
                         
                      
                     
                         <%
                                  Date dt = new Date();
                                  Calendar c = new GregorianCalendar(); 
                                  c.setTime(dt);

                                  String hora, minuto, segundo;
                                  
                                  hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                                  minuto = Integer.toString(c.get(Calendar.MINUTE));
                                  segundo = Integer.toString(c.get(Calendar.SECOND));
                         %>
                        
                    <tr>
                       
                       
                     <tr>
                            <% 
                                Factory subFabrica1 = Factory.getTipo(Factory.TIPO_MYSQL);
                                PedidoDAO dao1 = subFabrica1.getPedido();
                                int codigo3 = dao1.codigoPedido();
                             %>
                      </tr>
           
                      <tr>
                        
                         <td>
                           <p></p>
                           <strong>Nº Pedido</strong>
                         
                            <input id="pedido"  
                                   name="pedido" 
                                   class="form-control"
                                   readonly="readonly"> 
                         
                           </td>
                           
                           
                          <td>
                          <p id="mesa-mensaje" style="color:#ab001d"></p>
                          <strong>Nº Mesa</strong>
                        
                           <input  id="mesa"  
                                   name="mesa" 
                                   class="form-control"
                                   onblur="patronNumero(this.id, this.value)"> 
                        </td>
                       </tr>
                     
                      
                         
                        <td><strong>Fecha</strong>
                         
                        
                           <input  id="fecha"  
                                   name="fecha" 
                                   class="form-control"
                                   value="<%=sdf2.format(date) %>"
                                   readonly="readonly"> 
                                   
                            <input type="hidden" name="fecha" value="<%=sdf1.format(date) %>">
                        </td>
                     
                        <td><strong>Hora</strong>
                         
                        
                           <input  id="hora"  
                                   name="hora" 
                                   class="form-control"
                                   value="<%=hora+":"+minuto+":"+segundo%>"
                                   readonly="readonly"> 
                                   
                            <input type="hidden" name="fecha" value="<%=sdf1.format(d) %>">
                        </td>
                     </tr>
                     
                  </table>
               </div>
               
          
           <!--======================================================================== 
               ====================== FORMULARIO DE LA FACTURA ======================== 
               ======================================================================== -->
               
               <div id="div-factura"  style="display:block;">
                   <table class="table table-striped">
                   
                       
                     <tr>
                        <td>&nbsp;</td>
                        <td>
                           <table>
                              <tr>                                
                                 <td>&nbsp;&nbsp;</td>
                                 <td>
                                    <p id="producto-mensaje" style="color:#ab001d"></p>
                                    <label for="producto">Producto</label>
                                     <lp:cboDinamico name="producto" sql="SQL_IdProducto" clase="form-control" id="producto1"/>
                                 </td>
                                 
                                 <td>&nbsp;&nbsp;</td>
                                 <td>
                                    <p id="cantidad1-mensaje" style="color:#ab001d"></p>
                                    <label for="cantidad1">Cantidad</label>
                                     <input  id="cantidad1"  
                                             name="cantidad" 
                                             class="form-control"
                                             onblur="patronNumero(this.id, this.value)"> 

                                 </td>
                                 
                                  <td>&nbsp;&nbsp;</td>
                                   <td>
                                    <p id="precio1-mensaje" style="color:#ab001d"></p>
                                    <label for="precio1">Precio</label>
                                    <input  id="precio1"  
                                            name="precio" 
                                            class="form-control"
                                            onblur="patronNumero(this.id, this.value)"> 
                                 </td>
                                 
                                 
                              </tr>
                           </table>
                        </td>
                     </tr>
                     
                      
                     
                     <tr>
                        <td colspan="2" style="text-align:right">
                           <div style="color:#ab001d" id="agregar-pedido-boton"></div>
                           <input type="button" value="Agregar" class="btn btn-primary" id="enviar_pedido">
                        </td>
                     </tr>
                     <tr>
                        <td>&nbsp;</td>
                        <td>
                           <table class="table" id="tabla-pedido">
                              <tr style="background:#428bca;color:white">
                                <td>ITEM</td>
                                 <td>DESCRIPCION</td>
                                 <td>CANTIDAD</td>
                                 <td>P.UNITARIO</td>
                                 <td>IMPORTE</td>
                                 <td>ACCION</td>
                              </tr>
                           </table>
                           <div class="footer" style="margin-left:520px; margin-bottom:250px; display:inline;">
                             <label >Total:</label>
                             <input type="text" id="total">
                           </div>
                           
                           <input type="hidden" id="arreglo_hidden" name="arreglo_hidden">
                           
                        </td>
                     </tr>
                     </div>
                  </table>
               </div>
               
               
               <div id="boton-generar" style="display:block;">
                  <div style="text-align:right">
                     <input type="submit" class="btn btn-primary" value="Generar Pedido">
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div> <br><br>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script>


   $(document).on("ready", function(){
	   
	   
	   
	   /**======= DECLARACION DE VARIABLES GLOBALES =========**/
	  
	    
           var item_pedido = 0;
	       var c=0;
           arreglo_pedido = [];
     
      /*** ======================================================================== 
           ====================== CODIGO PARA ENVIAR EL PEDIDO ====================== 
           ======================================================================== ****/
      
           
          $("#enviar_pedido").on("click", function(){
    	  
           item_pedido++;
           c++;
           var combo = document.getElementById("producto1");
           var selected = combo.options[combo.selectedIndex].text;
           var cantidad = $("#cantidad1").val();
           var precio = $("#precio1").val();
           var importe = (precio * cantidad);
          

           arreglo_pedido.push([item_pedido, selected, cantidad, precio , importe ,c +";"]);
           $("#tabla-pedido").append("<tr><td>"+ item_pedido +"</td><td>"+ selected +"</td><td>"+ cantidad+"</td><td>"+ precio+"</td><td>"+ importe +"</td><td><a class='btn btn-info'><span class='glyphicon glyphicon-trash'></span> Eliminar</a>  </td>");
           $("#arreglo_hidden").val(arreglo_pedido);
           $("#selected").val("");
           $("#cantidad1").val("");
           $("#precio1").val("");
           $("#cantidad1").focus();
      });
      
   
 /*** ========================================================================
      =============  CODIGO PARA VIZUALIZAR EL FORMULARIO ====================
      ======================================================================== ****/
      
      $("#factura").on("click", function(){
         $("#boton-generar").css("display","block");
         if($(this).is(":checked")){
            var datos = $("#arreglo_boleta_hidden").val();
            if(datos!=""){
               if(confirm("¿Está seguro que desea quitar la información anterior?")){
                  $("#arreglo_boleta_hidden").val("");
                  $("#div-factura").css("display","block");
                  $("#div-nota").css("display","none");
                  $("#div-boleta").css("display","none");
               }else{
                  $("#boleta").trigger("click");
               }
            }else{
               $("#div-factura").css("display","block");
               $("#div-nota").css("display","none");
               $("#div-boleta").css("display","none");
            }
         }
      });

    /*** ================================================================================
         =============  CODIGO PARA VALIDAR SOLO LETRAS ============
         ================================================================================ ****/
      
            patronTexto = function(id, texto){
            var patron = /^[a-zA-Z_áéíóúñ\s]*$/;
            // si devuelve null quiere decir que el usuario ha ingresado mal su información
            if(texto.match(patron)==null){
               if($("#"+id).val()!=""){
                  $("#"+id+"-mensaje").html("Este campo solo admite letras");
                  $("#"+id).focus();
                }
            
            }else{
               $("#"+id+"-mensaje").html("")
            }
          }
    
    

       /*** ================================================================================
            =============  CODIGO PARA VALIDAR SOLO NÚMEROS ================================
            ================================================================================ ****/
         
    
             patronNumero = function(id, texto){
                var patron = /^[0-9]+$/;
               if(texto.match(patron)==null){
                 if($("#"+id).val()!=""){
                   $("#"+id+"-mensaje").html("Este campo solo admite numeros");
                   $("#"+id).focus();
                }            
              }else{
                $("#"+id+"-mensaje").html("")
             }
            }
         });
   
   
   
        /*==========================================================
          ======== CALCULO DE SUMA DE SUBTOTALES ===================
          ==========================================================*/   
          
           function suma(){
        	   
        	   var total = 0;
        	  
        	   for(i=1; i<=c;i++){
            	   
              	 if(c==item_pedido){
              		 
              		 total=total + importe;
              	 }
              	   
                 }
           }
          
   
</script>
</body>
</html> 