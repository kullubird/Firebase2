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

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


    }

    private void signIn() {
        String EtUsername = etUsername.getText().toString().trim();
        String EtPassword = etPass.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(EtUsername, EtPassword);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Toast.makeText(getApplicationContext(),"Sign in Failed",Toast.LENGTH_SHORT);
        }
        else{
            Toast.makeText(getApplicationContext(),"Sign in Success",Toast.LENGTH_SHORT);
            Intent i=new Intent(getApplicationContext(),HomeScreen.class);
            startActivity(i);
        }
    }
}
