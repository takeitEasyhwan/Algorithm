import java.util.HashSet;
import java.util.Set;

class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean arr[] = new boolean[10_000_000];
        arr[0] = true;
        arr[1] = true;
        boolean[] visited = new boolean[numbers.length()];
        char[] output = new char[numbers.length()];
        for(int i=2;i*i<arr.length;i++) {
            if(!arr[i]) {
                for(int j=i;i*j<arr.length;j++) {
                    arr[i*j] = true;
                }
            }
        }
        for(int i=0;i<numbers.length();i++) {
            req(numbers, output, visited, 0, i+1);
        }
        for(int key : set) {
            if(!arr[key])
                answer++;
        }
        return answer;
    }

    private void req(String numbers, char[] output, boolean[] visited, int depth, int r) {
        if(depth==r) {
            String temp="";
            for(int i=0;i<r;i++) {
                temp+=output[i];
            }
            set.add(Integer.parseInt(temp));
            return;
        }
        for(int i=0;i<numbers.length();i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = numbers.charAt(i);
                req(numbers, output, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
}
