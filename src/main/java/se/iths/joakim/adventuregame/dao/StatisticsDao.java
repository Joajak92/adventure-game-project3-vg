package se.iths.joakim.adventuregame.dao;

import se.iths.joakim.adventuregame.model.Statistics;

import java.util.List;

public interface StatisticsDao {
    void save(Statistics stat);

    List<Statistics> loadAll();
}

