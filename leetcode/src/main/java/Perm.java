public class Perm {

    public void swap(char c[],int k,int m){
        char temp=c[k];
        c[k]=c[m];
        c[m]=temp;
    }
    public void allRange(char c[],int k,int m){
           if (k == m-1){
               System.out.println(new String(c));

           }
            for(int i=k;i<m;i++){
                swap(c,k,i);
                allRange(c,k+1,m);
                swap(c,k,i);
            }

    }

    public static void main(String[] args) {
        Perm p = new Perm();
        char[] a = new char[]{'1','2', '3', '4', '5', '6'};
        p.allRange(a, 0, a.length);
    }
}
