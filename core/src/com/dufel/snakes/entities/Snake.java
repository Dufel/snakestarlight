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
        o_cells.addFirst( new Cell( 2, 7, AssetManager.o_manager.o_snake.o_snake_head_right, Direction.RIGHT ) );
        o_cells.addLast( new Cell( 1, 7, AssetManager.o_manager.o_snake.o_snake_body_horizontal, Direction.RIGHT ) );
        o_cells.addLast( new Cell( 0, 7, AssetManager.o_manager.o_snake.o_snake_tail_right, Direction.RIGHT ) );
    }

    public void update( Direction vo_direction, boolean vb_expand ) {
        
        Cell o_head = o_cells.first();
        
        Cell o_new_head = new Cell( o_head.n_col, o_head.n_row );
        o_new_head.setDirection( vo_direction );

        // Update the cell head based on the direction it's heading towards in this new step,
        // and the cell body that was previously the head based on the previous direction
        Direction o_prev_direction = o_head.getDirection();
        switch ( vo_direction ) {
            
            case UP :
                
                o_new_head.n_row++;
                o_new_head.setTexture( AssetManager.o_manager.o_snake.o_snake_head_up );
                
                switch ( o_prev_direction ) {
                    
                    // Set texture for the old head
                    case UP : 
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_vertical );
                        break;
                        
                    case LEFT :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_top_right );
                        break;
                        
                    case RIGHT : 
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_top_left );
                        break;
                    
                }
                break;
                
            case DOWN : 
                
                o_new_head.n_row--;
                o_new_head.setTexture( AssetManager.o_manager.o_snake.o_snake_head_down );
                
                switch ( o_prev_direction ) {
                    
                    case DOWN : 
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_vertical );
                        break;
                        
                    case LEFT :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_bottom_right );
                        break;
                        
                    case RIGHT :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_bottom_left );
                        break;
                    
                }
                break;
                
            case LEFT :
                
                o_new_head.n_col--;
                o_new_head.setTexture( AssetManager.o_manager.o_snake.o_snake_head_left );
                
                switch ( o_prev_direction ) {
                    
                    case UP :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_bottom_left );
                        break;
                        
                    case DOWN :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_top_left );
                        break;
                        
                    case LEFT :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_horizontal );
                        break;
                    
                }
                break;
                
            case RIGHT :
                
                o_new_head.n_col++;
                o_new_head.setTexture( AssetManager.o_manager.o_snake.o_snake_head_right );
                
                switch ( o_prev_direction ) {
                    
                    case UP :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_bottom_right );
                        break;
                        
                    case DOWN :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_top_right );
                        break;
                        
                    case RIGHT :
                        
                        o_head.setTexture( AssetManager.o_manager.o_snake.o_snake_body_horizontal );
                        break;
                    
                }
                break;
        }
        
        o_cells.addFirst( o_new_head );
        
        if ( !vb_expand ) {
            
            o_cells.removeLast();

            Cell o_new_tail = o_cells.last();
            Cell o_two_ahead = o_cells.get( o_cells.size - 2 );

            // Update the new tail's texture based on the direction the cell was previously pointing
            switch ( o_two_ahead.getDirection() ) {

                case RIGHT:
                    o_new_tail.setTexture( AssetManager.o_manager.o_snake.o_snake_tail_right );
                    break;
                case LEFT:
                    o_new_tail.setTexture( AssetManager.o_manager.o_snake.o_snake_tail_left );
                    break;
                case UP:
                    o_new_tail.setTexture( AssetManager.o_manager.o_snake.o_snake_tail_up );
                    break;
                case DOWN:
                    o_new_tail.setTexture( AssetManager.o_manager.o_snake.o_snake_tail_down );
                    break;
            }
        }
    }

    public void render( SpriteBatch vo_batch ) {

        // Draw rest of the body here, excluding head and tail if necessary
        for ( Cell o_cell : o_cells ) {
            o_cell.render( vo_batch );
        }

    }        
    
    public boolean collidesWith( Cell o_cell ) {
        
        Cell o_head = o_cells.first();
        return o_cell.n_col == o_head.n_col && o_cell.n_row == o_head.n_row;
        
    }
}
