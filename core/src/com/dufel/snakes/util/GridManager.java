package com.dufel.snakes.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.dufel.snakes.entities.Cell;
import com.dufel.snakes.entities.Pellet;
import com.dufel.snakes.entities.Snake;

public class GridManager {

    public Snake o_snake;
    public Pellet o_pellet;

    public Array<Cell> o_grid;    
    
    public int n_grid_size;

    public GridManager() {
                
        o_snake = new Snake();
        o_pellet = new Pellet();
        n_grid_size = 14;

        o_grid = new Array<>( 30 );

        for ( int i = 0; i < 15; i++ ) {
            for ( int j = 0; j < 15; j++ ) {

                if ( ( i + j ) % 2 == 0 ) {
                    o_grid.add( new Cell( j, i, AssetManager.o_manager.o_screen.o_tile_a, Direction.NONE ) );
                } else {
                    o_grid.add( new Cell( j, i, AssetManager.o_manager.o_screen.o_tile_b, Direction.NONE ) );
                }
            }
        }
    }

    /**
     * This will be called on each discrete frame of the game's timeline.
     * It will perform collision checks between each actor, and update the snake's position.
     * @param vo_direction the direction of movement
     */
    public void update( Direction vo_direction ) {
        
        boolean b_expand = o_snake.collidesWith( o_pellet.o_cell );
        
        o_snake.update( vo_direction, b_expand );
        
        if ( b_expand ) {
            o_pellet.update( o_grid, o_snake.o_cells );
        }
    }
    
    public Direction getCurrentDirection() {
        return o_snake.o_cells.first().getDirection();
    }
    
    /**
     * Check if the snake is meeting the conditions for a game-over.
     * @return true if game is over, else false
     */
    public boolean checkForGameOver() {
        
        Cell o_head = o_snake.o_cells.first();
        
        // Check if snake is beyond boundaries of the map
        if ( o_head.n_col < 0 || o_head.n_row < 0 || o_head.n_col > n_grid_size || o_head.n_row > n_grid_size ) {
        
            return true;
        } 

        // Check if snake head has intersected with any cells of its body
        // Head is guaranteed to be first cell in the queue
        boolean b_first = true;
        for ( Cell o_cell : o_snake.o_cells ) {

            if ( o_head.n_col == o_cell.n_col && o_head.n_row == o_cell.n_row ) {

                if ( b_first ) {
                    b_first = false;
                } else {
                    return true;
                }
            }                
        }
        
        return false;
    }

    /**
     * Performs the rendering of each actor to the screen.
     * @param vo_batch the sprite batch
     */
    public void render( SpriteBatch vo_batch ) {

        for ( Cell o_cell : o_grid ) {
            o_cell.render( vo_batch );
        }

        o_pellet.render( vo_batch );
        o_snake.render( vo_batch );
    }

}
