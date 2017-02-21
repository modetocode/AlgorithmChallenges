package test.matrixGraphs;

import challenges.base.IntegerPair;
import challenges.base.Pair;
import challenges.matrixGraphs.NumberPuzzleData;
import challenges.matrixGraphs.NumberPuzzleGraphChallenge;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ModeToCode on 21.02.2017.
 */
public class NumberPuzzleGraphChallengeTest {

    private NumberPuzzleGraphChallenge numberPuzzleGraphChallenge;

    @Before
    public final void setUp() {
        numberPuzzleGraphChallenge = new NumberPuzzleGraphChallenge();
    }

    @Test
    public void solve_SmallMatrixNoBorders_BestSolution() {
        setUp();
        //arrange
        int numberOfRows = 3;
        int numberOfColumns = 3;
        Map<Integer, List<Integer>> nodeIndexToNodeIndexBlockersMap = new HashMap<>();
        int startRowIndex = 0;
        int startColumnIndex = 0;
        int endRowIndex = 2;
        int endColumnIndex = 2;
        NumberPuzzleData numberPuzzleData = new NumberPuzzleData(numberOfRows, numberOfColumns, nodeIndexToNodeIndexBlockersMap, startRowIndex, startColumnIndex, endRowIndex, endColumnIndex);
        Integer expectedResult = 4;

        //act
        Optional<Integer> actualResult = this.numberPuzzleGraphChallenge.solve(numberPuzzleData);

        //assert
        Assert.assertTrue(actualResult.isPresent());
        Assert.assertEquals(expectedResult, actualResult.get());
    }

    @Test
    public void solve_SmallMatrixWithBorders_BestSolution() {
        setUp();
        //arrange
        int numberOfRows = 3;
        int numberOfColumns = 3;
        List<IntegerPair> blockersList =
            Stream.of(
                new IntegerPair(0, 1), new IntegerPair(3, 4))
                .collect(Collectors.toList());
        Map<Integer, List<Integer>> nodeIndexToNodeIndexBlockersMap = generateNodeIndexToNodeIndexBlockersMap(blockersList);
        int startRowIndex = 0;
        int startColumnIndex = 0;
        int endRowIndex = 0;
        int endColumnIndex = 2;
        NumberPuzzleData numberPuzzleData = new NumberPuzzleData(numberOfRows, numberOfColumns, nodeIndexToNodeIndexBlockersMap, startRowIndex, startColumnIndex, endRowIndex, endColumnIndex);
        Integer expectedResult = 6;

        //act
        Optional<Integer> actualResult = this.numberPuzzleGraphChallenge.solve(numberPuzzleData);

        //assert
        Assert.assertTrue(actualResult.isPresent());
        Assert.assertEquals(expectedResult, actualResult.get());
    }

    @Test
    public void solve_SmallMatrixWithBorders_NoSolution() {
        setUp();
        //arrange
        int numberOfRows = 3;
        int numberOfColumns = 3;
        List<IntegerPair> blockersList =
                Stream.of(
                        new IntegerPair(4, 1), new IntegerPair(4, 3), new IntegerPair(4, 7), new IntegerPair(4, 5))
                        .collect(Collectors.toList());
        Map<Integer, List<Integer>> nodeIndexToNodeIndexBlockersMap = generateNodeIndexToNodeIndexBlockersMap(blockersList);
        int startRowIndex = 0;
        int startColumnIndex = 0;
        int endRowIndex = 1;
        int endColumnIndex = 1;
        NumberPuzzleData numberPuzzleData = new NumberPuzzleData(numberOfRows, numberOfColumns, nodeIndexToNodeIndexBlockersMap, startRowIndex, startColumnIndex, endRowIndex, endColumnIndex);

        //act
        Optional<Integer> actualResult = this.numberPuzzleGraphChallenge.solve(numberPuzzleData);

        //assert
        Assert.assertTrue(!actualResult.isPresent());
    }

    private Map<Integer, List<Integer>> generateNodeIndexToNodeIndexBlockersMap(List<IntegerPair> blockersList) {
        Map<Integer, List<Pair<Integer>>> nodeIndexToNodeIndexPairBlockersMap = blockersList.stream().collect(Collectors.groupingBy(Pair::getFirstElement));
        Map<Integer, List<Integer>> nodeIndexToNodeIndexBlockersMap = new HashMap<>();
        for (Map.Entry<Integer, List<Pair<Integer>>> entry : nodeIndexToNodeIndexPairBlockersMap.entrySet()) {
            Integer nodeIndex = entry.getKey();
            List<Pair<Integer>> pairList = entry.getValue();
            List<Integer> blockedNodeList = pairList.stream().map(Pair::getSecondElement).collect(Collectors.toList());
            nodeIndexToNodeIndexBlockersMap.put(nodeIndex, blockedNodeList);
        }

        return nodeIndexToNodeIndexBlockersMap;
    }
}
