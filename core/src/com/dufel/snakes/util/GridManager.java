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

    public GridManager() {

        o_snake = new Snake();
        o_pellet = new Pellet();

        o_grid = new Array<>( 30 );

        for ( int i = 0; i < 15; i++ ) {
            for ( int j = 0; j < 15; j++ ) {
                o_grid.add( new Cell( j, i ) );
            }
        }
    }

    /**
     * This will be called on each discrete frame of the game's timeline.
     * It will perform collision checks between each actor, and update the
     */
    public void update() {

    }

    /**
     * Performs the rendering of each actor to the screen.
     * @param vo_batch the sprite batch
     */
    public void render( SpriteBatch vo_batch ) {

        for ( Cell o_cell : o_grid ) {
            o_cell.render( vo_batch, AssetManager.o_manager.o_tex );
        }

        o_snake.render( vo_batch );
    }

}
