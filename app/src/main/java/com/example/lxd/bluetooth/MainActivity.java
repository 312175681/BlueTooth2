package com.example.lxd.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取蓝牙适配器
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "没有获取到蓝牙适配器", Toast.LENGTH_SHORT).show();
            finish();

        }
        //如果沒有开启
        if (!bluetoothAdapter.isDiscovering()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 1);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Toast.makeText(this,"开启蓝牙",Toast.LENGTH_SHORT).show();
            }else if (resultCode==RESULT_CANCELED){
                Toast.makeText(this,"没有开启蓝牙",Toast.LENGTH_SHORT).show();
                finish();

            }
        }





    }
}

