package challenges.base;

/**
 * Created by ModeToCode on 21.02.2017.
 */
public class Pair<T> {
    private T firstElement;
    private T secondElement;

    public Pair(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getFirstElement() {
        return firstElement;
    }

    public T getSecondElement() {
        return secondElement;
    }
}
