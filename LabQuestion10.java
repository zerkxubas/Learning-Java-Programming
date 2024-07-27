/**
 * Write a client side program for daytime service using socket.
 * Specify host name: "https://ntppool.org/zone/np"
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class LabQuestion10 {
    public static void main(String[] args) {
        String hostName = "time.nist.gov";
        int port = 13;
        try(
                Socket socket = new Socket(hostName, port);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ){
            String currentTime;
            while ((currentTime = reader.readLine()) != null){
                System.out.println("Current time from server: " + currentTime);
            }

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
