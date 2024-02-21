import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {   
        ServerSocket serverSocket=new ServerSocket(22222); // defining server socket
        System.out.println("Server started...");

        while(true)
        {
            Socket socket=serverSocket.accept(); // dedicated socket for client
            System.out.println("Client connected...");

            ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());

            Object clientMessage=ois.readObject(); // reading from client
            System.out.println("From Client: " + (String)clientMessage);

            String serverMessage=(String) clientMessage;
            serverMessage=serverMessage.toUpperCase();
            oos.writeObject(serverMessage); // sending to client
        }
    }
}