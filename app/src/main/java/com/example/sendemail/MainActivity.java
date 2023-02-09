package com.example.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mailTo;
    private EditText mailSubject;
    private EditText mailContent;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mailTo = findViewById(R.id.edit_mail_address);
        mailSubject =findViewById(R.id.edit_mail_subject);
        mailContent = findViewById(R.id.edit_mail_message);
        send = findViewById(R.id.send_email_button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{mailTo.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT, mailSubject.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT, mailContent.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it, "Choose Mail App"));
            }
        });
    }

}
