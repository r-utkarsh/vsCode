
import java.util.HashMap;


public class startHash {
    public static void main(String[] args) {
        HashMap<String, Integer> examScore = new HashMap<>();
        examScore.put("a", 34);
        examScore.put("c", 71);
        examScore.put("b", 62);
        examScore.put("e", 54);
        examScore.put("f", 82);

        examScore.putIfAbsent("d", 10);
        examScore.replace("a", 1);

        System.out.println(examScore.toString());
    //     System.out.println(examScore.size());
    //     System.out.println(examScore.containsKey("d"));
    //     System.out.println(examScore.containsValue(34));
        examScore.forEach((i,val) -> {
            System.out.println(i+" - "+val);
        });

        System.out.println();
        
        examScore.forEach((i,val) -> {
            val %= 10;
            System.out.print(i+" - "+val);
            if (val>1) {
                System.out.print(" - ok");
            }
            System.out.println();
        });

        System.out.println();
        
        examScore.forEach((i,val) -> {
            val -= 10;
            System.out.print(i+" - "+val);
            if (val>50) {
                System.out.print(" - not ok");
            }
            System.out.println();
        });
    }
}
