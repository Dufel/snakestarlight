package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dufel.snakes.util.Constants;
import com.dufel.snakes.util.Direction;

public class Cell {

    public int n_col;
    public int n_row;

    private TextureRegion o_texture;
    
    private Direction o_direction;

    public Cell() {
        n_col = 0;
        n_row = 0;
    }
        
    public Cell( int vn_col, int vn_row ) {
        n_col = vn_col;
        n_row = vn_row;
    }

    public Cell( int vn_col, int vn_row, TextureRegion vo_texture, Direction vo_direction ) {
        n_col = vn_col;
        n_row = vn_row;
        o_texture = vo_texture;
        o_direction = vo_direction;
    }

    public void setPosition( int vn_col, int vn_row ) {
        n_col = vn_col;
        n_row = vn_row;
    }

    public void setDirection( Direction vo_direction ) {
        o_direction = vo_direction;
    }

    public Direction getDirection() {
        return o_direction;
    }

    public void setTexture( TextureRegion vo_texture ) {
        o_texture = vo_texture;
    }
    
    public void render( SpriteBatch vo_batch, TextureRegion vo_texture ) {
        
        vo_batch.draw( vo_texture, Constants.MARGIN + n_col, Constants.MARGIN + n_row, 1, 1 );
    
    }

    public void render( SpriteBatch vo_batch ) {
        vo_batch.draw( o_texture, Constants.MARGIN + n_col, Constants.MARGIN + n_row, 1, 1 );
    }

    @Override
    public boolean equals( Object obj ) {
        
        Cell o_cell = (Cell) obj;
        return o_cell.n_col == this.n_col && o_cell.n_row == this.n_row;
    }
        
    @Override
    protected Cell clone() throws CloneNotSupportedException {
        
        Cell o_cell = new Cell( n_col, n_row, o_texture, o_direction );
        return o_cell;
    }

    @Override
    public String toString() {
        return "Col: " + n_col + " | Row: " + n_row + " | Dir: " + o_direction.name();
    }

}
