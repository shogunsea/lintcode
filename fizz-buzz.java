class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("fizz buzz");
            } else if (i % 5 == 0) {
                res.add("buzz");
            } else if (i % 3 == 0){
                res.add("fizz");
            } else {
                res.add(""+ i);
            }
        }

        return res;
    }
}

