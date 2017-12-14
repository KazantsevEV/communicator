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
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.speech.RecognizerIntent;
import java.util.List;
import java.util.ArrayList;

public class SpeechRecognition extends QtActivity
{

        public static void run(Activity ownerActivity) {
                // проверяем есть ли активити для распознавания
                if (isSpeechRecognitionActivityPresented(ownerActivity) != true)
                    // начинаем процесс установки
                    installGoogleVoiceSearch(ownerActivity);
        }

        private static boolean isSpeechRecognitionActivityPresented(Activity ownerActivity) {
                try {
                        // получаем экземпляр менеджера пакетов
                        PackageManager pm = ownerActivity.getPackageManager();
                        // получаем список активити способных обработать запрос на распознавание
                        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);

                        if (activities.size() != 0) {	// если список не пустой
                                return true;            // то умеем распознавать речь
                        }
                } catch (Exception e) {

                }

                return false; // не умеем распозновать речь
        }

        public static Intent createRecognitionIntent() {
            Intent intent = null;

            // создаем Intent с действием RecognizerIntent.ACTION_RECOGNIZE_SPEECH
            intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

            // добаляем дополнительные параметры:
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Идет запись");	// текстовая подсказка пользователю
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM/*LANGUAGE_MODEL_WEB_SEARCH*/);	// модель распознавания
            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.br.portablevision");
            intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);	// количество результатов, которое мы хотим получить
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ru-RU");

            return intent;
        }

        private static void startRecognitionActivity(Activity ownerActivity) {

        // создаем Intent с действием RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                // добаляем дополнительные параметры:
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Идет запись");	// текстовая подсказка пользователю
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);	// модель распознавания
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);	// количество резальтатов, которое мы хотим получить
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ru-RU");

        // стартуем активити и ждем от нее результата
        ownerActivity.startActivityForResult(intent, 1/*SystemData.VOICE_RECOGNITION_REQUEST_CODE*/);
        }

        private static void installGoogleVoiceSearch(final Activity ownerActivity) {

                // создаем диалог, который спросит у пользователя хочет ли он
                // установить Голосовой Поиск
                Dialog dialog = new AlertDialog.Builder(ownerActivity)
                        .setMessage("Для распознавания речи необходимо установить \"Голосовой поиск Google\"")	// сообщение
                        .setTitle("Внимание")	// заголовок диалога
                        .setPositiveButton("Установить", new DialogInterface.OnClickListener() {	// положительная кнопка

                                // обработчик нажатия на кнопку Установить
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                        try {
                                                // создаем Intent для открытия в маркете странички с приложением
                                                // Голосовой Поиск имя пакета: com.google.android.voicesearch
                                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.voicesearch"));
                                                // настраиваем флаги, чтобы маркет не папал к в историю нашего приложения (стек активити)
                                                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                                                // отправляем Intent
                                                ownerActivity.startActivity(intent);
                                         } catch (Exception ex) {
                                                 // неудалось открыть маркет
                                                 // например из-за того что он не установлен
                                                 // ничего не подалаешь
                                         }
                                }})

                        .setNegativeButton("Отмена", null)	// негативная кнопка
                        .create();

                dialog.show();	// показываем диалог
        }
}

//public class SpeechRecognition extends QtActivity
//{
//    public void test()
//    {
//        System.out.println("Test OK!");
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

////    public void startRecognition() {
////        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

////        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Идет запись");	// текстовая подсказка пользователю
////        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM/*LANGUAGE_MODEL_WEB_SEARCH*/);	// модель распознавания
////        //intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.br.portablevision");
////        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);	// количество результатов, которое мы хотим получить
////        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ru-RU");

////        startActivityForResult(intent, 5);
////    }

//    public Intent startRecognition() {
//        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Идет запись");	// текстовая подсказка пользователю
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM/*LANGUAGE_MODEL_WEB_SEARCH*/);	// модель распознавания
//        //intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, "com.br.portablevision");
//        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);	// количество результатов, которое мы хотим получить
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ru-RU");
//        return intent;
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            System.out.println(requestCode);
//            System.out.println(resultCode);

//            if (resultCode == RESULT_OK) {
//                ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//               // if ( matches ! = null && matches . size () > 0 && matches . get ( 0 ). length () > 0 )
//                    System.out.println(matches);


//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }
//}
