package org.thewdj.bluectrl.utility;

import com.badlogic.gdx.Gdx;

/**
 * Created by D.zzm on 2015.6.16.
 */
public class Utility {

    public static float Distance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow((double) x2 - (double) x1, (double) 2) + Math.pow((double) y2 - (double) y1, (double) 2));
    }

    public static boolean IsTouched() {
        return Gdx.input.isTouched();
    }

    public static boolean IsTouched(int Pointer) {
        return Gdx.input.isTouched(Pointer);
    }

    public static float GetX() {
        return Gdx.input.getX();
    }

    public static float GetX(int Pointer) {
        return Gdx.input.getX(Pointer);
    }

    public static float GetY() {
        return Gdx.graphics.getHeight() - Gdx.input.getY();
    }

    public static float GetY(int Pointer) {
        return Gdx.graphics.getHeight() - Gdx.input.getY(Pointer);
    }

    public static float GetDX() {
        return Gdx.input.getDeltaX();
    }

    public static float GetDX(int Pointer) {
        return Gdx.input.getDeltaX(Pointer);
    }

    public static float GetDY() {
        return -Gdx.input.getDeltaY();
    }

    public static float GetDY(int Pointer) {
        return -Gdx.input.getDeltaY(Pointer);
    }

    public class STGCore{
    	
      /*
    	private void LoadBullet() {
            CtrlValueA = 50;
            CtrlValueB = 50;
            for (int i = 0; i <= CtrlValueA; i++) {
                for (int j = 0; j <= CtrlValueB; j++) {
                    Bullets[i][j] = new BulletObject();
                }
            }
        }
    	
    	private void GenBullet() {
            Double DoubleTmp;
            if (Time < 1500) {
                CtrlValueA = 20;
                CtrlValueB = 40;
                for (int i = 0; i <= CtrlValueA; i++) {
                    for (int j = 0; j <= CtrlValueB; j++) {
                        if ((!Bullets[i][j].IsEnabled) && (Time % 2 == 0)) {
                            DoubleTmp = Math.cos(i) + i * Math.cos(0.15d * j);
                            Bullets[i][j].x = DoubleTmp.floatValue() + (DeviceWidth / 2);
                            DoubleTmp = Math.sin(i) - i * Math.sin(0.15d * j);
                            Bullets[i][j].y = DoubleTmp.floatValue() + (DeviceHeight * 0.75f);

                            DoubleTmp = Math.random();
                            Bullets[i][j].r = 0.2f + 0.8f * DoubleTmp.floatValue();
                            DoubleTmp = Math.random();
                            Bullets[i][j].g = 0.2f + 0.8f * DoubleTmp.floatValue();
                            DoubleTmp = Math.random();
                            Bullets[i][j].b = 0.2f + 0.8f * DoubleTmp.floatValue();
                            DoubleTmp = Math.random();
                            //Bullets[i][j].a = 0.6f * DoubleTmp.floatValue();
                            Bullets[i][j].a = 1.0f;
                            DoubleTmp = 360d * Math.random();
                            Bullets[i][j].Rotate = DoubleTmp.intValue();
                            DoubleTmp = Math.random();
                            //Bullets[i][j].ScaleXY = 0.5f + DoubleTmp.floatValue();
                            Bullets[i][j].ScaleXY = 1.0f;

                            Bullets[i][j].Direction = Math.random() > 0.5d;

                            Bullets[i][j].IsEnabled = true;
                        }
                        Bullets[i][j].dx = (Bullets[i][j].x - (DeviceWidth / 2)) / 40;
                        Bullets[i][j].dy = (Bullets[i][j].y - (DeviceHeight * 0.75f)) / 40;
                        Bullets[i][j].x = Bullets[i][j].x + Bullets[i][j].dx / 2;
                        Bullets[i][j].y = Bullets[i][j].y + Bullets[i][j].dy / 2;
                    }
                }
            } else if (Time < 2000) {
                for (int i = 0; i <= CtrlValueA; i++) {
                    for (int j = 0; j <= CtrlValueB; j++) {
                        Bullets[i][j].dx = (Bullets[i][j].x - (DeviceWidth / 2)) / 40;
                        Bullets[i][j].dy = (Bullets[i][j].y - (DeviceHeight * 0.75f)) / 40;
                        Bullets[i][j].x = Bullets[i][j].x + Bullets[i][j].dx / 2;
                        Bullets[i][j].y = Bullets[i][j].y + Bullets[i][j].dy / 2;
                    }
                }
            } else {
                CtrlValueA = 20;
                CtrlValueB = 40;
                for (int i = 0; i <= CtrlValueA; i++) {
                    for (int j = 0; j <= CtrlValueB; j++) {
                        if ((!Bullets[i][j].IsEnabled) && (Time % 10 == 0)) {
                            DoubleTmp = Math.cos(i) + j * Math.cos(0.15d * j);
                            Bullets[i][j].x = DoubleTmp.floatValue() + (DeviceWidth / 2);
                            DoubleTmp = Math.sin(i) - j * Math.sin(0.15d * j);
                            Bullets[i][j].y = DoubleTmp.floatValue() + (DeviceHeight * 0.75f);

                            DoubleTmp = Math.random();
                            Bullets[i][j].r = 0.2f + 0.8f * DoubleTmp.floatValue();
                            DoubleTmp = Math.random();
                            Bullets[i][j].g = 0.2f + 0.8f * DoubleTmp.floatValue();
                            DoubleTmp = Math.random();
                            Bullets[i][j].b = 0.2f + 0.8f * DoubleTmp.floatValue();
                            DoubleTmp = Math.random();
                            //Bullets[i][j].a = 0.6f * DoubleTmp.floatValue();
                            Bullets[i][j].a = 1.0f;
                            DoubleTmp = 360d * Math.random();
                            Bullets[i][j].Rotate = DoubleTmp.intValue();
                            DoubleTmp = Math.random();
                            //Bullets[i][j].ScaleXY = 0.5f + DoubleTmp.floatValue();
                            Bullets[i][j].ScaleXY = 1.0f;

                            Bullets[i][j].Direction = Math.random() > 0.5d;

                            Bullets[i][j].IsEnabled = true;
                        }
                        Bullets[i][j].dx = (Bullets[i][j].x - (DeviceWidth / 2)) / 20;
                        Bullets[i][j].dy = (Bullets[i][j].y - (DeviceHeight * 0.75f)) / 20;
                        Bullets[i][j].x = Bullets[i][j].x + Bullets[i][j].dx / 2;
                        Bullets[i][j].y = Bullets[i][j].y + Bullets[i][j].dy / 2;
                    }
                }
            }


        }

        private void DrawBullet() {
            for (int i = 0; i <= CtrlValueA; i++) {
                for (int j = 0; j <= CtrlValueB; j++) {
                    if (Bullets[i][j].IsEnabled) {
                        if (Bullets[i][j].Direction) {
                            DrawCoreObj.DrawPic(TexBullet, Bullets[i][j].x, Bullets[i][j].y, Bullets[i][j].Rotate + Angle, Bullets[i][j].ScaleXY, Bullets[i][j].ScaleXY, Bullets[i][j].r, Bullets[i][j].g, Bullets[i][j].b, Bullets[i][j].a);
                        } else {
                            DrawCoreObj.DrawPic(TexBullet, Bullets[i][j].x, Bullets[i][j].y, Bullets[i][j].Rotate - Angle, Bullets[i][j].ScaleXY, Bullets[i][j].ScaleXY, Bullets[i][j].r, Bullets[i][j].g, Bullets[i][j].b, Bullets[i][j].a);
                        }
                    }
                }
            }
        }

        public void JudgeBullet() {
            final float Min = 8.0f;
            final float Max = 22.0f;
            for (int i = 0; i <= CtrlValueA; i++)
                for (int j = 0; j <= CtrlValueB; j++) {
                    if (Bullets[i][j].IsEnabled && Bullets[i][j].PreJudge(PlayerX, PlayerY, 500)) {
                        if (Bullets[i][j].Judge(PlayerX, PlayerY, Min, Max) == BulletObject.JUDGE_AWAY && !Bullets[i][j].IsGrazed) {
                            Bullets[i][j].IsGrazed = true;
                        }
                        if (Bullets[i][j].Judge(PlayerX, PlayerY, Min, Max) == BulletObject.JUDGE_GRAZE && Bullets[i][j].IsGrazed) {
                            Bullets[i][j].IsGrazed = false;
                            Graze++;
                            GRA.play();
                        }
                        if (Bullets[i][j].Judge(PlayerX, PlayerY, Min, Max) == BulletObject.JUDGE_MISS) {
                            Bullets[i][j].IsEnabled = false;
                            Miss++;
                            BIU.play();
                            PlayerX = DeviceWidth / 2;
                            PlayerY = DeviceHeight / 10;
                        }
                    }
                }
        }

        public void Control() {
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) PlayerY = PlayerY + 2;
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) PlayerY = PlayerY - 2;
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) PlayerX = PlayerX - 2;
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) PlayerX = PlayerX + 2;
            } else {
                if (Gdx.input.isKeyPressed(Input.Keys.UP)) PlayerY = PlayerY + 5;
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) PlayerY = PlayerY - 5;
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) PlayerX = PlayerX - 5;
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) PlayerX = PlayerX + 5;
            }

            if (Gdx.input.isTouched()) {
                PlayerX = PlayerX + Gdx.input.getDeltaX();
                PlayerY = PlayerY - Gdx.input.getDeltaY();
            }
        }

        private void JudgeBorder() {
            for (int i = 0; i <= CtrlValueA; i++) {
                for (int j = 0; j <= CtrlValueB; j++) {
                    if (Bullets[i][j].IsEnabled) {
                        if (!Flag) {
                            if (Bullets[i][j].x < -300 || Bullets[i][j].x > DeviceWidth + 300 || Bullets[i][j].y < -100 || Bullets[i][j].y > DeviceHeight + 100)
                                Bullets[i][j].Init();
                        } else {
                            if (Utility.Distance(Bullets[i][j].x, Bullets[i][j].y, DeviceWidth / 2, DeviceHeight / 2) > Math.max(DeviceWidth, DeviceHeight))
                                Bullets[i][j].Init();
                        }
                    }
                }
            }

            if (PlayerX > DeviceWidth) PlayerX = DeviceWidth;
            if (PlayerY > DeviceHeight) PlayerY = DeviceHeight;
            if (PlayerX < 0) PlayerX = 0;
            if (PlayerY < 0) PlayerY = 0;
        }
        
        BIU = Gdx.audio.newSound(Gdx.files.internal("BIU.ogg"));
        GRA = Gdx.audio.newSound(Gdx.files.internal("Graze.ogg"));
        */
    }
}
