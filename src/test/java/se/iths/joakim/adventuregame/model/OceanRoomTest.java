package se.iths.joakim.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.joakim.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class OceanRoomTest {
    private Player player;
    private FakeUI fakeUI;
    private OceanRoom oceanRoom;

    @BeforeEach
    void setUp() {
        fakeUI = new FakeUI();
        oceanRoom = new OceanRoom();
        player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void diveAndFindGoldNugget() {
        fakeUI.setInput("d");
        oceanRoom.enterRoom(player, fakeUI);
        Assertions.assertTrue(player.hasFoundGoldNugget());
    }
}