package challenges.lists;

import challenges.base.challenge.ListChallenge;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by ModeToCode on 14.02.2017.
 * Determine if a given SLL is a cyclic or acyclic.
 * Solution:
 *  Complexity:
 *      Time: O(n)
 *      Memory: O(1)
 *  Description:
 *      Create two pointers, one that will iterate faster (double-element-jump) and one slower (one-element-jump)
 *      If a null pointer is encountered, then for sure it is an acyclic list.
 *      If not,
 */
public class IsListAcyclicChallenge<T> implements ListChallenge<T, Boolean> {

    @Override
    public Boolean solve(List<T> data) {
        if (data == null) {
            return null;
        }

        if (data.isEmpty()){
            return true;
        }

        Iterator<T> fastIterator = data.iterator();
        Iterator<T> slowIterator = data.iterator();
        fastIterator.next();
        T currentSlowIteratorElement = slowIterator.next();

        while(true) {
//            if (currentFastIteratorElement == currentSlowIteratorElement) {
//                return false;
//            }

//            if (!fastIterator.hasNext()) {
//                return true;
//            }
//
//            currentFastIteratorElement = fastIterator.next();
//            if (currentFastIteratorElement == currentSlowIteratorElement) {
//                return false;
//            }
//
//            if (!fastIterator.hasNext()) {
//                return true;
//            }
//
//            currentFastIteratorElement = fastIterator.next();
//            if (currentFastIteratorElement == currentSlowIteratorElement) {
//                return false;
//            }

            Optional<Boolean> acyclicPropertyValid = checkIfAcyclicPropertyValid(fastIterator, currentSlowIteratorElement);
            if (acyclicPropertyValid.isPresent()) {
                return acyclicPropertyValid.get();
            }

            acyclicPropertyValid = checkIfAcyclicPropertyValid(fastIterator, currentSlowIteratorElement);
            if (acyclicPropertyValid.isPresent()) {
                return acyclicPropertyValid.get();
            }

            if (!slowIterator.hasNext()) {
                return true;
            }

            currentSlowIteratorElement = slowIterator.next();
        }
    }


    Optional<Boolean> checkIfAcyclicPropertyValid(Iterator<T> iteratorToIterate, T elementToCompare) {
        if (!iteratorToIterate.hasNext()) {
            return Optional.of(true);
        }

        T elementForIterator = iteratorToIterate.next();
        if (elementForIterator == elementToCompare) {
            return Optional.of(false);
        }

        return Optional.empty();
    }
}
