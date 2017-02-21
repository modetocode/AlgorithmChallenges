package test.lists;

import challenges.lists.IsListAcyclicChallenge;
import org.junit.Before;
import org.junit.Test;
import util.generator.GeneratorUtil;
import util.generator.IntegerGenerator;
import util.generator.ListGenerator;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertTrue;

/**
 * Created by ModeToCode on 14.02.2017.
 */
public class IsListAcyclicChallengeTest {

    private IsListAcyclicChallenge<Integer> isListAcyclicChallenge;
    private IntegerGenerator generator;

    @Before
    public void init() {
        this.isListAcyclicChallenge = new IsListAcyclicChallenge<>();
        this.generator = GeneratorUtil.getDefaultIntegerGenerator();
    }

    @Test
    public void isListAcyclic_SmallAcyclicList_True(){
        //Arrange
        List<Integer> smallAcyclicList = ListGenerator.generateList(100, this.generator);

        //Act
        Boolean result = isListAcyclicChallenge.solve(smallAcyclicList);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isListAcyclic_LargeAcyclicList_True(){
        //Arrange
        List<Integer> largeAcyclicList = ListGenerator.generateList(100000, this.generator);

        //Act
        Boolean result = isListAcyclicChallenge.solve(largeAcyclicList);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isListAcyclic_NullList_Null(){
        //Arrange
        List<Integer> list = null;

        //Act
        Boolean result = isListAcyclicChallenge.solve(list);

        //Assert
        assertNull(result);
    }

    @Test
    public void isListAcyclic_EmptyList_True(){
        //Arrange
        List<Integer> list = new LinkedList<>();

        //Act
        Boolean result = isListAcyclicChallenge.solve(list);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isListAcyclic_OneElementList_True(){
        //Arrange
        List<Integer> oneElementList = ListGenerator.generateList(1, this.generator);

        //Act
        Boolean result = isListAcyclicChallenge.solve(oneElementList);

        //Assert
        assertTrue(result);
    }
}
