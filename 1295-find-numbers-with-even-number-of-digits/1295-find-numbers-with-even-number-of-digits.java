class Solution {
    public int findNumbers(int[] arr) {
        List<Integer> res = new ArrayList<>();
		for(int item : arr){
			if(isEven(item)==true)
				res.add(item);
		}
		return res.size();
		// add your logic here
	}
	boolean isEven(int num){
		int count = 0;
		num=Math.abs(num);
		while(num>0){
			count++;
			num=num/10;
		}
		if(count%2 == 0)
			return true;
		else
			return false;
	}
    
}