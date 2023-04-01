package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {

    // Create static ServerSocket variable
    private static ServerSocket serverSocket;

    // Create socket server port on which it will listen
    private static int port = 6000;

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        // create the socket server object using the port
        serverSocket = new ServerSocket(port);

        // Keep listens indefinitely until receives 'exit' call or program terminates
        while (true) {
            System.out.println("[SERVER] - Waiting for the client request");

            // Creating socket and waiting for client connection – Accept the connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("[SERVER] - Client connected from " + clientSocket.getInetAddress().getHostAddress());

            // Read from socket to ObjectInputStream object.
            ObjectInputStream clientMessage = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("[SERVER] - Get message from client");

            // Convert ObjectInputStream object to String
            String message = (String) clientMessage.readObject();
            System.out.println("[SERVER] - Message Received: " + message);

            // Create ObjectOutputStream object
            ObjectOutputStream sendMessege = new ObjectOutputStream(clientSocket.getOutputStream());

            // Write object to Socket
            sendMessege.writeObject("[SERVER] - Hi Client " + message);

            // Close resources and socket
            clientSocket.close();
            clientMessage.close();
            sendMessege.close();

            // Terminate the server if client sends exit request
            if (message.equalsIgnoreCase("EXIT")) break;
        }
        System.out.println("[SERVER] - Shutting down socket server!!");

        // Close the ServerSocket object
        serverSocket.close();

    }

}
