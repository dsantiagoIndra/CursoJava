import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/*Acceder mediante el cmd (o su equivalente) del sistema al repositorio local de su proyecto y generar una nueva rama que se llame 
"DESARROLLO"
Luego, generar un programa sobre dicha rama desde el IDE y actualizarlo en el repositorio remoto (Github). 
El programa debe hacer lo siguiente:
Desarrollar un bot que te pregunte como te sentis el día de hoy, y en base a las siguientes posibilidades haga una accion
1. Triste -> Cuenta un chiste
2. Alegre -> "Enhorabuena"
3. Nervioso -> Mensaje de calma
TIP: A los chistes los pueden almacenar en un array y usar el metodo RANDOM para contar un chiste aleatorio. 
El programa tiene que tener un mensaje de bienvenida, donde te pregunte tu nombre previamente y te informe la fecha actual.
ENTREGABLES: 
Link del repositorio con el codigo almacenado. 
Captura del CMD mostrando la generacion de la rama. 
(!) EL CODIGO DEBE ESTAR ALMACENADO EN LA RAMA "DESARRROLLO (!)*/


public class Emociones {
	
	public static void main(String[] args) {
		
		Scanner captura = new Scanner(System.in);
		Date date = new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(df.format(date));
        ArrayList<String> chistes = new ArrayList<>();
        chistes.add("-¿Por qué las focas del circo miran siempre hacia arriba?\n"+ "-Porque es donde están los focos.\n");
        chistes.add("-¡Estás obsesionado con la comida!\n"+ "-No sé a que te refieres croquetamente.\n");
        chistes.add("-¿Por qué estás hablando con esas zapatillas?\n"+ "-Porque pone converse.\n");
        chistes.add("-¿Sabes cómo se queda un mago después de comer?\n"+ "-Magordito.\n");
        chistes.add("-Buenos días, me gustaría alquilar Batman Forever.\n"+ "-No es posible, tiene que devolverla tomorrow.\n");
        Random rand = new Random(); 
        int limite = chistes.size();
        int random = rand.nextInt(limite);
		
		System.out.println("¡Bienvenido al programa de las emociones!");
        System.out.println("Introduce tu nombre: ");
        String nombre=captura.nextLine();
        System.out.println("Tu nombre es " + nombre);
        System.out.println("La fecha del dia de hoy es " + df.format(date));
        System.out.println("¿Como te sientes hoy?");
        String sentimiento=captura.next();
        switch (sentimiento){
	        case "Triste":
	        	System.out.println("No solucionara sus problemas, pero este chiste le animará.\n");
	            System.out.println(chistes.get(random));
	            System.out.println("Jijijiiji");
	            break;
	        case "Alegre":
	            System.out.println("¡¡Enhorabuena!!");
	            break;
	        case "Nervioso":
	            System.out.println("Tranquilo, que todo va a ir bien.");
	            break;
    }
        
        
	}
}
