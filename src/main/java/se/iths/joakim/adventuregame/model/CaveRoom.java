package se.iths.joakim.adventuregame.model;

import se.iths.joakim.adventuregame.view.UI;

public class CaveRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går in i en mörk grotta, när du kommit in en bit ser du en drake!");
        Dragon dragon = new Dragon("Drake", 20,0,15);

        while (player.isAlive() && dragon.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)ettirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(dragon);
                ui.showMessage("Du attackerade draken! Drakens HP är: " + dragon.getHealth());
                if(dragon.isAlive()) {
                    dragon.attack(player);
                    ui.showMessage("Draken attackerade dig! Ditt HP är: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade draken!");
                    player.setDefeatedDragon(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du springer ifrån draken!");
                break;
            }
        }
    }
}
