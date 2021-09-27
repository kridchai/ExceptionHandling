//6313123 chanachon
//6313215 tanakrit
//6313171 kridchai
import java.io.*;
import java.util.*;
class Statistics {
    public static void main(String[] args){
        ArrayList<Film> Al = new ArrayList<Film>();
        boolean Success = false;
        String FileName = "oscars_err.txt";
        Scanner inFile = null;
        while(!Success)
        {
            try
                {        
                inFile = new Scanner(new File(FileName));
                Success = true;
                while(inFile.hasNext()){
                   process(Al,inFile);
                }
                }
           
        
            catch(FileNotFoundException e){
                System.out.println(e);
                System.out.println("New file name");
                Scanner s = new Scanner(System.in);
                FileName = s.next();   
            }
        }
        Collections.sort(Al);
                for(int i  = Al.size()-1 ;i>=0;i--)
                    Al.get(i).print();
    }
    public static void process(ArrayList<Film> Al ,Scanner inFile){
        String line = "";
        line = inFile.nextLine();
        String[] buff = line.split(",");
        String name  = buff[0];
        try{
            int year = Integer.parseInt(buff[1].trim());
            if(year<0)
                throw new ArithmeticException("My exception for negative "+year); 
            int best = Integer.parseInt(buff[2].trim());
            if(best > 1 ||best<0)
                throw new ArithmeticException("My exception for invalid flags "+best); 
            int wins = Integer.parseInt(buff[3].trim());
            if(wins<0)
                throw new ArithmeticException("My exception for negative "+wins); 
            int nominations = Integer.parseInt(buff[4].trim());
            if(nominations<0)
                throw new ArithmeticException("My exception for negative "+nominations); 
            Film f = new Film(name,year,best,wins,nominations);
            Al.add(f);
        }
        catch(NumberFormatException e){
                System.out.println(e);
                System.out.println(line);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
                System.out.println(line);
            }
            catch(ArithmeticException e){
                System.out.println(e);
                System.out.println(line);
            
            }
        
    
    }
}
