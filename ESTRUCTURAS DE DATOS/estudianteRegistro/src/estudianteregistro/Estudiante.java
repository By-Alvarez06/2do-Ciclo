/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudianteregistro;

public class Estudiante {

    private String cedula;
    private String nombre;
    private String direccion;
    private String sexo;
    private int edad;
    private int telefono;

    public Estudiante() {
        cedula = "";
        nombre = "";
        direccion = "";
        sexo = "";
        edad = 0;
        telefono = 0;
    }

    public void setCedula(String s) {
        cedula = s;
    }

    public void setNombre(String s) {
        nombre = s;
    }

    public void setDireccion(String s) {
        direccion = s;
    }

    public void setSexo(String s) {
        sexo = s;
    }

    public void setEdad(int n) {
        edad = n;
    }

    public void setTelefono(int n) {
        telefono = n;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public int getTelefono() {
        return telefono;
    }
}
