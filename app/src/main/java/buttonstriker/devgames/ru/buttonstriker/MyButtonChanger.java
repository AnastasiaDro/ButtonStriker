package buttonstriker.devgames.ru.buttonstriker;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;




public class MyButtonChanger extends android.support.v7.widget.AppCompatButton {
    private Button buttonLeft;
    private Button buttonCenter;
    private Button buttonRight;
    private int newBtnHigh;
    private int newBtnWight;


    //позиция кнопки
    int position = 1;
//узнаем ширину экрана
    int width;

    // на сколько сдвигаем кнопку
    int changePx;
   // int mod = -1;

    int sizeInPX;

    MainPresenter presenter;


    public MyButtonChanger(Context context, Button buttonLeft, Button buttonCenter, Button buttonRight, int width, MainPresenter presenter) {
        super(context);
        this.buttonLeft = buttonLeft;
        this.buttonCenter = buttonCenter;
        this.buttonRight = buttonRight;
        this.width = width;
        this.changePx = width/4;
        this.presenter = presenter;


        //что-то там рпиводим к пикселям в зависимости от полученного размера экрана для последующего изменения размера кнопки
        sizeInPX= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

    }


    //заменить размер кнопок
    //ТУТ НУЖНО ПЕРЕДЕЛАТЬ КРАСИВО!!!
    //будем ориентироваться на размер средней кнопки
    public void changeBtnSize () {

        //берем параметры у каждой кнопки по отдельности
        ViewGroup.LayoutParams paramsCenter = buttonCenter.getLayoutParams();
        ViewGroup.LayoutParams paramsRight = buttonRight.getLayoutParams();
        ViewGroup.LayoutParams paramsLeft = buttonLeft.getLayoutParams();

//        //что-то там рпиводим к пикселям в зависимости от полученного размера экрана
//        int sizeInPX= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        //задаем новые ширину и высоту в зависимости от видимости

        newBtnHigh = paramsRight.height - sizeInPX;
        newBtnWight = paramsRight.width - sizeInPX;
        //каждой кнопке по отдельности изменяем в её параметрах ширину и высоту на новую
        paramsCenter.height = newBtnHigh;
        paramsCenter.width = newBtnWight;

        paramsRight.height = newBtnHigh;
        paramsRight.width = newBtnWight;

        paramsLeft.height = newBtnHigh;
        paramsLeft.width = newBtnWight;

        //Прикручивааем каждой кнопке новые параметры
        buttonCenter.setLayoutParams(paramsCenter);
        buttonRight.setLayoutParams(paramsRight);
        buttonLeft.setLayoutParams(paramsLeft);

        //проверка блятьf
        System.out.println("массив презентера пуст =" + presenter.getPresenterButtonParamsArray().isEmpty());

        //тут добавляем в массив презентера параметры кнопок
        presenter.setPresenterButtonParamsArray(paramsLeft, paramsCenter, paramsRight);
    }


    //меняем положение кнопки
    public void changeBtnAlingment () {
        switch (position){
            case 1:
                buttonCenter.setVisibility(INVISIBLE);
                buttonLeft.setVisibility(VISIBLE);
                position = 2;
                break;
            case 2:
                buttonLeft.setVisibility(INVISIBLE);
                buttonRight.setVisibility(VISIBLE);
                position = 3;
                break;
            case 3:
                buttonRight.setVisibility(INVISIBLE);
                buttonCenter.setVisibility(VISIBLE);
                position = 1;
                break;
        }



//        int left = button.getLeft();
//        int right = button.getRight();
//        button.setLeft((left-changePx*mod));
//        button.setRight((right-changePx*mod));
//        System.out.println("лево: " + left);

    }

}
