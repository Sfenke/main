package javaapplication_3word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class JavaApplication_3word {

    public static void main(String[] args) throws IOException {
        
        FileReader  f = new FileReader("text.txt");
        try(BufferedReader br   = new BufferedReader(f);) {
            /*преобразование потока*/
                 ArrayList <String> temp=new ArrayList<>();
              String result = br.lines().collect(Collectors.joining(" "));
              int i=0;
              for (int j = 1; j < result.length(); j++) {
                if(result.charAt(j)==' '||result.charAt(j)=='\n'){
                    if (result.charAt(j-1)=='.'||result.charAt(j-1)==','
                            ||result.charAt(j-1)==':'||result.charAt(j-1)==';'
                            ||result.charAt(j-1)=='!'||result.charAt(j-1)=='?') {
                        temp.add(result.substring(i, j-1));
                    }else temp.add(result.substring(i, j));
                   
                    i=j+1;
                } else if (j==(result.length()-1)){
                    
                           if (result.charAt(j-1)=='.'||result.charAt(j-1)==','
                                ||result.charAt(j-1)==':'||result.charAt(j-1)==';'
                                ||result.charAt(j-1)=='!'||result.charAt(j-1)=='?'
                                ){
                           temp.add(result.substring(i, j-1));
                           } else temp.add(result.substring(i, j));
                }
              }
              
                 System.out.println(temp);
                 ArrayList <String> word3=new ArrayList<>();
                 for (int j = 2; j < temp.size(); j=j+3) {
                     word3.add(temp.get(j));   
                     }
                  System.out.println(word3);
            }
        catch(IOException e ){System.out.println();}
    }
    
}
