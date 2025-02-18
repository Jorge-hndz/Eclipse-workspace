package Refactoizacion;
import java.util.*;

public class EjercicioArrays {
    public static void main(String[] args) {
        int numAlumnos = 40;
        Integer[] control = new Integer[numAlumnos];
        int[] practicas = new int[numAlumnos];
        float[] calificaciones = new float[numAlumnos];
        float[] estadistica = new float[10];
        int[] aprobados = new int[numAlumnos];
        int[] suspensos = new int[numAlumnos];
        int maxNota = 0, minNota = 10;

        for (int i = 0; i < numAlumnos; i++) {
            control[i] = (int) (Math.random() * 11);
            practicas[i] = (int) (Math.random() * 11);
            calificaciones[i] = (control[i] + practicas[i]) / 2.0f;
            if (control[i] > maxNota) maxNota = control[i];
            if (control[i] < minNota) minNota = control[i];
        }

        List<Integer> notas = Arrays.asList(control);
        int indMinNota = notas.indexOf(minNota) + 1;
        int indMaxNota = notas.indexOf(maxNota) + 1;

        System.out.println("Mínimo: " + minNota + " (índice: " + indMinNota + ")");
        System.out.println("Máximo: " + maxNota + " (índice: " + indMaxNota + ")");
        System.out.println("Notas: " + notas);
        System.out.println("Prácticas: " + Arrays.toString(practicas));
        System.out.println("Calificaciones: " + Arrays.toString(calificaciones));

        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (float nota : calificaciones) {
                if (nota > i && nota <= i + 1) count++;
            }
            estadistica[i] = (float) count / numAlumnos * 100;
            System.out.println("Estadística nota <= " + (i + 1) + " = " + Math.round(estadistica[i] * 100.0) / 100.0 + "%");
        }

        int countAprobados = 0, countSuspensos = 0;
        for (int i = 0; i < numAlumnos; i++) {
            if (calificaciones[i] >= 5) aprobados[countAprobados++] = i + 1;
            else suspensos[countSuspensos++] = i + 1;
        }

        System.out.println("Aprobados: " + Arrays.toString(Arrays.copyOf(aprobados, countAprobados)));
        System.out.println("Suspensos: " + Arrays.toString(Arrays.copyOf(suspensos, countSuspensos)));

        double[] calif = new double[numAlumnos];
        for (int i = 0; i < 31; i++) calif[i] = (int) (Math.random() * 11);
        System.out.println("Nota antigua alumno nº4: " + calif[3]);
        calif[3] = 6;
        System.out.println("Nota nueva alumno nº4: " + calif[3]);
    }
}
