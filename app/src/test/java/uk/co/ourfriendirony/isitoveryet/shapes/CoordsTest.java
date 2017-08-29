package uk.co.ourfriendirony.isitoveryet.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordsTest {
    @Test
    public void valuesSetAreAccessable() {
        int topValue = 123;
        int bottomValue = 234;
        int leftValue = 345;
        int rightValue = 456;

        Coords coords = new Coords()
                .setLeft(leftValue)
                .setRight(rightValue)
                .setTop(topValue)
                .setBottom(bottomValue);

        assertEquals("leftValue incorrect", leftValue, coords.getLeft());
        assertEquals("rightValue incorrect", rightValue, coords.getRight());
        assertEquals("topValue incorrect", topValue, coords.getTop());
        assertEquals("bottomValue incorrect", bottomValue, coords.getBottom());
    }
}