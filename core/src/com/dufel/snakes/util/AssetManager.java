package com.dufel.snakes.util;

import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

    public static final AssetManager o_manager = new AssetManager();

    public final Texture o_tex;
    public final Texture o_horse_head;
    public final Texture o_horse_tail;
    public final Texture o_horse_body;

    public AssetManager() {

        o_tex = new Texture( "badlogic.jpg" );
        o_horse_head = new Texture( "broccoli.png" );
        o_horse_tail = new Texture( "cupcake.png" );
        o_horse_body = new Texture( "donut.png" );

    }

}
