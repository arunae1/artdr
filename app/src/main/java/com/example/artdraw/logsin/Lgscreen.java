package com.example.artdraw.logsin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.artdraw.MainActivity;
import com.example.artdraw.R;
import com.google.firebase.auth.FirebaseAuth;

public class Lgscreen extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private EditText E1,E2;
    private Button button , button2;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lgscreen);
        firebaseAuth= FirebaseAuth.getInstance();
        button =(Button) findViewById(R.id.lgbtn);
        button2 =(Button) findViewById(R.id.skip);
        E1=findViewById(R.id.email);
        E2=findViewById(R.id.pass);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText((Context) Lgscreen.this,"Demo try Only",Toast.LENGTH_SHORT).show();
                Intent mai = new Intent(Lgscreen.this, MainActivity.class);
                startActivity(mai);
                finish();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String Email1 = E1.getText().toString();
                String Id1 = E2.getText().toString();
                if(!TextUtils.isEmpty(Email1)&&!TextUtils.isEmpty(Id1)) {
                    progressDialog = new ProgressDialog(Lgscreen.this);
                    progressDialog.setMessage("Registering Please wait..."); // Setting Message
                    progressDialog.show(); // Display Progress Dialog
                    if(firebaseAuth.getCurrentUser()!=null){
                        Intent mai = new Intent(Lgscreen.this, MainActivity.class);
                        startActivity(mai);
                        finish();
                    }


                    else {
                        Toast.makeText((Context) Lgscreen.this,"Register To try",Toast.LENGTH_SHORT).show();
                         progressDialog.dismiss();
                }
            }
            }
        });

    }
}