package com.example.application;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.application.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    
    Button add;
    AlertDialog dialog;
    LinearLayout layout;

    int main =0;


    //민경 변수
    CheckBox CheckBox_check1, CheckBox_check2, CheckBox_check3;

    LinearLayout LinearLayout_morning, LinearLayout_afternoon, LinearLayout_night;
    LinearLayout LinearLayout_morningDetails, LinearLayout_afternoonDetails, LinearLayout_nightDitails;

    private Button Button_add1, Button_add2, Button_add3;
    private CheckBox check1_1, check2_1, check3_1;
    //private TextView EditText_routine;
    //----------------------------------------------------------

    //card 에서 ->창으로
    public CardView card1;

    public CheckBox check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost)findViewById(R.id.th);
        tabHost.setup();

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("ROUTINE").setIndicator("Routine");
        tabSpecSong.setContent(R.id.tabRoutine);
        tabHost.addTab(tabSpecSong);

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("CHALLENGE").setIndicator("Challenge");
        tabSpecArtist.setContent(R.id.tabChallenge);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("MYPAGE").setIndicator("My Page");
        tabSpecAlbum.setContent(R.id.tabMyPage);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);

        //----------------------------------------------------------

        //경민의 코드

        add = findViewById(R.id.add);

        layout= findViewById(R.id.container);

        buildDialog();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });


        card1 = (CardView)findViewById(R.id.c1);

        card1.setOnClickListener(this);


        /*
        setContentView(R.layout.activity_one);
        ImageView imageAddNoteMain = findViewById(R.id.imageAddNoteMain);

        imageAddNoteMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateNoteActivity.class);
                startActivity(intent);


            }
        });
    */

        //----------------------------------------------------------

        //민경 코드
        //init
        LinearLayout_morningDetails = findViewById(R.id.LinearLayout_morningDetails);
        LinearLayout_morning = findViewById(R.id.LinearLayout_morning);
        LinearLayout_morning.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        LinearLayout_afternoonDetails = findViewById(R.id.LinearLayout_afternoonDetails);
        LinearLayout_afternoon = findViewById(R.id.LinearLayout_afternoon);
        LinearLayout_afternoon.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        LinearLayout_nightDitails = findViewById(R.id.LinearLayout_nightDetails);
        LinearLayout_night = findViewById(R.id.LinearLayout_night);
        LinearLayout_night.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        //----------------------------------------------------------

        Button_add1 = (Button)findViewById(R.id.Button_add1);
        check1_1 = (CheckBox)findViewById(R.id.check1_1);

        Button_add2 = (Button)findViewById(R.id.Button_add2);
        check2_1 = (CheckBox)findViewById(R.id.check2_1);

        Button_add3 = (Button)findViewById(R.id.Button_add3);
        check3_1 = (CheckBox)findViewById(R.id.check3_1);

        Button_add1.setOnClickListener(this);
        Button_add2.setOnClickListener(this);
        Button_add3.setOnClickListener(this);
    }

    //----------------------------------------------------------

    //민경 함수

    //카드뷰 접었다 폈다
    public void expand(View view){
        int v1 = (LinearLayout_morningDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(LinearLayout_morning, new AutoTransition());
        LinearLayout_morningDetails.setVisibility(v1);

        int v2 = (LinearLayout_afternoonDetails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(LinearLayout_afternoon, new AutoTransition());
        LinearLayout_afternoonDetails.setVisibility(v2);

        int v3 = (LinearLayout_nightDitails.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(LinearLayout_night, new AutoTransition());
        LinearLayout_nightDitails.setVisibility(v3);
    }
    //----------------------------------------------------------

    //경민 함수
    private void buildDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog,null);
        EditText name = view.findViewById(R.id.name);
        builder.setView(view);
        builder.setTitle("Enter name")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                }).setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {


            }
        });

        dialog= builder.create();
    }

    //Card 눌리면 새 Activity
    @Override
    //Card 눌리면 새 Activity
    public void onClick(View v) {
        Intent i;

        switch(v.getId())
        {
            case R.id.c1 :
                i = new Intent(this,One.class);
                startActivity(i);
                break;
            case (R.id.Button_add1):
                CustomDialog dialog1 = new CustomDialog(this);
                dialog1.setDialogListener(new CustomDialog.CustomDialogListener() {
                    @Override
                    public void onPositiveClicked(String name) {
                        check1_1.setText(name);
                    }

                    @Override
                    public void onNegativeClicked() {

                    }
                });
                dialog1.show();
                break;
            case (R.id.Button_add2):
                CustomDialog dialog2 = new CustomDialog(this);
                dialog2.setDialogListener(new CustomDialog.CustomDialogListener() {
                    @Override
                    public void onPositiveClicked(String name) {
                        check2_1.setText(name);
                    }

                    @Override
                    public void onNegativeClicked() {

                    }
                });
                dialog2.show();
                break;
            case (R.id.Button_add3):
                CustomDialog dialog3 = new CustomDialog(this);
                dialog3.setDialogListener(new CustomDialog.CustomDialogListener() {
                    @Override
                    public void onPositiveClicked(String name) {
                        check3_1.setText(name);
                    }

                    @Override
                    public void onNegativeClicked() {

                    }
                });
                dialog3.show();
                break;
        }
    }

    //----------------------------------------------------------


}