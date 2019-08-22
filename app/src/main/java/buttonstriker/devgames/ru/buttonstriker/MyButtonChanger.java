package buttonstriker.devgames.ru.buttonstriker;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;



public class MyButtonChanger extends android.support.v7.widget.AppCompatButton {
    Button buttonLeft;
    Button buttonCenter;
    Button buttonRight;
    int newBtnHigh;
    int newBtnWight;

    //позиция кнопки
    int position = 1;
//узнаем ширину экрана
    int width;

    // на сколько сдвигаем кнопку
    int changePx;
    int mod = -1;



    public MyButtonChanger(Context context, Button buttonLeft, Button buttonCenter, Button buttonRight, int width) {
        super(context);
        this.buttonLeft = buttonLeft;
        this.buttonCenter = buttonCenter;
        this.buttonRight = buttonRight;
        this.width = width;
        this.changePx = width/4;


    }


    //заменить размер кнопок
    //будем ориентироваться на размер средней кнопки
    public void changeBtnSize () {
        ViewGroup.LayoutParams params = buttonCenter.getLayoutParams();
        int sizeInPX= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        newBtnHigh = params.height - sizeInPX;
        newBtnWight = params.width - sizeInPX;
        params.height = newBtnHigh;
        params.width = newBtnWight;
        buttonLeft.setLayoutParams(params);
        buttonCenter.setLayoutParams(params);
        buttonRight.setLayoutParams(params);
    }


    //меняем положение кнопки
    public void changeBtnAlingment () {
        switch (position){
            case 1:
                mod = -1;
                position = 2;
                break;
            case 2:
                mod = 2;
                position = 3;
                break;
            case 3:
                mod = -1;
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
