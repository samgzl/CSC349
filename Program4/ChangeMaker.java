// Samantha Gunzl, Quinn Coleman
// sgunzl, qcoleman
// 2/26/2018
// Project 4


public class Tester {

	public static void main(String[] args) {
		
		System.out.println("Testing change_DP and change_greedy algortihms");
		int us_matches = 0, soviet_matches = 0, p2_matches = 0;
		int no_nickel_matches = 0, some_set_matches = 0;
		int[] us_denoms = {100, 50, 25, 10, 5, 1};
		int[] soviet_denoms = {100, 50, 20, 15, 10, 5, 3, 2, 1};
		int[] p2_denoms = {64, 32, 16, 8, 4, 2, 1};
		int[] no_nickel_denoms = {100, 50, 25, 10, 1};
		int[] some_set_denoms = {66, 35, 27, 18, 10, 1 };
		for (int i=1; i<201; i++) {
			us_matches += compareCoins(i, us_denoms);
			soviet_matches += compareCoins(i, soviet_denoms);
			p2_matches += compareCoins(i, p2_denoms);
			no_nickel_matches += compareCoins(i, no_nickel_denoms);
			some_set_matches += compareCoins(i, some_set_denoms);
		}
		System.out.println("Testing set1: " + us_matches +" matches in 200 tests");
		System.out.println("Testing set2: " + soviet_matches +" matches in 200 tests");
		System.out.println("Testing set3: " + p2_matches +" matches in 200 tests");
		System.out.println("Testing set4: " + no_nickel_matches +" matches in 200 tests");
		System.out.println("Testing set5: " + some_set_matches +" matches in 200 tests");

	}
	
	private static int compareCoins(int i, int[] denominations) {
		int[] dp, greedy;
		int count_dp, count_greedy;
		int k = denominations.length;
		int matches = 0;
		dp = ChangeMaker.change_DP(i, denominations);
		greedy = ChangeMaker.change_greedy(i, denominations);
		count_dp = getOptimalCoinCount(dp, k, denominations);
		count_greedy = getOptimalCoinCount(greedy, k, denominations);
		if (count_dp == count_greedy) {
			matches += 1;
		}
		return matches;
	}
	
	private static int getOptimalCoinCount(int[] change, int k, int[] denominations) {
		int count = 0;
		for (int i=0; i<k; i++) {
			if (change[i] == 0) {
				continue;
			}
			count += change[i];
		}
		return count;
	}
	
}
