class User {
    int userId;
    Set<Integer> followers; // people following the user
    Set<Integer> followees; // people the user follows
    public User(int userId){
        this.userId = userId;
        followers = new HashSet<>();
        followees = new HashSet<>();
    }
}

class Tweet {
    int userId;
    int tweetId;
    public Tweet(int userId, int tweetId){
        this.userId = userId;
        this.tweetId = tweetId;
    }
}

class Twitter {
    LinkedList<Tweet> newsFeed;
    Map<Integer, User> users;
    public Twitter() {
        newsFeed = new LinkedList<>();
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {

        if(!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }
        Tweet tweet = new Tweet(userId, tweetId);
        // System.out.println("userId: " + userId + "; tweetId: " + tweetId);
        newsFeed.addFirst(tweet);

        // System.out.println("newsFeed size: " + newsFeed.size());
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        int count = 0;
        
        // Iterate over the newsFeed (most recent tweets first)
        for (Tweet tweet : newsFeed) {
            if (count >= 10) break;
            if(users.get(userId) == null)continue;
            
            if (tweet.userId == userId || users.get(userId).followees.contains(tweet.userId)) {
                res.add(tweet.tweetId);
                count++;
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId))users.put(followerId, new User(followerId));
        if(!users.containsKey(followeeId))users.put(followeeId, new User(followeeId));
        users.get(followerId).followees.add(followeeId);
        users.get(followeeId).followers.add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && users.containsKey(followeeId)) {
            users.get(followerId).followees.remove(followeeId);
            users.get(followeeId).followers.remove(followerId);
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