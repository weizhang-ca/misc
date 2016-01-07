int[][] a = {
		{3,0,0,0,0,0,0},
		{4,4,0,0,0,0,0},
		{8,9,7,0,0,0,0},
		{8,4,1,6,0,0,0},
		{9,9,3,1,5,0,0},
		{8,5,1,3,6,2,0},
		{7,6,9,1,1,2,3}
	};
int max(int a, int b){
	return a>b?a:b;
}
//Non-recursive
void find_max_path(int** a, int n){
	int[n][n] temp;
	//set all values to 0 in temp
	init(temp);
	int i=0;
	temp[0][0] = a[i++][0];
	for(;i<n; i++){
		for(int j=0; j<=i; j++){
			if(j=0){
				temp[i][j] = temp[i-1][j]+a[i][j];
			}
			else{
				temp[i][j] = max(temp[i-1][j], temp[i-1][j-1])+a[i][j];
			}
		}
	}
	int max_index = find_max(temp[n-1][j]);
	print(temp[n-1][max_index]);
	stack<int[]> s;
	s.push(n-1, max_index});
	for(int j=n-2; j>=0; j--){
		if(max_index > 0){
			max_index = temp[j][max_index-1]>temp[j][max_index]?max_index-1:max_index;
		}
		s.push({j, max_index});
	}
	
	print(s);
}

//Recursive
int find_max_path_recursive(int** a, int i, int j, int n){
	int max_value;
	if(i==n-1){
		max_value =  a[i][j];
		a[n][j] = max_value;
	}
	else{
		for(int j=0; j<=i; j++){
			max_value = max(find_max_path_recursive(int** a, i+1, j, n), find_max_path_recursive(int** a, i+1, j+1, n)+a[i][j]
			a[n][j] = max_value;
		}
	}
	return a[n][j];
}

void main(){
	find_max_path_recursive(a, 0, 0, 9);
}