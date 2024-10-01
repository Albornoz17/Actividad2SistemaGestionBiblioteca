import java.util.Scanner;

public class adminBook {
    Scanner sc = new Scanner(System.in);
    public void BookOption() {
        int l_option = 0;
        while (l_option < 4 ) {
            System.out.println("Que acción quiere realizar:");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Eliminar un libro");
            System.out.println("3. Mostrar libros guardados");
            System.out.println("4. Volver al menu principal");
            System.out.print("Seleccione una opción: ");
            l_option = sc.nextInt();
            sc.nextLine();
            switch (l_option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    if (l_option > 4) {
                        System.out.println("Opción incorrecta, intente nuevamente");
                        l_option = 0;
                    } else System.out.println("Gracias por visitarnos");
                    break;
            }
        }
    }

    public void GetNewBook() {
        System.out.println("Hola word");
    }
}