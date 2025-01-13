import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Boolean> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, true);
        }
        for (String phone : phone_book) {
            StringBuilder sb = new StringBuilder();
            for (int i=1; i<phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (map.containsKey(prefix))
                    return false;
            }
        }
        return true;
    }
}