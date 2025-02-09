class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0, n = skill.length();
        
        for (String st : skill_trees) {
            String pattern = "^[^" + skill + "]*$";
            if (st.matches(pattern)) {
                answer++;
                continue;
            }
            
            int position = -1, index = 0;
            boolean[] visited = new boolean[n];
            boolean check = true;
            for (char c : skill.toCharArray()) {
                int io = st.indexOf(c);
                if (io > -1) {
                    if (index == 0 && !visited[index]) {
                        visited[index++] = true;
                        position = io;
                        continue;
                    } else if (!visited[index - 1]) {
                        check = false;
                        break;
                    }
                    
                    if (io > position) {
                        visited[index] = true;
                        position = io;
                    } else {
                        check = false;
                        break;
                    }
                }
                index++;
            }
            
            if (check) answer++;
        }
        return answer;
    }
}