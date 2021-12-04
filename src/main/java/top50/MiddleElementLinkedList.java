package top50;

import java.util.Iterator;
import java.util.LinkedList;

public class MiddleElementLinkedList {

    public static <T> T getMiddleElementOfList(LinkedList<T> list) {
        Iterator<T> it = list.iterator();
        Iterator<T> doubleIt = list.iterator();
        int pos = 0;
        T middleElem = null;
        while (it.hasNext()) {
            it.next();
            pos++;
            if (pos % 2 == 0) {
                middleElem = doubleIt.next();
            }
        }
        if (pos % 2 == 1) {
            middleElem = doubleIt.next();
        }
        return middleElem;
    }
}
