package com.mycompany.main;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    private static Scanner scanString = new Scanner(System.in);
    private static Scanner scanNumero= new Scanner(System.in).useLocale(Locale.US);
    private static GestorAlumno gestorAlumno = new GestorAlumno();

    public static void main(String[] args)
    {
    try
    {

        boolean salir = false;
        int opcion;
        do {
            menu();
            opcion = scanNumero.nextInt();

            switch (opcion)
            {
                case 1:
                    agregarAlumno();
                    break;
                case 2:
                    listarAlumnos();
                    break;
               case 3:
                    eliminar();
                    break;
                case 4:
                    buscarAlumno();
                case 5:
                    agregarEjemploAlumno();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            } 
        } while (!salir); 
    }
    catch (IllegalArgumentException e)
    {
        System.out.println(e.getMessage());
    } 
    }
    private static void menu()
    {
        System.out.println("Elija opción:");
        System.out.println("1- Agregar alumno");
        System.out.println("2- Listar alumno");
        System.out.println("3- Borra un alumno");
        System.out.println("4- Busca un alumno");
        System.out.println("5- Agregar ejemplo de alumnos");
        System.out.println("0- Salir");
    }
    private static void agregarAlumno()
    {
        System.out.println("========== Formulario de alumno ==========");
        System.out.println("Nombre: ");
        String nombre = scanString.nextLine();
        System.out.println("Apellido: ");
        String apellido = scanString.nextLine();
        System.out.println("Numero de telefono: ");
        int numeroTelefono = scanNumero.nextInt();
        System.out.println("Email: ");
        String email = scanString.nextLine();
        System.out.println("nota1: ");
        double nota1 = scanNumero.nextDouble();
        System.out.println("Nota2: ");
        double nota2 = scanNumero.nextDouble();
        System.out.println("Nota3");
        double nota3 = scanNumero.nextDouble();
        System.out.println("Asistencia");
        double asistencia = scanNumero.nextDouble();
        System.out.println("Finales: ");
        double finales = scanNumero.nextDouble();
        gestorAlumno.agregarAlumno(new Alumno(nombre,apellido,numeroTelefono,email,nota1,nota2,nota3,asistencia,finales));
    }

    private  static void listarAlumnos()
    {
        // Salida de datos con variable local
        System.out.println("\n\n          Listado de Alumnos");
        System.out.println("=================================================================================================================================================================================================");
        System.out.println("ID  Nombre                 Apellido           Telefono                     Email                        nota1    nota2     nota3    asistencia   examen final     Nota Final     Nota Cualitativa");
        System.out.println("=================================================================================================================================================================================================");
        for (Alumno alumno : gestorAlumno.listarPersonas())
        {
            System.out.println(alumno);
        }
    }
     private static void buscarAlumno()
    {
        int numero;
        System.out.println("Que alumno desea buscar?");
        numero = scanNumero.nextInt();
        for (Alumno alumno : gestorAlumno.buscarAlumnoPorId(numero))
        {
            System.out.println("El alumno encontrado por el id es: " + alumno.toAlumno());
        }
       
    }

    private static void eliminar()
    {
        int numero;
        listarAlumnos();
        System.out.println("Que alumno desea eliminar?");
        numero = scanNumero.nextInt();
//        System.out.println("alumno eliminado con exito");
        for (Alumno alumno : gestorAlumno.buscarAlumnoPorId(numero))
        {
            System.out.println("Has seleccionado al alumno " + alumno.toAlumno());
        }
      gestorAlumno.eliminarAlumno(numero);

      

    } 

    private static void agregarEjemploAlumno()
    {
        gestorAlumno.agregarAlumno(new Alumno("Santiago","Alonso",635966493,
                "santi.alr4705@gmail.com",6,8,10,10,10));

        gestorAlumno.agregarAlumno(new Alumno("Jorge","Santana",635966494,
                "jorsanfra@gmail.com",10,8,10,9,10));

        gestorAlumno.agregarAlumno(new Alumno("Sergio","Palermo",635966495,
                "pisodeabajo5@gmail.com",5,3,7,4,7));

        gestorAlumno.agregarAlumno(new Alumno("Víctor","Gómez",635966496,
                "victorgapc@gmail.com",8,8,10,3,9));

        gestorAlumno.agregarAlumno(new Alumno("Luis","Ao",635966497,
                "luisao.g@gmail.com",8,9,6,7,9));

        gestorAlumno.agregarAlumno(new Alumno("Feve","Mil",635966498,
                "fevemilf@gmail.com",10,10,10,10,10));

        gestorAlumno.agregarAlumno(new Alumno("Pedro","Hernández",635966499,
                "pedritohr@gmail.com",4,9,3,4,5.75));


    }

    
   
}