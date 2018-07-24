package android.kevin.fightautism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText etPass, etUsername;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mAuth = FirebaseAuth.getInstance();

        etPass = findViewById(R.id.password);
        etUsername = findViewById(R.id.username);

        b1 = findViewById(R.id.bb1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EtUsername = etUsername.getText().toString().trim();
                String EtPassword = etPass.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(EtUsername, EtPassword);
                Toast.makeText(getApplicationContext(),"Now click proceed",Toast.LENGTH_SHORT).show();

                /*FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser == null) {
                    Toast.makeText(getApplicationContext(),"Sign in Failed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sign in Success",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),HomeScreen.class);
                    startActivity(i);
                }
                */
            }
        });

        b2=findViewById(R.id.bb2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if (currentUser == null) {
                    Toast.makeText(getApplicationContext(),"Sign in Failed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Sign in Success",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),HomeScreen.class);
                    startActivity(i);
                }
            }
        });


    }

}
