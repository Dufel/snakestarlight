package com.dufel.snakes.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dufel.snakes.util.Constants;
import com.dufel.snakes.util.GridManager;

public class GameScreen extends ScreenAdapter {

    OrthographicCamera o_camera;
    Game o_game;
    Viewport o_viewport;
    GridManager o_grid;
    SpriteBatch o_batch;

    public GameScreen( Game vo_game ) {
        o_game = vo_game;
    }

    @Override
    public void show() {

        o_batch = new SpriteBatch();
        o_grid = new GridManager();
        o_camera = new OrthographicCamera();
        o_viewport = new FitViewport( Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, o_camera );

        o_viewport.apply( true );

    }

    @Override
    public void resize( int width, int height ) {
        o_viewport.update( width, height, true );
    }

    public void update( float delta ) {

        // Need to determine when this method is called at a certain interval,
        // so as to call underlying updates / render at discrete steps

    }

    @Override
    public void render( float delta ) {

        update( delta );

        o_camera.update();
        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        o_batch.setProjectionMatrix( o_camera.combined );
        o_batch.begin();
        o_grid.render( o_batch );
        o_batch.end();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
