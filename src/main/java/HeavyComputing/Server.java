package HeavyComputing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void serverJob(int port, String magicEnd) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return;
        }
        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String input = in.readLine();
                System.out.println("Server get \'" + input + "\'");
                if (magicEnd.equals(input)) {
                    System.out.println("Exiting");
                    return;
                }
                int countFromClient = Integer.parseInt(input);

                if (countFromClient == 1 || countFromClient == 2) {
                    out.println(1);
                } else {
                    int fibo = fib(countFromClient);
                    out.println(fibo);
                }
                input = in.readLine();
                System.out.println("Server get \'" + input + "\'");
                if (magicEnd.equals(input)) {
                    System.out.println("Exiting");
                    return;
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public int fib(int n) {
        int fim2 = 0;
        int fim1 = 1;
        int fi = fim2 + fim1;
        for (int i = 2; i < n; i++) {
            fim2 = fim1;
            fim1 = fi;
            fi = fim1 + fim2;
        }
        return fi;
    }
}
