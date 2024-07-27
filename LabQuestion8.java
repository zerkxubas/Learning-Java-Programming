/**
 * List three predefined cookie policy in Java.
 * Write a program in java, a cookie policy that blocks all .gov cookies but allows other domains.
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class LabQuestion8 {
    public static void main(String[] args) {
        // Create a HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // Create a HttpRequest
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://saidocorporation.com")).build();
        try{
            // Send the request
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            // Get cookies from the response headers
            List<String> cookiesHeader = response.headers().firstValue("Set-Cookie").stream().collect(Collectors.toList());
            // Filter cookies
            List<String> filteredCookies = cookiesHeader.stream()
                                            .filter(cookie -> !cookie.contains(".gov"))
                                            .collect(Collectors.toList());
            // Print filtered Cookies
            filteredCookies.forEach(System.out::println);
            System.out.println(filteredCookies);
        }catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
