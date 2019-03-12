package com.gatech.astroworld.spacetrader.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.gatech.astroworld.spacetrader.R;
import com.gatech.astroworld.spacetrader.entity.GoodType;
import com.gatech.astroworld.spacetrader.model.Game;
import com.gatech.astroworld.spacetrader.model.Store;
import com.gatech.astroworld.spacetrader.views.market.Buy_ItemFragment;
import com.gatech.astroworld.spacetrader.views.market.Sell_ItemFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class market_Activity extends AppCompatActivity implements Buy_ItemFragment.OnListFragmentInteractionListener,
        Sell_ItemFragment.OnListFragmentInteractionListener {
    private BottomNavigationView bottomNav;
    private int selectedItem;
    public static TextView mBuyTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_activity);
        final NavController nav = Navigation.findNavController(this, R.id.nav_host_fragment);
        TextView remainingCredits = findViewById(R.id.yourCredits);
        mBuyTotal = findViewById(R.id.buyTotal);
        String credits = String.valueOf(Game.getInstance().getPlayer().getCredits());
        remainingCredits.setText("Remaining Credits: " + String.valueOf(Game.getInstance().getPlayer().getCredits()));
        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNavMenu);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.destination_buy:
                        nav.navigate(R.id.toBuyFragment);
                        return true;
                    case R.id.destination_sell:
                        nav.navigate(R.id.toSellFragment);
                        return true;
                    default: return false;
                }
            }
        });
    }

    @Override
    public void onListFragmentInteraction(Store.MarketGood item) {

    }

    @Override
    public void onListFragmentInteraction(GoodType item) {

    }

    public String updatePlayerCredits() {
        String cred = String.valueOf(Game.getInstance().getPlayer().getCredits());
        return  cred;
    }

//    @Override
//    public void onListFragmentInteraction(com.gatech.astroworld.spacetrader.views.market.dummy.DummyContent.DummyItem item) {
//
//    }
}
