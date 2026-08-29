class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Create nodes 1 to n
        for(int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        // Build adjacency list
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    map.get(i + 1).add(j + 1);
                }
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n + 1];

        // Count connected components
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, visited, map);
            }
        }

        return count;
    }

    public static void dfs(
        int node,
        boolean[] visited,
        HashMap<Integer, List<Integer>> adj
    ) {
        visited[node] = true;

        for(int nei : adj.get(node)) {
            if(!visited[nei]) {
                dfs(nei, visited, adj);
            }
        }
    }
}