import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        List<User> records = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        
        for (String r : record) {
            String[] infos = r.split(" ");
            String type = infos[0];
            String userId = infos[1];
            
            if (type.equals("Enter")) {
                String name = infos[2];
                records.add(new User(userId, name, String.format("%s님이 들어왔습니다.", name)));
                users.put(userId, name);
            } else if (type.equals("Leave")) {
                String name = users.get(userId);
                records.add(new User(userId, name, String.format("%s님이 나갔습니다.", name)));
            } else {
                String changeName = infos[2];
                users.put(userId, changeName);
            }
        }
        
        for (User u : records) {
            String userId = u.getUserId();
            String saveName = users.get(userId);
            
            if (!u.getName().equals(saveName)) {
                u.changeName(saveName);
            }
        }
        
        return records.stream().map(r -> r.getRecord()).toArray(String[]::new);
    }
    
    class User {
        private String userId;
        private String name;
        private String record;
        
        User(String userId, String name, String record) {
            this.userId = userId;
            this.name = name;
            this.record = record;
        }
        
        public String getUserId() {
            return this.userId;
        }
        
        public String getName() {
            return this.name;
        }
        
        public String getRecord() {
            return this.record;
        }
        
        public void changeName(String changeName) {
            this.record = this.record.replace(name, changeName);
            this.name = changeName;
        }
    }
}