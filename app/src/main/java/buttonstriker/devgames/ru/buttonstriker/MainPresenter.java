package buttonstriker.devgames.ru.buttonstriker;


//Класс для сохранения переменных
public class MainPresenter {
    private static MainPresenter instance = null;

    private static final Object syncobj = new Object();

//переменные для сохранения
//счётчик нажатий на экран
private Integer touch = 0;
    //счётчик нажатий на кнопку
    private Integer press = 0;
    //счётчик последовательных попаданий
    private Integer strike = 0;
    //переменная для смены направлений смещения кнопки
    // private int mod = -1;
    //обнулять внутренникй стайк-счётчик
    int oneNine = 0;
}
