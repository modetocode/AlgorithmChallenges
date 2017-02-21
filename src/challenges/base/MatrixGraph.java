package challenges.base;

import java.util.*;

/**
 * Created by ModeToCode on 21.02.2017.
 */
public class MatrixGraph<E> implements Graph<E> {

    private static final int NO_NEIGHBOUR_VALUE = -1;
    private static final int IS_NEIGHBOUR_VALUE = 0;

    private final int numberOfNodes;
    private final boolean isDirectedGraph;
    private E[] graphNodes;
    private int[][] neighbourMatrix;

    public MatrixGraph(int numberOfNodes, boolean isDirectedGraph) {
        this.numberOfNodes = numberOfNodes;
        this.graphNodes = (E[]) new Object[numberOfNodes];
        this.neighbourMatrix = new int[numberOfNodes][];
        for (int i = 0; i < numberOfNodes; i++) {
            this.neighbourMatrix[i] = new int[numberOfNodes];
            Arrays.fill(this.neighbourMatrix[i], NO_NEIGHBOUR_VALUE);
        }

        this.isDirectedGraph = isDirectedGraph;
    }

    public void addNeighbour(int i, int j) {
        this.validateIndex(i);
        this.validateIndex(j);
        this.neighbourMatrix[i][j] = IS_NEIGHBOUR_VALUE;
        if (isDirectedGraph) {
            return;
        }

        this.neighbourMatrix[j][i] = IS_NEIGHBOUR_VALUE;
    }

    public void removeNeighbour(int i, int j) {
        this.validateIndex(i);
        this.validateIndex(j);
        this.neighbourMatrix[i][j] = NO_NEIGHBOUR_VALUE;
        if(isDirectedGraph) {
            return;
        }

        this.neighbourMatrix[j][i] = NO_NEIGHBOUR_VALUE;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= numberOfNodes) {
            throw new IllegalArgumentException();
        }
    }

    public Optional<Integer> breathFirstSearch(int startNodeIndex, int endNodeIndex) {
        this.validateIndex(startNodeIndex);
        this.validateIndex(endNodeIndex);
        boolean[] isVisited = new boolean[this.numberOfNodes];
        int[] cost = new int[this.numberOfNodes];
        Arrays.fill(isVisited, false);
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<Integer> futureNodesQueue  = new LinkedList<>();
        futureNodesQueue.add(startNodeIndex);
        cost[startNodeIndex] = 0;
        while (!futureNodesQueue.isEmpty()) {
            int currentNodeIndex = futureNodesQueue.remove();
            int currentNodeCost = cost[currentNodeIndex];
            isVisited[currentNodeIndex] = true;
            if (currentNodeIndex == endNodeIndex) {
                return Optional.of(currentNodeCost);
            }

            for (int neighbourIndex : getNeighbourIndexes(currentNodeIndex)) {
                if (isVisited[neighbourIndex]) {
                    continue;
                }

                futureNodesQueue.add(neighbourIndex);
                cost[neighbourIndex] = currentNodeCost + 1;
            }
        }

        return Optional.empty();
    }

    private List<Integer> getNeighbourIndexes(int nodeIndex) {
        List<Integer> neighboursIndexList = new LinkedList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            if (this.neighbourMatrix[nodeIndex][i] == IS_NEIGHBOUR_VALUE) {
                neighboursIndexList.add(i);
            }
        }

        return neighboursIndexList;
    }
}
