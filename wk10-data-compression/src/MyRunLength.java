public class MyRunLength {

    public static String compress(String str){
        String temp = "";
        for (int i = 0, count = 1; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))
                count++;
            else {
                temp = temp.concat(Integer.toString(count)).concat(Character.toString(str.charAt(i)));
                count = 1;
            }
        }
        return temp;
    }

    public static String expand(String str){
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                int n = Character.getNumericValue(str.charAt(i));
                for(int j=0; j<n; j++){
                    temp = temp.concat(String.valueOf(str.charAt(i+1)));
                }
            }
        }
        return temp;
    }

    public static void main(String[] args){
        String str = "AAAAABBBBCCC";
        System.out.println("Before run length compression: " + str);
        System.out.println("After run length compression: " + compress(str));
        System.out.println("After run length expansion: " + expand(compress(str)));
    }
}
