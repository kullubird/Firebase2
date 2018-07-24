package android.kevin.fightautism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends AppCompatActivity {

    Button signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        signout=findViewById(R.id.logout_btn);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth mAuth=FirebaseAuth.getInstance();
                mAuth.signOut();

                Intent i=new Intent(getApplicationContext(),SignIn.class);
                startActivity(i);
            }
        });
    }
}
