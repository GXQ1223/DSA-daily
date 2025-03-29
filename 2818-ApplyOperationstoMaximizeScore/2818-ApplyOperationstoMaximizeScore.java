// Last updated: 3/28/2025, 10:53:23 PM
class Solution {
    final int MOD = 1000000007;
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer> primeScores = new ArrayList<>(Collections.nCopies(n, 0));

        //calculate the prime score for each number in nums
        for(int index = 0; index < n; index++){
            int num = nums.get(index);
            //check for prime factors from 2 to squr(n)
            for(int factor = 2; factor <= Math.sqrt(num); factor++){
                if(num % factor == 0){
                    //increment prime score for each prime factor
                    primeScores.set(index, primeScores.get(index) + 1);

                    //remove all occorrences of the prime factor from num
                    while(num % factor == 0) num /= factor;
                }
            }

            //if num is still greater than or equal to 2, it's a prime factor
            if(num >= 2) primeScores.set(index, primeScores.get(index) + 1);
        }

        //initialize next and previous dominant index arrays
        int[] nextDominant = new int[n];
        int[] prevDominant = new int[n];
        Arrays.fill(nextDominant, n);
        Arrays.fill(prevDominant, -1);

        //stack to store indices for monotonic decreasing prime score
        Stack<Integer> decreasingPrimeScoreStack = new Stack<>();

        //calculating the next and previous dominant indices for each number
        for(int index = 0; index < n; index++){
            //while the stack is not empty and the current prime score is greater than the stack's top
            while(
                !decreasingPrimeScoreStack.isEmpty() && 
                primeScores.get(decreasingPrimeScoreStack.peek()) < primeScores.get(index)
            ) {
                int topIndex = decreasingPrimeScoreStack.pop();

                //set the next dominant element for the popped index
                nextDominant[topIndex] = index;
            }

            //if the stack is not empty, set the previous dominant element for the current index
            if(!decreasingPrimeScoreStack.isEmpty())
                prevDominant[index] = decreasingPrimeScoreStack.peek();

            //push the current index onto the stack
            decreasingPrimeScoreStack.push(index);
        }

        //calculate the number of subarrays in which each element is dominant
        long[] numOfSubarrays = new long[n];
        for(int index = 0; index < n; index++){
            numOfSubarrays[index] = 
                ((long) nextDominant[index] - index) * 
                (index - prevDominant[index]);
        }

        //priority queue to process elements in decreasing order of their value
        PriorityQueue<int[]> processingQueue = new PriorityQueue<>(
            (a, b) ->{
                if(b[0] == a[0]){
                    return Integer.compare(a[1], b[1]); // break tie based on the index(ascending order)
                }
                return Integer. compare(b[0], a[0]); //descending order for the value
            }
        );

        //push each number and its index onto the pq
        for(int i = 0; i < n; i++) processingQueue.offer(new int[]{nums.get(i), i});

        long score = 1;
        //process elements while there are operations left
        while(k > 0){
            //get the element with the maximum value from the queue
            int[]top = processingQueue.poll();
            int num = top[0];
            int index = top[1];

            //calculate the number of operations to apply on the current element
            long operations = Math.min((long)k, numOfSubarrays[index]);

            //update the score by raising the element to the power of operations 
            score = (score * power(num, operations)) % MOD;

            //reduce the remaining operations count
            k -= operations;
        }
        return (int)score;
    }

        
    //helper function to compute teh power of a number modulo MOD
    private long power(long base, long exponent){
        long res = 1;

        //calculate the exponentiation using binary exponentiation
        while(exponent > 0){
            //if the exponent is odd, multiply the result by teh base
            if(exponent % 2 == 1) res = (res * base) % MOD;

            //square the base and half the exponent
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return res;
    }
}