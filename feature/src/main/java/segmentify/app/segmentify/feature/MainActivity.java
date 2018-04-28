package segmentify.app.segmentify.feature;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        ImageView widgetInfoImg = findViewById(R.id.btnWidgetInfo);
        this.setTitle("Segmentify Performance");
        this.setTitleColor(Color.CYAN);
        widgetInfoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(v.getContext())
                        .title("Merhaba")
                        .content("kerem")
                        .positiveText("OKAY")
                        .show();
            }
        });


    }

}
