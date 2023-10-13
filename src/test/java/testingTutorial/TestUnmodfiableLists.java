package testingTutorial;

import static java.util.Collections.unmodifiableList;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestUnmodfiableLists {
    private List<Integer> iList = null;
    private List<Integer> unmodiList = null;
    @Before public void setUp() {
        iList = new ArrayList<>();
        iList.add(10);
        iList.add(25);
        iList.add(500);
        unmodiList = unmodifiableList(iList);
    }
    @Test (expected= UnsupportedOperationException.class)
    public void unmodifiableAdd() {
        unmodiList.add(17);
    }
    @Test
    public void unmodifiableIterate() {
        Iterator<Integer> unmodItr = unmodiList.iterator();
        int loopCount = 0;
        while (unmodItr.hasNext()) {
            loopCount++;
            unmodItr.next();
        }
        assertTrue(iList.size() == loopCount);
    }

}