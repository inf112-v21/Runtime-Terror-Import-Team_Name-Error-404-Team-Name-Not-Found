package inf112.skeleton.app.networking;

import com.badlogic.gdx.net.Socket;

import java.io.*;
import java.net.SocketException;

public class Server implements Runnable{

    private final Host host;
    private final Socket socketConnected;
    private final int num;
    private boolean connected = true;

    public Server(Host host, Socket connected, int num) {
        this.host = host;
        this.socketConnected = connected;
        this.num = num;
        String clientIP = connected.getRemoteAddress();
        host.playersConnected[num] = clientIP;
    }

    private String ping() {
        return "Pong";
    }

    public void closeConnection() {
        host.playersConnected[num] = " ";
        socketConnected.dispose();
        Thread.currentThread().interrupt();
        connected = false;
    }

    private void closeHost() {
        host.stop();
        closeConnection();
    }

    private String getPlayers() {
        StringBuilder reply = new StringBuilder();
        for (String connection : host.playersConnected) {
            reply.append(connection);
            reply.append(" ,");
        }
        return reply.toString();
    }

    private String[] parse(String msg) {
        try {
            return msg.split(",");
        } catch (NullPointerException e) {
            return new String[]{""};
        }
    }

    private String getGameState() {
        return host.getGameState();
    }

    private void setGameStatus(String gameState) {
        host.setGameState(gameState);
    }


    public void run(){
        InputStream input = socketConnected.getInputStream();
        DataOutputStream output = new DataOutputStream(socketConnected.getOutputStream());
        BufferedReader bufferedinput = new BufferedReader(new InputStreamReader(input));
        while (connected) {
            try {
                String commands = bufferedinput.readLine();
                String[] command = parse(commands);
                String order = command[0];
                String reply;
                switch (order) {
                    case "ping":
                        reply = ping();
                        break;
                    case "stopClient":
                        reply = "closeing connection";
                        closeConnection();
                    case "stopHost":
                        reply = "closeing host";
                        closeHost();
                    case "getPlayers":
                        reply = getPlayers();
                    case "getGameState":
                        reply = getGameState();
                    case "setStart":
                        setGameStatus("start");
                        reply = "Starting";
                    default:
                        reply = "Error 404";
                        break;
                }
                // Send server reply to client
                output.writeBytes(reply);
                output.flush();
            } catch (SocketException e) {
                closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        }
    }
}
