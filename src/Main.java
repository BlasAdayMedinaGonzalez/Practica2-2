import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProcessBuilder pB = new ProcessBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce número de ventanas");
        int numVentanas = sc.nextInt();

        pB.command("cmd.exe", "/c" ,"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "www.google.com");
        try {
            Process process = null;
            for (int i = 0; i < numVentanas; i++) {
                process = pB.start();
            }
            System.out.println(process.isAlive());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
