package HeavyComputing;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void clientJob (String host, int port,String magicEnd){

        Socket socket = null;
        try {
            socket =   new Socket(host,port);
        }catch (IOException ioException) {
            ioException.printStackTrace();
            return;
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println(" Введите целое число: ");
            int countFromClient = scanner.nextInt();
            out.println(countFromClient);
            String input = in.readLine();
            System.out.println("Client get \'" + input + "\'");
            System.out.println("The server calculated. The answer is  " + input);
            out.println(magicEnd);
            out.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
