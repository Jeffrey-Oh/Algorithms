import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 파일명 정보를 FileInfo 객체로 변환 (원래 순서를 위해 index 저장)
        FileInfo[] fileInfos = new FileInfo[files.length];
        for (int i = 0; i < files.length; i++) {
            fileInfos[i] = new FileInfo(files[i], i);
        }
        
        // 조건에 맞게 정렬: HEAD (대소문자 무시) → NUMBER (정수 비교) → 원래 순서 유지
        Arrays.sort(fileInfos, (f1, f2) -> {
            int headComp = f1.headLower.compareTo(f2.headLower);
            if (headComp != 0) return headComp;
            
            int numberComp = Integer.compare(f1.number, f2.number);
            if (numberComp != 0) return numberComp;
            
            return Integer.compare(f1.index, f2.index);
        });
        
        // 정렬된 순서대로 원본 파일명만 추출하여 배열로 반환
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileInfos[i].original;
        }
        return answer;
    }
    
    // 파일명 정보를 저장하는 내부 클래스 (정적 클래스로 분리하여 가독성 향상)
    static class FileInfo {
        String original;   // 원본 파일명
        String head;       // HEAD 부분 (원본 그대로)
        String headLower;  // 대소문자 구분 없이 비교하기 위한 HEAD (소문자)
        int number;        // NUMBER 부분 (정수 값)
        int index;         // 원래 배열에서의 위치
        
        public FileInfo(String original, int index) {
            this.original = original;
            this.index = index;
            parse();
        }
        
        // 파일명을 HEAD, NUMBER, TAIL로 분리 (TAIL은 정렬에 사용하지 않음)
        private void parse() {
            int len = original.length();
            int pos = 0;
            
            // HEAD: 첫 숫자가 등장하기 전까지의 모든 문자
            while (pos < len && !Character.isDigit(original.charAt(pos))) {
                pos++;
            }
            head = original.substring(0, pos);
            headLower = head.toLowerCase();
            
            // NUMBER: 연속된 숫자 (최대 5자리)
            int numStart = pos;
            int digitCount = 0;
            while (pos < len && Character.isDigit(original.charAt(pos)) && digitCount < 5) {
                pos++;
                digitCount++;
            }
            String numStr = original.substring(numStart, pos);
            number = Integer.parseInt(numStr);
        }
    }
}