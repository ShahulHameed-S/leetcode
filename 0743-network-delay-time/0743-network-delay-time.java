class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
     adjList.get(u).add(new int[] {v, w});
        }
       int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
      PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        distance[k] = 0;
        pq.offer(new int[] {k, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            if (distance[node] < cost) {
                continue;
            }
            for (int[] nei : adjList.get(node)) {
                int neighbor = nei[0];
                int weight = nei[1];
                int newDist = cost + weight;
               if (newDist < distance[neighbor]) {
                    distance[neighbor] = newDist;
                    pq.offer(new int[] {neighbor,newDist});
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, distance[i]);
        }
        return answer;
    }
}