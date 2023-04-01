import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class PhysicalAddress {

    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            byte[] mac = ni.getHardwareAddress();

            System.out.println("Host name : "+ address.getHostName());
            System.out.println("Host IP address : "+ address.getHostAddress());

            StringBuilder sb = new StringBuilder();
            for (int i=0;i<mac.length;i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println("MAC Address: " + sb);

        } catch (UnknownHostException e) {
            System.out.println("Not fount URL");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }

}
