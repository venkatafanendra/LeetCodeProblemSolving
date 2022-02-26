class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int target1,target2,front,back;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            target1=target-nums[i];
            for(int j=i+1;j<n;j++){
                target2=target1-nums[j];
                front = j+1;
                back = n-1;
                while(front<back){
                    if(nums[front]+nums[back]<target2)
                        front++;
                    else if(nums[front]+nums[back]>target2)
                        back--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        res.add(quad);
                        while(front<back && quad.get(2)==nums[front])
                            front++;
                        while(front<back && quad.get(3)==nums[back])
                            back--;
                    }
                }
                while(j+1<n && nums[j]==nums[j+1])
                    j++;
            }
            while(i+1<n-1 && nums[i]==nums[i+1])
                i++;
        }
        return res;
    }
}