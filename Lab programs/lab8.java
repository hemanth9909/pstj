import java.util.*;

public class SmartTrafficNavigation {
    static final int INF = 999999;

    static void shortestPath(int[][] graph, int source, int dest) {
        int n = graph.length;
        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[source] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] &&
                    (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            if (u == -1 || dist[u] == INF) break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0 && !visited[v] &&
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        if (dist[dest] == INF) {
            System.out.println("No route available.");
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = dest; v != -1; v = parent[v]) {
            path.add(v);
        }
        Collections.reverse(path);

        System.out.println("Shortest Distance: " + dist[dest]);
        System.out.print("Route: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print("Location " + path.get(i));
            if (i < path.size() - 1) System.out.print(" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 2, 0, 0},
            {4, 0, 1, 5, 0},
            {2, 1, 0, 8, 10},
            {0, 5, 8, 0, 2},
            {0, 0, 10, 2, 0}
        };

        shortestPath(graph, 0, 4);
    }
}
Shortest Distance: 10
Route: Location 0 -> Location 2 -> Location 1 -> Location 3 -> Location 4
