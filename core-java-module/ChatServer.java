import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started. Waiting for client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Client: " + inputLine);
            System.out.print("Server: ");
            String response = stdIn.readLine();
            out.println(response);
        }

        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
