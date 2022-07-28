package kr.hs.emirim.s2125.mirim_project_0728_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] imgName = {"백현","디오","수호","시우민","세훈","카이","수빈","연준","승관"};
    ImageView[] imgv = new ImageView[imgName.length];
    int[] voteCount = new int[imgName.length];
    int[] imgId = {R.id.img1, R.id.img2, R.id.img3, R.id.img4, R.id.img5, R.id.img6,
                    R.id.img7, R.id.img8, R.id.img9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("선호하는 남자 아이돌 투표");
        Button btnFinish = findViewById(R.id.btn_vote_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("imgName", imgName);
                intent.putExtra("voteCount", voteCount);
                startActivity(intent);
            }
        });
        for(int i=0; i<voteCount.length; i++){
            voteCount[i]=0;
        }
        for(int i=0; i<imgv.length; i++){
            final int index;
            index =i;
            imgv[index] = findViewById(imgId[index]);
            imgv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index]+" : 총"+voteCount[index]+"표", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}