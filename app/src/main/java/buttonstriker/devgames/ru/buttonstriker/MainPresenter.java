package buttonstriker.devgames.ru.buttonstriker;


import android.view.ViewGroup;
import java.util.ArrayList;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

//Класс для сохранения переменных
public class MainPresenter {
    private static MainPresenter instance = null;

    private static final Object syncobj = new Object();


//переменные для сохранения
//счётчик нажатий на экран
    private Integer touch;
    //счётчик нажатий на кнопку
    private  Integer press;
    //счётчик последовательных попаданий
    private Integer strike;
    //обнулять внутренникй страйк-счётчик
    private int oneNine;

    //размеры кнопок тоже надо сохранить ТУТ
    private ArrayList <ViewGroup.LayoutParams> presenterButtonParamsArray;
    //ТУТ НУЖНО СОХРАНЯТЬ ВИДИМОСТЬ КНОПОК
    private int btnVisibArr[];

    //перенесем сюда позицию
    private int position;

    //стартовые высота и ширина кнопок



    private MainPresenter () {
        touch=0;
        //счётчик нажатий на кнопку
        press=0;
        //счётчик последовательных попаданий
       strike=0;
        //переменная для смены направлений смещения кнопки
        // private int mod = -1;
        //обнулять внутренникй стайк-счётчик
        oneNine=0;
        //делаем наш массив с параметрами пустым
        presenterButtonParamsArray = new ArrayList<>(3);

        //видимость кнопок
        btnVisibArr = new int[]{INVISIBLE, VISIBLE, INVISIBLE};
        //позиция
        position = 1;
    }

    //Методы для увеличения переменных на 1
    public  void incrementTouch(){
        touch++;
    }
    public void incrementPress(){
        press++;
    }
    public void incrementStrike(){
        strike++;
    }

    public void incrementOneNine(){
        oneNine++;
    }

    //геттеры  для переменных
    public Integer getTouch(){
        return touch;
    }

    public Integer getPress(){
        return press;
    }

    public Integer getStrike(){
        return strike;
    }
    public Integer getOneNine(){
        return oneNine;
    }

    //сеттеры для переменных
    public void setTouch(Integer touch) {
        this.touch = touch;
    }

    public void setPress(Integer press) {
        this.press = press;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public void setOneNine(int oneNine) {
        this.oneNine = oneNine;
    }

    //метод установки позиции
    public void setPosition(int pos){
        position = pos;
    // метод получения позиции
    }
    public int getPosition(){
        return position;
    }

    //метод сохранения???
    public static MainPresenter getInstance(){
        synchronized (syncobj){
            if (instance == null){
                instance = new MainPresenter();

            }
            return instance;
        }
    }

    //геттер для массива
    public ArrayList<ViewGroup.LayoutParams> getPresenterButtonParamsArray() {
        return presenterButtonParamsArray;
    }
    //геттер для массива с видимостями кнопок
    public int[] getBtnVisibArr(){
        return btnVisibArr;
    }

    //перегрузим геттер для массива с видимостями кнопок
    public int getBtnVisibArr(int i) {
        return btnVisibArr[i];
    }


    public ViewGroup.LayoutParams getButtonParams(String btnPosName) {
       ViewGroup.LayoutParams btnParams = null;
        switch (btnPosName){
            case "left":
            btnParams = presenterButtonParamsArray.get(0);
            break;
            case "center":
            btnParams = presenterButtonParamsArray.get(1);
            break;
            case "right":
            btnParams = presenterButtonParamsArray.get(2);
        }
        return btnParams;
    }

    //записываем в ArrayList с параметрами кнопок
    //метод используется в классе MyButtonChanger.changeButtonSize()
    public void setPresenterButtonParamsArray(ViewGroup.LayoutParams paramsLeft, ViewGroup.LayoutParams paramsCenter, ViewGroup.LayoutParams paramsRight){
        //presenterButtonParamsArray.clear();
        presenterButtonParamsArray.add(paramsLeft);
        presenterButtonParamsArray.add(paramsCenter);
        presenterButtonParamsArray.add(paramsRight);
        //тут видимость кнопок
    }

    //меняем значения переменных в массиве
    public void setBtnVisibInArray(int visibilityLeft, int visibilityCenter, int visibilityRight){
                btnVisibArr[0] = visibilityLeft;
                btnVisibArr[1] = visibilityCenter;
                btnVisibArr[2] = visibilityRight;
    }


}
