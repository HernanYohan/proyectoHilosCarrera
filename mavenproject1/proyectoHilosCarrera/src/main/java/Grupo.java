/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hernan
 */
public class Grupo {
    /**
     * Variable que indica la meta 
     */
    
    private int meta;
    
    /**
     * variable que indica el numero de pasos que ha dado 
     */
    private int pasos = 0;
    /**
     * Variable que indica el grupo al que pertenece 
     */
    private int numeroGrupo;
    /**
     * Variable que dice la figura de cada corredor 
     */
    private String figura;

    
    /**
     * Constructor que inicializa todas las variable 
     * @param meta
     * 
     * @param numeroGrupo
     * @param figura 
     */
    public Grupo(int meta, int numeroGrupo, String figura) {
        this.meta = meta;
       
        this.numeroGrupo = numeroGrupo;
        this.figura = figura;
    }
    
    public void imprimirRecorrido(){
        String recorrido=("\n"+"grupo "+numeroGrupo+"->  "); 
        if(pasos<33){
            for(int i=0;i<pasos;i++){
              recorrido = recorrido+"_";
            }
            recorrido+=figura;
            for(int i=pasos;i<32;i++){
              recorrido = recorrido+"_";
            }
            recorrido+=figura;
                 
            for(int i=33;i<66;i++){
             recorrido = recorrido+"_";
            }
            recorrido+=figura;
                    
            for(int i=66;i<=100;i++){
              recorrido = recorrido+"_";
            }
                        
        System.out.print(recorrido);
        }
        
        if (pasos >= 33 && pasos < 66) {
            
            for (int i = 0; i < 33; i++) {
                recorrido = recorrido + "_";
            }
            recorrido += figura;
            for (int i = 33; i < pasos; i++) {
                recorrido = recorrido + "_";
            }
            recorrido += figura;
            for (int i = pasos; i < 65; i++) {
                recorrido = recorrido + "_";
            }
            recorrido += figura;
            for (int i = 66; i <= 100; i++) {
                recorrido = recorrido + "_";
            }

          System.out.print(recorrido);

        }
        if (pasos >= 66) {
           
            for (int i = 0; i < 33; i++) {
                recorrido = recorrido + "_";
            }
            recorrido += figura;
            for (int i = 33; i < 66; i++) {
                recorrido = recorrido + "_";
            }
            recorrido += figura;
            for (int i = 66; i <= pasos; i++) {
                recorrido = recorrido + "_";
            }
            recorrido += figura;
            for (int i = pasos; i < 99; i++) {
                recorrido = recorrido + "_";
            }

            System.out.print( recorrido);

        }

        
            System.out.print(recorrido);

    }
    
        public int retornarPasos(){
            return pasos;
         }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }
    
    
}
