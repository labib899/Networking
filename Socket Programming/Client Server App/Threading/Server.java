import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException 
    {
        ServerSocket serverSocket=new ServerSocket(22222);
        System.out.println("Server started...");

        while(true)
        {
            Socket socket=serverSocket.accept();
            System.out.println("Client connected...");
            new ServerThread(socket);
        }
    }
}

class ServerThread implements Runnable
{   
    Socket clientSocket;
    Thread t;

    ServerThread(Socket clientSocket) // constructor
    {
        this.clientSocket=clientSocket;
        t=new Thread(this);
        t.start();
    }

    public void run()
    {
        try 
        {
            ObjectInputStream ois=new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos=new ObjectOutputStream(clientSocket.getOutputStream());

            while(true)
            {
                Object clientMessage=ois.readObject(); // reading from client
                if(clientMessage==null) break;
                System.out.println("From Client: " + (String)clientMessage);

                String serverMessage=(String) clientMessage;
                serverMessage=serverMessage.toUpperCase();
                oos.writeObject(serverMessage); // sending to client
            }
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        try 
        {
            clientSocket.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}