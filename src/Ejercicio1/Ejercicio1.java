package Ejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        ProcessBuilder pB = new ProcessBuilder();
        Scanner sc = new Scanner(System.in);

        pB.command("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        try {
            System.out.println("Introduce número de ventanas:");
            int numVentanas = sc.nextInt();
            ArrayList <Process> arrayProcesos = new ArrayList<Process>();

            for (int i = 0; i < numVentanas; i++) {
                Process process = pB.start();
                arrayProcesos.add(process);
            }

            for (Process process: arrayProcesos) {
                while (process.isAlive()){
                    process.waitFor();
                }
            }



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        sc.close();

    }
}
