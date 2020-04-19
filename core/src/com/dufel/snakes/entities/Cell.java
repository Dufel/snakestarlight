package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dufel.snakes.util.AssetManager;
import com.dufel.snakes.util.Constants;

public class Cell {

    public int n_col;
    public int n_row;

    private Texture o_texture;

    public Cell() {
        n_col = 0;
        n_row = 0;
    }

    public Cell( int vn_col, int vn_row ) {
        n_col = vn_col;
        n_row = vn_row;
    }

    public Cell( int vn_col, int vn_row, Texture vo_texture ) {
        n_col = vn_col;
        n_row = vn_row;
        o_texture = vo_texture;
    }

    public void setPosition( int vn_col, int vn_row ) {
        n_col = vn_col;
        n_row = vn_row;
    }

    public void render( SpriteBatch vo_batch, Texture vo_texture ) {
        vo_batch.draw( vo_texture, Constants.MARGIN + n_col, Constants.MARGIN + n_row, 1, 1 );
    }

    public void render( SpriteBatch vo_batch ) {
        vo_batch.draw( o_texture, Constants.MARGIN + n_col, Constants.MARGIN + n_row, 1, 1 );
    }
}
