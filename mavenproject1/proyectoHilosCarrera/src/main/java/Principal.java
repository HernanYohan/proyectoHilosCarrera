
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hernan
 */
public class Principal {
    
    public void iniciar (){
   
    
    Utilitarios ut= new Utilitarios();
    
    Grupo grupo1 = new Grupo(100, 1, "H");
    Grupo grupo2 = new Grupo(100, 2, "D");
    Grupo grupo3 = new Grupo(100, 3, "C");
    
        Corredor corredor1 =new Corredor(1, 0,33 , grupo1, ut);
        Corredor corredor2 =new Corredor(2, 33,66 , grupo1, ut);
        Corredor corredor3 =new Corredor(3, 66,100 , grupo1, ut);
        
        Corredor corredor4 =new Corredor(4, 0,33 , grupo2, ut);
        Corredor corredor5 =new Corredor(5, 33,66 , grupo2, ut);
        Corredor corredor6 =new Corredor(6, 66,100 , grupo2, ut);
        
        Corredor corredor7 =new Corredor(7, 0,33 , grupo3, ut);
        Corredor corredor8 =new Corredor(8, 33,66 , grupo3, ut);
        Corredor corredor9 =new Corredor(9, 66,100 , grupo3, ut);
        
        
        
       
        
        ExecutorService executer= Executors.newFixedThreadPool(9);
            executer.execute(corredor1);
            executer.execute(corredor2);
            executer.execute(corredor3);
            executer.execute(corredor4);
            executer.execute(corredor5);
            executer.execute(corredor6);
            executer.execute(corredor7);
            executer.execute(corredor8);
            executer.execute(corredor9);
        executer.shutdown();
    
    
    
    
    
    
    }
    
}
