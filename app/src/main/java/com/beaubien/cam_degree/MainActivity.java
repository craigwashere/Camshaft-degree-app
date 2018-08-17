package com.beaubien.cam_degree;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


/*  Example case:
    IO = 31-degrees BTDC
    IC = 63-degrees ABDC
    EO = 77-degrees BBDC
    EC = 29-degrees ATDC

    Intake Duration = IO + 180 + IC = 274
    Exhaust Duration =  EO + 180 + EC = 286
    Intake Centerline =  (duration ÷ 2) – IO = 106 degrees
    Exhaust Centerline = (calculated duration ÷ 2) – EC = 114
    LSA = (intake centerline + exhaust centerline) ÷ 2 = 110 degrees
*/

public class MainActivity extends AppCompatActivity
{
    private OnUpdateFragmentDetail updater;

    public interface OnUpdateFragmentDetail
    {
        void update_details(lobe lobes);
    }

    private EditText text_intake_opens,
                     text_intake_closes;
    private EditText text_exhaust_opens,
                     text_exhaust_closes;

    float intake_opens, intake_closes, exhaust_opens, exhaust_closes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_intake_opens = (EditText) findViewById(R.id.text_intake_opens);
        text_intake_closes = (EditText) findViewById(R.id.text_intake_closes);

        text_exhaust_opens = (EditText) findViewById(R.id.text_exhaust_opens);
        text_exhaust_closes = (EditText) findViewById(R.id.text_exhaust_closes);


        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text_intake_closes.getText().toString().isEmpty())
                    intake_closes = 0;
                else
                    intake_closes = Float.valueOf(text_intake_closes.getText().toString());

                if (text_intake_opens.getText().toString().isEmpty())
                    intake_opens = 0;
                else
                    intake_opens = Float.valueOf(text_intake_opens.getText().toString());

                if (text_exhaust_opens.getText().toString().isEmpty())
                    exhaust_opens = 0;
                else
                    exhaust_opens = Float.valueOf(text_exhaust_opens.getText().toString());

                if (text_exhaust_closes.getText().toString().isEmpty())
                    exhaust_closes = 0;
                else
                    exhaust_closes = Float.valueOf(text_exhaust_closes.getText().toString());

                lobe lobes = new lobe(intake_opens, intake_closes, exhaust_opens, exhaust_closes);
                detail_fragment fragment = new detail_fragment();

                updater = fragment;

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_detail, fragment)
                        .commit();

                updater.update_details(lobes);

            }
        });
    }
}

