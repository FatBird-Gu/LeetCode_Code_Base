package mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Twitter {
    private static Set<String> followInfo;
    private static List<String> post;
    private int timeStamp;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followInfo = new HashSet<>();
        post = new ArrayList<>(1000);
        timeStamp = 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Twitter twitter = new Twitter();

        // �û�1������һ�������� (�û�id = 1, ����id = 5).
        twitter.postTweet(1, 5);

        // �û�1�Ļ�ȡ����Ӧ������һ���б����а���һ��idΪ5������.
        System.out.println(twitter.getNewsFeed(1));

        // �û�1��ע���û�2.
        twitter.follow(1, 2);

        // �û�2������һ�������� (����id = 6).
        twitter.postTweet(2, 6);

        // �û�1�Ļ�ȡ����Ӧ������һ���б����а����������ģ�id�ֱ�Ϊ -> [6, 5].
        // ����id6Ӧ��������id5֮ǰ����Ϊ������5֮���͵�.
        System.out.println(twitter.getNewsFeed(1));

        // �û�1ȡ����ע���û�2.
        twitter.unfollow(1, 2);

        // �û�1�Ļ�ȡ����Ӧ������һ���б����а���һ��idΪ5������.
        // ��Ϊ�û�1�Ѿ����ٹ�ע�û�2.
        System.out.println(twitter.getNewsFeed(1));

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        StringBuilder sb = new StringBuilder();
        sb.append(userId).append(" ").append(tweetId);
        post.add(sb.toString());
        timeStamp++;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> allUser = new HashSet<>();
        allUser.add(userId);
        for (String iter : followInfo) {
            String[] frfe = iter.split(" ");
            if (Integer.valueOf(frfe[0]) == userId) {
                allUser.add(Integer.valueOf(frfe[1]));
            }
        }
        int rest = 10;
        for (int i = timeStamp - 1; i >= 0 && rest > 0; i--) {
            String str = post.get(i);
            String[] strs = str.split(" ");
            if (allUser.contains(Integer.valueOf(strs[0]))) {
                res.add(Integer.valueOf(strs[1]));
                rest--;
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        StringBuilder sb = new StringBuilder();
        sb.append(followerId).append(" ").append(followeeId);
        followInfo.add(sb.toString());
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        StringBuilder sb = new StringBuilder();
        sb.append(followerId).append(" ").append(followeeId);
        if (followInfo.contains(sb.toString())) {
            followInfo.remove(sb.toString());
        }
    }

}
