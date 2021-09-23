package com.example.qr_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import java.sql.BatchUpdateException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    EditText qrData;
    Button qrGenerate,qrScan;
    ImageView qrDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrData=(EditText)findViewById(R.id.inputText);
        qrGenerate=(Button)findViewById(R.id.generateQr);
        qrScan = (Button)findViewById(R.id.scanQr);
        qrDisplay=(ImageView)findViewById(R.id.displayQr);

        qrGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = qrData.getText().toString();

                // Initializing the QR Encoder with your value to be encoded, type you required and Dimension
                QRGEncoder qrgEncoder = new QRGEncoder(input, null, QRGContents.Type.TEXT, 600);
                qrgEncoder.setColorBlack(Color.BLACK);
                qrgEncoder.setColorWhite(Color.WHITE);
                // Getting QR-Code as Bitmap
                Bitmap qrBit = qrgEncoder.getBitmap();
                // Setting Bitmap to ImageView
                qrDisplay.setImageBitmap(qrBit);

            }
        });

    }
}