/**
 * Write a program that lists all the network interfaces of your machine (localhost).
 */
import java.net.*;
import java.util.*;
public class LabQuestion2 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()){
                NetworkInterface netInterface = networkInterfaces.nextElement();
                System.out.println("Network Interfaces : " + netInterface.getName());
            }
        }catch (SocketException exception){
            System.out.println(exception.getMessage());
        }
    }
}
