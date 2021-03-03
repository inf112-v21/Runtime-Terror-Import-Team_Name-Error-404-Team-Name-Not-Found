package inf112.skeleton.app.networking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

import java.util.ArrayList;
import java.util.Arrays;

public class Host {

    String hostName;
    int port;
    public final Server[] servers;
    public final String[] connected;
    private boolean playing = true;
    private final ServerSocket serverSocket;
    private String gameState;

    public Host(String hostName){
    ServerSocketHints serverH = new ServerSocketHints();
    this.hostName = hostName;
    this.port = 5009;
    this.serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, hostName, port, serverH);
    connected = new String[4];
    servers = new Server[4];
    Arrays.fill(connected, " ");
    gameState = "waiting";
    acceptNewSockets();


    }

    public void stop() {
        for(Server player: servers){
            if(player != null) {
                player.closeConnection();
            }
        }
        serverSocket.dispose();
        playing = false;
    }

    public String getGameState(){
        return gameState;
    }

    public String setGameState(){
        return gameState;
    }
}
