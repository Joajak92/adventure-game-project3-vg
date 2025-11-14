package se.iths.joakim.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.joakim.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class MountainRoomTest {

    private Player player;
    private FakeUI fakeUI;
    private MountainRoom mountainRoom;

    @BeforeEach
    void setUp() {
        fakeUI = new FakeUI();
        mountainRoom = new MountainRoom();
        player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void attackAndDefeatGiant() {
        fakeUI.setInput("a");
        mountainRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(player.hasDefeatedGiant());
    }
}