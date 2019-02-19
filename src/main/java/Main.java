import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(random.nextInt(100));
        }
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(3));
        //требование задания номер один
        Collections.addAll(myArrayList, 6,7,8);

        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(6));
        //требование два
        //требование три
        //Тут мы добавим класс студент (возмем со стак оверфлоу)
        Collections.sort(myArrayList, );
    }
}
