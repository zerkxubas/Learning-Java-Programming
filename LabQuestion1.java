/**
 * Write a program to find the Ip Address and MAC Address of your local machine.
 * Hint : use getter or factory method
 */
import java.net.*;
public class LabQuestion1 {
    public static void main(String[] args) {
        try {
            InetAddress address1 = InetAddress.getLocalHost();
            // calling the customized method getMacAddress()
            String macAddress = getMacAddress(address1);
            System.out.println("IP Address : " + address1);
            System.out.println("MAC Address : " + macAddress);

        }catch (SocketException | UnknownHostException exception){
            System.out.println(exception.getMessage());
        }
    }
    private static String getMacAddress(InetAddress address) throws SocketException{
        NetworkInterface network = NetworkInterface.getByInetAddress(address);
        byte[] macArray = network.getHardwareAddress();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < macArray.length; i++){
            stringBuilder.append(String.format("%02X%s", macArray[i], (i < macArray.length - 1) ? "-" : ""));
        }
        return stringBuilder.toString();
    }
}
