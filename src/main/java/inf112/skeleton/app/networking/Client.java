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
    private PrintWriter outPutStream;
    private BufferedReader inputStream;

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

    public String getPing(){
        return sendReceive("Ping");
    }

    public void closeHost(){
        sendReceive("stopHost");
    }

    public void closeConnection(){
        sendReceive("stopClient");
    }

    public String[] getPlayers() {
        String reply = sendReceive("getPlayers");
        return reply.split("-");
    }


    private String sendReceive(String msg){
        outPutStream.println(msg);
        String receive;
        try {
            receive = inputStream.readLine();
        } catch (IOException e) {
            receive = "bad";
        }
        if (receive == null) {
            receive = "bad";
        }
        return receive;
    }


}
