package Ejercicio2;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Ejercicio2 {
    public static void main(String[] args) {
        ProcessBuilder pB = new ProcessBuilder();
        Scanner sc = new Scanner(System.in);
        ArrayList <Process> processArrayList = new ArrayList<Process>();

        pB.command("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        try {
            System.out.println("Indique número de ventanas: ");
            int numVen = sc.nextInt();

            for (int i = 0; i < numVen; i++) {
                Process process = pB.start();
                processArrayList.add(process);
                ProcessHandle.Info infoProcees = process.info();
                System.out.println("Se ha creado el proceso: " + process.pid()
                        + ", a la hora: " + LocalTime.now());
            }

            for (Process proceso: processArrayList) {
                proceso.waitFor(3000, TimeUnit.MILLISECONDS);
                System.out.println("Ha finalizado el proceso: " + proceso.pid()
                        + ", a la hora: " + LocalTime.now());
                proceso.destroy();
            }
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
