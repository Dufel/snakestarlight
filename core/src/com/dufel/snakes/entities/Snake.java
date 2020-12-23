package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;
import com.dufel.snakes.util.AssetManager;
import com.dufel.snakes.util.Direction;

public class Snake {

    public Queue<Cell> o_cells;
    
    public Direction o_prev_direction;

    public Snake() {
        
        o_cells = new Queue<>();
        
        // Starting positions
        o_prev_direction = Direction.RIGHT;
                
        o_cells.addFirst( new Cell( 2, 7, AssetManager.o_manager.o_snake.o_snake_head_right ) );
        o_cells.addLast( new Cell( 1, 7, AssetManager.o_manager.o_snake.o_snake_body_horizontal ) );
        o_cells.addLast( new Cell( 0, 7, AssetManager.o_manager.o_snake.o_snake_tail_right ) );
    
    }

    public void update( Direction vo_direction, boolean vb_expand ) {
        
        Cell o_head = o_cells.first();
        
        Cell o_new_head = new Cell( o_head.n_row, o_head.n_col );
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
