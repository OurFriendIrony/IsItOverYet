package uk.co.ourfriendirony.isitoveryet.general;

public class StringHandler {


    public static String pad(int num, int size) {
        return String.format("%0" + size + "d", num);
    }

}
