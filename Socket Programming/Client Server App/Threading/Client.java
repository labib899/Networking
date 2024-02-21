import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
        System.out.println("Client started...");
        Socket socket=new Socket("127.0.0.1", 22222);
        System.out.println("Client connected...");

        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());

        while(true)
        {
            Scanner input=new Scanner(System.in); // taking input from console
            String message=input.nextLine();
            if(message.equals("exit")) break;
            oos.writeObject(message); // sending to server
            
            Object fromServer=(String) ois.readObject();
            System.out.println("From server: " + fromServer);
        }

        socket.close();
    }
}