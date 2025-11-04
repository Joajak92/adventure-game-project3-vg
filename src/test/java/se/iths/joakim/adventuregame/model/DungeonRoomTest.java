package se.iths.joakim.adventuregame.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import se.iths.joakim.adventuregame.view.FakeUI;

public class DungeonRoomTest {

    @Test
    public void attackAndDefeatEnemy(){
        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");
        Player player = new Player.Builder()
                .name("Jocke")
                .health(100)
               .score(0)
                .strength(10)
                .build();
        DungeonRoom dungeonRoom = new DungeonRoom();
        dungeonRoom.enterRoom(player,fakeUI);
        Assertions.assertTrue(player.hasDefeatedEnemy());

    }
}
