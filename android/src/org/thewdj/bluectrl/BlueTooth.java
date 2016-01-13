package org.thewdj.bluectrl;

import android.content.Intent;
import android.widget.Toast;
import android.content.Context;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;

/**
 * Created by drzzm on 2016.1.1.
 */
public class BlueTooth {

    public static class Main {

        public static BluetoothSPP BT;
        public static Toast T;

        public static boolean Init(Context context) {
            BT = new BluetoothSPP(context);

            if (BT.isBluetoothEnabled()) {
                if (BT.isBluetoothAvailable()) {
                    BT.setupService();
                    BT.startService(BluetoothState.DEVICE_OTHER);
                    return true;
                } else {
                    T = Toast.makeText(context,R.string.toast_bluetooth_unavailable, Toast.LENGTH_LONG);
                    T.show();
                    return false;
                }
            } else {
                T = Toast.makeText(context,R.string.toast_bluetooth_off, Toast.LENGTH_LONG);
                T.show();
                return false;
            }

        }

        public static void Dispose() {
            BT.stopService();
        }

        public static String[] GetPairedDeviceName() {
            return BT.getPairedDeviceName();
        }

        public static void Connect(Intent Data) {
            BT.connect(Data);
        }

        public static void Connect(String DeviceName) {
            String[] Names = BT.getPairedDeviceName();
            String[] Adds = BT.getPairedDeviceAddress();
            for (int i = 0; i < Names.length; i++) {
                if (Names[i].equals(DeviceName)) {
                    BT.connect(Adds[i]);
                    break;
                }
            }
        }

        public static void DisConnect() {
            BT.disconnect();
        }

        public static void Send(String Data) {
            BT.send(Data, false);
        }

        public static void Sendln(String Data) {
            BT.send(Data, true);
        }

    }

}
