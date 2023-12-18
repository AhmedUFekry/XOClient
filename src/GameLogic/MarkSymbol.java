/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

/**
 *
 * @author DELL
 */

public enum MarkSymbol {
    X("X"),
    O("O"),
    XIMG("x.png"),
    OIMG("o.png"),
    BLANK("");

    private final String mark;

    MarkSymbol(String initMark) {
        this.mark = initMark;
    }

    public boolean isMarked() {
        return this != BLANK;
    }

    public String getMark() {
        return this.mark;
    }

   /* @Override
    public String toString() {
        return String.valueOf(mark);
    }*/
}

