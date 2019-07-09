package com.example.firstandroidcode;

public interface SharpView {

    SharpViewRenderProxy getRenderProxy();

    enum ArrowDirection {
        LEFT, TOP, RIGHT, BOTTOM
    }
}
