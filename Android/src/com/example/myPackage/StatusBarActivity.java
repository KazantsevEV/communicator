package com.example.myPackage;

import org.qtproject.qt5.android.bindings.QtActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.view.View;
import android.graphics.Color;
import android.content.Context;

public class StatusBarActivity extends QtActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public int Test() {
        return 7;
    }
}
