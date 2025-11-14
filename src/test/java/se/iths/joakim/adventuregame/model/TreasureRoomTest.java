package se.iths.joakim.adventuregame.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import se.iths.joakim.adventuregame.view.FakeUI;

public class TreasureRoomTest {

    @Test
    public void openChestWhenHasFoundKey(){
        FakeUI fakeUI = new FakeUI();
        TreasureRoom treasureRoom = new TreasureRoom();
        Player player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        fakeUI.setInput("Ja");
        player.setFoundKey(true);
        treasureRoom.enterRoom(player,fakeUI);
        Assertions.assertTrue(player.hasOpenedChest());
    }
}
