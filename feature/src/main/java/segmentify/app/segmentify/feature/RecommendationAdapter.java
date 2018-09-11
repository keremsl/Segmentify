package segmentify.app.segmentify.feature;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecommendationAdapter extends BaseAdapter {


    ArrayList<Recommendation> reco;
    Activity activity;
    LayoutInflater layoutInflater;


    public RecommendationAdapter(ArrayList<Recommendation> reco, Activity activity) {
        this.reco = reco;
        this.activity = activity;
        this.layoutInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View recoCard = convertView;
        if(convertView==null){
            layoutInflater.inflate(R.layout.reco_template,null);
        }

        TextView recoPageType = (TextView) recoCard.findViewById(R.id.txt_recoPageType);
        TextView recoName = (TextView) recoCard.findViewById(R.id.txt_recoName);
        TextView recoDate = (TextView) recoCard.findViewById(R.id.txt_recoDate);

        recoPageType.setText(reco.get(position).get_recoPageType());
        recoName.setText(reco.get(position).get_recoName());
        recoDate.setText(reco.get(position).get_recoDate().toString());


        return recoCard;
    }
}
