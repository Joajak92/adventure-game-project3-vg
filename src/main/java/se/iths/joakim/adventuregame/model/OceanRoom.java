package se.iths.joakim.adventuregame.model;

import se.iths.joakim.adventuregame.view.UI;

public class OceanRoom implements Room{

    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du är nu ute i ett stormigt hav!");
        String choice = ui.getInput("Vill du (d)yka eller (r)ettirera?");

        if(choice.equalsIgnoreCase("d")) {
            player.dive();
        }

    }
}
