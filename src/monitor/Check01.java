//information at https://www.udemy.com/java-multithreading/#lecture/107238
package monitor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

class Runner extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {

            try {
                System.out.println("Hello. This is itteration #" + i + "\n it is on thread #" + Thread.currentThread() + " \n");
                for (int j = 0; j < 10; j++) {
                    System.out.println("The value of j in " + Thread.currentThread() + " = " + j);
                }
                int code;
                URL t = new URL("http://www.google.com/");
                HttpURLConnection conn = (HttpURLConnection) t.openConnection();
                conn.setRequestMethod("GET");  //conn.setRequestMethod ("HEAD") or ("GET"); 
                conn.connect();
                code = conn.getResponseCode();
                System.out.println(t + "Status - " + code + "(Thread " + Thread.currentThread() + " )");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

public class Check01 {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();


        Runner runner2 = new Runner();
        runner2.start();


        Runner runner3 = new Runner();
        runner3.start();

    }
}
