/**
 * Write a program to parse the given URL/split the URL
 * Hint: Parse protocol or schema, user info, host address, port, path, ref, query string
 * a) "https://www.example.com:80/index.html"
 * b) "ftp://mp3:mp3@138.247.121.61:21000/c%3a/"
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class LabQuestion6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a URL: ");
        String urlString = scanner.nextLine();
        try{
            URL url = new URL(urlString);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("User Info: " + (url.getUserInfo() != null ? url.getUserInfo() : "Not present"));
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + (url.getPort() != -1 ? url.getPort() : "Default"));
            System.out.println("Path: " + (url.getPath() != null ? url.getPath() : "Not present"));
            System.out.println("Reference (Fragment): " + (url.getRef() != null ? url.getRef() : "Not present"));
            System.out.println("Query: " + (url.getQuery() != null ? url.getQuery() : "Not present"));
        }catch (MalformedURLException exception){
            System.out.println("Invalid URL. "+ exception.getMessage());
        }
    }
}
