package com.example.exemplotimeredittext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePickerDialog tpHora;
    EditText edtHora;
    TextView tvHoraCapt;
    Button btnHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHoraCapt = (TextView) findViewById(R.id.lblHoraCapturada);
        edtHora = (EditText)findViewById(R.id.txtHora);
        edtHora.setInputType(InputType.TYPE_NULL);
        btnHora = (Button)findViewById(R.id.cmdMostrarHora);

        edtHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendario = Calendar.getInstance();
                int hora = calendario.get(Calendar.HOUR_OF_DAY);
                int minuto = calendario.get(Calendar.MINUTE);
                tpHora = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int shora, int sminuto) {
                        tvHoraCapt.setText(shora + ":" + sminuto);
                    }
                }, hora, minuto, true);
                tpHora.show();
            }
        });
    }
}