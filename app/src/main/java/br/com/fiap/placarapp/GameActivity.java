package br.com.fiap.placarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private String timeCasa;
    private String timeVisitante;

    private TextView tvTimeCasa;
    private TextView tvTimeVisitante;

    private int golCasa;
    private int golVisitante;

    private TextView tvPlacarTimeCasa;
    private TextView tvPlacarTimeVisitante;

    private static final String GOL_CASA = "GOLCASA";
    private static final String GOL_VISITANTE = "GOLVISITANTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvTimeCasa = (TextView) findViewById(R.id.tvTimeCasa);
        tvTimeVisitante = (TextView) findViewById(R.id.tvTimeVisitante);
        tvPlacarTimeCasa = (TextView) findViewById(R.id.tvPlacarTimeCasa);
        tvPlacarTimeVisitante = (TextView) findViewById(R.id.tvPlacarTimeVisitante);

        if (getIntent() != null) {
            timeCasa = getIntent().getStringExtra(MainActivity.TIME_CASA);
            timeVisitante = getIntent().getStringExtra(MainActivity.TIME_VISITANTE);

            tvTimeCasa.setText(timeCasa);
            tvTimeVisitante.setText(timeVisitante);
        }

        if (savedInstanceState != null) {
            golCasa = savedInstanceState.getInt(GOL_CASA);
            golVisitante = savedInstanceState.getInt(GOL_VISITANTE);
        }
        tvPlacarTimeCasa.setText(String.valueOf(golCasa));
        tvPlacarTimeVisitante.setText(String.valueOf(golVisitante));
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void golCasa(View v) {
        golCasa++;
        tvPlacarTimeCasa.setText(String.valueOf(golCasa));
    }

    public void golVisitante(View v) {
        golVisitante++;
        tvPlacarTimeVisitante.setText(String.valueOf(golVisitante));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(GOL_CASA, golCasa);
        outState.putInt(GOL_VISITANTE, golVisitante);
    }

}
