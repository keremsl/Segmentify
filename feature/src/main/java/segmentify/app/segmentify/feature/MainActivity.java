package segmentify.app.segmentify.feature;

import android.content.Context;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.isapanah.awesomespinner.AwesomeSpinner;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.Duration;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Context context = this;
    private DrawerLayout mDrawerLayout;
    List<String> dashboard_spinner = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        setNavigationViewListener();

        dashboard_spinner.add("Segmentify Performance");
        dashboard_spinner.add("Website Performance");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        //Calendar nextYear = Calendar.getInstance();
        //nextYear.add(Calendar.YEAR, 1);

      //  CalendarPickerView calendar = findViewById(R.id.calendar_view);
       // Date today = new Date();
       // calendar.init(today, nextYear.getTime())
         //       .inMode(new Date())

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.menu);

     //   AwesomeSpinner my_spinner = (AwesomeSpinner) findViewById(R.id.material_spinner);
      //  List<String> categories = new ArrayList<String>();
      //  categories.add("Segmentify");
      //  categories.add("Your Website");

      // ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        //my_spinner.setAdapter(categoriesAdapter);
       /* MaterialSpinner materialSpinner = findViewById(R.id.material_spinner);
        materialSpinner.setItems(dashboard_spinner);

        materialSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                switch (position){
                    case 0:
                        Toast.makeText(context,"Segmentify",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context,"Website",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
*/
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ImageView infoWidget = findViewById(R.id.info_widget);
        ImageView interactionWidget = findViewById(R.id.info_interaction);
        ImageView revenueWidget = findViewById(R.id.info_revenue);
        ImageView basketWidget = findViewById(R.id.info_basket);

        infoWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(context)                                                     /* show info about widget */
                        .title("Widget")
                        .content(R.string.info_widget)
                        .show();
            }
        });

        interactionWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(context)
                        .title("Interaction")
                        .content(R.string.info_interaction)                                              /* show info about interaction */
                        .show();
            }
        });

        revenueWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(context)                                                     /* show info about revenue */
                        .title("Revenue")
                        .content(R.string.info_revenue)
                        .show();
            }
        });

        basketWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(context)                                                     /* show info about basket */
                        .title("Basket")
                        .content(R.string.info_basket)
                        .show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.nav_item_reco) {
                Toast.makeText(context, "recos", Toast.LENGTH_SHORT).show();
            }
        return false;
        }



    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    }

