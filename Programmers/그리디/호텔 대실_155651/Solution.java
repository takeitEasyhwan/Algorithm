import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        BookList bookArr[] = new BookList[book_time.length];
        for(int i=0;i<bookArr.length;i++) {
            String st[] = book_time[i][0].split(":");
            String et[] = book_time[i][1].split(":");
            int eft;
            if(Integer.parseInt(et[1])>=50)
                eft = (Integer.parseInt(et[0])+1)*100 + Integer.parseInt(et[1])-50;
            else 
                eft = Integer.parseInt(et[0]+et[1])+10;
            bookArr[i] = new BookList(Integer.parseInt(st[0]+st[1]),eft);
        }
        Arrays.sort(bookArr); 
        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i=0;i<bookArr.length;i++) {
            if(arraylist.size()==0)
                arraylist.add(bookArr[i].fin);
            else {
                boolean check=false;
                for(int j=0;j<arraylist.size();j++) {
                    if(arraylist.get(j)<=bookArr[i].start) {
                        arraylist.set(j,bookArr[i].fin);
                        check = true;
                        break;
                    }
                }
                if(!check)
                    arraylist.add(bookArr[i].fin);
                
            }
        }
        return arraylist.size();
    }
    
    static class BookList implements Comparable<BookList> {
        int start;
        int fin;
        BookList(int start, int fin) {
            this.start = start;
            this.fin = fin;
        }       
        @Override
        public int compareTo(BookList o) {
            if(this.start != o.start)
                return this.start-o.start;
            return this.fin - o.fin;
        }
    }
}
