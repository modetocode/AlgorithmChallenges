package challenges.base;

/**
 * Created by ModeToCode on 14.02.2017.
 */
public interface Challenge<T, S> {

    S solve(T data);
}
