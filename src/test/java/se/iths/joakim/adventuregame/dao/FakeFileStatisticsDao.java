package se.iths.joakim.adventuregame.dao;

import se.iths.joakim.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao{


    @Override
    public void save(Statistics stat) {
    }

    @Override
    public List<Statistics> loadAll() {
        List<Statistics> stats = new ArrayList<>();
        stats.add(new Statistics("Jocke", 120));
        stats.add(new Statistics("Annelie", 140));
        stats.add(new Statistics("Daniel", 100));
        stats.add(new Statistics("Calle", 80));
        return stats;
    }
}
