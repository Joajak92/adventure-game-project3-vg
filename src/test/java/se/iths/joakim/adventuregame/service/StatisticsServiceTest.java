package se.iths.joakim.adventuregame.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.joakim.adventuregame.dao.FakeFileStatisticsDao;
import se.iths.joakim.adventuregame.model.Statistics;

import java.util.Comparator;
import java.util.List;

public class StatisticsServiceTest {

    @Test
    public void testGetSortedStatistics() {
        FakeFileStatisticsDao fakeStatsDao = new FakeFileStatisticsDao();
        List<Statistics> statsList = fakeStatsDao.loadAll();
        statsList.sort(Comparator.comparingInt(Statistics::getScore).reversed());

        Assertions.assertEquals("Annelie", statsList.get(0).getPlayerName());
        Assertions.assertEquals(140, statsList.get(0).getScore());

        Assertions.assertEquals("Jocke", statsList.get(1).getPlayerName());
        Assertions.assertEquals(120, statsList.get(1).getScore());

    }
}
