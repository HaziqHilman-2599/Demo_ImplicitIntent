package sg.edu.rp.c347.id19023980.demoimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnEmail;
    EditText editTextMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.editTextMessage);
        btnEmail = findViewById(R.id.buttonEmail);

        btnEmail.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,"Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,editTextMessage.getText());
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose an Email client"));
            }
        });
    }
}
