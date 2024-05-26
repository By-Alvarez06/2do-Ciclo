package tablaperiodica;

public class TablaP {
    private int nAtomico; // Numero Atomico
    private String elAtomico; //Elemento de la tabla periodica
    private String siAtomico; // Simbolo del elemento
    private float masAtomico; // Masa atomica
    
    /*
    Funciones para asignar los valores a los atributos y obtenerlos
    */
    
    public void setnAtomico(int n){
        nAtomico = n;
    }
    
    public void setElAtomico(String s){
        elAtomico = s;
    }
    public void setSiAtomico(String s){
        siAtomico = s;
    }
    
    public void setMasAtomico(float n){
        masAtomico = n;
    }
    
    
    public int getnAtomico(){
        return nAtomico;
    }
    
    public String getElAtomico(){
        return elAtomico;
    }
    public String getSiAtomico(){
        return siAtomico;
    }
    
    public float getMasAtomico(){
        return masAtomico;
    }
}
