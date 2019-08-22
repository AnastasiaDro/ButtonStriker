package buttonstriker.devgames.ru.buttonstriker;


//Класс для сохранения переменных
public class MainPresenter {
    private static MainPresenter instance = null;

    private static final Object syncobj = new Object();

//переменные для сохранения
//счётчик нажатий на экран
private Integer touch;
    //счётчик нажатий на кнопку
    private Integer press;
    //счётчик последовательных попаданий
    private Integer strike;
    //обнулять внутренникй стайк-счётчик
    private int oneNine;

    //размеры кнопок тоже надо сохранить ТУТ

    //

    private MainPresenter () {
        setTouch(0);
        //счётчик нажатий на кнопку
        setPress(0);
        //счётчик последовательных попаданий
       setStrike(0);
        //переменная для смены направлений смещения кнопки
        // private int mod = -1;
        //обнулять внутренникй стайк-счётчик
        setOneNine(0);
    }

    //Методы для увеличения переменных на 1
    public void incrementTouch(){
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


    //метод сохранения???
    public static MainPresenter getInstance(){
        synchronized (syncobj){
            if (instance == null){
                instance = new MainPresenter();
            }
            return instance;
        }
    }



}
