import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.*;
import java.net.Socket;

public class Ref
{
    public static void main(String[] args) 
    {
        Field[] clientFields=Client.class.getDeclaredFields();
        Method[] clientMethods=Client.class.getDeclaredMethods();
        Class[] clientClasses=Server.class.getDeclaredClasses();

        Field[] serverFields=Server.class.getDeclaredFields();
        Method[] serverMethods=Server.class.getDeclaredMethods();
        Class[] serverClasses=Server.class.getDeclaredClasses();

        Field[] ThreadFields=ServerThread.class.getDeclaredFields();
        Method[] ThreadMethods=ServerThread.class.getDeclaredMethods();
        Class[] ThreadClasses=ServerThread.class.getDeclaredClasses();

        for(Field x:clientFields) System.out.println(x.getName());
        for(Method x:clientMethods) System.out.println(x.getName());
        for(Class x:clientClasses) System.out.println(x.getName());

        for(Field x:serverFields) System.out.println(x.getName());
        for(Method x:serverMethods) System.out.println(x.getName());
        for(Class x:serverClasses) System.out.println(x.getName());

        for(Field x:ThreadFields) System.out.println(x.getName());
        for(Method x:ThreadMethods) System.out.println(x.getName());
        for(Class x:ThreadClasses) System.out.println(x.getName());
    }
}
