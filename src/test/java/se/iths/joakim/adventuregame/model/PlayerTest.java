package se.iths.joakim.adventuregame.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PlayerTest {

    @Test
    public void attack(){
        Player player = new Player.Builder()
                .name("Jocke")
                .health(100)
                .score(0)
                .strength(10)
                .build();
        Enemy enemy = new Enemy("vätte", 20, 20, 10);
        player.attack(enemy);
        Assertions.assertEquals(10, enemy.getHealth());
    }
}
