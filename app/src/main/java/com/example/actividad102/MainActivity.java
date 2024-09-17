package com.example.actividad102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText urlInput;
    private Button openWebPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos del layout
        urlInput = findViewById(R.id.urlInput);
        openWebPageButton = findViewById(R.id.openWebPageButton);

        // Listener para el botón que abrirá la página en WebViewActivity
        openWebPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlInput.getText().toString(); // Obtener la URL
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url; // Asegurarse de que tenga el prefijo HTTP o HTTPS
                }

                // Iniciar la actividad WebViewActivity y pasar la URL
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
