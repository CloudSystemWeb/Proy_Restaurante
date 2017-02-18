package beans;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Proceso extends Thread {
	
	
	
	    public  String lblAux ="";
	
	
		public Proceso(String msg)
	 
	     {
	 
	         super(msg);
	 
	     }
	 
	      
	 
	     public void run()
	 
	     {
	 
           
             
	        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
	        
	 		while (true) {
	 			
	 			Date d = new Date();
	 			System.out.println(sdf.format(d));
	 		
	 			try {
	 				Thread.sleep(1000);
	 				
	 				
	 			} catch (InterruptedException e) {
	 				e.printStackTrace();
	 				
	 			}
	 			
	 			
	 			
	 		}
	 	}
	 

	     public String getLblAux() {
			return lblAux;
		}


	     public String setEtiqueta(String lblaux){
	 		return this.lblAux = lblaux;
	 	}
	     
	
		
	 	public static void main(String[] args) {
	 		
		       
	        Proceso hilo1 = new Proceso("Hilo 1");
	        hilo1.start();
          
	     

	    }
		
		
}
	 
	

