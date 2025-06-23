public class Solution {

    private void findCombinations(List<Integer> elements, int groupSize, int start,
            List<Integer> current, List<List<Integer>> result) {
        if (current.size() == groupSize) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (elements.size() - start < groupSize - current.size())
            return;

        for (int i = start; i < elements.size(); i++) {
            current.add(elements.get(i));
            findCombinations(elements, groupSize, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public double minTime(int n, int k, int m, int[] time, double[] mul) {
        class State {
            double totalTime;
            int mask;
            int stage;
            int location;

            State(double t, int m, int s, int l) {
                totalTime = t;
                mask = m;
                stage = s;
                location = l;
            }
        }

        if (k == 1 && n > 1)
            return -1.0;

        int numMasks = 1 << n;
        double[][][] dist = new double[numMasks][m][2];
        for (double[][] stage : dist)
            for (double[] loc : stage)
                Arrays.fill(loc, Double.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingDouble(s -> s.totalTime));
        dist[0][0][0] = 0.0;
        pq.offer(new State(0.0, 0, 0, 0));

        int finalMask = numMasks - 1;

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            if (curr.totalTime > dist[curr.mask][curr.stage][curr.location] + 1e-9)
                continue;

            if (curr.mask == finalMask && curr.location == 1)
                return Math.round(curr.totalTime * 100000.0) / 100000.0;

            if (curr.location == 0) {
                List<Integer> basePeople = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((curr.mask & (1 << i)) == 0)
                        basePeople.add(i);
                }

                for (int sz = 1; sz <= Math.min(k, basePeople.size()); sz++) {
                    List<List<Integer>> combinations = new ArrayList<>();
                    findCombinations(basePeople, sz, 0, new ArrayList<>(), combinations);

                    for (List<Integer> group : combinations) {
                        int maxTime = 0;
                        for (int i : group)
                            maxTime = Math.max(maxTime, time[i]);

                        double crossTime = maxTime * mul[curr.stage];
                        double newTime = curr.totalTime + crossTime;
                        int nextStage = (curr.stage + (int) Math.floor(crossTime)) % m;

                        int nextMask = curr.mask;
                        for (int i : group)
                            nextMask |= (1 << i);

                        if (newTime < dist[nextMask][nextStage][1]) {
                            dist[nextMask][nextStage][1] = newTime;
                            pq.offer(new State(newTime, nextMask, nextStage, 1));
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if ((curr.mask & (1 << i)) != 0) {
                        double retTime = time[i] * mul[curr.stage];
                        double totalTime = curr.totalTime + retTime;
                        int nextStage = (curr.stage + (int) Math.floor(retTime)) % m;
                        int nextMask = curr.mask & ~(1 << i);

                        if (totalTime < dist[nextMask][nextStage][0]) {
                            dist[nextMask][nextStage][0] = totalTime;
                            pq.offer(new State(totalTime, nextMask, nextStage, 0));
                        }
                    }
                }
            }
        }
        return -1.0;
    }
}
