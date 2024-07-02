import java.util.*;
class MyClass {
	int count;
	public MyClass() {
		count++;
	}
}
public class DP {
    public static void main(String[] args) {
        // String s = "abcd";
        // String p = "*?d";
        // System.out.println(isMatch(s, p));
		//Given a dictionary and a string check if the string can be broken into words present in the dictionary
		// Set<String> dict = new HashSet<String>();
		// dict.add("like");
		// dict.add("i");
		// dict.add("man");
		// dict.add("go");
		// dict.add("mangoes");
		// String s = "ilikemangoes";
		// String p = "ilikegoes";
		// System.out.println(wordBreak(p, dict));
		// Student s1 = new Student(1,6);
		// Student s2 = new Student(4,2);
		// Student s3 = new Student(9,2);
		// List<Student> list = new ArrayList<Student>();
		// list.add(s1);
		// list.add(s2);
		// list.add(s3);
		// Collections.sort(list,(a,b) -> a.price-b.price | a.id-b.id);
		// for(Student s : list){
		// 	s.print(s.id,s.price);
		// }
		MyClass obj1 = new MyClass();
		MyClass obj2 = new MyClass();
		MyClass obj3 = new MyClass();
		System.out.println(MyClass.count);

    }
	public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static boolean isMatch(String s, String p) {   
		int m = p.length(),n = s.length();
		boolean dp[][] = new boolean[m+1][n+1];
		dp[m][n] = true;
		for(int i=m-1;i>=0;i--){
			if(p.charAt(i)=='*'){
				dp[i][n] = dp[i+1][n];
            }
		}
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(p.charAt(i)=='?' || p.charAt(i)==s.charAt(j)){
					dp[i][j] = dp[i+1][j+1];
                }
				else if(p.charAt(i)=='*'){
					dp[i][j] = (dp[i+1][j]||dp[i+1][j+1])||dp[i][j+1];
                }
			}
		}
		return dp[0][0];
	}
}
class Student{
	int id;
	int price;
	public Student(int id,int price){
		this.id = id;
		this.price = price;
	}
	public void print(int id,int price){
		System.out.println(id+" "+price);
	}
}
