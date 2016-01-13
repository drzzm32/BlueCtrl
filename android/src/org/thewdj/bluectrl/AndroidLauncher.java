package org.thewdj.bluectrl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;


public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BlueTooth.Main.Init(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), DeviceList.class);
            startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);

            AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
            initialize(new BlueCtrlNative(), config);
        } else {
            AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
            initialize(new BlueCtrl(), config);
        }
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        BlueTooth.Main.DisConnect();
        BlueTooth.Main.Dispose();
        Gdx.app.exit();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if (resultCode == Activity.RESULT_OK)
                BlueTooth.Main.BT.connect(data);
            else
                Gdx.app.exit();
        }
    }
}

