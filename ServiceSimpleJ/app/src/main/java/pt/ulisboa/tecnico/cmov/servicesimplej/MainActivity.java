package pt.ulisboa.tecnico.cmov.servicesimplej;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Start the service
    public void startService(View view) {
        GlobalClass globalClass = (GlobalClass) getApplication();
        globalClass.incrementCounter();

        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("counter", globalClass.getCounter());
        startService(intent);
    }

    // Stop the service
    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
