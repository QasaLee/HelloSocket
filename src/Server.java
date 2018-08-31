import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // Initialize Socket and input Stream
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream inputStream;

    // Constructor with port
    public Server(int port) {

        // Starts ser and waits for a connection
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server side connection STARTED!");
            System.out.println("Waiting for a client ...");

            socket = serverSocket.accept(); // Attention: pay attention.
            System.out.println("Client accepted");

            // Takes input from the client socket
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            // Reads message from client until "over" is sent
            while (!line.equals("over")) {
                try {
                    line = inputStream.readUTF();
                    System.out.println(line);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            // Close the connection
            System.out.println("Closing the connection: ...");
            socket.close();
            inputStream.close();
            serverSocket.close(); // Attention: It should've not existed!


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
