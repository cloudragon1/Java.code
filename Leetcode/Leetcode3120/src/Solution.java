class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr = new int[2];
        for (char c : word.toCharArray()) {
            arr[c >> 5 & 1] |= 1 << (c & 31);
        }
        return Integer.bitCount(arr[0] & arr[1]);
    }
}