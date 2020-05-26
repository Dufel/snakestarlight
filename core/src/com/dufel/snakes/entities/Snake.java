package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;
import com.dufel.snakes.util.AssetManager;
import com.dufel.snakes.util.Direction;

public class Snake {

    public Queue<Cell> o_cells;
    
    private Direction o_prev_direction;

    public Snake() {
        
        o_cells = new Queue<>();
        
        // Starting positions
        o_prev_direction = Direction.RIGHT;
        
        o_cells.addFirst( new Cell( 2, 7, AssetManager.o_manager.o_horse_head ) );
        o_cells.addLast( new Cell( 1, 7, AssetManager.o_manager.o_horse_body ) );
        o_cells.addLast( new Cell( 0, 7, AssetManager.o_manager.o_horse_tail ) );
    
    }

    public void update( Direction vo_direction, boolean vb_expand ) {
        
        Cell o_head = o_cells.first();
        
        Cell o_new_head = new Cell( o_head.n_row, o_head.n_col );
        switch ( vo_direction ) {
            
            case UP :
                
                o_new_head.n_row++;
                
                switch ( o_prev_direction ) {
                    
                    // Set texture for the old head
                    case UP : 
                        
                        break;
                        
                    case DOWN :
                        
                        break;
                        
                    case LEFT :
                        
                        break;
                        
                    case RIGHT : 
                        
                        break;
                    
                }
                break;
                
            case DOWN : 
                
                o_new_head.n_row--;
                
                switch ( o_prev_direction ) {
                    
                    
                    
                }
                break;
                
            case LEFT :
                
                o_new_head.n_col--;
                
                switch ( o_prev_direction ) {
                    
                    
                    
                }
                break;
                
            case RIGHT :
                
                o_new_head.n_col++;
                
                switch ( o_prev_direction ) {
                    
                    
                    
                }
                break;
        }
        
        o_cells.addFirst( o_new_head );
        
        if ( !vb_expand ) {
            o_cells.removeLast();
        }

    }

    public void render( SpriteBatch vo_batch ) {

        Cell o_head = o_cells.removeFirst();
        Cell o_tail = o_cells.removeLast();

        o_head.render( vo_batch );
        o_tail.render( vo_batch );

        // Draw rest of the body here, excluding head and tail if necessary
        for ( Cell o_cell : o_cells ) {
            o_cell.render( vo_batch );
        }

        o_cells.addFirst( o_head );
        o_cells.addLast( o_tail );
    }
    
    public boolean collidesWith( Cell o_cell ) {
        
        Cell o_head = o_cells.first();
        return o_cell.n_col == o_head.n_col && o_cell.n_row == o_head.n_row;
        
    }
}
