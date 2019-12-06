public class GuessNumber {
    public int guessNumber(int n) {
      int left = 1;
      int right = n;
      while (left <= right){
          int mid = (left + right)/2;
          if (guess(mid) == 0 ){
              return mid;
          }else if (guess(mid) > 0){
              left = mid +1;
          }else if (guess(mid) < 0){
              right = mid-1;
          }
      }
      return left;
    }

    int guess(int num){
        if (num == 6){
            return 0;
        }
        return  num < 6 ? -1 : 1;
    }

    public static void main(String[] args) {
        GuessNumber gn = new GuessNumber();
        System.out.println(gn.guessNumber(10));
    }

}
