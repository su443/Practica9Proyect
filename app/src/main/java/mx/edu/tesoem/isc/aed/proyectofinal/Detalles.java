package mx.edu.tesoem.isc.aed.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    TextView dlbmatricula,dlbnombre,dlbpromedio,dlbcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        dlbmatricula = findViewById(R.id.dlblmatricula);
        dlbnombre = findViewById(R.id.dlblnombre);
        dlbpromedio = findViewById(R.id.dlblcorreo);
        dlbpromedio = findViewById(R.id.dlblpromedio);


        String nombre = getIntent().getExtras().get("Nombre").toString();
        DatosParcelable dato = getIntent().getParcelableExtra("DatosParcelable");

        dlbmatricula.setText(dato.getMatricula());
        dlbnombre.setText(dato.getNombre());
        dlbcorreo.setText(dato.getCorreo());
        dlbpromedio.setText(dato.getPromedio());

        getSupportActionBar().setTitle(nombre);
    }
}
