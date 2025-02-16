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
import com.guercifzone.tafsirahlam.UIFragment.Aaa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Alif_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Baa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Daad_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Dall_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Dthaa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Faa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Ghaa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Haae_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Jim_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Khaa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Laam_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Miim_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Noon_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Qaa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Raa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Saad_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Shin_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Sin_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Taa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Taae_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Thaa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Thaal_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Waaw_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Yaa_Fragment;
import com.guercifzone.tafsirahlam.UIFragment.Zaa_Fragment;

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
        fragmentClass =  Alif_Fragment.class;
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
                        fragmentClass = Alif_Fragment.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = Baa_Fragment.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = Taa_Fragment.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = Thaa_Fragment.class;
                        break;
                    }
                    case 4:{
                        fragmentClass = Jim_Fragment.class;
                        break;
                    }
                    case 5:{
                        fragmentClass = Haae_Fragment.class;
                        break;
                    }
                    case 6:{
                        fragmentClass = Khaa_Fragment.class;
                        break;
                    }
                    case 7:{
                        fragmentClass = Dall_Fragment.class;
                        break;
                    }
                    case 8:{
                        fragmentClass = Thaal_Fragment.class;
                        break;
                    }
                    case 9:{
                        fragmentClass = Raa_Fragment.class;
                        break;
                    }
                    case 10:{
                        fragmentClass = Zaa_Fragment.class;
                        break;
                    }
                    case 11:{
                        fragmentClass = Sin_Fragment.class;
                        break;
                    }
                    case 12:{
                        fragmentClass = Shin_Fragment.class;
                        break;
                    }
                    case 13:{
                        fragmentClass = Saad_Fragment.class;
                        break;
                    }
                    case 14:{
                        fragmentClass = Daad_Fragment.class;
                        break;
                    }
                    case 15:{
                        fragmentClass = Taae_Fragment.class;
                        break;
                    }
                    case 16:{
                        fragmentClass = Dthaa_Fragment.class;
                        break;
                    }
                    case 17:{
                        fragmentClass = Aaa_Fragment.class;
                        break;
                    }
                    case 18:{
                        fragmentClass = Ghaa_Fragment.class;
                        break;
                    }
                    case 19:{
                        fragmentClass = Faa_Fragment.class;
                        break;
                    }
                    case 20:{
                        fragmentClass = Qaa_Fragment.class;
                        break;
                    }
                    case 21:{
                        fragmentClass = Khaa_Fragment.class;
                        break;
                        }
                    case 22:{
                        fragmentClass = Laam_Fragment.class;
                        break;
                    }
                    case 23:{
                        fragmentClass = Miim_Fragment.class;
                        break;
                    }
                    case 24:{
                        fragmentClass = Noon_Fragment.class;
                        break;
                    }
                    case 25:{
                        fragmentClass = Haae_Fragment.class;
                        break;
                    }
                    case 26:{
                        fragmentClass = Waaw_Fragment.class;
                        break;
                    }
                    case 27:{
                        fragmentClass = Yaa_Fragment.class;
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