package com.example.batuhandemir.volleyballcounter.UI.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.batuhandemir.volleyballcounter.Entity.ScoreTableModel;
import com.example.batuhandemir.volleyballcounter.R;

import java.util.List;

public class ScoreTableAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<ScoreTableModel> scoreTableModels;

    public ScoreTableAdapter(Context context, List<ScoreTableModel> scoreTableModels) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.scoreTableModels = scoreTableModels;
    }

    @Override
    public int getCount() {
        return scoreTableModels.size();
    }

    @Override
    public Object getItem(int position) {
        return scoreTableModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = mInflater.inflate(R.layout.list_item_score,null);

        TextView txtEditSetNumarasi = rowView.findViewById(R.id.txtEditSetNumarasi);
        TextView txtEditTakimBir = rowView.findViewById(R.id.txtEditTakimBir);
        TextView txtEditTakimBirScore = rowView.findViewById(R.id.txtEditTakimBirScore);
        TextView txtEditTakimIki = rowView.findViewById(R.id.txtEditTakimIki);
        TextView txtEditTakimIkiScore = rowView.findViewById(R.id.txtEditTakimIkiScore);

        txtEditSetNumarasi.setText(position+1 +".Set");
        txtEditTakimBir.setText(scoreTableModels.get(position).getTakimBirAdi());
        txtEditTakimBirScore.setText(scoreTableModels.get(position).getTakimBirScore());
        txtEditTakimIki.setText(scoreTableModels.get(position).getTakimIkiAdi());
        txtEditTakimIkiScore.setText(scoreTableModels.get(position).getTakimIkiScore());

        if(Integer.parseInt(scoreTableModels.get(position).getTakimBirScore()) > Integer.parseInt(scoreTableModels.get(position).getTakimIkiScore())){
            txtEditTakimBirScore.setTextColor(rowView.getContext().getColor(R.color.winner_text_color));
            txtEditTakimIkiScore.setTextColor(rowView.getContext().getColor(R.color.loser_text_color));
        }else {
            txtEditTakimBirScore.setTextColor(rowView.getContext().getColor(R.color.loser_text_color));
            txtEditTakimIkiScore.setTextColor(rowView.getContext().getColor(R.color.winner_text_color));
        }

        return rowView;
    }
}
