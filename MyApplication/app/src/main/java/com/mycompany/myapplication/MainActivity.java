package com.mycompany.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText inputColor;
    Button btnSearch;
    TextView txtResult;
    View background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obtener las views
        inputColor = findViewById(R.id.input_color);
        btnSearch = findViewById(R.id.btn_search);
        txtResult = findViewById(R.id.txt_result);
        background = findViewById(R.id.background);
    }

    /**
     * retorna el texto ingresado por el usuario en la EditText
     */
    private String getInput() {
        return inputColor.getText().toString().toLowerCase();
    }

    /**
     * llamado desde el boton de "buscar color"
     */
    public void onSearchClick(View view) {
        String input = getInput();
        int resourceId = getResourceId(input);

        //mostrar nombre del color
        String colorName = getColorName(resourceId);
        txtResult.setText(colorName);

        //setear color de fondo
        int color = getColorFromRes(resourceId);
        background.setBackgroundColor(color);
    }

    /**
     * retorna el nombre de un color segun el archivo colors.xml
     */
    private String getColorName(int resourceId) {
        if (resourceId > 0) {
            return getResources().getResourceEntryName(resourceId);
        } else {
            return getString(R.string.transparente);
        }
    }

    /**
     * retorna un color hex
     */
    private int getColorFromRes(int resourceId) {
        int color = Color.TRANSPARENT;
        if (resourceId > 0) {
            color = getResources().getColor(resourceId);
        }

        return color;
    }

    /**
     * busca un resource id segun el atributo "name" en colors.xml
     */
    private int getResourceId(String resName) {
        return getResources().getIdentifier(resName, "color", getPackageName());
    }
}
