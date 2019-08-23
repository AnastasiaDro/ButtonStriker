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
        //подгружаем в текстовые поля значения из презентера
        touchCountValue.setText(presenter.getTouch().toString());
        pressCountValue.setText(presenter.getPress().toString());
        strikeValue.setText(presenter.getStrike().toString());

        //textView для обработки касаний
        FrameLayout touchMe = findViewById(R.id.touchMe);
        touchMe.setOnTouchListener(this);

        //получаем ширину экрана
        getScreenWidth();


        System.out.println("ширина: " + width);
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

                presenter.incrementTouch();
                presenter.setStrike(0);
                presenter.setOneNine(0);
                //увеличиваем счётчик на экране;
                touchCountValue.setText(presenter.getTouch().toString());
                strikeValue.setText(presenter.getStrike().toString());
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
        //press++;
        //touch++;
       presenter.incrementPress();
       presenter.incrementTouch();
        if (flag = true) {
//            strike++;
//            oneNine++;
            presenter.incrementStrike();
            presenter.incrementOneNine();


   //         System.out.println(strike);
        } else {
//            strike = 1;
//            oneNine = 1;
            presenter.setStrike(1);
            presenter.setOneNine(1);
        }


        pressCountValue.setText(presenter.getPress().toString());
        touchCountValue.setText(presenter.getTouch().toString());
        strikeValue.setText(presenter.getStrike().toString());
        flag = true;

        //пробуем менять положение
        if (presenter.getStrike() % 3 == 0) {
            myButtonChanger.changeBtnAlingment();
// //           mod=mod*(-2);
        }

        //изменим размер кнопки
        if (presenter.getStrike() % 9 == 0) {
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


//        //метод сохранения активности (из жизнцикла)
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("Touch", presenter.getTouch());
//    }
//    // чтобы подгружалось сохранение
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        touch = savedInstanceState.getInt("Touch");
//        touchCountValue.setText(touch.toString());
//    }

    }

