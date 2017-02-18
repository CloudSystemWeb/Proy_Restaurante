<!DOCTYPE html>

<%@taglib uri="misLibrerias" prefix="lp" %>
<%@page import="daos.*"%>
<%@page import="beans.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>

<html lang="es">
<head>
   <meta charset="UTF-8">
   <title>GESTION DE PEDIDOS</title>
  <link rel="stylesheet" href="css/jquery-ui.min.css"> 
   <link rel="stylesheet" href="css/bootstrap.min.css">
   <link rel="stylesheet" href="css/estilo.css">
  
  
</head>

<body>
   <div class="contenedor">
      <div class="row">
         <div class="col-md-6" style="text-align:left">
         
            <br> <br>
            
            
         </div>
         
         <div class="col-md-6" style="text-align:right">
         <br>

         </div>
      </div>
      <div class="row">
         <div class="col-md-12" align="center">
           <h1> <b>GESTION DE PEDIDOS</b></h1>
         </div>
      </div><br><br>
      <div class="row">
         <div class="col-md-12">
            <form action="pedido" method="post" >
               <div id="tabla-variada">
                  <table class="table table-striped">
                             
                            
                           
                            <% 
                              Factory subFabrica4 = Factory.getTipo(Factory.TIPO_MYSQL);
                              PedidoDAO dao4 = subFabrica4.getPedido();
                              int codigo4 = dao4.codigoDetaPedido();
                             %>
                          
                           
                        
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
                         
                     
                    <tr>
                       
                       
                     <tr>
                            <% 
                                Factory subFabrica1 = Factory.getTipo(Factory.TIPO_MYSQL);
                                PedidoDAO dao1 = subFabrica1.getPedido();
                                int codigo3 = dao1.codigoPedido();
                             %>
                      </tr>
           
                      <tr class="pallete_black">
                        
                         <td>
                           <p></p>
                           <strong>Nº Pedido</strong>
                         
                            <input id="pedido"
                                   class="form-control"
                                   readonly="readonly"
                                   value="PED000<%=codigo3+1 %>"
                                   style="background-color:#fff;border:none;"> 
                          <input type="hidden" name="pedido" value="<%=codigo3%>">
                          <input type="hidden" name="detapedido" value="<%=codigo4%>">
                           </td>
                           
                           
                          <td>
                          <p id="mesa-mensaje" style="color:#ab001d"></p>
                          <strong>Nº Mesa</strong>
                        
                           <input  id="mesa"  
                                   name="mesa" 
                                   class="form-control"
                                   onblur="patronNumero(this.id, this.value)"
                                   required="required"> 
                        </td>
                       </tr>
                     
                      <tr>
                         
                        <td><strong>Fecha</strong>
                         
                        
                           <input  id="fecha"  
                                   name="fecha" 
                                   class="form-control"
                                   value="<%=sdf2.format(date) %>"
                                   style="border:none;font-size:16px;background-color:#fff;"
                                   readonly="readonly"> 
                                   
                            <input type="hidden" name="fecha" value="<%=sdf1.format(date) %>">
                        </td>
                     
                        <td><strong>Hora</strong><br>
                       
                           <span id="liveclock"></span>
             
                        </td>
                     </tr>
                     
                  </table>
               </div>
               
          
           <!--======================================================================== 
               ====================== FORMULARIO DE LA FACTURA ======================== 
               ======================================================================== -->
               
               <div id="div-factura"  style="display:block;">
                   <table class="table table-striped" id="tb-pedido">
                   
                       
                     <tr>
                        <td>&nbsp;</td>
                        <td>
                           <table>
                              <tr>       
                              
                                                       
                                 <td>&nbsp;&nbsp;</td>
                                 <td>
                                    <p id="producto-mensaje" style="color:#ab001d"></p>
                                    <label for="producto">Producto</label>
                                     <lp:cboDinamico id="producto1" 
                                                     name="producto"
                                                     clase="form-control"  
                                                     sql="SQL_IdProducto" 
                                                     />  
                                            
                                 </td>
                                 
                                 
                                 
                                 <td>&nbsp;&nbsp;</td>
                                 <td>
                                      <p id="cantidad1-mensaje" style="color:#ab001d"></p>
                                      <label  for="cantidad1">Cantidad</label>
                                      <input  id="cantidad1"  
                                              name="cantidad" 
                                              class="form-control"
                                              onblur="patronNumero(this.id, this.value)"> 
                                      <input type="hidden" name="empleado" value="2">
                                 </td>
                                 
                                 
                                  <td>&nbsp;&nbsp;</td>
                                   <td>
                                      <p id="precio1-mensaje" style="color:#ab001d"></p>
                                      <label  for="precio1">Precio</label>
                                      <input  id="precio1"  
                                              name="precio" 
                                              class="form-control"
                                              onblur="patronNumero(this.id, this.value)"> 
                                 </td>
                                 
                                  <td>&nbsp;&nbsp;</td>
                                   <td>
                                      <p id="umedida1-mensaje" style="color:#ab001d"></p>
                                      <label  for="umedida1">Unid.Medida</label>
                                      <input  id="umedida1"  
                                              name="umedida" 
                                              class="form-control"
                                              onblur="patronTexto(this.id, this.value)"> 
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
                        
                         <div class="alert alert-success">
                           <%
		                      String mensaje =(String)request.getAttribute("MENSAJE");
                              if(mensaje!=null){
                    	   %>
			
			               <%=mensaje %> 
			 
		                   <% }%>
		                 </div> 
                       
                        
                           <table class="table" id="tabla-pedido">
                            
                                <tr style="background:#428bca;color:white">
                                    <td>ITEM</td>
                                    <td>DESCRIPCION</td>
                                    <td>CANTIDAD</td>
                                    <td>P.UNITARIO</td>
                                    <td>UNID.MEDIDA</td>
                                    <td>IMPORTE</td>
                                    <td>ACCION</td>
                                </tr>
                              
                           </table>
                           <div class="footer" style="margin-left:520px; margin-bottom:250px; display:inline;">
                             <label >Total:</label>
                             <input type="text" id="total" >
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
    	  
         
           var combo = document.getElementById("producto1");
           var selected = combo.options[combo.selectedIndex].text;
           var combo = $("#producto1").val();
           var cantidad = $("#cantidad1").val();
           var precio = $("#precio1").val();
           var umedida = $("#umedida1").val();
           var mesa = $("#mesa").val();
           var importe = (precio * cantidad);
         
           item_pedido++;
           arreglo_pedido.push([item_pedido,combo,cantidad, precio ,umedida +";"]);
           $("#tabla-pedido").append("<tr><td>"+ item_pedido +"</td><td>"+ selected +"</td><td><div contenteditable>"+ cantidad+"</div></td><td><div contenteditable>"+ precio+"</div></td><td><div contenteditable>"+ umedida +"</div></td><td>"+ importe +"</td><td><a class='btn btn-info' onclick='remove(this)'><span class='glyphicon glyphicon-trash'></span> Eliminar </a></td>");
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
         
   
</script>

<script type="text/javascript"> 


function show5(){
if (!document.layers&&!document.all&&!document.getElementById)
return

var Digital=new Date()
var hours=Digital.getHours()
var minutes=Digital.getMinutes()
var seconds=Digital.getSeconds()

var dn="PM"
if (hours<12)
dn="AM"
if (hours>12)
hours=hours-12
if (hours==0)
hours=12

if (minutes<=9)
minutes="0"+minutes
if (seconds<=9)
seconds="0"+seconds
//change font size here to your desire
myclock="<font size='3' face='Arial' >"+hours+":"+minutes+":"
+seconds+" "+dn+"</font>"
if (document.layers){
document.layers.liveclock.document.write(myclock)
document.layers.liveclock.document.close()
}
else if (document.all)
liveclock.innerHTML=myclock
else if (document.getElementById)
document.getElementById("liveclock").innerHTML=myclock
setTimeout("show5()",1000)
}


window.onload=show5

                    
</script> 

<script type="text/javascript">

function remove(t)
{
    var td = t.parentNode;
    var tr = td.parentNode;
    var table = tr.parentNode;
    table.removeChild(tr);
}

</script>



</body>
</html> 