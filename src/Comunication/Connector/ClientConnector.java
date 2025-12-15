package Comunication.Connector;

public class ClientConnector implements Runnable{

    public ClientConnector(){
        
    }

    @Override
    public void run() {
        while (true){


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
