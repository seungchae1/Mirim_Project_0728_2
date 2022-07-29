package kr.hs.emirim.s2125.mirim_project_0728_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String[] imgName = intent.getStringArrayExtra("imgName");
        int[] voteCount = intent.getIntArrayExtra("voteCount");

        TextView[] tv= new TextView[imgName.length];
        int[] textId = {R.id.text01, R.id.text02, R.id.text03, R.id.text04, R.id.text05, R.id.text06,
                    R.id.text06, R.id.text07, R.id.text08, R.id.text09};
        RatingBar[] rb = new RatingBar[voteCount.length];
        int[] rbId = {R.id.r1,R.id.r2,R.id.r3,R.id.r4, R.id.r5,R.id.r6,R.id.r7,R.id.r8,R.id.r9};

        for(int i=0; i< imgName.length; i++){
            tv[i] = findViewById(textId[i]);
            rb[i] = findViewById(rbId[i]);
            tv[i].setText(imgName[i]);
            rb[i].setRating(voteCount[i]);
        }
        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        int[] imgId={R.drawable.bh,R.drawable.rudtn,R.drawable.ssh,R.drawable.sm,R.drawable.sh,
                R.drawable.sb,R.drawable.duswns,R.drawable.tmdrhks,};

        TextView maxText = findViewById(R.id.max_text);
        ImageView maxImg = findViewById(R.id.max_img);
        int maxIndex=0;
        for(int i=1; i< imgId.length; i++){
            if(voteCount[i]>voteCount[maxIndex]) maxIndex=i;
        }
        maxText.setText("최다득표한 사진 이름 : "+imgName[maxIndex]);
        maxImg.setImageResource(imgId[maxIndex]);
    }
}