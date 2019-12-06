public class ArrangeCoins {

    public int arrangeCoins(int n) {
        int res = n * 2;
        int middle = (int)Math.sqrt(res);
        int left = 0;
        int right = n;
        int middleRes = middle * (middle + 1);
        while (left < right){
            if (middleRes == res){
                return middle;
            }else if (middleRes < res){
                right = middle + 1;
            }else {
                left = middle -1 ;
            }
            middle = (right - left)/2;
            middleRes = middle * (middle + 1);
            if ((middle * (middle - 1)) < res && res <((middle + 1) * (middle + 2))){
                return middle;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangeCoins().arrangeCoins(4));
    }

}
