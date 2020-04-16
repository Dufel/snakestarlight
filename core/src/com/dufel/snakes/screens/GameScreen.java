package com.dufel.snakes.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dufel.snakes.util.GridManager;

public class GameScreen extends ScreenAdapter {

    Game o_game;
    Viewport o_viewport;
    GridManager o_grid;

    public GameScreen( Game vo_game ) {

        o_viewport = new ScreenViewport();
        o_game = vo_game;

    }

    public void update( float delta ) {

        // Need to determine when this method is called at a certain interval,
        // so as to call underlying updates / render at discrete steps

    }

    @Override
    public void render( float delta ) {

        update( delta );

        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        super.render(delta);
    }

    @Override
    public void resize( int width, int height ) {
        super.resize( width, height );
    }

    @Override
    public void show() {
        super.show();
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
