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
import java.util.List;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.speech.RecognizerIntent;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.speech.RecognizerIntent;
import java.util.ArrayList;

public class SpeechRecognition extends QtActivity
{
    public void test()
    {
        System.out.println("Test OK!");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    public void startRecognition() {
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Идет запись");	// текстовая подсказка пользователю
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM/*LANGUAGE_MODEL_WEB_SEARCH*/);	// модель распознавания
//        //intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.br.portablevision");
//        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);	// количество результатов, которое мы хотим получить
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ru-RU");

//        startActivityForResult(intent, 5);
//    }

    public Intent startRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Идет запись");	// текстовая подсказка пользователю
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM/*LANGUAGE_MODEL_WEB_SEARCH*/);	// модель распознавания
        //intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.br.portablevision");
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);	// количество результатов, которое мы хотим получить
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ru-RU");
        return intent;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println(requestCode);
        System.out.println(resultCode);

        if (resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            System.out.println(matches);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
