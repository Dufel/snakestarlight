package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;
import com.dufel.snakes.util.AssetManager;
import com.dufel.snakes.util.Direction;

public class Snake {

    public Queue<Cell> o_cells;

    public Snake() {
        
        o_cells = new Queue<>();
        
        // Starting positions
        o_cells.addFirst( new Cell( 2, 7 ) );
        o_cells.addLast( new Cell( 1, 7 ) );
        o_cells.addLast( new Cell( 0, 7 ) );
    
    }

    public void update( Direction vo_direction ) {
        
        Cell o_head = o_cells.first();
        
        Cell o_new_head = new Cell( o_head.n_row, o_head.n_col );
        switch ( vo_direction ) {
            
            case UP :
                o_new_head.n_row++;
                break;
                
            case DOWN : 
                o_new_head.n_row--;
                break;
                
            case LEFT :
                o_new_head.n_col--;
                break;
                
            case RIGHT :
                o_new_head.n_col++;
                break;
        }
        
        o_cells.addFirst( o_new_head );
        o_cells.removeLast();

    }

    public void render( SpriteBatch vo_batch ) {

        Cell o_head = o_cells.removeFirst();
        Cell o_tail = o_cells.removeLast();

        o_head.render( vo_batch, AssetManager.o_manager.o_horse_head );
        o_tail.render( vo_batch, AssetManager.o_manager.o_horse_tail );

        // Draw rest of the body here, excluding head and tail if necessary
        for ( Cell o_cell : o_cells ) {
            o_cell.render( vo_batch, AssetManager.o_manager.o_horse_body );
        }

        o_cells.addFirst( o_head );
        o_cells.addLast( o_tail );
    }
    
    public boolean collidesWith( Cell o_cell ) {
        
        Cell o_head = o_cells.first();
        return o_cell.n_col == o_head.n_col && o_cell.n_row == o_head.n_row;
        
    }
}
