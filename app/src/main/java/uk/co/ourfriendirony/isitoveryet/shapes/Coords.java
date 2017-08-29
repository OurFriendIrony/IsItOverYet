package uk.co.ourfriendirony.isitoveryet.shapes;
public class Coords {
    private int left = 0;
    private int right = 0;
    private int top = 0;
    private int bottom = 0;

    public Coords setLeft(int left) {
        this.left = left;
        return this;
    }

    public Coords setRight(int right) {
        this.right = right;
        return this;
    }

    public Coords setTop(int top) {
        this.top = top;
        return this;
    }

    public Coords setBottom(int bottom) {
        this.bottom = bottom;
        return this;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }
}
