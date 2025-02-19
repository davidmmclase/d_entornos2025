import java.util.Arrays;
import java.util.List;

public class EjercicioDeArrays{
    public static void main(String[] args){
        int numAlumnos = 40;
        int[] control = new int[numAlumnos], practicas = new int[numAlumnos];
        float[] calificaciones = new float[numAlumnos];
        int[] listaClase = new int[numAlumnos];
        
        genNotas(control, practicas, calificaciones, numAlumnos);
        iniLista(listaClase);
        mostrarInfo(control, practicas, calificaciones, listaClase);
        calcEstadisticas(calificaciones, numAlumnos);
        procAprobados(calificaciones, numAlumnos);
        modNota();
    }

    // notas aleatorias, calcular min y max
    public static void genNotas(int[] control, int[] practicas, float[] calificaciones, int numAlumnos){
        int minNota = 11, maxNota = 0, indMinNota = 0, indMaxNota = 0;

        for(int i=0; i<numAlumnos; i++){
            control[i] = (int) (Math.random()*11);
            practicas[i] = (int) (Math.random()*11);
            calificaciones[i] = (control[i] + practicas[i])/2f;
            
            if(control[i] < minNota){
                minNota = control[i];
                indMinNota = i+1;
            }else if(control[i] > maxNota){
                maxNota = control[i];
                indMaxNota = i+1;
            }
        }
        
        System.out.println("Mínimo es: " + minNota + " (Alumno " + indMinNota + ")");
        System.out.println("Máximo es: " + maxNota + " (Alumno " + indMaxNota + ")\n");
    }

    // lista de clase
    public static void iniLista(int[] listaClase){
        for(int i=0; i<listaClase.length; i++){listaClase[i] = i+1;}
    }

    // info notas
    public static void mostrarInfo(int[] control, int[] practicas, float[] calificaciones, int[] listaClase){
        System.out.println("Lista de clase : " + Arrays.toString(listaClase));
        System.out.println("Array de Notas : " + Arrays.toString(control));
        System.out.println("Prácticas      : " + Arrays.toString(practicas));
        System.out.println("Calificaciones : " + Arrays.toString(calificaciones) + "\n");
    }

    // estadísticas de calificaciones
    public static void calcEstadisticas(float[] calificaciones, int numAlumnos){
        float[] estadistica = new float[10];
        
        for(int i=0; i<10; i++){
            int count = 0;
            for(float calificacion : calificaciones){
                if(calificacion > i && calificacion <= i+1){count++;}
            }
            estadistica[i] = (count/(float) numAlumnos)*100;
            System.out.println("Estadística nota tramo <= " + (i+1) + ": " + Math.round(estadistica[i] * 100.0) / 100.0 + "%");
        }
    }

    // aprobados y suspensos
    public static void procAprobados(float[] calificaciones, int numAlumnos){
        int[] aprobados = new int[numAlumnos], suspensos = new int[numAlumnos];
        int countAprobados = 0, countSuspensos = 0;

        for(int i=0; i<numAlumnos; i++){
            if(calificaciones[i] >= 5){aprobados[countAprobados++] = i+1;}
            else{suspensos[countSuspensos++] = i+1;}
        }
        
        int[] a = Arrays.copyOfRange(aprobados, 0, countAprobados);
        int[] s = Arrays.copyOfRange(suspensos, 0, countSuspensos);
        
        System.out.println("\nResumen de aprobados por nº de lista: " + Arrays.toString(a));
        System.out.println("Resumen de suspensos por nº de lista: " + Arrays.toString(s));
    }

    // mod nota
    public static void modNota(){
        double[] calif = new double[40];
        for(int j=0; j<31; j++){calif[j] = (int) (Math.random()*11);}
        System.out.println("\nNota anterior alumno nº4: " + calif[3]);
        System.out.println("Nota nueva alumno nº4: " + (calif[3]=6));
    }
}
