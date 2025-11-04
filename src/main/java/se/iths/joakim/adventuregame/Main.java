package se.iths.joakim.adventuregame;

import se.iths.joakim.adventuregame.config.AppInfo;
import se.iths.joakim.adventuregame.dao.FileStatisticsDao;
import se.iths.joakim.adventuregame.dao.StatisticsDao;
import se.iths.joakim.adventuregame.model.Player;
import se.iths.joakim.adventuregame.model.StartRoom;
import se.iths.joakim.adventuregame.model.Statistics;
import se.iths.joakim.adventuregame.service.StatisticsService;
import se.iths.joakim.adventuregame.view.ScannerUI;
import se.iths.joakim.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();
        AppInfo appInfo = AppInfo.getInstance();
        ui.showMessage("Skapad av: " + appInfo.getProperty("app.author"));
        ui.showMessage("Version: " + appInfo.getProperty("app.version"));
        String name = ui.getInput("Ange ditt namn:");
        Player player = new Player.Builder()
                .name(name)
                .health(100)
                .score(0)
                .strength(10)
                .build();

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

