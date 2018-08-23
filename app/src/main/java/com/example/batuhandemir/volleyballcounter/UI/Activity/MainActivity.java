package com.example.batuhandemir.volleyballcounter.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.batuhandemir.volleyballcounter.Entity.ScoreTableModel;
import com.example.batuhandemir.volleyballcounter.UI.Adapters.ScoreTableAdapter;
import com.example.batuhandemir.volleyballcounter.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ImageView imgBtnTakimBirEdit;
    private ImageView imgBtnTakimIkiEdit;
    private TextView txtEditTakimBir;
    private TextView txtEditTakimIki;

    private ImageView imgBtnTakimBirCountAdd;
    private ImageView imgBtnTakimBirCountDelete;
    private TextView txtEditTakimBirCount;
    private ImageView imgBtnTakimIkiCountAdd;
    private ImageView imgBtnTakimIkiCountDelete;
    private TextView txtEditTakimIkiCount;

    private ImageView imgBtnSetiBitir;
    private ImageView imgBtnMaciBitir;

    private ListView listViewScore;

    private static List<ScoreTableModel> scoreList = new ArrayList<>();
    private static int takimBirScore = 00;
    private static int takimIkiScore = 00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Register_Handler();
    }

    private void init() {
        imgBtnTakimBirEdit = findViewById(R.id.imgBtnTakimBirEdit);
        imgBtnTakimIkiEdit = findViewById(R.id.imgBtnTakimIkiEdit);
        txtEditTakimBir = findViewById(R.id.txtEditTakimBir);
        txtEditTakimIki = findViewById(R.id.txtEditTakimIki);

        imgBtnTakimBirCountAdd = findViewById(R.id.imgBtnTakimBirCountAdd);
        imgBtnTakimBirCountDelete = findViewById(R.id.imgBtnTakimBirCountDelete);
        txtEditTakimBirCount = findViewById(R.id.txtEditTakimBirCount);
        imgBtnTakimIkiCountAdd = findViewById(R.id.imgBtnTakimIkiCountAdd);
        imgBtnTakimIkiCountDelete = findViewById(R.id.imgBtnTakimIkiCountDelete);
        txtEditTakimIkiCount = findViewById(R.id.txtEditTakimIkiCount);

        imgBtnSetiBitir = findViewById(R.id.imgBtnSetiBitir);
        imgBtnMaciBitir = findViewById(R.id.imgBtnMaciBitir);

        listViewScore = findViewById(R.id.listViewScore);
    }
    private void Register_Handler() {
        Register_Handler_Click();
    }

    private void Register_Handler_Click(){
        click_imgBtnTakimBirEdit();
        click_imgBtnTakimIkiEdit();
        click_imgBtnTakimBirCountAdd();
        click_imgBtnTakimBirCountDelete();
        click_imgBtnTakimIkiCountAdd();
        click_imgBtnTakimIkiCountDelete();
    }
    private void click_imgBtnTakimBirEdit(){
        imgBtnTakimBirEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void click_imgBtnTakimIkiEdit(){
        imgBtnTakimIkiEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void click_imgBtnTakimBirCountAdd(){
        imgBtnTakimBirCountAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takimBirScore ++;
                if(takimBirScore < 10)
                    txtEditTakimBirCount.setText("0"+String.valueOf(takimBirScore));
                else
                    txtEditTakimBirCount.setText(String.valueOf(takimBirScore));
            }
        });
    }
    private void click_imgBtnTakimBirCountDelete(){
        imgBtnTakimBirCountDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(takimBirScore != 0){
                    takimBirScore --;
                    if(takimBirScore < 10)
                        txtEditTakimBirCount.setText("0"+String.valueOf(takimBirScore));
                    else
                        txtEditTakimBirCount.setText(String.valueOf(takimBirScore));

                }
            }
        });
    }
    private void click_imgBtnTakimIkiCountAdd(){
        imgBtnTakimIkiCountAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takimIkiScore ++;
                if(takimIkiScore < 10)
                    txtEditTakimIkiCount.setText("0"+String.valueOf(takimIkiScore));
                else
                    txtEditTakimIkiCount.setText(String.valueOf(takimIkiScore));
            }
        });
    }
    private void click_imgBtnTakimIkiCountDelete(){
        imgBtnTakimIkiCountDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(takimIkiScore != 0){
                    takimIkiScore --;
                    if(takimIkiScore < 10)
                        txtEditTakimIkiCount.setText("0"+String.valueOf(takimIkiScore));
                    else
                        txtEditTakimIkiCount.setText(String.valueOf(takimIkiScore));

                }
            }
        });
    }

    private void click_imgBtnSetiBitir(){
        imgBtnSetiBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreTableModel scoreTableModel = new ScoreTableModel();
                scoreTableModel.setTakimBirAdi(txtEditTakimBir.getText().toString());
                scoreTableModel.setTakimBirScore(txtEditTakimBirCount.getText().toString());
                scoreTableModel.setTakimIkiAdi(txtEditTakimIki.getText().toString());
                scoreTableModel.setTakimIkiScore(txtEditTakimIkiCount.getText().toString());
                scoreList.add(scoreTableModel);
                ScoreTableModel
            }
        });
    }





}
