/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hernan
 */
public class Utilitarios {
    
    /**
     * funcion que genera un numero aleatorio entre 1 y 3 y lo retorna
     * @return 
     */
    public synchronized int numeroRandom(){
       return (int) Math.floor(Math.random()*(3));
    }
    
}
