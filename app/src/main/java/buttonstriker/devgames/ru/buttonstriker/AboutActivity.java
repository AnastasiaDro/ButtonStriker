package buttonstriker.devgames.ru.buttonstriker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void goFacebook(View v){
        TextView faceBookUrlText = findViewById(R.id.faceBookUrlText);
        Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100001054275331");
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(browserIntent);
    }
}
