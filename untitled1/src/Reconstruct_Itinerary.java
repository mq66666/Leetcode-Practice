import java.util.*;

public class Reconstruct_Itinerary {
    static class Solution {
        HashMap<String, PriorityQueue<String>> rout = new HashMap<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                rout.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                rout.get(ticket.get(0)).offer(ticket.get(1));
            }
            List<String> ans = new ArrayList<>();
            dfs(ans, "JFK", rout);
            Collections.reverse(ans);
            return ans;

        }

        public void dfs(List<String> ans, String from, HashMap<String, PriorityQueue<String>> rout) {
            rout.putIfAbsent(from, new PriorityQueue<String>());
            if (!rout.get(from).isEmpty()) {
                String des = rout.get(from).poll();
                dfs(ans, des, rout);

            }
            ans.add(from);

        }
    }

}