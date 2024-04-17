class TopVotedCandidate {
  //TC: O(logn)
  //SC:  O(2n)
    HashMap<Integer, Integer> countMap;
    HashMap<Integer, Integer> leadersMap;
    private int[] time;
    public TopVotedCandidate(int[] persons, int[] times) {
         this.leadersMap = new HashMap<>();
         this.countMap = new HashMap<>();
         this.time = times;
         int leader = 0;
         for(int i = 0; i <persons.length; i++){
            int person = persons[i];
            int time = times[i];
            countMap.put(person, countMap.getOrDefault(person,0) + 1);
            if(countMap.get(leader) <= countMap.get(person)){
                leader = person;
            }
            leadersMap.put(time,leader);
         }
    }
    
    public int q(int t) {
        if(leadersMap.containsKey(t)) return leadersMap.get(t);
        int low = 0, high = time.length - 1;
        //bs
        while(low <= high){
            int mid = low + (high - low)/2;
            if(time[mid] > t){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return leadersMap.get(time[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
