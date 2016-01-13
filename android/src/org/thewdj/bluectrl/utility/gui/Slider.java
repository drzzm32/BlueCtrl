package org.thewdj.bluectrl.utility.gui;

import com.badlogic.gdx.graphics.Texture;

import org.thewdj.bluectrl.utility.DrawCore;
import org.thewdj.bluectrl.utility.Utility;

/**
 * Created by drzzm on 2016.1.3.
 */
public class Slider extends Control {
    public float MaxValue;
    private int Pointer;
    public float Value;
    public boolean IsAutoReset;

    public Slider(Texture BackTexture, Texture FrontTexture) {
        super(BackTexture, FrontTexture);
        MaxValue = (Back.getHeight() - Front.getHeight()) / 2;
        Value = 0; Pointer = 0;
        IsAutoReset = false;
    }

    @Override
    protected void RenderFront(DrawCore E) {
        float TmpValue;
        for (int i = 0; i < 10; i++) {
            if (Utility.IsTouched(i)) {
                Pointer = i;
                TmpValue = Utility.GetX(i);
                if (TmpValue > X - Front.getWidth() * 0.25 && TmpValue < X + Front.getWidth() * 1.25) {
                    TmpValue = Utility.GetY(i);
                    if (TmpValue > Y + Value + MaxValue - Front.getHeight() * 1.25 && TmpValue < Y + Value + MaxValue + Front.getHeight() * 1.25) {
                        Value += Utility.GetDY(i);
                    }
                }
            } else if (Pointer == i){
                TmpValue = Front.getHeight() / 2;
                if (IsAutoReset || (Value < TmpValue && Value > -TmpValue)) {
                    for (int j = 0; j < Height / TmpValue; j++) {
                        if (Value > 0) Value--;
                        if (Value < 0) Value++;
                    }
                }
            }
        }

        if (Value > MaxValue) Value = MaxValue;
        if (Value < -MaxValue) Value = -MaxValue;

        E.DrawPic(Front, X, Y + Value + MaxValue, 0);
    }
}
