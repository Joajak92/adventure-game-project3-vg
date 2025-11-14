package se.iths.joakim.adventuregame.model;

import se.iths.joakim.adventuregame.view.UI;

public class MountainRoom implements Room {

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du går runt bland de höga bergen, plötsligt ser du en stor Jätte!");
        Giant giant = new Giant("Giant", 20,0,10);

        while (player.isAlive() && giant.isAlive()) {
            String choice = ui.getInput("Vill du (a)ttackera eller (r)ettirera?");
            if (choice.equalsIgnoreCase("a")) {
                player.attack(giant);
                ui.showMessage("Du attackerade jätten! Jättens HP är: " + giant.getHealth());
                if(giant.isAlive()) {
                    giant.attack(player);
                    ui.showMessage("Jätten attackerade dig! Ditt HP är: " + player.getHealth());
                } else {
                    ui.showMessage("Du besegrade jätten!");
                    player.setDefeatedGiant(true);
                }
            } else if (choice.equalsIgnoreCase("r")) {
                ui.showMessage("Du fintar jätten och springer ifrån utan att han ser dig!");
                break;
            }
        }
    }
}
