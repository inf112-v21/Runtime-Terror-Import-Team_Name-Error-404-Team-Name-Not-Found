package inf112.skeleton.app.game;

import inf112.skeleton.app.networking.Client;

public class HostGame {
    private final Client client;

    public HostGame(Client client) {
        this.client = client;
        this.client.setGameState("start");
    }
}
