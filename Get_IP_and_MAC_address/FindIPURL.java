import java.net.InetAddress;
import java.net.UnknownHostException;

class FindIPURL{
    public static void main(String[] args) {
        String host = "google.com";
        try {
            InetAddress address = InetAddress.getByName(host);
            String ip = address.getHostAddress();

            System.out.println("IP Address of "+ host + " : " + ip);

        } catch (UnknownHostException ex) {
            System.out.println("Invalid URL");
        }
    }
}