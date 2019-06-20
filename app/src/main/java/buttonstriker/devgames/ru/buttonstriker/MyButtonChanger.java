package buttonstriker.devgames.ru.buttonstriker;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MyButtonChanger extends android.support.v7.widget.AppCompatButton {
    Button button;
    int newBtnHigh;
    int newBtnWight;

    public MyButtonChanger(Context context, Button button) {
        super(context);
        this.button = button;
    }


    //заменить размер кнопки
    public void changeBtnSize () {
        ViewGroup.LayoutParams params = button.getLayoutParams();
        int sizeInPX= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        newBtnHigh = params.height - sizeInPX;
        newBtnWight = params.width - sizeInPX;
        params.height = newBtnHigh;
        params.width = newBtnWight;
        button.setLayoutParams(params);
    }


    //меняем положение кнопки
    public void changeBtnAlingment () {
        ViewGroup.LayoutParams params = button.getLayoutParams();
        int left = button.getLeft();
        int right = button.getRight();
        button.setLeft(left-40);
        button.setRight(right-40);
        System.out.println(left);
    }

    //рандом



}
