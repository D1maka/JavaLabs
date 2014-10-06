package ua.kpi.JavaLabs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmytro_veres on 05.10.14.
 */
public class MyArrayListTest {
    @Test
    public void testCreateNewListSizeZero() {
        MyList myList = new MyArrayList();
        final int expectedSize = 0;
        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void testAddNullToEmptyListSizeOne() {
        MyList myList = new MyArrayList();
        Object obj = null;
        myList.add(obj);

        final int expectedSize = 1;

        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void testAddOneToEmptyList() {
        MyList myList = new MyArrayList();
        Object obj = new Integer(7);
        myList.add(obj);

        final Object expectedValue = new Integer(7);

        assertEquals(expectedValue, myList.get(0));
    }

    @Test
    public void testAddElementSizeEqualsOne() {
        MyList myList = new MyArrayList();
        Object obj = new Object();
        myList.add(obj);

        final int expectedSize = 1;

        assertEquals(expectedSize, myList.size());
    }

    @Test
    public void testInsertToEnd() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);
        Object five = new Integer(5);
        myList.add(five);

        final Object result = new Integer(5);
        assertEquals(result, myList.get(1));
    }

    @Test
    public void testInsertMiddle() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);
        Object five = new Integer(5);
        myList.add(five);
        Object middleValue = new Integer(0);
        myList.add(1, middleValue);

        final Object expectedMiddleValue = new Integer(0);
        assertEquals(expectedMiddleValue, myList.get(1));
    }

    @Test
    public void testInsertStart() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);
        Object five = new Integer(5);
        myList.add(five);
        Object middleValue = new Integer(0);
        myList.add(0, middleValue);

        final Object expectedMiddleValue = new Integer(0);
        assertEquals(expectedMiddleValue, myList.get(0));
    }

    @Test
    public void testInsertToEndIndex() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);
        Object five = new Integer(5);
        myList.add(five);
        Object middleValue = new Integer(0);
        myList.add(2, middleValue);

        final Object expectedMiddleValue = new Integer(0);
        assertEquals(expectedMiddleValue, myList.get(2));
    }

    @Test
    public void testInsertEmptyListZeroPositionSuccess() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(0, four);

        final Object expectedMiddleValue = new Integer(4);
        assertEquals(expectedMiddleValue, myList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertToWrongPositiveIndexException() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(2, four);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertToWrongNegativeIndexException() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(-2, four);
    }

    @Test
    public void testAddArrayToEmptyList() {
        MyList myList = new MyArrayList();
        Object[] objects = new Integer [] {1, 2, 3, 4, 5};
        myList.addAll(objects);

        final Object[] resultObjects = new Integer[5];
        for (int i = 0; i < 5; i++) {
            resultObjects[i] = myList.get(i);
        }

        final Object[] expectedObjects = new Integer [] {1, 2, 2, 3, 4, 5};

        assertEquals(myList.size(), resultObjects.length);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueWrongIndex() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.get(2);
    }

    @Test
    public void testGetValueCorrectIndex() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);

        Object expectedValue = new Integer(4);
        assertEquals(expectedValue, myList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyList() {
        MyList myList = new MyArrayList();
        myList.remove(0);
    }

    @Test
    public void testRemoveFromNonEmptyListEnd() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(0, four);

        Object expectedValue = new Integer(4);
        assertEquals(expectedValue, myList.remove(0));
    }

    @Test
    public void testRemoveFromNonEmptyListSizeChanges() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);
        Object five = new Integer(5);
        myList.add(five);
        myList.remove(0);

        int expectedSize = 1;
        assertEquals(expectedSize, myList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueWrongIndex() {
        MyArrayList myList = new MyArrayList();
        Object four = new Integer(4);

        myList.set(-1, new Object());
    }

    @Test
    public void testSetValueCorrectIndex() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);

        myList.set(0, new Integer(5));

        Object expectedValue = new Integer(5);

        assertEquals(expectedValue, myList.get(0));
    }

    @Test
    public void testIndexOfNull() {
        MyList myList = new MyArrayList();
        Object nullElement = null;
        myList.add(nullElement);

        int expectedIndex = 0;

        assertEquals(expectedIndex, myList.indexOf(null));
    }

    @Test
    public void testIndexOfNumber() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);

        int expectedIndex = 0;

        assertEquals(expectedIndex, myList.indexOf(new Integer(4)));
    }

    @Test
    public void testIndexOfUnexistingValue() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);

        int expectedIndex = -1;

        assertEquals(expectedIndex, myList.indexOf(new Integer(5)));
    }

    @Test
    public void testToArrayEmpty() {
        MyList myList = new MyArrayList();

        final Object[] expectedObjects = new Integer [0];

        assertEquals(expectedObjects,myList.toArray());
    }

    @Test
    public void testToArrayNonEmpty() {
        MyList myList = new MyArrayList();
        Object four = new Integer(4);
        myList.add(four);
        Object five = new Integer(5);
        myList.add(five);

        final Object[] expectedObjects = new Integer [] { 4, 5};

        assertEquals(expectedObjects, myList.toArray());
    }
}
