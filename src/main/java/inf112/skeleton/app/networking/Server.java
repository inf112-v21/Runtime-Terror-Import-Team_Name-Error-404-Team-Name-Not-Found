package inf112.skeleton.app.networking;

import com.badlogic.gdx.net.Socket;

import java.io.*;

public class Server {

    private final Host host;
    private final Socket socketConnected;
    private final int num;
    private boolean connected = true;

    public Server(Host host, Socket connected, int num){
        this.host = host;
        this.socketConnected = connected;
        this.num = num;
        String clientIP = connected.getRemoteAddress();
        host.connected[num] = clientIP;
    }

    private String ping() {
        return "Pong";
    }

    public void closeConnection() {
        host.connected[num] = " ";
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
        for(String connection : host.connected) {
            reply.append(connection);
            reply.append(" -");
        }
        return reply.toString();
    }


    public void play() throws IOException {
        InputStream input = socketConnected.getInputStream();
        DataOutputStream output = new DataOutputStream(socketConnected.getOutputStream());
        BufferedReader bufferedinput = new BufferedReader(new InputStreamReader(input));


        while (connected){
            String command = bufferedinput.readLine();
            String reply;
            switch (command) {
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
                default:
                    reply = "Error 404";
                    break;
            }
            // Send server reply to client
            output.writeBytes(reply);
            output.flush();
        }

    }
}
