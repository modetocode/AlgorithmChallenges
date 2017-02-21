package challenges.matrixGraphs;

import java.util.List;
import java.util.Map;

/**
 * Created by ModeToCode on 21.02.2017.
 */
public class NumberPuzzleData {

    private final int numberOfRows;
    private final int numberOfColumns;
    private Map<Integer, List<Integer>> nodeIndexToNodeIndexBlockersMap;
    private final int startRowIndex;
    private final int startColumnIndex;
    private final int endRowIndex;
    private final int endColumnIndex;

    public NumberPuzzleData(int numberOfRows, int numberOfColumns, Map<Integer, List<Integer>> nodeIndexToNodeIndexBlockersMap, int startRowIndex, int startColumnIndex, int endRowIndex, int endColumnIndex) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.nodeIndexToNodeIndexBlockersMap = nodeIndexToNodeIndexBlockersMap;
        this.startRowIndex = startRowIndex;
        this.startColumnIndex = startColumnIndex;
        this.endRowIndex = endRowIndex;
        this.endColumnIndex = endColumnIndex;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public Map<Integer, List<Integer>> getNodeIndexToNodeIndexBlockersMap() {
        return nodeIndexToNodeIndexBlockersMap;
    }

    public int getStartRowIndex() {
        return startRowIndex;
    }

    public int getStartColumnIndex() {
        return startColumnIndex;
    }

    public int getEndRowIndex() {
        return endRowIndex;
    }

    public int getEndColumnIndex() {
        return endColumnIndex;
    }
}
