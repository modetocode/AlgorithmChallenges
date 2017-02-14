package util.generator;

/**
 * Created by ModeToCode on 14.02.2017.
 */
public final class GeneratorUtil {

    private static final int INTEGER_GENERATOR_MIN_VALUE = 0;
    private static final int INTEGER_GENERATOR_MAX_VALUE = 1000;

    public static IntegerGenerator getDefaultIntegerGenerator(){
        return new IntegerGenerator(INTEGER_GENERATOR_MIN_VALUE, INTEGER_GENERATOR_MAX_VALUE);
    }
}
