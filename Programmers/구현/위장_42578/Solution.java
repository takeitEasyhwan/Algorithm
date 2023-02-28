import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        List<Clothes> list = new LinkedList<Clothes>();
        label : for(int i=0;i<clothes.length;i++) {
        	for(int j=0;j<list.size();j++) {
        		if(list.get(j).kind.equals(clothes[i][1])) {
        			list.set(j, new Clothes(clothes[i][1],list.get(j).cnt+1));
        			continue label;
        		}
        			
        	}
        	
        	list.add(new Clothes(clothes[i][1]));
        }
        
        for(int i=0;i<list.size();i++) {
        	answer*=(list.get(i).cnt+1);
        	//System.out.println(list.get(i));
        }
        return --answer;
    }
}
class Clothes{
	String kind;
	int cnt;
	public Clothes(String kind) {
		this.kind = kind;
		cnt=1;
	}
	public Clothes(String kind,int cnt) {
		this.kind = kind;
		this.cnt=cnt;
	}
	@Override
	public String toString() {
		return "Clothes [kind=" + kind + ", cnt=" + cnt + "]";
	}
	
}
