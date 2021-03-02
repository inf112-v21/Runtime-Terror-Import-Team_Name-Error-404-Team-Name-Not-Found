package inf112.skeleton.app.networking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;

import java.util.ArrayList;

public class Host {
    String hostName;
    int port;
    ArrayList<String> connected;

    public Host(String hostName){
    ServerSocketHints serverH = new ServerSocketHints();
    this.hostName = hostName;
    this.port = 5009;
    ServerSocket serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, hostName, port, serverH);
    connected = new ArrayList<String>(4);


    }
}
