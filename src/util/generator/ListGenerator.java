package util.generator;

import util.generator.ObjectGenerator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ModeToCode on 14.02.2017.
 */
public class ListGenerator {

    public static <T> List<T> generateList(int elementCount, ObjectGenerator<T> objectGenerator) {
        List<T> generatedList = new LinkedList<>();
        for (int i = 0; i < elementCount; i++) {
            T newObject = objectGenerator.generateObject();
            generatedList.add(newObject);
        }

        return generatedList;
    }
}
