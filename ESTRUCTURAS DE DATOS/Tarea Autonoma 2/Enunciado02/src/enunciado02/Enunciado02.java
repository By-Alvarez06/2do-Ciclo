package enunciado02;

import java.util.Scanner;

/*
Clase Empleado la cual  nos ayuda a definir y almacenar la informacion de cada
empleado a ingresar
*/
class Empleado {
    String nombre;
    int id;
    char categoria;
    int antiguedad;
    double sueldoTotal;

    /*
    Constructor definido para asignar valores a un objeto de tipo Empleado
    */
    public Empleado(String nombre, int id, char categoria, int antiguedad) {
        this.nombre = nombre;
        this.id = id;
        this.categoria = categoria;
        this.antiguedad = antiguedad;
        this.sueldoTotal = calcularSueldoTotal();
    }

    /*
    Funcion que calcula los sueldos totales de cada empleado según la condición 
    especificada (Categoría A, B o C)
    */
    private double calcularSueldoTotal() {
        double sueldoBasico = 450;
        double bonificacion = 0;

        switch (categoria) {
            case 'A':
                bonificacion = 800 + 500;
                if (antiguedad > 5) {
                    bonificacion += 30 * (antiguedad - 5);
                }
                break;
            case 'B':
                bonificacion = 400 + 300;
                if (antiguedad > 5) {
                    bonificacion += 30 * (antiguedad - 5);
                }
                break;
            case 'C':
                bonificacion = 300;
                if (antiguedad > 5) {
                    bonificacion += 25 * (antiguedad - 5);
                }
                break;
        }

        double sueldoTotal = sueldoBasico + bonificacion;

        // Aplicar descuentos
        if (sueldoTotal > 2100) {
            sueldoTotal *= 0.92;  // 8% de impuesto a la renta
        } else {
            sueldoTotal *= 0.95;  // 5% de impuesto a la renta
        }

        return sueldoTotal;
    }
}

/*
Clase Nodo la cual nos sirve para cada nodo definido del arbol binario
*/
class Nodo {
    Empleado empleado;
    Nodo izquierdo, derecho;

    public Nodo(Empleado empleado) {
        this.empleado = empleado;
        this.izquierdo = this.derecho = null;
    }
}

/*
Clase necesaria para implementar las funciones del arbol binario como la inserción
y mmostrar informacion en orden
*/
class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(Empleado empleado) {
        raiz = insertarRec(raiz, empleado);
    }

    /*
    Metodo de insercion recursiva utilizado de manera similar al Enunciado01
    */
    private Nodo insertarRec(Nodo raiz, Empleado empleado) {
        if (raiz == null) {
            raiz = new Nodo(empleado);
            return raiz;
        }

        if (empleado.id < raiz.empleado.id) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, empleado);
        } else if (empleado.id > raiz.empleado.id) {
            raiz.derecho = insertarRec(raiz.derecho, empleado);
        }

        return raiz;
    }

    public void mostrarEnOrden() {
        mostrarEnOrdenRec(raiz);
    }

    /*
    Muestra la información de los empleados almacenados en el arbol binario
    */
    private void mostrarEnOrdenRec(Nodo raiz) {
        if (raiz != null) {
            mostrarEnOrdenRec(raiz.izquierdo);
            System.out.println("ID: " + raiz.empleado.id + ", Nombre: " + raiz.empleado.nombre + ", Sueldo Total: " + raiz.empleado.sueldoTotal);
            mostrarEnOrdenRec(raiz.derecho);
        }
    }
}

public class Enunciado02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        Creacion de un arbol por cada categoria
        */
        ArbolBinarioBusqueda arbolA = new ArbolBinarioBusqueda();
        ArbolBinarioBusqueda arbolB = new ArbolBinarioBusqueda();
        ArbolBinarioBusqueda arbolC = new ArbolBinarioBusqueda();

        System.out.print("Ingrese la cantidad de empleados: ");
        int cantidadEmpleados = sc.nextInt();
        sc.nextLine();  // Limpieza de Buffer

        for (int i = 0; i < cantidadEmpleados; i++) {
            System.out.println("\nEmpleado #" + (i+1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Categoría (A, B o C): ");
            char categoria = sc.next().charAt(0);
            System.out.print("Antigüedad: ");
            int antiguedad = sc.nextInt();
            sc.nextLine();  // Consumir el salto de línea

            Empleado empleado = new Empleado(nombre, id, categoria, antiguedad);

            /*
            Ingreso del empleado al arbol binario segun la categoria ingresada
            por pantalla
            */
            switch (categoria) {
                case 'A':
                    arbolA.insertar(empleado);
                    break;
                case 'B':
                    arbolB.insertar(empleado);
                    break;
                case 'C':
                    arbolC.insertar(empleado);
                    break;
            }
        }

        System.out.println("\nEmpleados en categoría A:");
        arbolA.mostrarEnOrden();
        System.out.println("\nEmpleados en categoría B:");
        arbolB.mostrarEnOrden();
        System.out.println("\nEmpleados en categoría C:");
        arbolC.mostrarEnOrden();
    }
}
