import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal{
        public static void main(String[] arg){
                Usuario[] usuarios = añadirUsuarios();
		System.out.println("¡Hola mundo!");
                fechaHoraActual();
		mostrarUsuarios(usuarios);
        }
        public static void fechaHoraActual(){
                LocalDateTime fecha = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("// dd/MM/YYYY \\\\ | ( hh:mm:ss )");
                        System.out.println(fecha.format(formato));
    	}
	public static Usuario[] añadirUsuarios(){
		Scanner teclado = new Scanner(System.in);

		System.out.println("NÚMERO DE USUARIOS PARA AÑADIR: ");
		int total = teclado.nextInt();

		teclado.nextLine();

		Usuario[] usuarios = new Usuario[total];
		for(int i=0; i<total; i++){
			System.out.println("DATOS DE USUARIOS no." + (i+1) + ("Nombre, apellidos, email): "));
			String nombre = teclado.nextLine();
			String apellidos = teclado.nextLine();
			String email = teclado.nextLine();
			usuarios[i] = new Usuario(nombre, apellidos, email);
		}
	return usuarios;
	}
	public static void mostrarUsuarios(Usuario[] usuarios) {
	System.out.println("\nINFORMACIÓN USUARIOS: ");
	for(int i=0; i<usuarios.length; i++){
		System.out.println("Usuario: " + (i + 1) + ": ");
		System.out.println("Nombre: " + usuarios[i].nombre);
		System.out.println("Apellidos: " + usuarios[i].apellidos);
		System.out.println("Email: " + usuarios[i].email);
		System.out.println();
        }
    }
}

