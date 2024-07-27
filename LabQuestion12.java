/**
 * Write a program to display the socket information
 * address, port, local address, local port.
 */
import java.io.IOException;
import java.net.Socket;

public class LabQuestion12 {
    public static void main(String[] args) {
        String hostname = "example.com";
        int port = 80;
        try(Socket socket = new Socket(hostname,port)){
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());
            System.out.println("Local Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
