package com.example.batuhandemir.volleyballcounter.UI.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.batuhandemir.volleyballcounter.Entity.ScoreTableModel;
import com.example.batuhandemir.volleyballcounter.UI.Adapters.ScoreTableAdapter;
import com.example.batuhandemir.volleyballcounter.R;
import com.example.batuhandemir.volleyballcounter.UI.GlobalVar.GlobalVar;

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

    @Override
    public void onBackPressed() {
        backpressed_Message();
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

        click_imgBtnSetiBitir();
        click_imgBtnMaciBitir();
    }
    private void click_imgBtnTakimBirEdit(){
        imgBtnTakimBirEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_alertDialog(GlobalVar.birinciTakimEditID);
            }
        });
    }
    private void click_imgBtnTakimIkiEdit(){
        imgBtnTakimIkiEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_alertDialog(GlobalVar.ikinciTakimEditID);
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
                if(Integer.parseInt(txtEditTakimBirCount.getText().toString()) != 0 || Integer.parseInt(txtEditTakimIkiCount.getText().toString())!=0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert);
                    builder.setMessage("Seti Bitirmeyi Onaylıyor Musunuz ?")
                            .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ScoreTableModel scoreTableModel = new ScoreTableModel();
                                    scoreTableModel.setTakimBirAdi(txtEditTakimBir.getText().toString());
                                    scoreTableModel.setTakimBirScore(txtEditTakimBirCount.getText().toString());
                                    scoreTableModel.setTakimIkiAdi(txtEditTakimIki.getText().toString());
                                    scoreTableModel.setTakimIkiScore(txtEditTakimIkiCount.getText().toString());
                                    scoreList.add(scoreTableModel);
                                    ScoreTableAdapter adapter = new ScoreTableAdapter(getBaseContext(),scoreList);
                                    adapter.notifyDataSetChanged();
                                    listViewScore.setAdapter(adapter);

                                    txtEditTakimBirCount.setText("00");
                                    txtEditTakimIkiCount.setText("00");
                                    takimBirScore=00;
                                    takimIkiScore=00;
                                    dialogInterface.dismiss();
                                }
                            })
                            .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).show();
                }
            }
        });
    }
    private void click_imgBtnMaciBitir(){
        imgBtnMaciBitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert);
                builder.setMessage("Maç Bitir Tüm Veriler Sıfırlayıp Yeni Maç Açmak Demektir Onaylıyor Musunuz ?")
                        .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent gp = new Intent(MainActivity.this,MainActivity.class);
                                startActivity(gp);
                                dialogInterface.dismiss();
                            }
                        })
                        .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
    }

    private void show_alertDialog(final int editID){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.alert_dialog_edit_takim_name);
        dialog.setCancelable(false);

        TextView txtEditEskiTakimAdi = dialog.findViewById(R.id.txtEditEskiTakimAdi);
        final EditText editTextYeniTakimAdi = dialog.findViewById(R.id.editTextYeniTakimAdi);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        Button btnEdit = dialog.findViewById(R.id.btnEdit);

        if(editID == GlobalVar.birinciTakimEditID){
            txtEditEskiTakimAdi.setText(txtEditTakimBir.getText().toString());
        }else if(editID == GlobalVar.ikinciTakimEditID){
            txtEditEskiTakimAdi.setText(txtEditTakimIki.getText().toString());
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextYeniTakimAdi.getText().toString().isEmpty() == false){
                    if(editID == GlobalVar.birinciTakimEditID){
                        txtEditTakimBir.setText(editTextYeniTakimAdi.getText().toString());
                        dialog.dismiss();
                    }else if(editID == GlobalVar.ikinciTakimEditID){
                        txtEditTakimIki.setText(editTextYeniTakimAdi.getText().toString());
                        dialog.dismiss();
                    }
                }else {
                    Toast.makeText(MainActivity.this,"Lütfen Takim İsmi Giriniz !!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }
    private void backpressed_Message(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_Material_Light_Dialog_Alert);
        builder.setMessage("Uygulamadan Çıkmak İstiyor Musunuz ?")
                .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }

}
