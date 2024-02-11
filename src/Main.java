import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcion = 1;
        int opcionG;

        System.out.println("Escribe el nombre de la lista");
        AddressBook A = new AddressBook(scan.nextLine());


       do{
           System.out.println(
                   "1. Cargar lista\n" +
                   "2. Crear contacto\n" +
                   "3. Mostrar lista de contactos\n" +
                   "4. Eliminar contacto\n" +
                   "5. Salir");
           int option = Integer.parseInt(scan.nextLine());

           switch(option){
               case 1:
                   A.load(A.getName());
                   break;
               case 2:
                   A.create();
                   System.out.println("Desea guardar el contacto 1. Si 2. No");
                   opcionG =  Integer.parseInt(scan.nextLine());
                   if(opcionG == 1){
                       A.save(A.getName());
                   }else{
                       break;
                   }
                   break;
               case 3:
                   A.list(A.getName());
                   break;
               case 4:
                   A.delete(A.getName());
                   System.out.println("Desea guardar los cambios 1. Si 2. No");
                   opcionG =  Integer.parseInt(scan.nextLine());
                   if(opcionG == 1){
                       A.save(A.getName());
                   }else{
                       break;
                   }
                   break;
               case 5:
                   opcion = 0;
                   break;
           }

       }while (opcion != 0);


    }
}