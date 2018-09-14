package segmentify.app.segmentify.feature;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.Duration;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Context context = this;
    private DrawerLayout mDrawerLayout;
    ListView _listview = null; // Reco list for this account
    ScrollView scrollView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        setNavigationViewListener();
         _listview = findViewById(R.id.recoLa); // Reco list for this account
        scrollView = findViewById(R.id.base);
        final CardView thisMontCard = findViewById(R.id.card_interval_thisMonth);
        final CardView yesterdayCard = findViewById(R.id.card_interval_yesterday);
        final CardView todayCard = findViewById(R.id.card_interval_today);                                                  // UPPER MENU FOR CHOOSING TIME INTERVAL //
        final TextView txtView_month = findViewById(R.id.card_interval_thisMonth_txt);
        final TextView txtView_yesterday = findViewById(R.id.card_interval_yesterday_txt);
        final TextView txtView_today = findViewById(R.id.card_interval_today_txt);




        /* ------------------------------- INIT DASHBOARD CONTAINERS ----------------------------- -------------- */

        final ArrayList<View> sgmContainers = new ArrayList<>();
        final ArrayList<View> websiteContainers = new ArrayList<>();

        View IsegWidget = findViewById(R.id.IsgmWidget);
        View IsegBasket = findViewById(R.id.IsgmBasket);
        View IsegRevenue = findViewById(R.id.IsgmRevenue);
        View IsegInteractıon = findViewById(R.id.IsgmInteraction);

        View IwebsitePageView = findViewById(R.id.IwebsitePageView);
        View IwebsiteDevice = findViewById(R.id.IwebsiteDevice);
        View IwebsiteRevenue = findViewById(R.id.IwebsiteRevenue);
        View IwebsiteVisitors = findViewById(R.id.IwebsiteVisitors);

        sgmContainers.add(IsegBasket);
        sgmContainers.add(IsegInteractıon);
        sgmContainers.add(IsegRevenue);
        sgmContainers.add(IsegWidget);

        websiteContainers.add(IwebsiteDevice);
        websiteContainers.add(IwebsitePageView);
        websiteContainers.add(IwebsiteRevenue);
        websiteContainers.add(IwebsiteVisitors);


        /* -------------------------------------------------------------------------------------------------*/




        /* -------------------------------CARD LISTENERS FOR RETRIEVING TIME INTERVAL DATA AND DESIGN UTILS---------------------------------- */

        thisMontCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisMontCard.setCardBackgroundColor(Color.parseColor("#547494"));
                txtView_month.setTextColor(Color.parseColor("#FFFFFF"));
                yesterdayCard.setCardBackgroundColor(Color.parseColor("#e6e5f0"));
                todayCard.setCardBackgroundColor(Color.parseColor("#e6e5f0"));
                txtView_yesterday.setTextColor(Color.parseColor("#000000"));
                txtView_today.setTextColor(Color.parseColor("#000000"));
            }
        });

        todayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todayCard.setCardBackgroundColor(Color.parseColor("#547494"));
                txtView_today.setTextColor(Color.parseColor("#FFFFFF"));
                thisMontCard.setCardBackgroundColor(Color.parseColor("#e6e5f0"));
                yesterdayCard.setCardBackgroundColor(Color.parseColor("#e6e5f0"));
                txtView_yesterday.setTextColor(Color.parseColor("#000000"));
                txtView_month.setTextColor(Color.parseColor("#000000"));
            }
        });

        yesterdayCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesterdayCard.setCardBackgroundColor(Color.parseColor("#547494"));
                txtView_yesterday.setTextColor(Color.parseColor("#FFFFFF"));
                todayCard.setCardBackgroundColor(Color.parseColor("#e6e5f0"));
                thisMontCard.setCardBackgroundColor(Color.parseColor("#e6e5f0"));
                txtView_today.setTextColor(Color.parseColor("#000000"));
                txtView_month.setTextColor(Color.parseColor("#000000"));
            }
        });

        /* ----------------------------------------------------------------------------------------------------*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        Spinner uppermenuspinner = findViewById(R.id.segmentifyOryourwebsite_spn);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.site_options, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        uppermenuspinner.setAdapter(adapter);

        uppermenuspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        for (View v:
                                sgmContainers) {
                            v.setVisibility(View.VISIBLE);
                        }

                        for (View v:
                                websiteContainers) {
                            v.setVisibility(View.GONE);
                        }
                        break;
                    case 1:
                        for (View v:
                                sgmContainers) {
                            v.setVisibility(View.GONE);
                        }

                        for (View v:
                                websiteContainers) {
                            v.setVisibility(View.VISIBLE);
                        }
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.menu);


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
                        .content(R.string.info_interaction)        /* show info about interaction */
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



        List<Recommendation> _recos = new ArrayList<>(); // All Recos

        List<Recommendation> _liveRecos = new ArrayList<>();
        List<Recommendation> _testRecos = new ArrayList<>();

        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));
        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));
        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));
        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));
        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));
        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));
        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));
        _recos.add(new Recommendation(new Date(),"Example Reco - scn12431","Example Reco"));

        RecommendationAdapter recommendationAdapter = new RecommendationAdapter(this, R.layout.reco_template, _recos);

        _listview.setAdapter(recommendationAdapter);
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
        if (item.getItemId() == R.id.nav_item_reco) {
            _listview.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
            mDrawerLayout.closeDrawers();
        } else if(item.getItemId() == R.id.nav_item_dashboard){
            _listview.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
            mDrawerLayout.closeDrawers();
        }

        return false;
    }


    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

}

