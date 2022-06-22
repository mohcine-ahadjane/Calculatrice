package com.example.calcuatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int valeur1=0;
    private int valeur2=0;
    private String operation="";
    private Boolean isOp1=true;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
    }


    public void afficher() {
        if (!isOp1) {
            textView.setText(String.valueOf(valeur1) + " " + operation + String.valueOf(valeur2));
        } else textView.setText(String.valueOf(valeur1));
    }
    public void setOperator(View view){
         switch (view.getId()){
                case R.id.plus: operation="+";       break;
                case R.id.moin: operation="-";       break;
                case R.id.fois: operation="*";       break;
                case R.id.divisePar: operation="/";  break;
                default: return;
         }
         isOp1=false;
         afficher();
    }

    public void ajouterNbr(View view){
        int val = Integer.parseInt(((Button)view).getText().toString());
        if(isOp1){
            valeur1 = valeur1*10+val;
        }
        else {
            valeur2=valeur2*10+val;

        }
        afficher();
    }

    public void calculer(View view){
        if (!isOp1){
            switch (operation){
                case "+": valeur1=valeur1+valeur2;  break;
                case "-": valeur1=valeur1-valeur2;  break;
                case "*": valeur1=valeur1*valeur2;  break;
                case "/": valeur1=valeur1/valeur2;  break;
                default: return;
            }
            valeur2=0;
            isOp1=true;
            afficher();
        }
    }

    public void clean(View view){
        valeur1=0;
        valeur2=0;
        isOp1=true;
        operation="";
        afficher();
    }
}