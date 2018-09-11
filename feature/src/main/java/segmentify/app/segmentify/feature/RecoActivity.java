package segmentify.app.segmentify.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class RecoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reco);
        ArrayList<Recommendation> recos = new ArrayList<>();
        recos.add(new Recommendation(new Date(),"Search Page - scn123123123","Selected For You"));
        recos.add(new Recommendation(new Date(),"Search Page - scn123123123","Selected For You"));
        recos.add(new Recommendation(new Date(),"Search Page - scn123123123","Selected For You"));              // DUMMY DATA
        recos.add(new Recommendation(new Date(),"Search Page - scn123123123","Selected For You"));
        recos.add(new Recommendation(new Date(),"Search Page - scn123123123","Selected For You"));


        ListView recoList = findViewById(R.id.recoL);
        RecommendationAdapter recommendationAdapter = new RecommendationAdapter(recos,this);
        recoList.setAdapter(recommendationAdapter);
    }




}
