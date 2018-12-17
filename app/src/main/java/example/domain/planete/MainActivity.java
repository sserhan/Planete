package example.domain.planete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final Planete[] initdata = {
            new Planete("Mercure", 58),
            new Planete("Vénus", 108),
            new Planete("Terre", 150),};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
