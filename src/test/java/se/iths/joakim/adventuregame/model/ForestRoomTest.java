package se.iths.joakim.adventuregame.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import se.iths.joakim.adventuregame.view.FakeUI;

public class ForestRoomTest {

    @Test
    public void testHasFoundKey(){
        ForestRoom forestRoom = new ForestRoom();
        FakeUI fakeUI = new FakeUI();
        Player player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        fakeUI.setInput("Ja");
        forestRoom.enterRoom(player,fakeUI);
        Assertions.assertTrue(player.hasFoundKey());
    }
}
