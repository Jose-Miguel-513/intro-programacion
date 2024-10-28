import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ArrayDePersonas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Personas> personas = new ArrayList<>();
        
        while (true) {
           try {
                System.out.println("Ingrese el nombre de una persona:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la edad de la persona:");
                int edad = Integer.parseInt(scanner.nextLine());

                Personas persona = new Personas(nombre, edad);
                personas.add(persona);

                
                System.out.println("¿Desea ingresar otra persona? (Sí/No)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("No")) {
                    break;
                }

                }catch (InputMismatchException e){
                
                    System.out.println("No se ha ingresado un numero entero valido, pruebe de nuevo");
                    System.out.println(e.getMessage());
                    scanner.nextLine();

                }catch(Exception e){
                    System.out.println("Se produjo un error, intente de nuevo");
                    System.out.println(e.getMessage());
                    scanner.nextLine();
            }
            
        }

        System.out.println();

        int suma = 0;
        Personas personaMayor = personas.get(0);
        Personas personaMenor = personas.get(0);
    
        for (Personas persona : personas) {

            suma += persona.getEdad();

            if (persona.getEdad() > personaMayor.getEdad()) {
                    personaMayor = persona;
            }
            
              
            if (persona.getEdad() < personaMenor.getEdad()) {
                    personaMenor = persona;
            }

        }

        int length = personas.size();
        double promedio = suma / length;

        System.out.println("El promedio de edad es de: " + promedio + "\nLa persona mayor es: " + personaMayor.getNombre() + " Con: " + personaMayor.getEdad() + "\nLa persona menor es: " + personaMenor.getNombre() + " Con: " + personaMenor.getEdad()); 

        scanner.close();
    }
}