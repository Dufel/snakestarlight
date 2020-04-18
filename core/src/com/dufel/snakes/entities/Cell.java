package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dufel.snakes.util.AssetManager;
import com.dufel.snakes.util.Constants;

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

    public void render( SpriteBatch vo_batch, Texture vo_texture ) {
        vo_batch.draw( vo_texture, Constants.MARGIN + n_col, Constants.MARGIN + n_row, 1, 1 );
    }
    public enum Type {
        EMPTY, SNAKE;
    }
}
