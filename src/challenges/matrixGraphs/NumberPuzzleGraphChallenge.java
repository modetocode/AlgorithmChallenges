package challenges.matrixGraphs;

import challenges.base.MatrixGraph;
import challenges.base.challenge.Challenge;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by ModeToCode on 21.02.2017.
 * Given a tile matrix, and given a list of blockers between tiles, find the optimal solution given the start and end position in the matrix.
 * Blocker: Not allowing a passage between two neighbouring tiles.
 * Optimal solution: minimal number of moves to reach from the start position to the end position.
 */
public class NumberPuzzleGraphChallenge implements Challenge<NumberPuzzleData, Optional<Integer>> {

    @Override
    public Optional<Integer> solve(NumberPuzzleData data) {
        MatrixGraph<Integer> graph = new MatrixGraph<>(data.getNumberOfRows() * data.getNumberOfColumns(), false);
        for (int i = 0; i < data.getNumberOfRows(); i++) {
            for (int j = 0; j < data.getNumberOfColumns(); j++) {
                int firstNodeIndex = getNodeIndex(i, j, data.getNumberOfColumns());

                // Right
                if(isValidIndex(i, j + 1, data.getNumberOfRows(), data.getNumberOfColumns())) {
                    int secondNodeIndex = getNodeIndex(i, j + 1, data.getNumberOfColumns());
                    graph.addNeighbour(firstNodeIndex, secondNodeIndex);
                }

                // Bottom
                if(isValidIndex(i + 1, j, data.getNumberOfRows(), data.getNumberOfColumns())) {
                    int secondNodeIndex = getNodeIndex(i + 1, j, data.getNumberOfColumns());
                    graph.addNeighbour(firstNodeIndex, secondNodeIndex);
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : data.getNodeIndexToNodeIndexBlockersMap().entrySet()) {
            int index = entry.getKey();
            List<Integer> blockerIndexList = entry.getValue();
            for (Integer blockerIndex : blockerIndexList) {
                graph.removeNeighbour(index, blockerIndex);
            }
        }

        int startNodeIndex = getNodeIndex(data.getStartRowIndex(), data.getStartColumnIndex(), data.getNumberOfColumns());
        int endNodeIndex = getNodeIndex(data.getEndRowIndex(), data.getEndColumnIndex(), data.getNumberOfColumns());
        return graph.breathFirstSearch(startNodeIndex, endNodeIndex);
    }

    private int getNodeIndex(int rowIndex, int columnIndex, int numberOfColumns) {
        return rowIndex * numberOfColumns + columnIndex;
    }

    private boolean isValidIndex(int rowIndex, int columnIndex, int numberOfRows, int numberOfColumns) {
        return rowIndex >= 0 && rowIndex < numberOfRows && columnIndex >= 0 && columnIndex < numberOfColumns;
    }
}
