class Main{

    public boolean reverseString(String s){
        StringBuilder newStr = new StringBuilder();

        for (char c: s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }

    public boolean twoPointers(String s){
        int l = 0, r=s.length()-1;

        while (l<r){
            while(l<r && !alphaNum(s.charAt(l))){
                l++;
            }
            while(r>l && !alphaNum(s.charAt(r))){
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++; r--;
        }
        return true;
    }

    public boolean alphaNum(char c){
        return (c >= 'A' && c <= 'Z' || 
        c >= 'a' && c <= 'z' || 
        c >= '0' && c <= '9');
    }


}