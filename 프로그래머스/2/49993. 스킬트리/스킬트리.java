class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String st : skill_trees) {
            StringBuilder filteredSkillTree = new StringBuilder();
            
            // 스킬 트리에서 필수 스킬만 추출
            for (char c : st.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    filteredSkillTree.append(c);
                }
            }
            
            // 필터링된 스킬 트리가 스킬의 선행 조건을 만족하는지 확인
            if (skill.startsWith(filteredSkillTree.toString())) {
                answer++;
            }
        }
        
        return answer;
    }
}
