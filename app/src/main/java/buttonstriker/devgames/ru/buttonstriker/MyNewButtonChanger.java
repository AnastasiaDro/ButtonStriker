package buttonstriker.devgames.ru.buttonstriker;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;

public class MyNewButtonChanger extends android.support.v7.widget.AppCompatButton  {

    Button button;
    int newBtnHigh;
    int newBtnWight;

    //позиция кнопки
    int position = 1;
    //узнаем ширину экрана
    int width;

    // на сколько сдвигаем кнопку
    int changePx;

    //начальная левая позиция
    int left;
    //начальная правая позиция
    int right;

    //координаты самой правой позиции
    int firstLeft;
    int firstRight;

    //координаты самой левой позиции
    int thirdLeft;
    int thirdRight;

    //текущее положение кнопки
    int myLeft;
    int myRight;


    public MyNewButtonChanger(Context context, Button button, int width) {
        super(context);
        this.button = button;
        this.width = width;
        this.changePx = width/4;
        left = button.getLeft();
        right = button.getRight();
        //значения крайней левой позиции
        firstLeft = left - changePx;
        firstRight = right - changePx;
        //значения крайней правой позиции
        thirdLeft = left + changePx;
        thirdRight = right+changePx;



    }

    //заменить размер кнопки - ТО ЖЕ, ЧТО И В MyButtonChanger
    public void changeBtnSize () {
        ViewGroup.LayoutParams params = button.getLayoutParams();
        int sizeInPX= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        newBtnHigh = params.height - sizeInPX;
        newBtnWight = params.width - sizeInPX;
        params.height = newBtnHigh;
        params.width = newBtnWight;
        button.setLayoutParams(params);
    }


    public void changeBtnAlingment () {
        if (myLeft==left) {
            button.setLeft(firstLeft);
            button.setRight(firstRight);
        }
        if (myLeft==firstLeft){
            button.setLeft(thirdLeft);
            button.setRight(thirdRight);
        }
        if (myLeft==thirdLeft){
            button.setLeft(left);
            button.setRight(right);
        }

    }



}
