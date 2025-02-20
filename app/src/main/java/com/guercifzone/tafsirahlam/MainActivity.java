package com.guercifzone.tafsirahlam;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.guercifzone.tafsirahlam.CustomDrawer.MenuItem;
import com.guercifzone.tafsirahlam.CustomDrawer.SNavigationDrawer;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir18_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir1_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir2_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir15_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir8_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir9_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir20_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir19_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir26_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir5_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir7_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir23_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir24_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir25_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir21_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir10_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir14_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir13_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir12_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir3_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir16_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir4_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir17_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir27_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir28_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Tafsir11_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
SNavigationDrawer sNavigationDrawer;
int color1 = 0;
Class fragmentClass;
public static Fragment fragment;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("حرف الألف",R.drawable.alif));
        menuItems.add(new MenuItem("حرف الباء",R.drawable.baa));
        menuItems.add(new MenuItem("حرف التاء",R.drawable.taa));
        menuItems.add(new MenuItem("حرف الثاء",R.drawable.taae));
        menuItems.add(new MenuItem("حرف الجيم",R.drawable.jim));
        menuItems.add(new MenuItem("حرف الحاء",R.drawable.haa));
        menuItems.add(new MenuItem("حرف الخاء",R.drawable.khaa));
        menuItems.add(new MenuItem("حرف الدال",R.drawable.dall));
        menuItems.add(new MenuItem("حرف الذال",R.drawable.thaal));
        menuItems.add(new MenuItem("حرف السين",R.drawable.sin));
        menuItems.add(new MenuItem("حرف الشين",R.drawable.shin));
        menuItems.add(new MenuItem("حرف الصاد",R.drawable.saad));
        menuItems.add(new MenuItem("حرف الضاد",R.drawable.daad));
        menuItems.add(new MenuItem("حرف الطاء",R.drawable.taae));
        menuItems.add(new MenuItem("حرف الظاد",R.drawable.thaee));
        menuItems.add(new MenuItem("حرف العين",R.drawable.iin));
        menuItems.add(new MenuItem("حرف الغين",R.drawable.ghin));
        menuItems.add(new MenuItem("حرف الفاء",R.drawable.faa));
        menuItems.add(new MenuItem("حرف القاف",R.drawable.qaaf));
        menuItems.add(new MenuItem("حرف الكاف",R.drawable.kaff));
        menuItems.add(new MenuItem("حرف  اللام",R.drawable.laam));
        menuItems.add(new MenuItem("حرف الميم",R.drawable.miim));
        menuItems.add(new MenuItem("حرف النون",R.drawable.noon));
        menuItems.add(new MenuItem("حرف الهاء",R.drawable.haae));
        menuItems.add(new MenuItem("حرف الواو",R.drawable.waaw));
        menuItems.add(new MenuItem("حرف الياء",R.drawable.yaae));

        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  Tafsir1_Fragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.framelayout, fragment).commit();
        }
        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);
                switch (position){
                    case 0:{
                        fragmentClass = Tafsir1_Fragment.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = Tafsir2_Fragment.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = Tafsir3_Fragment.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = Tafsir4_Fragment.class;
                        break;
                    }
                    case 4:{
                        fragmentClass = Tafsir5_Fragment.class;
                        break;
                    }
                    case 5:{
                        fragmentClass = Tafsir26_Fragment.class;
                        break;
                    }
                    case 6:{
                        fragmentClass = Tafsir7_Fragment.class;
                        break;
                    }
                    case 7:{
                        fragmentClass = Tafsir8_Fragment.class;
                        break;
                    }
                    case 8:{
                        fragmentClass = Tafsir17_Fragment.class;
                        break;
                    }
                    case 9:{
                        fragmentClass = Tafsir10_Fragment.class;
                        break;
                    }
                    case 10:{
                        fragmentClass = Tafsir11_Fragment.class;
                        break;
                    }
                    case 11:{
                        fragmentClass = Tafsir12_Fragment.class;
                        break;
                    }
                    case 12:{
                        fragmentClass = Tafsir13_Fragment.class;
                        break;
                    }
                    case 13:{
                        fragmentClass = Tafsir14_Fragment.class;
                        break;
                    }
                    case 14:{
                        fragmentClass = Tafsir15_Fragment.class;
                        break;
                    }
                    case 15:{
                        fragmentClass = Tafsir16_Fragment.class;
                        break;
                    }
                    case 16:{
                        fragmentClass = Tafsir9_Fragment.class;
                        break;
                    }
                    case 17:{
                        fragmentClass = Tafsir18_Fragment.class;
                        break;
                    }
                    case 18:{
                        fragmentClass = Tafsir19_Fragment.class;
                        break;
                    }
                    case 19:{
                        fragmentClass = Tafsir20_Fragment.class;
                        break;
                    }
                    case 20:{
                        fragmentClass = Tafsir21_Fragment.class;
                        break;
                    }
                    case 21:{
                        fragmentClass = Tafsir7_Fragment.class;
                        break;
                        }
                    case 22:{
                        fragmentClass = Tafsir23_Fragment.class;
                        break;
                    }
                    case 23:{
                        fragmentClass = Tafsir24_Fragment.class;
                        break;
                    }
                    case 24:{
                        fragmentClass = Tafsir25_Fragment.class;
                        break;
                    }
                    case 25:{
                        fragmentClass = Tafsir26_Fragment.class;
                        break;
                    }
                    case 26:{
                        fragmentClass = Tafsir27_Fragment.class;
                        break;
                    }
                    case 27:{
                        fragmentClass = Tafsir28_Fragment.class;
                        break;
                    }
                }

                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.framelayout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State "+newState);
                    }
                });
            }
        });

    }
}