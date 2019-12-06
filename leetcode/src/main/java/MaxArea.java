public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0 ; i< height.length ; i++){
            for (int j = i ; j < height.length ;j ++){
                maxArea = Math.max((j-i) * Math.min(height[j], height[i]), maxArea);
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length -1;
        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left] ,height[right]) * (right-left));
            if (height[left] < height[right]){
                left ++;
            }else {
                right++;
            }
        }
        return maxArea;
    }


}
