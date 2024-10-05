import java.util.Scanner;

public class mainMenu implements IDatas {
    public static void main(String[] args) {
        m_books.put("El hombre que calculaba","Malba Tahan");
        System.out.println("==========================");
        System.out.println("        BIENVENIDO");
        System.out.println("==========================");
        mainMenu.Option();
    }
    public static void Option(){
        Scanner sc = new Scanner(System.in);
        adminUser l_user = new adminUser();
        adminBook l_book = new adminBook();
        int l_option = 0;
        while (l_option != 4) {
            System.out.println("Que opciones quiere ver:");
            System.out.println("1. Usuarios");
            System.out.println("2. Libros");
            System.out.println("3. Novedades");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            l_option = sc.nextInt();
            sc.nextLine();
            switch (l_option) {
                case 1:
                    l_user.UserOption();
                    break;
                case 2:
                    l_book.BookOption();
                    break;
                case 3:
                    l_book.GetNewBook();
                    break;
                case 4:
                    System.out.println("*Gracias por visitarnos*");
                    break;
                default:
                    System.out.println("*Opción no valida, por favor intente nuevamente*");
                    break;
            }
        }
    }
}