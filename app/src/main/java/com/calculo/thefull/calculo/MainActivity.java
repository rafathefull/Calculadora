package com.calculo.thefull.calculo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView display;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnmas;
    private Button btnmenos;
    private Button btnmult;
    private Button btndiv;
    private Button btnce;
    private double nResult;
    private String cAcumulador;
    private int operacion;
    private Button btnigual;
    private double operador;
    private double operadando;
    private Button btnpunto;


    public void setAcumulador( String cAccumulator ) {
        this.cAcumulador += cAccumulator;
        display.setText( this.cAcumulador );

    }
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nResult = 0.0;
        operador = 0.0;
        operadando = 0.0;
        cAcumulador = "";

        btn0 = ( Button ) findViewById(R.id.btn0);
        btn1 = ( Button ) findViewById(R.id.btn1);
        btn2 = ( Button ) findViewById(R.id.btn2);
        btn3 = ( Button ) findViewById(R.id.btn3);
        btn4 = ( Button ) findViewById(R.id.btn4);
        btn5 = ( Button ) findViewById(R.id.btn5);
        btn6 = ( Button ) findViewById(R.id.btn6);
        btn7 = ( Button ) findViewById(R.id.btn7);
        btn8 = ( Button ) findViewById(R.id.btn8);
        btn9 = ( Button ) findViewById(R.id.btn9);
        btnmas = ( Button ) findViewById(R.id.btnmas);
        btnmenos = ( Button ) findViewById(R.id.btnmenos);
        btnce = ( Button ) findViewById(R.id.btnce);
        btnigual = ( Button ) findViewById(R.id.btnigual);
        btnpunto = ( Button ) findViewById(R.id.btnpunto);
        btnmult = ( Button ) findViewById(R.id.btnmult);
        btndiv = ( Button ) findViewById(R.id.btndiv);

        display = ( TextView ) findViewById(R.id.display );
        display.setText("");

        btnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nResult = 0.0;
                operador = 0.0;
                operadando = 0.0;
                cAcumulador = "";
                display.setText("");
            }
        });

        btnpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador(".");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("1");
            }
        } );
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("2");
            }
        } );
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("3");
            }
        } );
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("4");
            }
        } );
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("5");
            }
        } );
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("6");
            }
        } );
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("7");
            }
        } );
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("8");
            }
        } );
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAcumulador("9");
            }
        } );


        btnmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    operador = Double.parseDouble( cAcumulador );
                    cAcumulador = "";
                    operacion = 1;
                    display.setText("");

            }
        } );

        btnmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    operador = Double.parseDouble( cAcumulador );
                    cAcumulador = "";
                    operacion = 2;
                    display.setText("" );
            }
        } );

        btnmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = Double.parseDouble( cAcumulador );
                cAcumulador = "";
                operacion = 3;
                display.setText("" );
            }
        } );

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador = Double.parseDouble( cAcumulador );
                cAcumulador = "";
                operacion = 4;
                display.setText("" );
            }
        } );



        btnigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !cAcumulador.isEmpty() && operacion != 0 )  {
                    operadando = Double.parseDouble( cAcumulador );
                  try {
                      switch (operacion) {
                          case 1:
                              nResult = operador + operadando;
                              break;
                          case 2:
                              nResult = operador - operadando;
                              break;
                          case 3:
                              nResult = operador * operadando;
                              break;
                          case 4:
                              nResult = operador / operadando;
                              break;
                      }
                  } catch ( ArithmeticException e ){
                    nResult = 0;
                  }

                    display.setText(Double.toString( nResult ) );
                    cAcumulador = Double.toString( nResult ) ;
                    operacion = 0;
                    operador = 0;
                    operadando = 0;
                }
            }
        } );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
