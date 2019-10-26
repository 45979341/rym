package com.pingan.rym.common;

/**
 * @author 刘欣武
 * @version $Id: Calibre, v 0.1 2018/11/19 9:41 刘欣武 Exp$
 */
public enum Calibre {

    INVALID(0),
    EXPOSURE(1),
    CLICK(2),
    RATE(3),;

    private int value;

    Calibre(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


