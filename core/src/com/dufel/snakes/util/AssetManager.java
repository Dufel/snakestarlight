package com.dufel.snakes.util;

import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

    public static final AssetManager o_manager = new AssetManager();

    public final Texture o_horse_head;
    public final Texture o_horse_tail;
    public final Texture o_horse_body;

    public final Texture o_tile_a;
    public final Texture o_tile_b;

    public AssetManager() {

        o_horse_head = new Texture( "snake_head.png" );
        o_horse_tail = new Texture( "snake_tail.png" );
        o_horse_body = new Texture( "snake_body.png" );

        o_tile_a = new Texture( "tile_a.png" );
        o_tile_b = new Texture( "tile_b.png" );
    }

}
