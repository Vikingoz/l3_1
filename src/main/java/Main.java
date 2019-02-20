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
        System.out.println("size " + myArrayList.size());;
        //требование задания номер один
        Collections.addAll(myArrayList, 6,7,8);

        System.out.println("element(6) " + myArrayList.get(6) +
                " element(7) " + myArrayList.get(7) +
                " size " + myArrayList.size());

        System.out.println("removed(6) " + myArrayList.remove(6));

        System.out.println("element(6) " + myArrayList.get(6) + " size " + myArrayList.size());
        System.out.println("removed(11) " + myArrayList.remove(11) +
                " size " + myArrayList.size());

        System.out.println("removed for object " + myArrayList.remove(Integer.valueOf("6")) +
                " size " + myArrayList.size());

        System.out.println("Check set: get(6) " + myArrayList.get(6) +
                " set(6)=613 " + myArrayList.set(6, Integer.valueOf("613")) +
                " get(6) " + myArrayList.get(6) +
                " size " + myArrayList.size());
        //требование два
        //требование три
        //Тут мы добавим класс студент (возмем со стак оверфлоу)
        // Collections.sort(myArrayList, );
    }
}
