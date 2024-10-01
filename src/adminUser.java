import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class adminUser {
    Scanner sc = new Scanner(System.in);
    private String m_name, m_password;
    //Name = Key | Password = Value
    private Map<String, String> m_user = new HashMap<>();
    public void UserOption(){
        m_user.put("Carlo","1234C");
        int l_option = 0;
        while (l_option < 4 ){
            System.out.println("==========================");
            System.out.println("1. Agregar un usuario");
            System.out.println("2. Eliminar un usuario");
            System.out.println("3. Mostrar usuarios registrados");
            System.out.println("4. Solicitar un préstamo");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opción: ");
            l_option = sc.nextInt();
            sc.nextLine();
            switch(l_option){
                case 1:
                    System.out.print("Escribe un nombre de usuario: ");
                    m_name = sc.nextLine();
                    if (m_user.containsKey(m_name)) {
                        System.out.println("Usuario no valido, intente nuevamente");
                        break;
                    }
                    System.out.print("Escribe una contraseña: ");
                    m_password = sc.nextLine();
                    m_user.put(m_name, m_password);
                    System.out.println("*Usuario "+m_name+" agregado correctamente*");
                    break;
                case 2:
                    System.out.print("Escribe el nombre de usuario: ");
                    m_name = sc.nextLine();
                    if (m_user.containsKey(m_name)) {
                        System.out.print("Escribe la contraseña: ");
                        m_password = sc.nextLine();
                        if (m_user.get(m_name).equals(m_password)) {
                            m_user.remove(m_name);
                            System.out.println("*Usuario "+m_name+" eliminado correctamente*");
                            break;
                        }
                    } else System.out.println("*Usuario no valido, intente nuevamente*");
                    break;
                case 3:
                    int i = 0;
                    System.out.println("==========================");
                    System.out.println("  USUARIOS REGISTRADOS");
                    System.out.println("==========================");
                    for (String key : m_user.keySet()) {
                        i++;
                        System.out.println(i+". " + key);
                    }
                    break;
                case 4:
                    break;
                default:
                    if (l_option > 5) {
                        System.out.println("Opción incorrecta, intente nuevamente");
                        l_option = 0;
                    } else System.out.println("Gracias por visitarnos");
                    break;
            }
        }
    }
}