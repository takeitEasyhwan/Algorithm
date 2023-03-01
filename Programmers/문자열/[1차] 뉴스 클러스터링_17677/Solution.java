import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        List<String> list1 = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        for(int i=0;i<str1.length()-1;i++) {
        	if('a'<=str1.charAt(i)&&str1.charAt(i)<='z'&&'a'<=str1.charAt(i+1)&&str1.charAt(i+1)<='z') {
        		list1.add(str1.substring(i, i+2));
        	}
        }
        for(int i=0;i<str2.length()-1;i++) {
        	if('a'<=str2.charAt(i)&&str2.charAt(i)<='z'&&'a'<=str2.charAt(i+1)&&str2.charAt(i+1)<='z') {
        		list2.add(str2.substring(i, i+2));
        	}
        }	
        if(list1.size()==0&&list2.size()==0)
        	return 65536;
        else if(list1.size()==0||list2.size()==0) {
        	return 0;
        }
        else {
        	list1.sort(null);
        	list2.sort(null);
        	int axis1=0;
        	int axis2=0;
        	while(axis1!=list1.size()&&axis2!=list2.size()) {
        		if(list1.get(axis1).equals(list2.get(axis2))) {
        			axis1++;
        			axis2++;
        			answer++;
        		}
        		else if(list1.get(axis1).compareTo(list2.get(axis2))>0) {
        			axis2++;
        		}
        		else {
        			axis1++;
        		}
        	}
        }
        return answer*65536/(list1.size()+list2.size()-answer);
    }
}
