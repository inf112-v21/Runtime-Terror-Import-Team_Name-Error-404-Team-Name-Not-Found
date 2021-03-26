package inf112.skeleton.app.networking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

import java.io.*;

public class Client {

    private final String hostIP;
    private final int port;
    private PrintWriter outPutStream;
    private BufferedReader inputStream;

    public Client(String hostIP, int port){
        SocketHints socketHints = new SocketHints();
        this.hostIP = hostIP;
        this.port = port;
        Socket client = Gdx.net.newClientSocket(Net.Protocol.TCP, hostIP, port, socketHints); // How to do this

        inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outPutStream = new PrintWriter(client.getOutputStream(), true);
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

    public void ready() {
        sendReceive("ready");
    }

    public String[] getPlayers() {
        String reply = sendReceive("getPlayers");
        return reply.split(",");
    }

    public String getGameState() {
        return sendReceive("getGameState");
    }

    public void setGameState(String state){
        sendReceive(state);
    }


    private String sendReceive(String msg){
        outPutStream.println(msg);
        String reply;
        try {
            reply = inputStream.readLine();
        } catch (IOException e) {
            reply = "bad";
        }
        if (reply == null) {
            reply = "bad";
        }
        System.out.println(reply);
        return reply;
    }


}
