public class MinCoins {
	int[] coin_type = {1, 5, 10, 25, 50};
	int find_min_coins(int n){
		int[] b= new int[n+1];
		for(int i=1; i<=n; i++){
			b[i] = b[i-coin_type[0]]+1;
			for(int j=1; j<5; j++){
				if(i>=coin_type[j]&&b[i]>=b[i-coin_type[j]]+1){
					b[i] = b[i-coin_type[j]]+1;
				}
			}
		}
		return b[n];
	}

	//Recursive
	int find_min_coins_recursive(int n){
		int a = 0;
		if(n<coin_type[0]){
			return 0;
		}
		a = find_min_coins_recursive(n-coin_type[0])+1;
		for(int j=1; j<5; j++){
			if(n>coin_type[j]){
				int temp = find_min_coins_recursive(n-coin_type[j])+1;
				if(a>temp)
				a = temp;
			}
			else{
				break;
			}
		}
		return a;
	}

}