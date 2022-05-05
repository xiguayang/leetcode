package GreedyAlgrithms;
public class PlaceFlowers {
    /**
     * 605. Can Place Flowers[E] You have a long flowerbed in which some of the
     * plots are planted, and some are not. However, flowers cannot be planted in
     * adjacent plots.
     * 
     * @param flowerbed: an integer array flowerbed containing 0's and 1's, where 0
     *                   means empty and 1 means not empty,
     * @param n
     * @return return if n new flowers can be planted in the flowerbed without
     *         violating the no-adjacent-flowers rule.
     */
    // Input: flowerbed = [1,0,0,0,1], n = 1
    // Output: true
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // solution: find elements whose left and right are both 0, except start and end
        // position
        // find adjacent three 0, plant one flower
        // count the number of elements if equals n return true
        int size = flowerbed.length;
        int count = 0;
        // only one spot
        if (size < 2) {
            if (flowerbed != null && flowerbed[0] == 0 && n == 1 || n == 0)
                return true;
        }
        // for start position
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }
        // for end position
        if (flowerbed[size - 1] == 0 && flowerbed[size - 2] == 0) {
            count++;
            flowerbed[size - 1] = 1;
        }
        // find three continue 0
        for (int i = 1; i < size - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        if (count >= n) {
            return true;
        }
        return false;
    }

}