package se.iths.joakim.adventuregame.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import se.iths.joakim.adventuregame.view.FakeUI;

public class TreasureRoomTest {

    @Test
    public void openChestIfHasKey(){
        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("Ja");
        TreasureRoom treasureRoom = new TreasureRoom();
        Player player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        player.setFoundKey(true);
        treasureRoom.enterRoom(player,fakeUI);
        Assertions.assertTrue(player.hasOpenedChest());
    }
}
