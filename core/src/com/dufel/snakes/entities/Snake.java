package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Queue;
import com.dufel.snakes.util.AssetManager;
import com.dufel.snakes.util.Constants;

public class Snake {

    public Queue<Cell> o_cells;

    public Snake() {
        o_cells = new Queue<>();
        o_cells.addFirst( new Cell( 2, 7 ) );
        o_cells.addLast( new Cell( 1, 7 ) );
    }

    public void update() {

    }

    public void render( SpriteBatch vo_batch ) {

        Cell o_head = o_cells.first();
        Cell o_tail = o_cells.last();

        o_head.render( vo_batch, AssetManager.o_manager.o_horse_head );
        o_tail.render( vo_batch, AssetManager.o_manager.o_horse_tail );

        // Draw rest of the body here, excluding head and tail if necessary
//        for ( Cell o_cell : o_cells ) {
//            o_cell.render( vo_batch, AssetManager.o_manager.o_horse_body );
//        }
    }
}
