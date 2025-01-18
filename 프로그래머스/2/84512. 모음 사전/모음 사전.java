class Solution {
    public int solution(String word) {
        int sum = 0;
        String input = "";

        while (true) {
            if (input.length() < 5) {
                int size = 5 - input.length();
                for (int i=0; i<size; i++) {
                    input += "A";
                    sum++;
                    if (input.toString().equals(word))
                        return sum;
                }
            }
            
            String output = switching(input, sum);
            sum++;
            if (output.equals(word))
                break;
            input = output;
        }

        return sum;
    }
    
    public String switching(String str, int sum) {
        char c = str.charAt(str.length() - 1);
        
        switch (c) {
            case 'A':
                return str.substring(0, str.length() - 1) + "E";
            case 'E':
                return str.substring(0, str.length() - 1) + "I";
            case 'I':
                return str.substring(0, str.length() - 1) + "O";
            case 'O':
                return str.substring(0, str.length() - 1) + "U";
            default:
                return switching(str.substring(0, str.length() - 1), sum);
        }
    }
}