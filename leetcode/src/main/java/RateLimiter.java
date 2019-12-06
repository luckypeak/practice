import java.util.ArrayList;
import java.util.List;

class Test {
    String as;
    int con;
    Test(){
        as = "saa";
        con = 1;
    }
}

public class RateLimiter {


    public static void main(String[] args) {
        List<Integer> as = new ArrayList<>() ;
        as.add(null);
        RateLimiter rt = new RateLimiter();
        Test test = new Test();
        rt.print1(test);
        System.out.println(test.as);
        rt.print(as);

    }
    public  void  print1(Test test){
        test.as = "asaasssaas";
    }
    public List<Integer> print(List<Integer> par){
        System.out.println(par.get(0));
        for (int i : par){
            System.out.println(i);
        }
        return par;
    }

}
