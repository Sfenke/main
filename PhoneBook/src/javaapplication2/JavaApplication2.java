package javaapplication2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class JavaApplication2 {
    public static void main(String[] args) throws IOException {
        FileReader  f = new FileReader("book.txt");
        try(BufferedReader br   = new BufferedReader(f);) {
            /*преобразование потока*/
                 ArrayList <String> temp=new ArrayList<>();
              String result = br.lines().collect(Collectors.joining("\n"));
              int i=0;
              for (int j = 0; j < result.length(); j++) {
                if(result.charAt(j)=='\n'){
                    temp.add(result.substring(i, j));
                   
                    i=j+1;
                } else if (j==(result.length()-1)){temp.add(result.substring(i, j+1));}
              }
              ArrayList<Subscriber> listSubscribers = new ArrayList<>();
              for (int j = 0; j < temp.size(); j=j+3) {
                      
             listSubscribers.add(new Subscriber(
                            temp.get(j),
                            Integer.parseInt(temp.get(j+1)), 
                            Double.parseDouble(temp.get(j+2))));
              }
             printSubscrib(listSubscribers);
             sortDebtors(listSubscribers);
              
            }
        catch(IOException e ){System.out.println("Ошибка");}
    }

public static void printSubscrib (ArrayList <Subscriber> listSubscribers) {
        System.out.println("Абонентов: "+listSubscribers.size());
        for (Subscriber m:listSubscribers) {
            System.out.println(m);
        }
    }
public  static void sortDebtors (ArrayList <Subscriber> listSubscribers) throws FileNotFoundException{
    ArrayList <Subscriber> index=new ArrayList();
    for (int i = 0; i < listSubscribers.size(); i++) {
        if (listSubscribers.get(i).getAccountBalance()<0){index.add(listSubscribers.get(i));}
    }
    for (int i = 0; i < index.size(); i++) {
            for (int j = 0; j < index.size()-1; j++) {
              if ((i!=index.size()-1)&&((index.get(j).getAccountBalance())>(index.get(i+1).getAccountBalance()))) {
                      ArrayList <Subscriber> temp=new ArrayList<>();
                      temp.add(index.get(j));
                      index.set(j,index.get(i+1));
                      index.set(i+1, temp.get(0));
                }
            }
        }
        
    if (!index.isEmpty()) {
        File sdFile = new File("out.txt");
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));          
        bw.write(index.toString());
        bw.close();
    } catch (IOException e) {
        
    }
    }else System.out.println("Должников нет");
  
}
}
