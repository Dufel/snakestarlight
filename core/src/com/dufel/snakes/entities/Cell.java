package com.dufel.snakes.entities;

public class Cell {

    public int n_col;
    public int n_row;

    public Cell() {
        n_col = 0;
        n_row = 0;
    }

    public Cell( int vn_col, int vn_row ) {
        n_col = vn_col;
        n_row = vn_row;
    }

    public void setPosition( int vn_col, int vn_row ) {
        n_col = vn_col;
        n_row = vn_row;
    }
}
