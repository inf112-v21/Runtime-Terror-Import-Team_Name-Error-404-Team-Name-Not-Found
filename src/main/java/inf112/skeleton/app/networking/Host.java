package inf112.skeleton.app.networking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;

import java.util.Arrays;

public class Host {

    String hostName;
    int port;
    public final Server[] servers;
    public final String[] playersConnected;
    private boolean playing = true;
    private final ServerSocket serverSocket;
    private String gameState;

    public Host(String hostName){
    ServerSocketHints serverH = new ServerSocketHints();
    this.hostName = hostName;
    this.port = 5009;
    this.serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, hostName, port, serverH);
    playersConnected = new String[4];
    servers = new Server[4];
    Arrays.fill(playersConnected, " ");
    gameState = "waiting";

        while(playing) {
            Socket socketConnected;
            synchronized (serverSocket){
                try {
                    socketConnected = serverSocket.accept(null);
                    System.out.print("Connection established: ");
                    System.out.println(socketConnected.getRemoteAddress());
                } catch (com.badlogic.gdx.utils.GdxRuntimeException e) {
                    System.out.println("no connection");
                    playing = false;
                    break;
                }
            }

            for (int i = 0; i < 8; i++) {
                if (playersConnected[i].equals(" ")) {
                    Server server = new Server(this, socketConnected, i);
                    Thread thread = new Thread((Runnable) server);
                    servers[i] = server;
                    thread.setName(String.format("Player %d", i));
                    thread.start();
                    break;
                } else if (i == 7) {
                    System.out.println("Lobby is full");
                }
            }
        }
        System.out.println("closeing");
    }


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
        return this.gameState;
    }

    public void setGameState(String gameState){
        this.gameState = gameState;
    }
}
