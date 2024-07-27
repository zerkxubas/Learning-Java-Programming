/**
 * Write a program that uses the HEAD request method and prints the last time a file on a server
 * was modified (any url of a file like image or docs etc)
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class LabQuestion9 {
    public static void main(String[] args) {
        String fileUrl = "https://jp.saidocorporation.com/wp-content/uploads/2024/03/web-bannewwwqr.png";
        try{
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            long lastModifiedDate = connection.getLastModified();
            if (lastModifiedDate == 0){
                System.out.println("Last modified HEAD info is not available.");
            }else{
                Date date = new Date(lastModifiedDate);
                System.out.println("File URL : " + fileUrl);
                System.out.println("Last Modified Date: "+ date);
            }
            connection.disconnect();
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
