package buttonstriker.devgames.ru.buttonstriker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class SettingsActivity extends AppCompatActivity {

    public static final int START_BTN_SIZE = 0;
    public static final int THIRD_BTN_SIZE = 50;
    public static final int FIFTH_BTN_SIZE = 90;
    public static final int KEYBOARD_SIZE = 111;

    public final static String ANSWER_BTN_SIZE = "ANSWER_BTN_SIZE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    //обработка нажатий на кнопки, задающие размер для кнопки "Жми!"
    public void onBeginSizeBtnSClick(View view) {
        Intent answerIntent = new Intent();

        switch (view.getId()){
            case R.id.btnStartFromBeginning:
                answerIntent.putExtra(ANSWER_BTN_SIZE, START_BTN_SIZE);
                break;
            case R.id.moves3btn:
                answerIntent.putExtra(ANSWER_BTN_SIZE,THIRD_BTN_SIZE);
                break;
            case R.id.moves5btn:
                answerIntent.putExtra(ANSWER_BTN_SIZE, FIFTH_BTN_SIZE);
                break;
            case R.id.btnKeyboardSize:
                answerIntent.putExtra(ANSWER_BTN_SIZE, KEYBOARD_SIZE);
                break;
            default:
                break;
        }
        setResult(RESULT_OK, answerIntent);
        finish();
    }

    public void onBtnBackClick(View view) {
        finish();
    }
}
