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


    // While playeing, aka venter på folk å koble på
        // Hvis vi får en ny tilkobling:
            // Legge til i spiller listen vår, altså legg til socket i listen over spiller som  er koblet på
            // Da har vi en åpen socket til andre spillere i en liste.
            // Dette har fordi da kan serveren pushe endringer til alle spillere
            // og spillere kan gi sine moves/trekk til serveren

    // 1 server med mange koblet til
        // Server har brettet og all spill-logikk og sender oppdateringer til alle klienter, for løkke
        // Server har brett-klassen alstå og oppdaterer brettet og sender på en måte endringene til hver klient
        // ^^  Det tror jeg er vanskelig
    }


    public void acceptNewSockets(){
        while(playing) {
            Socket socketConnected;
            synchronized (serverSocket){
                try {
                    socketConnected = serverSocket.accept(null);
                    System.out.print("client connected: ");
                    System.out.println(socketConnected.getRemoteAddress());
                } catch (com.badlogic.gdx.utils.GdxRuntimeException e) {
                    playing = false;
                    break;
                }
            }

            for (int i = 0; i < 4; i++) {
                if (connected[i].equals(" ")) {
                    Server server = new Server(this, socketConnected, i);
                    servers[i] = server;
                    break;
                } else if (i == 3) {
                    System.out.println("lobby full");
                }
            }
        }
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
