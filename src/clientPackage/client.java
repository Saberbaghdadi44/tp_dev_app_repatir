package clientPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws Exception
    {
        System.out.println("Je suis un client pas encore connecté...");
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Je suis connecté");

        Scanner s = new Scanner(System.in);
        System.out.println("donner le premier opérande ");
        int operand1 = s.nextInt();
        System.out.println("donner l'opérateur (+, -, *, /) ");
        char operator = s.next().charAt(0);
        System.out.println("donner le deuxième opérande ");
        int operand2 = s.nextInt();
        OutputStream os = socket.getOutputStream();
        os.write(operand1);
        os.write(operator);
        os.write(operand2);
        os.flush();
        InputStream is = socket.getInputStream();
        int result = is.read();
        System.out.println("le résultat est " + result);

        s.close();
        socket.close();
    }
}
