package buttonstriker.devgames.ru.buttonstriker;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

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
    //изменитель кнопки
    static MyButtonChanger myButtonChanger;

//    //переменные стартовых параметров кнопок
    int startParamsCenterHight;
    int startParamsCenterWight;

    String sizeChange = "";

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
        //здесь задаём размеры кнопок если массив с данными уже есть
        if (presenter.getPresenterButtonParamsArray().isEmpty() == false) {
            buttonLeft.setLayoutParams(presenter.getButtonParams("left"));
   //         buttonLeft.setVisibility(presenter.getBtnVisibArr(0));
            buttonCenter.setLayoutParams(presenter.getButtonParams("center"));
     //       buttonCenter.setVisibility(presenter.getBtnVisibArr(1));
            buttonRight.setLayoutParams(presenter.getButtonParams("right"));
   //         buttonRight.setVisibility(presenter.getBtnVisibArr(2));
        } else {

//            //заберем себе параметры кнопки
            startParamsCenterHight = buttonCenter.getLayoutParams().height;
            startParamsCenterWight = buttonCenter.getLayoutParams().width;

        }

        touchCountValue = findViewById(R.id.screenTouchCount);
        pressCountValue = findViewById(R.id.btnPressedCount);
        strikeValue = findViewById(R.id.strikeValue);
        //подгружаем в текстовые поля значения из презентера
        touchCountValue.setText(presenter.getTouch().toString());
        pressCountValue.setText(presenter.getPress().toString());
        strikeValue.setText(presenter.getStrike().toString());

        //подгружаем положение кнопок
        buttonLeft.setVisibility(presenter.getBtnVisibArr(0));
        buttonCenter.setVisibility(presenter.getBtnVisibArr(1));
        buttonRight.setVisibility(presenter.getBtnVisibArr(2));
        //textView для обработки касаний
        FrameLayout touchMe = findViewById(R.id.touchMe);
        touchMe.setOnTouchListener(this);

        //получаем ширину экрана
        //getScreenWidth();


        System.out.println("ширина: " + width);
        myButtonChanger = new MyButtonChanger(this.getBaseContext(), buttonLeft, buttonCenter, buttonRight, width, presenter);
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
       presenter.incrementPress();
       presenter.incrementTouch();
        if (flag = true) {
            presenter.incrementStrike();
            presenter.incrementOneNine();
        } else {
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
        }
        //изменим размер кнопки
        if (presenter.getStrike() % 9 == 0) {
            myButtonChanger.changeBtnSize();
        }
    }

    //кнопка настроек, обработчик
    public void onSettingsClick (View view){
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        intent.putExtra("BTN_SIZE_KEY", sizeChange);
        startActivity(intent);
    }


//
//    //получаем ширину экрана
//        public int getScreenWidth() {
//            Display display = getWindowManager().getDefaultDisplay();
//            Point size = new Point();
//            display.getSize(size);
//            width = size.x;
//        return width;
//        }


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

