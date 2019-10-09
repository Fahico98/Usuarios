
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.*;

public class Main {
   
   public static void main(String[] args) throws IOException{
      ArrayList<Usuario> usuarios = new ArrayList<>();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("***** SISTEMA DE REGISRO DE USUARIOS *****\n");
      while(true){
         System.out.println(
            "Opciones del programa: \n" +
            "  1. Registrar nuevos usuarios.\n" +
            "  2. Mostrar datos de usuarios previemente registrados.\n" +
            "  3. Salir.\n"
         );
         System.out.print("Ingrese su opción: ");
         String opcion = br.readLine();
         if(opcion.compareTo("1") == 0 || opcion.compareTo("1.") == 0){
            System.out.print("\nIngrese el número de usuarios que desea registrar: ");
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
               System.out.print("\nIngrese el nombre del usuario: ");
               String nombre = br.readLine();
               System.out.print("\nIngrese el documento de identidad del usuario: ");
               long id = Long.parseLong(br.readLine());
               System.out.print("\nIngrese la fecha de nacimiento del usuario (yyyy-mm-dd): ");
               String fechaNacStr = br.readLine();
               SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
               try{
                  Date fechaNac = formato.parse(fechaNacStr);
                  Usuario usuario = new Usuario(nombre, id, fechaNac);
                  String clave = "";
                  if(usuario.getEdad() >= 18){
                     while(true){
                        System.out.print(
                           "\nIngrese la clave del usuario (No menos de 9 caracteres, por lo menos una mayuscula\n" + 
                           "y una minuscula, así como un caracter especial y un caracter numérico): "
                        );
                        clave = br.readLine();
                        if(Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{Punct}]).{9,})").matcher(clave).matches()){
                           break;
                        }else{
                           System.out.println("Clave invalida...");
                        }
                     }
                  }
                  usuario.setClave(clave);
                  usuarios.add(usuario);
                  System.out.println("");
               }catch(ParseException e){}
            }
         }else if(opcion.compareTo("2") == 0 || opcion.compareTo("2.") == 0){
            if(usuarios.isEmpty()){
               System.out.println("\nAún no se han ingresado usuarios...");
            }else{
               for (int i = 0; i < usuarios.size(); i++) {
                  System.out.println(
                     "\nNombre: " + usuarios.get(i).getNombre() + ".\n" +
                     "Documento de identificación: " + usuarios.get(i).getDocumentoId() + ".\n" +
                     "Fecha de nacimiento: " + usuarios.get(i).getFechaNac().getYear() + "-" + 
                     usuarios.get(i).getFechaNac().getMonth() + "-" + usuarios.get(i).getFechaNac().getDate() +".\n" +
                     "Edad: " + usuarios.get(i).getEdad() + ".\n" +
                     "Clave: " + usuarios.get(i).getClave() + "."
                  );
               }
            }
            System.out.println("");
         }else if(opcion.compareTo("3") == 0 || opcion.compareTo("3.") == 0){
            System.out.println("\n***** FIN DEL PROGRAMA ******");
            break;
         }else{
            System.out.println("\nOpción no valida, por favor intentelo de nuevo...\n");
         }
      }
   }
}
