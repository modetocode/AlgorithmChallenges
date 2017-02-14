package util.generator;

import java.util.Random;

/**
 * Created by ModeToCode on 14.02.2017.
 */
public class IntegerGenerator implements ObjectGenerator<Integer> {

    private final int startValue;
    private final int endValue;
    private final Random random;
    private final int rangeDifference;


    public IntegerGenerator(int startValue, int endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
        this.random = new Random();
        this.rangeDifference = this.endValue - this.startValue;
    }

    @Override
    public Integer generateObject() {
        Integer newObject = new Integer(random.nextInt(this.rangeDifference + this.startValue));
        return newObject;
    }
}
