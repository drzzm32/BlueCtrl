package org.thewdj.bluectrl;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.thewdj.bluectrl.utility.DrawCore;
import org.thewdj.bluectrl.utility.gui.*;

public class BlueCtrlNative extends ApplicationAdapter {

    DrawCore E;
    long PublicTime;
    Texture BtnB, BtnF, SliderB, SliderBS, SliderF;
    Button Btn;
    Slider SlrA, SlrB, Swh;
    float TmpA, TmpB;

    @Override
    public void create() {
        E = new DrawCore();
        PublicTime = 0;

        BtnB = new Texture("Button-U.png");
        BtnF = new Texture("Button-P.png");
        SliderB = new Texture("SliderBody.png");
        SliderBS = new Texture("SliderBodySmall.png");
        SliderF = new Texture("SliderPoint.png");

        Btn = new Button(BtnB, BtnF);
        Btn.X = (Gdx.graphics.getWidth() - Btn.Width) / 2;
        Btn.Y = Btn.Height;
        SlrA = new Slider(SliderB, SliderF);
        SlrA.X = 32;
        SlrA.Y = 32;
        SlrA.IsAutoReset = true;
        SlrB = new Slider(SliderB, SliderF);
        SlrB.X = Gdx.graphics.getWidth() - SlrB.Width - 32;
        SlrB.Y = 32;
        SlrB.IsAutoReset = true;
        Swh = new Slider(SliderBS, SliderF);
        Swh.X = (Gdx.graphics.getWidth() - Swh.Width) / 2;
        Swh.Y = Gdx.graphics.getHeight() - 32 - Swh.Height;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.15f, 0.2f, 0.22f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        TmpA = SlrA.Value;
        TmpB = SlrB.Value;

        E.DrawBegin();
        Btn.Redner(E);
        SlrA.Redner(E);
        SlrB.Redner(E);
        Swh.Redner(E);
        E.DrawEnd();
        SwitchLock();

        if (PublicTime % 30 == 0) {
            if (Btn.IsClicked)
                BlueTooth.Main.Send("L300R300;");
            else
                BlueTooth.Main.Send("L" + (int) SlrA.Value + "R" + (int) SlrB.Value + ";");
        }

        PublicTime++;
    }

    private void SwitchLock() {
        if (Swh.Value > Swh.MaxValue / 2) {
            if (TmpA != SlrA.Value)
                SlrB.Value = SlrA.Value;
            else if (TmpB != SlrB.Value)
                SlrA.Value = SlrB.Value;
        } else if (Swh.Value < -Swh.MaxValue / 2) {
            if (TmpA != SlrA.Value)
                SlrB.Value = -SlrA.Value;
            else if (TmpB != SlrB.Value)
                SlrA.Value = -SlrB.Value;
        }
    }

}
