
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *@version 1.0
 * Clase donde se controla los movientos del corredor
 * @author Hernan
 */
public class Corredor  extends Thread{
    /**
     * Variable donde se le asigna un numero unico a cada corredor  
     */
    private int nCorredor;
    /**
     * Variable que indica desde que paso arranca el corredor
     */
    private int salida;
    /**
     * Variable que indica en que pasa para cada corredor 
     */
    private int llegada;
    /**
     * Varible que asigna un grupo a un corredor 
     */
    public Grupo grupo;
    
   /**
    * Variable de Utilitarios 
    */
    public Utilitarios ut;

    /**
     * Constructor que iniciliza las variables 
     * @param nCorredor
     * @param salida
     * @param llegada
     * @param grupo
     * @param ut 
     */
    public Corredor(int nCorredor, int salida, int llegada, Grupo grupo, Utilitarios ut) {
        this.nCorredor = nCorredor;
        this.salida = salida;
        this.llegada = llegada;
        this.grupo = grupo;
        this.ut = ut;
    }
    
    
   /**
    * Funcion encargada de pausar activar y poner en espera cada hilo 
    */
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
           grupo.setPasos(grupo.getPasos()+numeroAleatorio);
           
           grupo.imprimirRecorrido();
     
           Thread.sleep(500);
           
            if(grupo.getPasos()>= grupo.getMeta()){
                
                System.out.println("\n Gano el grupo: : "+grupo.getNumeroGrupo());     
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
  /**
   * Funcion que sirve para que corran los hilos 
   */
   @Override
    public void run() {  
        pausaInicioHilos();
   } 
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public int getnCorredor() {
        return nCorredor;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public void setnCorredor(int nCorredor) {
        this.nCorredor = nCorredor;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public int getSalida() {
        return salida;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public void setSalida(int salida) {
        this.salida = salida;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public int getLlegada() {
        return llegada;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public void setLlegada(int llegada) {
        this.llegada = llegada;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public Grupo getGrupo() {
        return grupo;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public Utilitarios getUt() {
        return ut;
    }
    /**
     * Funcion que vuelve publica la variable
     * @return 
     */
    public void setUt(Utilitarios ut) {
        this.ut = ut;
    }
    
    
}
