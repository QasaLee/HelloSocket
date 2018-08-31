import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    // MARK: - Field:

    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    // constructor to put ip address and port
    public Client(String ipAddress, int port) {
        // Establish a connection
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Client Side Connection Started!");

            // Takes input from terminal input
            input = new DataInputStream(System.in);

            // Sends output to the socket
            output = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException unknownHoseException) {
            System.out.println(unknownHoseException);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // String to read message from input
        String line = "";


        // Keep reading until "Over" is input
        while (!line.equals("over")) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                line = reader.readLine();

                output.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Close the connection
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
