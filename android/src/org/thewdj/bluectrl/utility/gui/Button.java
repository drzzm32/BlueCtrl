package org.thewdj.bluectrl.utility.gui;

import com.badlogic.gdx.graphics.Texture;

import org.thewdj.bluectrl.utility.DrawCore;
import org.thewdj.bluectrl.utility.Utility;

/**
 * Created by drzzm on 2016.1.3.
 */
public class Button extends Control {
    public boolean IsClicked;

    public Button(Texture BackTexture, Texture FrontTexture) {
        super(BackTexture, FrontTexture);
        IsClicked = false;
    }

    @Override
    protected void RenderFront(DrawCore E) {
        float TmpValue;
        for(int i = 0; i < 10; i++) {
            if (Utility.IsTouched(i)) {
                TmpValue = Utility.GetX(i);
                if (TmpValue > X && TmpValue < X + Width) {
                    TmpValue = Utility.GetY(i);
                    if (TmpValue > Y && TmpValue < Y + Height) {
                        E.DrawPic(Front, X, Y, 0);
                        IsClicked = true;
                        return;
                    }
                }
            }
        }
        IsClicked = false;
    }
}
