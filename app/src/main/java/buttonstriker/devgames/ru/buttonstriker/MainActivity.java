package buttonstriker.devgames.ru.buttonstriker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    //графика
    private Button button;
    private TextView touchCountValue;
    private TextView pressCountValue;
    private TextView strikeValue;


    //изменитель кнопки
    MyButtonChanger myButtonChanger;
//textView для обработки касаний
    private TextView touchMe;

    //счётчик нажатий на экран
    private Integer touch = 0;
    //счётчик нажатий на кнопку
    private Integer press = 0;
    //счётчик последовательных попаданий
    private Integer strike = 0;
    //переменная для смены направлений смещения кнопки
    private int mod = -1;

    //флаг попадания
    private boolean flag = false;

    //переменные нового размера кнопки
    int newBtnHigh;
    int newBtnWight;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        touchCountValue = findViewById(R.id.screenTouchCount);
        pressCountValue = findViewById(R.id.btnPressedCount);
        strikeValue = findViewById(R.id.strikeValue);
        touchMe = findViewById(R.id.touchMe);
        touchMe.setOnTouchListener(this);
        myButtonChanger = new MyButtonChanger(this.getBaseContext(), button);

    }

    //обработка касания на экран
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                touch++;
                strike = 0;
                //увеличиваем счётчик на экране;
                touchCountValue.setText(touch.toString());
                strikeValue.setText(strike.toString());
                flag = false;
                break;
//            case MotionEvent.ACTION_MOVE: // движение
//
//                break;
//            case MotionEvent.ACTION_UP: // отпускание
//            case MotionEvent.ACTION_CANCEL:
//
//                break;
        }

        return true;
    }



    public void onClick(View view) {
        //показываем, что попал в кнопку
        press++;
        System.out.println(press);;
        touch++;
        if (flag = true) {
            strike++;
        }
        else {
            strike = 1;
        }
        pressCountValue.setText(press.toString());
        touchCountValue.setText(touch.toString());
        strikeValue.setText(strike.toString());
        flag = true;

        //пробуем менять положение
        if (strike %3 == 0) {
            myButtonChanger.changeBtnAlingment(mod);
            mod=mod*(-2);
        }
        //изменим размер кнопки
        if (strike % 9 == 0) {
            mod=-1;
            myButtonChanger.changeBtnSize();
        }

        }



    }

