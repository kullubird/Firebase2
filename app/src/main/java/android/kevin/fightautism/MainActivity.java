package android.kevin.fightautism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText etPass, etUsername;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etPass = findViewById(R.id.password);
        etUsername = findViewById(R.id.username);

        b1 = findViewById(R.id.b1);

        mAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            signUp();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignIn.class);
                startActivity(i);

            }
        });
    }

    private void signUp() {

        String EtUsername = etUsername.getText().toString().trim();
        String EtPassword = etPass.getText().toString().trim();

        // StrPhone=EtPhone.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(EtUsername, EtPassword);
    }
}