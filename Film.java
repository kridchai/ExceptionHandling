
    //6313123 chanachon
//6313215 tanakrit
//6313171 kridchai
class Film implements Comparable<Film> {
    private String name,status;
    private int year, best, wins, nominations;
    Film(String name,int year,int best,int win,int nominations){
        this.name = name;
        this.best = best;
        if(best ==0)
            this.status = "";
        else
            this.status = "(best film)";
        this.nominations = nominations;
        this.wins = win;
        this.year = year;
    }
    public void print() {
        System.out.printf("%-25s %12s %10d %10d %10d\n",name,status,wins,nominations,year);
    }
    
    public int compareTo(Film other) {
        if (this.wins > other.wins)
            return 1;
        else if(this.wins < other.wins)
            return -1;
        else{
            if(this.nominations > other.nominations)
                return 1;
            else if(this.nominations < other.nominations)
                return -1;
            else{
                if(this.best>other.best)
                    return 1;
                else if(this.best < other.best)
                    return -1;
                else{
                    if(this.year > other.year)
                        return -1;
                    else if(this.year<other.year)
                        return 1;
                    else{
                        if(this.name.compareTo(other.name)>0)
                            return -1;
                        else if(this.name.compareTo(other.name)<0)
                            return 1;
                        else
                            return 0;
                    
                    }
                
                }
            
            }
        }
    
    }
}   


