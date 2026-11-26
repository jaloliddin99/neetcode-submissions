class Twitter {


    int time;
    Map<Integer, Set<Integer>> userList;
    Map<Integer, List<int[]>> feedList;

    public Twitter() {
        time = 0;
        userList = new HashMap<>();
        feedList = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        feedList.putIfAbsent(userId, new ArrayList<>());
        feedList.get(userId).add(new int[]{time++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(feedList.getOrDefault(userId, new ArrayList<>()));
        for (int followeeId : userList.getOrDefault(userId, new HashSet<>())) {
            feed.addAll(feedList.getOrDefault(followeeId, new ArrayList<>()));
        }
        feed.sort((a, b) -> b[0] - a[0]);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            res.add(feed.get(i)[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            userList.putIfAbsent(followerId, new HashSet<>());
            userList.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        userList.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
