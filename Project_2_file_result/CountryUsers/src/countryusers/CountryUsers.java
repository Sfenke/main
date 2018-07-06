package countryusers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;


public class CountryUsers {

    public static void main(String[] args) throws FileNotFoundException {
        FileReader  f = new FileReader("book.txt");
        try(BufferedReader br   = new BufferedReader(f);) {
            String readFileStr = br.lines().collect(Collectors.joining("%"));

            //узнаем колличество строк
            int numberLine=1;
            for(int j = 0; j < readFileStr.length(); j++)  
                if(readFileStr.charAt(j)=='%'){
                    numberLine=numberLine+1;
                }

            //Преобразуем строку в массив классов Users
            Users [] list  =new Users[numberLine];
            String temp []=new String[numberLine*3];
            int i=0; //
            int indexBeginString=0;
            int numberElementLine=0;
            numberLine=0;
            for (int j = 0; j<readFileStr.length(); j++) {
                if(readFileStr.charAt(j)==';'||readFileStr.charAt(j)=='%'){
                temp [i]=readFileStr.substring(indexBeginString, j);
                indexBeginString=j+1;
                i=i+1;
                numberElementLine=numberElementLine+1;
                } else if (j==(readFileStr.length()-1)){temp [i]=readFileStr.substring(indexBeginString, j+1);numberElementLine=numberElementLine+1;}
                if (readFileStr.charAt(j)=='%'||j==(readFileStr.length()-1)) {
                    if (j!=readFileStr.length()-1) {
                        i=i-1;
                    }
                    //проверка соответствия строки формату 
                    if(numberElementLine==3&&isDigit(temp[i-2])&isDigit(temp[i-1])&!isDigit(temp[i])){
                        list[numberLine]=new Users(Integer.parseInt(temp[i-2]),Integer.parseInt(temp[i-1]),temp[i]);
                        numberLine=numberLine+1;
                    }
                    numberElementLine=0;
                } 
           }
          // Поиск уникальных значиний по country
            int countryNumber=0;
            String [] country=new String[numberLine];
            for (int j = 0; j < numberLine; j++) {
                int count=0;
                for (int k = 0; k < numberLine-1; k++) {
                    if(list[j].getCountry().equals(country[k])){
                        count=count+1;
                    } 
                }
                if (count==0||country.length==0) {
                    country[countryNumber]=list[j].getCountry();
                    countryNumber=countryNumber+1;
                }
            }

            // Создадим результирующий массив классов Users
            Users [] result=new Users[countryNumber];
            for (int j = 0; j < result.length; j++) {
               result[j]=new Users (0,0,country[j]);
            }

            //Вычисление суммы по сount для соответствующих country
            int [][] id=new int[result.length][numberLine];
            for (int j = 0; j < result.length; j++) {
                int sum=0;
                int count=0;
                for (int k = 0; k < numberLine; k++) {
                    if (result[j].getCountry().equals(list[k].getCountry())) {
                        sum=sum+list[k].getCount();
                        id[j][count]=list[k].getUser_id();
                        count=count+1;
                    }
                }
                result[j].setCount(sum);
            }

            //Вычисление количества уникальных user_id
            for (int j = 0; j < result.length; j++) {
                int numberUniqueID=numberLine;
                for (int k = 0; k < numberLine; k++) {
                    int count=0;//счетчик
                    for (int k1 = k+1; k1 < numberLine; k1++) {
                        if (id[j][k]==id[j][k1]&id[j][k]!=0){
                            count=count+1;
                        }
                    }
                    if (count!=0||id[j][k]==0) {
                        numberUniqueID=numberUniqueID-1;
                    }
                }
                result[j].setUser_id(numberUniqueID);
            }
           
            Arrays.sort(result, new countSort());
            writeFile(result);
            }  catch (IOException e){}
}
    

private static boolean isDigit(String s) throws NumberFormatException {
    try {
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException e) {
       return false;
    }
}
private static void  writeFile(Users [] result){
    File sdFile = new File("result.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile))) { 
            for (Users m : result) {
                bw.write(m.toString() + "\r\n");
            }
        } catch (IOException e) {}
}
}