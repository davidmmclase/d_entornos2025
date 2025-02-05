import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal{
        public static void main(String[] arg){
                System.out.println("¡Hola mundo!");
                fechaHoraActual();
        }
        public static void fechaHoraActual() {
                LocalDateTime fecha = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("// dd/MM/YYYY \\\\ | ( hh:mm:ss )");
                        System.out.println(fecha.format(formato));
    }
}
