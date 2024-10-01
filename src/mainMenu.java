import java.util.Scanner;

public class mainMenu {
    Scanner sc = new Scanner(System.in);
    adminUser m_users = new adminUser();
    adminBook m_books = new adminBook();
    public static void main(String[] args) {
        mainMenu l_menu = new mainMenu();
        System.out.println("==========================");
        System.out.println("        BIENVENIDO");
        System.out.println("==========================");
        l_menu.Option();
    }
    public void Option() {
        int l_option = 0;
        while (l_option < 3) {
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
                    m_users.UserOption();
                    break;
                case 2:
                    m_books.BookOption();
                    break;
                case 3:
                    m_books.GetNewBook();
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
}