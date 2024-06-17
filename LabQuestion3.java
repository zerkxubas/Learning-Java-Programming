/**
 * Write a program to get and print the IP address of the given named host:
 * www.scst.edu.np, www.google.com, www.facebook.com
 */
import java.net.*;
public class LabQuestion3 {
    public static void printIpAddress(String hostname){
        try{
            InetAddress address = InetAddress.getByName(hostname);
            System.out.println(address);
        }catch (UnknownHostException exception){
            System.out.println(exception.getMessage());
        }
    }
    public static void main(String[] args){
        String sagarmatha = "www.scst.edu.np";
        String google = "www.google.com";
        String facebook = "www.facebook.com";
        printIpAddress(sagarmatha);
        printIpAddress(google);
        printIpAddress(facebook);
    }
}
