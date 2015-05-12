class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        if (k < 0) {
            return 0;
        }

        long val = 0;
        Queue<Long> queue3 = new LinkedList<Long>();
        Queue<Long> queue5 = new LinkedList<Long>();
        Queue<Long> queue7 = new LinkedList<Long>();
        queue3.add((long)1);

        for (int i = 0; i <= k; i++) {
            long v3 = queue3.size() > 0 ? queue3.peek() : Long.MAX_VALUE;
            long v5 = queue5.size() > 0 ? queue5.peek() : Long.MAX_VALUE;
            long v7 = queue7.size() > 0 ? queue7.peek() : Long.MAX_VALUE;
            val = Math.min(v3, Math.min(v5, v7));
            if (val == v3) { // enqueue into queue 3, S and 7
                queue3.remove();
                queue3.add(3 * val);
                queue5.add(5 * val);
            } else if (val == v5) { // enqueue into queue 5 and 7 queues.removeQ;
                queue5.remove();
                queue5.add(5 * val);
            } else if (val == v7) { // enqueue into Q7 queue?.remove();
                queue7.remove();
            }
            queue7.add(7 * val); // Always enqueue into Q7
        }
        return val;
    }
};

