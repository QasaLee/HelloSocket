import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    // constructor to put ip address and port
    public Client(String ipAddress, int port) {

        // Establish a connection
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connected!");

            // Takes input from terminal input
            input = new DataInputStream(System.in);

            // Sends output to the socket
            output = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
