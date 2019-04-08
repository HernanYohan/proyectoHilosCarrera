
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hernan
 */
public class Corredor  extends Thread{
    
    private int nCorredor;
    private int salida;
    private int llegada;
    public Grupo grupo;
    public Utilitarios ut;

    public Corredor(int nCorredor, int salida, int llegada, Grupo grupo, Utilitarios ut) {
        this.nCorredor = nCorredor;
        this.salida = salida;
        this.llegada = llegada;
        this.grupo = grupo;
        this.ut = ut;
    }
    
   public void pausaInicioHilos (){
   do{
    if (grupo.getPasos()<salida){
        synchronized(grupo){
            try{
                grupo.wait();
            }catch (InterruptedException ex){
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE,null,ex);
            }
            
        }
   }else{
        continue;
    }
    
   }while(grupo.getPasos()<salida);
   
   while(grupo.getPasos()<grupo.getMeta() && grupo.getPasos() < llegada ){
       try{
           int numeroAleatorio = ut.numeroRandom();
           grupo.setPasos(+numeroAleatorio);
           Thread.sleep(500);
           
            if(grupo.getPasos()>= grupo.getMeta()){
                
                System.out.println("\n EQUIPO GANADOR: "+grupo.getNumeroGrupo()+" ,Corredor: "+ nCorredor);
                        
                    System.exit(0);
                
            }else{
                    synchronized(grupo){
                        if(grupo.getPasos()>=llegada){
                            grupo.notifyAll();
                        }
                    }
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);   
            }
       
       
   }
   
   
   
   } 
  
   @Override
    public void run() {  
        pausaInicioHilos();
   } 
}
