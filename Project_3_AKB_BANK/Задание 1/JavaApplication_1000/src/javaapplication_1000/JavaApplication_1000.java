package javaapplication_1000;

import java.util.Random;

public class JavaApplication_1000 {

    public static void main(String[] args) {
      
        // создадим массив  для тестирования кода состоящий из 30 000 000 элементорв
        int [] arr=new int [30000000];
        int temp=0;
        while (temp!=arr.length-1){
            temp++;
            arr[temp]=temp; 
        }
        
        //дублирование случайного элемента
        Random random = new Random();
        int number = random.nextInt(arr.length-1);
        arr[number]=arr[number-1];
        System.out.println("Продублирован случайный элемент=" +(number-1));
        
        //поиск дублируемого элемента методом Гаусса
        int min=arr[0];
        int max=arr[arr.length-1];
        int sumMinMax=min+max;
        
        //вывод массива
//        for (int m:arr){
//            System.out.println(m);
//        }

        for (int i = 0; i < (arr.length+1)/2; i++) {
            if ((arr[min+i]+arr[max-i])!=sumMinMax) {
                if (arr[min+i]==arr[min+i-1]) {
                    System.out.println("Найденно отсутствующее число ="+ (arr[min+i]+1));
                } else System.out.println("Найденно отсутствующее число="+(arr[max-i]+1));
                break;
            }
            
        }
    }
    
}
