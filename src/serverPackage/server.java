package serverPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception
    {
        ServerSocket socketServer = new ServerSocket(5000);
        System.out.println("Je suis un serveur en attente la connexion d'un client ");
        Socket socket = socketServer.accept();
        System.out.println("un client est connecté");
        InputStream is = socket.getInputStream();
        int operand1 = is.read();
        int operatorByte = is.read();
        int operand2 = is.read();

        char operator = (char) operatorByte;
        System.out.println("Opération reçue: " + operand1 + " " + operator + " " + operand2);

        int result = 0;
        switch(operator){
            case '+': result = operand1 + operand2; break;
            case '-': result = operand1 - operand2; break;
            case '*': result = operand1 * operand2; break;
            case '/':
                if(operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    result = 0;
                }
                break;
        }
        OutputStream os = socket.getOutputStream();
        os.write(result);
        System.out.println("Résultat envoyé: " + result);

        socket.close();
        socketServer.close();
    }
}