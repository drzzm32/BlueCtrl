package org.thewdj.bluectrl.utility.gui;

import com.badlogic.gdx.graphics.Texture;

import org.thewdj.bluectrl.utility.DrawCore;

/**
 * Created by drzzm on 2016.1.3.
 */
public class Control {
    protected Texture Back, Front;
    public boolean IsEnabled;
    public float X, Y, Width, Height;

    public Control() {
    }

    public Control(Texture BackTexture, Texture FrontTexture) {
        Back = BackTexture;
        Front = FrontTexture;
        IsEnabled = true;
        X = 0; Y = 0;
        Width = Back.getWidth(); Height = Back.getHeight();
    }

    public void Redner(DrawCore E) {
        if (IsEnabled) {
            E.DrawPic(Back, X, Y, 0);
            RenderFront(E);
        }
    }

    protected void RenderFront(DrawCore E) {
    }
}
