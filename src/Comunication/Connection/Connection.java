package Comunication.Connection;

import java.net.Socket;

public class Connection {
    private Socket socket;
    private String ip;

    public Connection(String ip){
        this.socket = null;
        this.ip = ip;
    }

    public boolean isValid(){
        return socket != null;
    }

    public void setSocket(Socket socket){
        this.socket = socket;
    }
}
