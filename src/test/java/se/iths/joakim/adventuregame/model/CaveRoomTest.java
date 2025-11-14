package se.iths.joakim.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.joakim.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class CaveRoomTest {

    private Player player;
    private FakeUI fakeUI;
    private CaveRoom caveRoom;

    @BeforeEach
    void setUp() {
        fakeUI = new FakeUI();
        caveRoom = new CaveRoom();
        player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void attackAndDefeatDragon() {
        fakeUI.setInput("a");
        caveRoom.enterRoom(player,fakeUI);
        Assertions.assertTrue(player.hasDefeatedDragon());
    }
}