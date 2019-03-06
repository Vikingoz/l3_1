import etc.Student;
import etc.StudentComparator;

import java.util.*;

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

        System.out.println("Check add before: ");
        for (int i = 0; i < myArrayList.size(); i ++) {
            System.out.println("myArrayList(" + i + ") = " + myArrayList.get(i));
        }
        myArrayList.add(5, Integer.valueOf("88005"));
        System.out.println("Check add after add 5: ");
        for (int i = 0; i < myArrayList.size(); i ++) {
            System.out.println("myArrayList(" + i + ") = " + myArrayList.get(i));
        }
        //проверю лист итератор
        ListIterator<Integer> itr = myArrayList.listIterator();
        for (int i = 0; i < myArrayList.size(); i ++) {
            System.out.println("myIterator("+itr.next()+")");
        }

        /*for (int i = 0; i < myArrayList.size(); i ++) {
            System.out.println("myArrayList(" + i + ") = " + myArrayList.get(i));
        }*/
        //требование два
        MyArrayList<Integer> mySecondArrayList = new MyArrayList<Integer>();
        Collections.addAll(mySecondArrayList, 1,2,3);
        Collections.copy(myArrayList, mySecondArrayList);

        System.out.println("TEST2 Collections.copy: Check mySecondArrayList: " );

        for (int i = 0; i < myArrayList.size(); i ++) {
            System.out.println("myArrayList(" + i + ") = " + myArrayList.get(i));
        }
        //требование три
        //Тут мы добавим класс студент
        // Collections.sort(myArrayList, );
        MyArrayList<Student> myStudentList = new MyArrayList<Student>();
        Collections.addAll(myStudentList, new Student("Вася", 45),
                new Student("Оля", 18),
                new Student("Паша", 22));

        for (int i = 0; i < myStudentList.size(); i ++) {
            System.out.println("myStudentList before (" + i + ") = " + myStudentList.get(i).toString());
        }

        Collections.sort(myStudentList, new StudentComparator());

        for (int i = 0; i < myStudentList.size(); i ++) {
            System.out.println("myStudentList after (" + i + ") = " + myStudentList.get(i).toString());
        }

    }
}
