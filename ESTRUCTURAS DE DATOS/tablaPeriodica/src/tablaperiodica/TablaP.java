package tablaperiodica;

public class TablaP {
    private int nAtomico;
    private String elAtomico;
    private String siAtomico;
    private float masAtomico;
    
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
