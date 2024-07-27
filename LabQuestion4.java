/**
 * Write a program to determine whether an IP address is IPV4 or IPV6
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class LabQuestion4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an IP address: ");
        String ipAddress = scanner.nextLine();

        try{
            InetAddress address = InetAddress.getByName(ipAddress);
            if (address instanceof java.net.Inet4Address){
                System.out.println("The ip address " + ipAddress + " is IPV4.");
            } else if (address instanceof  java.net.Inet6Address) {
                System.out.println("The ip address " + ipAddress + " is IPV6.");
            }else{
                System.out.println("IP address type is not recognized.");
            }

        }catch (UnknownHostException exception)
        {
            System.out.println(exception.getMessage());
        }

        scanner.close();
    }
}
