import java.util.*;

interface IDatas{
    Map<String, String> m_books = new HashMap<>();
    Queue<String[][]> m_loansInQueue = new LinkedList<>();
    ArrayList<String> m_newBook = new ArrayList<>();
    Stack<String> m_booksLent = new Stack<>();
}

public class adminBook implements IDatas {

    private final Scanner sc = new Scanner(System.in);

    private String m_Title, m_Author;

    //Title = Key | Author = Value (Variable m_books)


    //m_localUser es una variable local para almacenar la misma información de la variable m_user de la clase adminUser
    private Map m_localUser = new HashMap<>();
    public void SetLocalUser( Map p_name) {this.m_localUser = p_name;}

    adminUser m_adminUser;

    public void BookOption() {
        int l_option = 0, l_contador = 0;
        m_adminUser = new adminUser();
        while (l_option != 6 ) {
            System.out.println("Que acción quiere realizar:");
            System.out.println("1. Agregar un libro");
            System.out.println("2. Eliminar un libro");
            System.out.println("3. Mostrar libros disponibles");
            System.out.println("4. Mostrar libros reservados");
            System.out.println("5. Mostrar libros no disponibles");
            System.out.println("6. Volver al menu principal");
            System.out.print("Seleccione una opción: ");
            l_option = sc.nextInt();
            sc.nextLine();
            switch (l_option) {
                case 1:
                    System.out.print("Escribe el titulo: ");
                    m_Title = sc.nextLine();
                    if (m_books.containsKey(m_Title)) {
                        System.out.println("El libro ya existe");
                        break;
                    }
                    System.out.print("Escribe el autor: ");
                    m_Author = sc.nextLine();
                    m_books.put(m_Title, m_Author);
                    m_newBook.add(m_Title);
                    System.out.println("*El libro ha sido agregado*");
                    break;
                case 2:
                    if (FiendBook()) {
                        m_books.remove(m_Title);
                        System.out.println("*El libro ha sido eliminado*");
                    }
                    break;
                case 3:
                    System.out.println("==========================");
                    System.out.println("    LIBROS DISPONIBLES");
                    System.out.println("==========================");
                    for (String key : m_books.keySet()) {
                        l_contador++;
                        System.out.println(l_contador+". " + key);
                    }
                    l_contador = 0;
                    System.out.println("==========================");
                    break;
                case 4:
                    System.out.println("===========================");
                    System.out.println("     LIBROS RESERVADOS");
                    System.out.println("===========================");
                    for (String[][] l_tempLoans : m_loansInQueue) {
                        for (String[] loanDetails : l_tempLoans) {
                            String l_title = loanDetails[0];
                            String l_user = loanDetails[1];
                            System.out.println(l_title + " fue reservado por " + l_user);
                        }
                    }

                    System.out.println("===========================");
                    break;
                case 5:
                    System.out.println("===========================");
                    System.out.println("   LIBROS NO DISPONIBLES");
                    System.out.println("===========================");
                    for (var l_titleLent : m_booksLent) {
                        l_contador++;
                        System.out.println(l_contador+". " + l_titleLent);
                    }
                    l_contador = 0;
                    System.out.println("===========================");
                    break;
                default:
                    if (l_option == 6) System.out.println("==========================");
                    else System.out.println("El valor ingresado es incorrecto");
                    break;
            }
        }
    }

    public void LoansInQueue() {
        String [][] l_loan = new String[1][2];
        System.out.print("Escribe el titulo del libro: ");
        l_loan[0][0] = sc.nextLine();
        System.out.print("Escribe a nombre de quien es la reserva: ");
        l_loan[0][1] = sc.nextLine();
        m_loansInQueue.add(l_loan);
        System.out.println("m_loans: "+m_loansInQueue);
        System.out.println("Se a creado su reserva");
    }

    public void LendBook() {
        m_adminUser = new adminUser();
        String l_name, l_password;
        System.out.print("Escribe tu nombre de usuario: ");
        l_name = sc.nextLine();
        System.out.print("Escribe tu contraseña: ");
        l_password = sc.nextLine();
        if (m_localUser.get(l_name).equals(l_password)) {
            if (FiendBook()) {
                m_books.remove(m_Title);
                m_booksLent.add(m_Title);
                System.out.println("Tu libro fue encontrado, recogelo y ten en cuenta que se debe de volver el siguiente mes");
            }
        } else {
            System.out.println("Usuario o contraseña incorrecta");
        }
    }

    private boolean FiendBook () {
        while (true) {
            System.out.print("Escribe el titulo del libro: ");
            m_Title = sc.nextLine();
            System.out.print("Escribe el autor: ");
            m_Author = sc.nextLine();
            if (m_books.containsKey(m_Title)) {
                if (m_books.get(m_Title).equals(m_Author)) {
                    return true;
                } else {
                    System.out.println("*El autor ingresado no coincide*");
                }
            } else {
                System.out.println("*El libro no está registrado*");
                return false;
            }
        }
    }

    public void GetNewBook() {
        int contador = 0;
        System.out.println("===========================");
        System.out.println("       NUEVOS LIBROS");
        System.out.println("===========================");
        for (String l_nameBook : m_newBook ) {
            contador++;
            System.out.println(contador+". " + l_nameBook);
        }
    }
}