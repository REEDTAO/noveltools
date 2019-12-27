package club.reedlu.rule;

public class Rule {
   public static  String TYPE_RULE="";

    public static boolean typePraser(String text, String href) {
        if(text.endsWith("小说"))return true;
        return false;
    }
}
