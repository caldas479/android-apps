package pt.ulisboa.tecnico.cmov.basicThreading;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;


public class MainActivity extends ComponentActivity {

    private Thread tickerThread;
    private boolean isTickerRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.start_button);
        Button stopButton = findViewById(R.id.stop_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTicker();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTicker();
            }
        });
    }

    private void startTicker() {
        if (!isTickerRunning) {
            isTickerRunning = true;
            Runnable tickerLogic = new Runnable() {
                private int counter = 0;

                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(1000);
                            Log.d("Ticker", "Counter: " + counter++);
                        } catch (InterruptedException e) {
                            Log.d("Ticker", "Ticker thread interrupted.");
                            Thread.currentThread().interrupt();
                        }
                    }
                    isTickerRunning = false;
                }
            };
            tickerThread = new Thread(tickerLogic, "Ticker Thread");
            tickerThread.start();
        }
    }

    private void stopTicker() {
        if (isTickerRunning && tickerThread != null) {
            tickerThread.interrupt();
        }
    }
}
