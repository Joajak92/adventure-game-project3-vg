package se.iths.joakim.adventuregame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.joakim.adventuregame.dao.FileStatisticsDao;
import se.iths.joakim.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockStatisticsServiceTest {

    @Mock
    FileStatisticsDao mockDao;

    @InjectMocks
    private StatisticsService statisticsService;

    @Test
    public void testMockLoadAndGetSortedStatistics() {
        List<Statistics> mockStats = new ArrayList<>();
        mockStats.add(new Statistics("Jocke", 130));
        mockStats.add(new Statistics("Annelie", 90));
        mockStats.add(new Statistics("Steffe", 110));
        when(mockDao.loadAll()).thenReturn(mockStats);
        List<Statistics> sortedStats = statisticsService.getSortedStatistics();

        Assertions.assertEquals(3, sortedStats.size());

        Assertions.assertEquals("Jocke", sortedStats.get(0).getPlayerName());
        Assertions.assertEquals(130, sortedStats.get(0).getScore());

        Assertions.assertEquals("Annelie", sortedStats.get(2).getPlayerName());
        Assertions.assertEquals(90, sortedStats.get(2).getScore());

        Assertions.assertEquals("Steffe", sortedStats.get(1).getPlayerName());
        Assertions.assertEquals(110, sortedStats.get(1).getScore());
    }
}
