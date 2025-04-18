import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args){

        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("Server is running...");

            Socket client1 = serverSocket.accept();
            System.out.println("Client 1 connected: " + client1.getInetAddress());

            Socket client2 = serverSocket.accept();
            System.out.println("Client 2 connected: " + client2.getInetAddress());

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));

            PrintWriter writer1 = new PrintWriter(client1.getOutputStream(), true);
            PrintWriter writer2 = new PrintWriter(client2.getOutputStream(), true);

            writer1.println("You are connected to the server!");
            writer2.println("You are connected to the server!");

            // Close connections when done
            client1.close();
            client2.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
