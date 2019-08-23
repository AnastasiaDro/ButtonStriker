package buttonstriker.devgames.ru.buttonstriker;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    //Создаём презентер
    private MainPresenter presenter = MainPresenter.getInstance();

    //графика
    private Button  buttonLeft;
    private Button buttonCenter;
    private Button buttonRight;
    private TextView touchCountValue;
    private TextView pressCountValue;
    private TextView strikeValue;

//

    //изменитель кнопки
    MyButtonChanger myButtonChanger;
   // MyNewButtonChanger myButtonChanger;
//textView для обработки касаний
    private FrameLayout touchMe;

//    //счётчик нажатий на экран
//    private Integer touch = 0;
//    //счётчик нажатий на кнопку
//    private Integer press = 0;
//    //счётчик последовательных попаданий
//    private Integer strike = 0;
//    //переменная для смены направлений смещения кнопки
//   // private int mod = -1;
//    //обнулять внутренникй стайк-счётчик
//    int oneNine = 0;

    //флаг попадания
    private boolean flag = false;

    //ширина экрана
   int width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonLeft = findViewById(R.id.buttonLeft);
        buttonCenter = findViewById(R.id.buttonCenter);
        buttonRight = findViewById(R.id.buttonRight);
        touchCountValue = findViewById(R.id.screenTouchCount);
        pressCountValue = findViewById(R.id.btnPressedCount);
        strikeValue = findViewById(R.id.strikeValue);
        touchMe = findViewById(R.id.touchMe);
        touchMe.setOnTouchListener(this);

        //получаем ширину экрана
        getScreenWidth();

        System.out.println("ширина: "+ width);
        myButtonChanger = new MyButtonChanger(this.getBaseContext(), buttonLeft, buttonCenter, buttonRight, width);
       // myButtonChanger = new MyNewButtonChanger(this.getBaseContext(), button, width);
    }

    //обработка касания на экран
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //выведем плотность экрана
        float density = getResources().getDisplayMetrics().density;
        System.out.println("плотность экрана: "+ density);
        //
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
//                touch++;
//                strike = 0;
//                oneNine = 0;

                MainPresenter.incrementTouch();
                MainPresenter.setStrike()
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
        touch++;
        if (flag = true) {
            strike++;
            oneNine++;
            System.out.println(strike);
        }
        else {
            strike = 1;
            oneNine = 1;
            System.out.println(oneNine+" тут 1 ");
        }


        pressCountValue.setText(press.toString());
        touchCountValue.setText(touch.toString());
        strikeValue.setText(strike.toString());
        flag = true;

        //пробуем менять положение
        if (strike %3 == 0) {
         myButtonChanger.changeBtnAlingment();
// //           mod=mod*(-2);
        }

        //изменим размер кнопки
        if (strike % 9 == 0) {
//
            myButtonChanger.changeBtnSize();
        }
        }

    //получаем ширину экрана
        public int getScreenWidth() {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            width = size.x;
        return width;
        }


        //метод сохранения активности (из жизнцикла)
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Touch", touch);
    }
    // чтобы подгружалось сохранение
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        touch = savedInstanceState.getInt("Touch");
        touchCountValue.setText(touch.toString());
    }

    }

