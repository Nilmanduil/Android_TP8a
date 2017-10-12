package fr.codevallee.formation.android_tp8a;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button sendButton = (Button) findViewById(R.id.smsButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberField = (EditText) findViewById(R.id.number);
                String number = numberField.getText().toString();

                Uri uri = Uri.parse("smsto:" +  number);
                Intent intent = new Intent(android.content.Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", number);
                startActivity(intent);
            }
        });

        Button callButton = (Button) findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberField = (EditText) findViewById(R.id.number);
                String number = numberField.getText().toString();

                Uri telephone = Uri.parse("tel:"+number);
                Intent secondeActivite = new Intent(Intent.ACTION_DIAL, telephone);
                startActivity(secondeActivite);
            }
        });
    }
}
