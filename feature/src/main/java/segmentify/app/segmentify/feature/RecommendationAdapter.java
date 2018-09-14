package segmentify.app.segmentify.feature;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.angads25.toggle.LabeledSwitch;

import java.util.ArrayList;
import java.util.List;

public class RecommendationAdapter extends ArrayAdapter<Recommendation> {

    //the list values in the List of type hero
    List<Recommendation> recoList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    public RecommendationAdapter(@NonNull Context context, int resource, @NonNull List<Recommendation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.recoList = objects;
    }


    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        TextView recoPage = view.findViewById(R.id.txt_recoPageType);
        TextView recoName = view.findViewById(R.id.txt_recoName);
        LabeledSwitch _recoSwitch = view.findViewById(R.id.switch_recoState); // TODO -!

        //getting the hero of the specified position
        Recommendation reco = recoList.get(position);


        recoPage.setText(reco.get_recoPageType());
        recoName.setText(reco.get_recoName());


        //adding a click listener to the button to remove item from the list
        _recoSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //we will call this method to remove the selected value from the list
                //we are passing the position which is to be removed in the method
              //  removeHero(position);
            }
        });

        //finally returning the view
        return view;
    }

    //this method will remove the item from the list
  /*  private void removeHero(final int position) {
        //Creating an alert dialog to confirm the deletion
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete this?");


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    */
}
