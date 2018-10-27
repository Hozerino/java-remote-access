import java.net.Socket;

public class ClientConnection implements Runnable {

    private Connection connection;

    protected ClientConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            while(true) {
                ServerMessageHandler.handleIncomingMessage(connection.readMessage(), this);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

