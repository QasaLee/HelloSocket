import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

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
                line = input.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        // Modify this to get up to speed with the deprecated readLine() method:
//        DataInputStream in = new DataInputStream(System.in);
//        // Change "DataInputStream d = new DataInputStream(in);" into:
//        BufferedReader d
//                = new BufferedReader(new InputStreamReader(in));



    }

}
