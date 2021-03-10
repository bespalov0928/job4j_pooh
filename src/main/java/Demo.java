import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        Executors.newFixedThreadPool(2);
        Server server = new Server();
        //запускаем сервер и ждем пакеты
        Thread thredServer = new Server();
       thredServer.start();


        //клиент отправляет пакет  на сервер
        System.out.println("firstClient");
        Thread thredClient = new Thread(
                () -> {
                    System.out.println(thredServer.getState());
                    try {
                        new Client("localhost", 5006).start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //System.out.println("server.start()");
                    //server.start();
                });
        thredClient.start();

        //клиент получает ответ от сервера
        //Client consumer = new Client(new Socket("localhost", 5000));
    }
}
