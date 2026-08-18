class Twitter {
    private Map<Integer,Set<Integer>> following;
    private Map<Integer,List<Tweet>> tweets;
    private int time;
     
    class Tweet{
        int id;
        int time;
        Tweet (int id,int time){
            this.id=id;
            this.time=time;
        }
    }
    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        int time=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId,time));
        time++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.time-a.time);
        if(tweets.containsKey(userId)){
            pq.addAll(tweets.get(userId));
        }
        if(following.containsKey(userId)){
            for(int followeeId:following.get(userId)){
                if(tweets.containsKey(followeeId)){
                    pq.addAll(tweets.get(followeeId));
                }
            }
        }
        while(!pq.isEmpty() && result.size()<10){
            result.add(pq.poll().id);
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId,new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */