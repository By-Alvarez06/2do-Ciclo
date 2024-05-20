package estudianteregistro;

import java.util.Scanner;

public class estudianteRegistro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante[] arrayRegistro = new Estudiante[6];
        for (int i = 0; i < arrayRegistro.length; i++) {
            Estudiante est = new Estudiante();
            System.out.printf("\nIngrese la cedula del estudiante %d: ", i + 1);
            est.setCedula(sc.nextLine());
            System.out.printf("Ingrese el nombre del estudiante %d: ", i + 1);
            est.setNombre(sc.nextLine());
            System.out.printf("Ingrese la direccion del estudiante %d: ", i + 1);
            est.setDireccion(sc.nextLine());
            System.out.printf("Ingrese el sexo del estudiante %d: ", i + 1);
            est.setSexo(sc.nextLine());
            System.out.printf("Ingrese la edad del estudiante %d: ", i + 1);
            est.setEdad(sc.nextInt());
            System.out.printf("Ingrese el telefono del estudiante %d: ", i + 1);
            est.setTelefono(sc.nextInt());

            arrayRegistro[i] = est;
            sc.nextLine();
        }

        for (int i = 0; i < arrayRegistro.length; i++) {
            Estudiante estudN = arrayRegistro[i];
            System.out.printf("""
                              \nEstudiante %d:
                              Cedula: %s
                              Nombre: %s
                              Direccion: %s
                              Sexo: %s
                              Edad: %d
                              Telefono: %d
                              """, (i + 1), estudN.getCedula(), estudN.getNombre(),
                    estudN.getDireccion(), estudN.getSexo(),
                    estudN.getEdad(), estudN.getTelefono());
        }
    }

}
