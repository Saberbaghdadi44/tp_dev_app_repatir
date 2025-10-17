package serverPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import sharePackage.Operation;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket socketServer = new ServerSocket(1234);
        System.out.println("Je suis un serveur en attente de la connexion d'un client...");
        while (true) {
            Socket socket = socketServer.accept();
            System.out.println("Un client est connecté");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Operation operation = (Operation) ois.readObject();
            System.out.println("Opération reçue: " + operation);
            double result = calculate(operation);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeDouble(result);
            oos.flush();
            System.out.println("Résultat envoyé: " + result);
            socket.close();}}
    private static double calculate(Operation operation) {
        double operand1 = operation.getOperand1();
        double operand2 = operation.getOperand2();
        String operator = operation.getOperator();
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division par zéro");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Opérateur non supporté: " + operator);
        }
    }
}