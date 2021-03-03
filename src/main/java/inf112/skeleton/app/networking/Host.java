package inf112.skeleton.app.networking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

import java.util.ArrayList;

public class Host {

    String hostName;
    int port;
    private ArrayList<Server> players;
    ArrayList<String> connected;
    private boolean playing = true;
    private final ServerSocket serverSocket;

    public Host(String hostName){
    ServerSocketHints serverH = new ServerSocketHints();
    this.hostName = hostName;
    this.port = 5009;
    this.serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, hostName, port, serverH);
    connected = new ArrayList<String>(4);

    while(playing) {
        Socket socketConnected;
        synchronized (serverSocket){
            socketConnected = serverSocket.accept(null);
            System.out.print("client connected: ");
            System.out.println(socketConnected.getRemoteAddress());
        }

        for (int i = 0; i < 4; i++) {
            Server server = new Server(this, socketConnected, i);
            Thread thread = new Thread((Runnable) server);
            players.set(i, server);
            thread.setName(String.format("player %d", i));
            thread.start();
            break;
        }
    }

    }

    public void stop() {
        for(Server player: players){
            if(player != null) {
                player.closeConnection();
            }
        }
        serverSocket.dispose();
        playing = false;
    }
}
