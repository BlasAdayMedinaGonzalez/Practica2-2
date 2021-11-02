package Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        ProcessBuilder pB = new ProcessBuilder();
        Scanner sc = new Scanner(System.in);
        String ruta = sc.next();
        File file = new File(ruta);

        if ( file.exists()) {
            pB.command("powershell.exe", "cat", ruta);

            try {
                Process process = pB.start();
                BufferedReader bfR = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linea = "";
                while ((linea = bfR.readLine()) != null) {
                    System.out.println(linea);
                }
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El fichero no existe");
        }
    }
}
