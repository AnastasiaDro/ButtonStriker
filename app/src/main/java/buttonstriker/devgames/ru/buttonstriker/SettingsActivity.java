package buttonstriker.devgames.ru.buttonstriker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class SettingsActivity extends AppCompatActivity {

    public static final String START_BTN_SIZE = "START_BTN_SIZE";
    public static final String THIRD_BTN_SIZE = "THIRD_BTN_SIZE";
    public static final String FIFTH_BTN_SIZE = "FIFTH_BTN_SIZE";
    public static final String KEYBOARD_SIZE = "KEYBOARD_SIZE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    //обработка нажатий на кнопки, задающие размер для кнопки "Жми!"
    public void onBeginSizeBtnSClick(View view) {

    }

    public void onBtnBackClick(View view) {
        finish();
    }
}
