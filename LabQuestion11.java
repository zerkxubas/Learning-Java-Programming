/**
 * Write a program to find the TCP/UDP ports running in your local machine.
 * Hint: use class name -> LowPortScanner((1-1024)) scan up to 65535
 * and use DatagramSocket for UDP and socket for TCP
 */
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

public class LabQuestion11 {
    public static void main(String[] args) {
        int startPort = 1, endPort = 1024;
        System.out.println("Scanning TCP Ports...");
        for (int port = startPort; port<= endPort; port++){
            try(Socket socket = new Socket()){
                socket.connect(new InetSocketAddress("localhost",port),200);
                System.out.println("TCP port " + port + " is open.");
            }catch (IOException exception){
                System.out.println(exception.getMessage());
            }
        }
        
        System.out.println("Scanning UDP Ports...");
        for (int port = startPort; port<= endPort; port++){
            try(DatagramSocket datagramSocket = new DatagramSocket(port)) {
                datagramSocket.setSoTimeout(200);
                datagramSocket.connect(new InetSocketAddress("localhost",port));
                System.out.println("UDP port " + port + " is open.");
            }catch (IOException exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
