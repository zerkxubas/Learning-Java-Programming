/**
 * Test the characteristics of a given IP Address
 * a) 127.0.0.1
 * b) 0::1 (loopback | global | unicast)
 */
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
public class LabQuestion5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an IP Address: ");
        String ip = scanner.nextLine();

        try{
            InetAddress address = InetAddress.getByName(ip);
            if (address.getHostAddress().contains(":")){
                System.out.println("The ip address " + ip + " is IPV6.");
            }else{
                System.out.println("The ip address " + ip + " is IPV4.");
            }

            if (address.isLoopbackAddress()){
                System.out.println("The ip address " + ip + " is a loopback address.");
            }else if (address.isSiteLocalAddress()){
                System.out.println("The ip address " + ip + " is a site-local address.");
            } else if (address.isLinkLocalAddress()) {
                System.out.println("The ip address " + ip + " is a link-local address.");
            } else if (isGlobalUnicast(address)) {
                System.out.println("The ip address " + ip + " is a global unicast address.");
            }else{
                System.out.println("The ip address " + ip + " has an unknown characteristics.");
            }
        }catch (UnknownHostException exception){
            System.out.println(exception.getMessage());
        }
    }

    // Static method isGlobalUnicast()
    private static boolean isGlobalUnicast(InetAddress address)
    {
        return !address.isLoopbackAddress() &&
                !address.isLinkLocalAddress() &&
                !address.isSiteLocalAddress() &&
                !address.isMulticastAddress();
    }
}
