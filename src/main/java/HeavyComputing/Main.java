package HeavyComputing;

public class Main {

    //При решении задачи я выбрала Blocking IO
    //потому что в данной задачи параллельного взаимодействия
    //клиента и сервера (мы спрашиваем клиентом сервер один раз и ждём ответа )
    //и у нас один только клиент!
    public static void main(String[] args) {
        int port = 23444;
        String host = "127.0.0.1";
        String magicEnd = "end";

        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            server.serverJob(port,magicEnd);
        });
        serverThread.start();
        Client client = new Client();
        client.clientJob(host,port,magicEnd);
        System.out.println("Exiting");
    }
}
