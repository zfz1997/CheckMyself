package single;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
class RegExpTest {
 
    public static void main(String[] args) {
        String str = "������(������)(������)(������)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
