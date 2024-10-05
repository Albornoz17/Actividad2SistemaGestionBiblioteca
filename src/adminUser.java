import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class adminUser {
    Scanner sc = new Scanner(System.in);
    //Name = Key | Password = Value
    private final Map<String, String> m_user = new HashMap<>();
    adminBook m_adminBook;
    public void UserOption(){
        m_adminBook = new adminBook();
        m_user.put("admin", "admin");
        int l_option = 0;
        String l_name, l_password;
        while (l_option != 6 ){
            System.out.println("==========================");
            System.out.println("1. Agregar un usuario");
            System.out.println("2. Eliminar un usuario");
            System.out.println("3. Mostrar usuarios registrados");
            System.out.println("4. Solicitar un préstamo");
            System.out.println("5. Reservar un libro");
            System.out.println("6. Volver al menu principal");
            System.out.print("Seleccione una opción: ");
            l_option = sc.nextInt();
            sc.nextLine();
            switch(l_option){
                case 1:
                    System.out.print("Escribe un nombre de usuario: ");
                    l_name = sc.nextLine();
                    if (m_user.containsKey(l_name)) {
                        System.out.println("Usuario no valido, intente nuevamente");
                        break;
                    }
                    System.out.print("Escribe una contraseña: ");
                    l_password = sc.nextLine();
                    m_user.put(l_name, l_password);
                    System.out.println("*Usuario "+l_name+" agregado correctamente*");
                    break;
                case 2:
                    System.out.print("Escribe el nombre de usuario: ");
                    l_name = sc.nextLine();
                    if (m_user.containsKey(l_name)) {
                        System.out.print("Escribe la contraseña: ");
                        l_password = sc.nextLine();
                        if (m_user.get(l_name).equals(l_password)) {
                            m_user.remove(l_name);
                            System.out.println("*Usuario "+l_name+" eliminado correctamente*");
                            break;
                        }
                    } else System.out.println("*Usuario no valido, intente nuevamente*");
                    break;
                case 3:
                    int contador = 0;
                    System.out.println("==========================");
                    System.out.println("   USUARIOS REGISTRADOS");
                    System.out.println("==========================");
                    for (String key : m_user.keySet()) {
                        contador++;
                        System.out.println(contador+". " + key);
                    }
                    break;
                case 4:
                    m_adminBook.SetLocalUser(m_user);
                    m_adminBook.LendBook();
                    break;
                case 5:
                    m_adminBook.LoansInQueue();
                    break;
                default:
                    if (l_option == 6) System.out.println("==========================");
                    else System.out.println("El valor ingresado es incorrecto");
                    break;
            }
        }
    }
}