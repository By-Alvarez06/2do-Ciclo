package enunciado03;

import java.util.Scanner;

/*
Clase Cliente la cual  nos ayuda a definir y almacenar la informacion de cada
empleado a ingresar
*/
class Cliente {
    String nombre;
    int id;
    int antiguedad;
    char historialCrediticio;
    char categoria;
    double descuento;
    double montoCompra;

    /*
    Constructor definido para asignar valores a cualquier instancia de tipo Cliente
    */
    public Cliente(String nombre, int id, int antiguedad, char historialCrediticio, double montoCompra) {
        this.nombre = nombre;
        this.id = id;
        this.antiguedad = antiguedad;
        this.historialCrediticio = historialCrediticio;
        this.montoCompra = montoCompra;
        this.categoria = calcularCategoria(montoCompra);
        this.descuento = calcularDescuento();
    }

    /*
    Función que calcula la categoría en base a los parametros designados
    */
    private char calcularCategoria(double montoCompra) {
        int puntos = 0;

        // Calcular puntos por monto de compra
        if (montoCompra > 1000) {
            puntos += 3;
        } else if (montoCompra >= 500) {
            puntos += 2;
        }

        // Calcular puntos por historial crediticio
        switch (historialCrediticio) {
            case 'A':
                puntos += 3;
                break;
            case 'B':
                puntos += 2;
                break;
            case 'C':
                puntos += 1;
                break;
        }

        // Calcular puntos por antiguedad
        if (antiguedad > 5) {
            puntos += 3;
        } else if (antiguedad >= 2) {
            puntos += 2;
        } else {
            puntos += 1;
        }

        // Determinar categoría
        if (puntos >= 7) {
            return 'A';
        } else if (puntos >= 3) {
            return 'B';
        } else {
            return 'C';
        }
    }

    /*
    Una vez designada la categoria con la función anterior, ocupamos la funcion
    para calcular el descuento en base a la categoria a la que pertenece el cliente
    */
    private double calcularDescuento() {
        switch (categoria) {
            case 'A':
                return 0.10;
            case 'B':
                return 0.06;
            case 'C':
                return 0.02;
            default:
                return 0.0;
        }
    }
}

/*
Clases Nodo Y ArbolBinario utilizadas en un contexto similar al las funciones 
del Enunciado02
*/
class Nodo {
    Cliente cliente;
    Nodo izquierdo, derecho;

    public Nodo(Cliente cliente) {
        this.cliente = cliente;
        this.izquierdo = this.derecho = null;
    }
}

class ArbolBinarioBusqueda {
    Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(Cliente cliente) {
        raiz = insertarRec(raiz, cliente);
    }

    private Nodo insertarRec(Nodo raiz, Cliente cliente) {
        if (raiz == null) {
            raiz = new Nodo(cliente);
            return raiz;
        }

        if (cliente.id < raiz.cliente.id) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, cliente);
        } else if (cliente.id > raiz.cliente.id) {
            raiz.derecho = insertarRec(raiz.derecho, cliente);
        }

        return raiz;
    }

    public void mostrarEnOrden() {
        mostrarEnOrdenRec(raiz);
    }

    private void mostrarEnOrdenRec(Nodo raiz) {
        if (raiz != null) {
            mostrarEnOrdenRec(raiz.izquierdo);
            System.out.println("ID: " + raiz.cliente.id + ", Nombre: " + 
                    raiz.cliente.nombre + ", Descuento: " + 
                    (raiz.cliente.descuento * 100) + "%" + " ; Monto de compra: " + raiz.cliente.montoCompra);
            mostrarEnOrdenRec(raiz.derecho);
        }
    }
}

public class Enunciado03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        Creacion de un arbol binario por categoria para la asignación de los 
        nodos (clientes)
        */
        ArbolBinarioBusqueda arbolA = new ArbolBinarioBusqueda();
        ArbolBinarioBusqueda arbolB = new ArbolBinarioBusqueda();
        ArbolBinarioBusqueda arbolC = new ArbolBinarioBusqueda();

        System.out.print("Ingrese la cantidad de clientes: ");
        int cantidadClientes = sc.nextInt();
        sc.nextLine();  // Limpieza de Buffer

        for (int i = 0; i < cantidadClientes; i++) {
            System.out.println("\nCliente #" + (i+1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("ID: ");
            int id = sc.nextInt();
            System.out.print("Antigüedad: ");
            int antiguedad = sc.nextInt();
            System.out.print("Historial crediticio (A, B o C): ");
            char historialCrediticio = sc.next().charAt(0);
            System.out.print("Monto de compra: ");
            double montoCompra = sc.nextDouble();
            sc.nextLine();  // Consumir el salto de línea

            Cliente cliente = new Cliente(nombre, id, antiguedad, historialCrediticio, montoCompra);

            switch (cliente.categoria) {
                case 'A':
                    arbolA.insertar(cliente);
                    break;
                case 'B':
                    arbolB.insertar(cliente);
                    break;
                case 'C':
                    arbolC.insertar(cliente);
                    break;
            }
        }

        System.out.println("\nClientes en categoría A:");
        arbolA.mostrarEnOrden();
        System.out.println("\nClientes en categoría B:");
        arbolB.mostrarEnOrden();
        System.out.println("\nClientes en categoría C:");
        arbolC.mostrarEnOrden();
    }
}
