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
import com.guercifzone.tafsirahlam.UIFragment.Alif_Fragment;

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
        menuItems.add(new MenuItem(R.drawable.python, "Python"));
        menuItems.add(new MenuItem(R.drawable.java, "Java"));
        menuItems.add(new MenuItem(R.drawable.android, "Android"));
        menuItems.add(new MenuItem(R.drawable.html, "Html"));
        menuItems.add(new MenuItem(R.drawable.c, "C"));
        menuItems.add(new MenuItem(R.drawable.cplusplus, "Cplusplus"));
        menuItems.add(new MenuItem(R.drawable.csharp, "CSharp"));
        menuItems.add(new MenuItem(R.drawable.css, "Css"));
        menuItems.add(new MenuItem(R.drawable.go, "Go"));
        menuItems.add(new MenuItem(R.drawable.graphic, "Graphics"));
        menuItems.add(new MenuItem(R.drawable.ios, "Ios"));
        menuItems.add(new MenuItem(R.drawable.javascript, "javaScript"));
        menuItems.add(new MenuItem(R.drawable.kotlin, "Kotlin"));
        menuItems.add(new MenuItem(R.drawable.msoffice, "MsOffice"));
        menuItems.add(new MenuItem(R.drawable.perl, "Perl"));
        menuItems.add(new MenuItem(R.drawable.php, "PHP"));
        menuItems.add(new MenuItem(R.drawable.ruby, "Ruby"));
        menuItems.add(new MenuItem(R.drawable.swift, "Swift"));
        menuItems.add(new MenuItem(R.drawable.vbnet, "Vb.net"));
        menuItems.add(new MenuItem(R.drawable.asp, "Asp"));
        menuItems.add(new MenuItem(R.drawable.database,"DataBase"));
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
                        fragmentClass = Fragment_Java.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = Fragment_Android.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = Fragment_Html.class;
                        break;
                    }
                    case 4:{
                        fragmentClass = Fragment_C.class;
                        break;
                    }
                    case 5:{
                        fragmentClass = Fragment_CPlusPlus.class;
                        break;
                    }
                    case 6:{
                        fragmentClass = Fragment_CSharp.class;
                        break;
                    }
                    case 7:{
                        fragmentClass = Fragment_Css.class;
                        break;
                    }
                    case 8:{
                        fragmentClass = Fragment_Go.class;
                        break;
                    }
                    case 9:{
                        fragmentClass = Fragment_Graphics.class;
                        break;
                    }
                    case 10:{
                        fragmentClass = Fragment_IOS.class;
                        break;
                    }
                    case 11:{
                        fragmentClass = Fragment_JavaScript.class;
                        break;
                    }
                    case 12:{
                        fragmentClass = Fragment_kotlin.class;
                        break;
                    }
                    case 13:{
                        fragmentClass = Fragment_MsOffice.class;
                        break;
                    }
                    case 14:{
                        fragmentClass = Fragment_Perl.class;
                        break;
                    }
                    case 15:{
                        fragmentClass = Fragment_PHP.class;
                        break;
                    }
                    case 16:{
                        fragmentClass = Fragment_Ruby.class;
                        break;
                    }
                    case 17:{
                        fragmentClass = Fragment_Swift.class;
                        break;
                    }
                    case 18:{
                        fragmentClass = Fragment_Vbnet.class;
                        break;
                    }
                    case 19:{
                        fragmentClass = Fragment_Asp.class;
                        break;
                    }
                    case 20:{
                        fragmentClass = Fragment_DataBase.class;
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