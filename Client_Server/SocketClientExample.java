package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException,
            ClassNotFoundException, InterruptedException
    {
        // Get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        String hostIP = host.getHostAddress();
        int port = 6000;

        Socket clientSocket;
        ObjectInputStream in;
        ObjectOutputStream out;

        for (int i=0;i<5;i++) {
            // Establish socket connection to server
            clientSocket = new Socket(hostIP, port);
            System.out.println("[CLIENT] - Try to connected server: " + host + " on port " + port);

            // Write to socket using ObjectOutputStream
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            System.out.println("[CLIENT] - Sending request to Socket Server");

            if (i==4) out.writeObject("EXIT");
            else out.writeObject("Client " + i);

            // Read the server response message using ObjectInputStream
            // You will need to invoke getInputStream method using socket
            in = new ObjectInputStream(clientSocket.getInputStream());
            String message = (String) in.readObject();
            System.out.println("[CLIENT] - Message: " + message);

            // Close resources
            in.close();
            out.close();
            clientSocket.close();

        }

    }

}
