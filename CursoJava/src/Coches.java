import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*////////////////////////////////////////////////////////
             EJERCICIO DE AUTOS
////////////////////////////////////////////////////////
En la ciudad de Buenos Aires suceden muchos accidentes de transito, se realizo un estudio indicando las marcas de autos mas propensas a participar de dichos accidentes, las cuales son las siguientes:
- Audi
- Alfa Romeo
- Ferrari
- Ford
Para cada una de estas marcas, se esta realizando un analisis que nos permita entender cuales son los modelos que mas participaron. 
Se nos pidio desarrollar un programa que almacene y muestre lo siguiente: 
- De cada marca de autos, informar los modelos que participaron de los siniestros
- Informar tambien la velocidad maxima de cada uno de los modelos
DESARROLLAR un txt que muestre, ordenado alfabeticamente, las marcas y sus respectivos modelos y sus velocidades maximas permitidas. 
Almacenarlo en el branch de Desarrollo. 
"Los modelos son los siguientes:"
..
..
"Su velocidad permitida es la siguiente:"
..
..
*/

public class Coches {

	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\dsantiago\\git\\CursoJava\\CursoJava\\src\\MarcasyCoches.txt";
		String fileNameR = "C:\\Users\\dsantiago\\git\\CursoJava\\CursoJava\\src\\AccidentesCoches.txt";
        Path file = Paths.get(fileName);
        Path fileR = Paths.get(fileNameR);
        ArrayList<String> coches=leerArchivo(fileName);
        String[] splitText=null;
        ArrayList<String> marcas=new ArrayList<>();
        ArrayList<String> modelos=new ArrayList<>();
        ArrayList<String> velocidades=new ArrayList<>();
        ArrayList<Integer> siniestros=new ArrayList<>();
        Random rand = new Random(); 
        int limite = 50;
        int random = rand.nextInt(limite);
        
        for (int i=0;i<10;i++){
        	System.out.println(random);
        	siniestros.add(random);
        }
        
        for (int i=1;i<coches.size();i++) {
        	splitText=coches.get(i).split(" ");
        	for (int j=0;j<splitText.length;j++) {
        		if(j==0) {
        			marcas.add(splitText[j]);
        		}else if(j==1) {
        			modelos.add(splitText[j]);
        		}else {
        			velocidades.add(splitText[j]);
        		}
        	}
        }
        
        System.out.println(marcas);
        System.out.println(modelos);
        System.out.println(velocidades);
        
        String texto="Los modelos son los siguientes: \n";
        for (int i=0;i<modelos.size();i++) {
        	texto+="El coche "+marcas.get(i)+ " de modelo "+modelos.get(i)+" ha tenido "+siniestros.get(i)+" accidentes.\n";
        }
        texto+="Su velocidad permitida es la siguiente: \n";
        for (int i=0;i<modelos.size();i++) {
        	texto+="El coche "+marcas.get(i)+ " de modelo "+modelos.get(i)+" tiene  "+velocidades.get(i)+" de velocidad maxima.\n";
        }
        
        crearArchivo(fileR, texto);
        
	}

	public static ArrayList leerArchivo(String fileName) {
        ArrayList<String> marcas = new ArrayList<>();
        FileReader fr= null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String texto = br.readLine();
            while(texto != null){
            	marcas.add(texto);
                texto = br.readLine();
            }
            System.out.println(marcas);
            System.out.println("Acabamos de leer");
        } catch (Exception ex) {
            System.out.println("Error: Algo fallo al leer el archivo");
        } finally {
            try {
                if(br!=null) {
                    br.close();
                }
                if(fr!=null) {
                    fr.close();
                }

            } catch (IOException e) {
                System.out.println("Error: Algo fallo al cerrar el archivo");
            }
        }
        return marcas;
    }
	
	public static void crearArchivo(Path file, String texto){
        try {
            List<String> lines = Arrays.asList(texto);
            Files.write(file, lines, StandardCharsets.UTF_8);
        }catch (Exception ex){
            System.out.println("Error: Algo fallo al crear el archivo");
        }
    }
}
