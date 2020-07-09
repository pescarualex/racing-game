package org.fasttrackit.persistence;

public interface RankingRepository {

    void addRankingItem(int rank, String competitorName, double tolalDistance);

    void close();
}
