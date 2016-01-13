package org.thewdj.bluectrl.utility;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by D.zzm on 2015.6.16.
 * Translated from VB.NET, ThSAG.
 */

public class AnimationObject {

    public enum Type {
        Liner, Sin, Cos
    }

    private Texture ImgSrc;
    private long Counter;
    private static DrawCore Engine;

    private double AniValue;

    public AnimationObject(Texture Tex, long StartTime) {
        if (Engine == null) Engine = new DrawCore();
        ImgSrc = Tex;
        Counter = StartTime;
        AniValue = 0D;
    }

    public void Draw(float x, float y, float Alpha) {
        Draw(x, y, 0F, 1F, Alpha);
    }

    public void Draw(float x, float y, float Angle, float Scale, float Alpha) {
        Engine.DrawBegin();
        Engine.DrawPic(ImgSrc, x, y, Angle, Scale, Scale, 1, 1, 1, Alpha);
        Engine.DrawEnd();
    }

    public void Draw(Double x, Double y, Double Angle, Double Scale, Double Alpha) {
        Draw(x.floatValue(), y.floatValue(), Angle.floatValue(), Scale.floatValue(), Alpha.floatValue());
    }

    public boolean Fade(float x, float y, long NowTime) {
        if (FadeIn(x, y, NowTime)) {
            return FadeOut(x, y, NowTime - 128);
        }
        return false;
    }

    public boolean FadeIn(float x, float y, long NowTime) {
        return FadeIn(x, y, 1F, NowTime);
    }

    public boolean FadeIn(float x, float y, long NowTime, int TotalTime) {
        return Trans(x, y, 1, 0, 0, x, y, 1, 0, 1,
                TotalTime, NowTime);
    }

    public boolean FadeIn(float x, float y, float Scale, long NowTime) {
        return Trans(x, y, Scale, 0, 0,
                x, y, Scale, 0, 1, 128, NowTime);
    }

    public boolean FadeOut(float x, float y, long NowTime) {
        return FadeOut(x, y, 1F, NowTime);
    }

    public boolean FadeOut(float x, float y, long NowTime, int TotalTime) {
        return Trans(x, y, 1, 0, 1, x, y, 1, 0, 0,
                TotalTime, NowTime);
    }

    public boolean FadeOut(float x, float y, float Scale, long NowTime) {
        return Trans(x, y, Scale, 0, 1, x, y, Scale, 0, 0,
                128, NowTime);
    }

    public boolean ScaleIn(float x, float y, long NowTime) {
        return ScaleIn(x, y, 0, NowTime, false);
    }

    public boolean ScaleIn(float x, float y, long NowTime, boolean WithFade) {
        return ScaleIn(x, y, 0, NowTime, WithFade);
    }

    public boolean ScaleIn(float x, float y, float StaticAngle, long NowTime) {
        return ScaleIn(x, y, StaticAngle, 1F, NowTime, false);
    }

    public boolean ScaleIn(float x, float y, float StaticAngle, long NowTime, boolean WithFade) {
        return ScaleIn(x, y, StaticAngle, 1F, NowTime, WithFade);
    }

    public boolean ScaleIn(float x, float y, float StaticAngle, float MaxScale, long NowTime) {
        return ScaleIn(x, y, StaticAngle, MaxScale, NowTime, false);
    }

    public boolean ScaleIn(float x, float y, float StaticAngle, float MaxScale, long NowTime, boolean WithFade) {
        if (WithFade) {
            return Trans(x, y, 0, StaticAngle, 0, x, y, MaxScale, StaticAngle, 1,
                    50, NowTime);
        } else {
            return Trans(x, y, 0, StaticAngle, 1, x, y, MaxScale, StaticAngle, 1,
                    50, NowTime);
        }
    }

    public boolean ScaleOut(float x, float y, long NowTime) {
        return ScaleOut(x, y, 0F, NowTime, false);
    }

    public boolean ScaleOut(float x, float y, long NowTime, boolean WithFade) {
        return ScaleOut(x, y, 0F, NowTime, WithFade);
    }

    public boolean ScaleOut(float x, float y, float StaticAngle, long NowTime) {
        return ScaleOut(x, y, StaticAngle, 1F, NowTime, false);
    }

    public boolean ScaleOut(float x, float y, float StaticAngle, long NowTime, boolean WithFade) {
        return ScaleOut(x, y, StaticAngle, 1F, NowTime, WithFade);
    }

    public boolean ScaleOut(float x, float y, float StaticAngle, float MaxScale, long NowTime) {
        return ScaleOut(x, y, StaticAngle, MaxScale, NowTime, false);
    }

    public boolean ScaleOut(float x, float y, float StaticAngle, float MaxScale, long NowTime, boolean WithFade) {
        if (WithFade) {
            return Trans(x, y, MaxScale, StaticAngle, 1, x, y, 0, StaticAngle, 0,
                    50, NowTime);
        } else {
            return Trans(x, y, MaxScale, StaticAngle, 1, x, y, 0, StaticAngle, 1,
                    50, NowTime);
        }
    }

    public void Rotate(float x, float y, float SpeedReduce, long NowTime) {
        Rotate(x, y, (NowTime - Counter) / SpeedReduce);
    }

    public void Rotate(float x, float y, float Angle) {
        Draw(x, y, Angle);
    }

    public boolean Trans(float sX, float sY, float sScale, float sAngle, float sFade, float tX, float tY, float tScale, float tAngle, float tFade,
                         long TotalTime, long NowTime) {
        if (NowTime - Counter < 0) {
            Draw(sX, sY, sAngle, sScale, sFade);
        } else if (NowTime - Counter <= TotalTime) {
            AniValue = Math.sin((NowTime - Counter) / (2F * TotalTime) * Math.PI);
            Draw(sX + (tX - sX) * AniValue,
                    sY + (tY - sY) * AniValue,
                    sAngle + (tAngle - sAngle) * AniValue,
                    sScale + (tScale - sScale) * AniValue,
                    sFade + (tFade - sFade) * AniValue);
        } else {
            return true;
        }
        return false;
    }

    public boolean Trans(float sX, float sY, float sScale, float sAngle, float sFade, float tX, float tY, float tScale, float tAngle, float tFade,
                         long TotalTime, long NowTime, Type AniType) {
        if (NowTime - Counter < 0) {
            Draw(sX, sY, sAngle, sScale, sFade);
        } else if (NowTime - Counter <= TotalTime) {
            switch (AniType) {
                case Sin:
                    AniValue = Math.sin((NowTime - Counter) / (2F * TotalTime) * Math.PI);
                    break;
                case Cos:
                    AniValue = 1D - Math.cos((NowTime - Counter) / (2F * TotalTime) * Math.PI);
                    break;
                case Liner:
                    AniValue = (double) (NowTime - Counter) / (double) TotalTime;
                    break;
            }
            Draw(sX + (tX - sX) * AniValue,
                    sY + (tY - sY) * AniValue,
                    sAngle + (tAngle - sAngle) * AniValue,
                    sScale + (tScale - sScale) * AniValue,
                    sFade + (tFade - sFade) * AniValue);
        } else {
            return true;
        }
        return false;
    }

}
