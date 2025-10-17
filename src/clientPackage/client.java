package clientPackage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import sharePackage.Operation;

public class client {

    public static void main(String[] args) throws Exception {
        System.out.println("Je suis un client pas encore connecté...");
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Je suis connecté");
        Scanner scanner = new Scanner(System.in);


        System.out.println("Donner le premier opérande: ");
        double operand1 = scanner.nextDouble();

        System.out.println("Donner l'opérateur (+, -, *, /): ");
        String operator = scanner.next();

        System.out.println("Donner le deuxième opérande: ");
        double operand2 = scanner.nextDouble();


        Operation operation = new Operation(operand1, operator, operand2);


        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(operation);
        oos.flush();


        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        double result = ois.readDouble();

        System.out.println("Le résultat de " + operation + " = " + result);

        socket.close();
        scanner.close();
    }
}