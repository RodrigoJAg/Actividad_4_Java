import java.util.*;
import java.io.*;
public class AddressBook {
    private HashMap <String, String> Contactos = new HashMap<String, String>();
    private String name;

    AddressBook(String nombre){
        this.name = nombre;
    }

    public String getName() {
        return name;
    }

    public void load(String nombreLista){
        File csvFile = new File("./Contactos " + nombreLista + ".csv" );
        try {
            if (csvFile.createNewFile()) {
                System.out.println("Archivo creado");
            } else {

                System.out.println("Archivo cargado");
                Scanner scan = new Scanner(csvFile);
                while (scan.hasNextLine()){
                    String data = scan.nextLine();
                    String[] string = data.split(",");
                    String parte1 = string[0];
                    String parte2 = string[1];
                    Contactos.put(parte1, parte2);
                }
                scan.close();

            }
        }catch(IOException e){
            System.out.println("ERROR");
        }
    }

    public void save(String nombreLista){
        try {
            FileWriter Writer = new FileWriter("./Contactos " + nombreLista + ".csv");
            for(String i : Contactos.keySet()){
                Writer.write(i + "," + Contactos.get(i) + "\n");
                Writer.flush();

            }
            Writer.close();
        }catch (IOException e){
            System.out.println("ERROR");
        }

    }

    public void  create(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Escriba el numero primero y luego el nombre del contacto a crear: ");
        Contactos.put(scan.nextLine(),scan.nextLine());
    }

    public void list(String nombreLista){
        try {
            File csvFile = new File("./Contactos " + nombreLista + ".csv");
            Scanner scan = new Scanner(csvFile);
            System.out.println("Contactos de: " + nombreLista);
             while (scan.hasNextLine()){
                String data = scan.nextLine();

                System.out.println(data.replace(',', ':'));
            }
            scan.close();

        }catch (IOException  e){
            System.out.println("ERROR");
        }




    }

    public void delete(String nombreLista){
        Scanner scan = new Scanner(System.in);
        System.out.println("Escribe el numero del contacto a eliminar de la lista de contactos de " + nombreLista );
        String valor = scan.nextLine();

        Contactos.remove(valor);

    }

}
