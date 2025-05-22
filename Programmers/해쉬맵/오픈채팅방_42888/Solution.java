import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> hashMap = new HashMap<>();
        int answerCnt=0;
        for(int i=0;i<record.length;i++) {
            String[] strArr = record[i].split(" ");

            if(!strArr[0].equals("Leave"))
                hashMap.put(strArr[1],strArr[2]);
            if(!strArr[0].equals("Change"))
                answerCnt++;
        }
        answer = new String[answerCnt];
        int index=0;
        for(int i=0;i< record.length;i++) {
            String[] strArr = record[i].split(" ");
            if(strArr[0].equals("Change"))
                continue;
            answer[index] = hashMap.get(strArr[1]);
            answer[index] += "님이 ";
            answer[index] += strArr[0].equals("Enter")?"들어왔":"나갔";
            answer[index]+="습니다.";
            index++;
        }
        return answer;
    }
}
