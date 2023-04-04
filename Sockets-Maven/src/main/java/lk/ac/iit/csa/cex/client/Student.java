package lk.ac.iit.csa.cex.client;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * Student is a client that needs to pay the tuition fee to the University
 * for 5COSC022C.2 Client-Server Architectures (IIT Sri Lanka) 
 * import necessary packages. 
 * if your code does not compile your grade will be downgraded to zero. 
 * You can overwrite/change the code lines if you need to.
 * You can use the hints from your IDE
*/
public class Student {

    private static Socket socket;

    public static void main(String args[]) {
		try {

			int universityPort = 23044;
			//get the IP address of the your local machine by using the name of the pc.


			//Create a socket connection
            /*
			Please be careful about the order of parameters that you want to use
			in the socket, otherwise, you will get constructor error
			*/
			socket = new Socket("localhost",universityPort);


			//Get output stream using socket
			OutputStream os = socket.getOutputStream();

			//Create an output stream writer object
			//You may need OutputStream as a parameter
			OutputStreamWriter osw = new OutputStreamWriter(os);

			//Create a buffered writer object
			//You may need OutputStreamWriter Object as a parameter
			BufferedWriter bw  = new BufferedWriter(osw);

			//You need to money transfer the tution fee.

			//The write the message to the buffer with UoW Number , module code and tution fee amount
			//You submit the tution fee with three data points.
			//it should have the module code for Client-Server Architectures, student uow id, and tution fee
			//Tution fee amount is the numerical digits of the UoW number without decimals
			//The write the message to the buffer
			Integer tutionFee = 100;
			String studentUoWId = "w1911221";
			String moduleCode = "5COSC022C";
			String tutionFeeMessage = studentUoWId + moduleCode + tutionFee + "\n";

			bw.write (tutionFee);
			bw.flush ();

			//print a message to the log to show that the tution fee value was sent to the server
			System.out.println("Tuition fee value was sent to the server");

			//Receiving reply message back from the server.
			//The reply would be a receipt number
			//Get input stream using socket
			//Define input stream reader
			//Define buffer reader

			InputStream is = socket.getInputStream();
            InputStreamReader isr  = new InputStreamReader(is);
            BufferedReader br  = new BufferedReader(isr);
			String message = br.readLine();
			//print the received message from the server to the log
			System.out.println("SERVER send : " + message);

		}
		//Catch the appropriate exceptions and write a suitable message to the log
		//there could be more than one.
		catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
//		catch (................ e) {
//		  System.out.println(.....);
//		}
//		catch (................ e) {
//		  System.out.println(....);
//		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			try {
				//write code to close the socket
				socket.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
    }
}
