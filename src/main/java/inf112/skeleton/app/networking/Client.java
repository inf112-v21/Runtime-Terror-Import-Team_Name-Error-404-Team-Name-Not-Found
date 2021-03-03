package inf112.skeleton.app.networking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

import java.io.*;

public class Client {

    private final String hostname_adress;
    private final int port;
    private static Socket socket;
    private PrintWriter sending;
    private BufferedReader incoming;

    public Client(String hostName, int port){
        SocketHints socketHints = new SocketHints();
        this.hostname_adress = hostName;
        this.port = port;
        this.socket = Gdx.net.newClientSocket(Net.Protocol.TCP, hostname_adress, port, socketHints); // How to do this
        
        setup_sockets();
    }

    private void setup_sockets(){
        this.inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.outPutStream = new PrintWriter(socket.getOutputStream(), true);
    }

    private void sendReceive(String msg){
        String receive;
        try {
            receive = incoming.readLine();
        } catch (java.net.SocketException e) {
            receive = "bad";
        } catch (IOException e) {

        }
    }


}
