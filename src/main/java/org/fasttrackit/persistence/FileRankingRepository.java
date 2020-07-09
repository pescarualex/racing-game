package org.fasttrackit.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileRankingRepository implements RankingRepository{

    private final BufferedWriter bufferedWriter;

    public FileRankingRepository() {
        //relative path vs absolute path
        String filePath = "target/rankings" + System.currentTimeMillis();
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create rankings file.");
        }
    }

    @Override
    public void addRankingItem(int rank, String competitorName, double tolalDistance) {
        String rankingItem = rank + ". " + competitorName + ": " + tolalDistance + " km";

        try {
            bufferedWriter.write(rankingItem);
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write ranking item to file" + rankingItem);
        }

    }

    @Override
    public void close() {
        try {
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException("Failed to save ranking files.");
        }

    }
}
