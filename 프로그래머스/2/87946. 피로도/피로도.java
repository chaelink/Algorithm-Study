class Solution {
    int answer = 0;
    int[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new int[n];
        // for(int i=0; i<n; i++) {
        //     if(dungeons[i][0]<=k) {
        //         visited[i] = 1;
        //         dfs(k, dungeons, 1);
        //         visited[i] = 0;
        //     }
        // }
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    void dfs(int k, int[][] dungeons, int v) {
        answer = Math.max(answer, v);
        
        for(int i=0; i<dungeons.length; i++) {
            if(visited[i]==0 && dungeons[i][0]<=k) {
                visited[i] = 1;
                k -= dungeons[i][1];
                dfs(k, dungeons, v+1);
                visited[i] = 0;
                k += dungeons[i][1];
            }
        }
    }
    
    
}