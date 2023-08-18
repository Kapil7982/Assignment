package assignemnt;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		
		int[] arr = {1,8,6,2,5,4,8,3,7};
		
		//int[] arr = {1,1};
		
		int n = arr.length;
		
		int left = 0;
		
		int right = n-1;
		
		int maxArea =0;
		
		while(left < right)
		{
			int minHeight = Math.min(arr[left], arr[right]);
			
			int width = right-left;
			
			int area = minHeight* width;
			
			maxArea = Math.max(maxArea, area);
			
			if(arr[left] <arr[right])
			{
				left++;
			}
			else
			{
				right--;
			}
		}
		System.out.println(maxArea);
	}

}
