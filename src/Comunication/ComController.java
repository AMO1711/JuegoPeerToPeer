package Comunication;

import Comunication.Connection.Connection;
import Comunication.Connector.ClientConnector;
import Comunication.Connector.ServerConnector;

import java.net.Socket;

public class ComController {
    private final Connection connection;
    private final ClientConnector clientConnector;
    private final ServerConnector serverConnector;
    private final String ip;
    private final int localPort1 = 10000, localPort2 = 10001;

    public ComController(String ip, int serverPort, int clientPort){
        this.ip = ip;
        connection = new Connection(ip);
        clientConnector = new ClientConnector(this, clientPort, serverPort, ip);
        serverConnector = new ServerConnector(this, serverPort, clientPort);

        inicializar();
    }

    public boolean isValid(){return connection.isValid();}

    public boolean isValid(Socket socket){
        boolean isValid = connection.isValid();

        if (!isValid){
            setSocket(socket);
        }

        return isValid;
    }

    public void setSocket(Socket socket){connection.setSocket(socket);}

    public int getAvailablePort(){
        int port;

        while (!serverConnector.isConected()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        port = serverConnector.getActualPort();

        if (port == localPort2){
            return localPort1;
        } else {
            return localPort2;
        }
    }

    private void inicializar(){
        serverConnector.run();
        clientConnector.run();
    }
}
