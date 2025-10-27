class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void merge(int nums[], int l, int m, int r) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int left = l;
        int right = m + 1;

        while (left <= m && right <= r) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= m) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= r) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = l; i <= r; i++) {
            nums[i] = temp.get(i - l);
        }
    }

    void mergeSort(int nums[], int l, int r) {
        int low = l;
        int high = r;
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }
}