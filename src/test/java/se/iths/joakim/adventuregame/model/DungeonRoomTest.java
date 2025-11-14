package se.iths.joakim.adventuregame.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import se.iths.joakim.adventuregame.view.FakeUI;

public class DungeonRoomTest {

    @Test
    public void attackAndDefeatEnemy(){
        DungeonRoom dungeonRoom = new DungeonRoom();
        FakeUI fakeUI = new FakeUI();
        Player player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        fakeUI.setInput("a");
        dungeonRoom.enterRoom(player,fakeUI);
        Assertions.assertTrue(player.hasDefeatedEnemy());

    }
}
