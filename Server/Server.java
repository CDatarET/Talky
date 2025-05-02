import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args){

        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("Server is running...");

            Socket client1 = serverSocket.accept();
            System.out.println("Client 1 connected: " + client1.getInetAddress());

            BufferedReader reader1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));

            PrintWriter writer1 = new PrintWriter(client1.getOutputStream(), true);

            writer1.println("You are connected to the server!");

            String line;
            while(((line = reader1.readLine()) != null)){
                System.out.println("client1: "+line);
            }
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
