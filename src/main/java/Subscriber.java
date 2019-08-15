/**
 * <功能介绍>
 * <>
 *
 * @version v1
 * @Author laobai
 * @data 2019年8月1日
 */
import redis.clients.jedis.JedisPubSub;



public class Subscriber extends JedisPubSub {

    @Override

    public void onMessage(String channel, String message) {

        System.out.println("接受端收到：Channel:" + channel + ",Message:" + message);

    }



    @Override

    public void onPMessage(String pattern, String channel, String message) {

        System.out.println("Pattern:" + pattern + ",Channel:" + channel + ",Message:" + message);

    }



    @Override

    public void onSubscribe(String channel, int subscribedChannels) {

        System.out.println("onSubscribe---channel:"+channel+",subscribedChannels:"+subscribedChannels);

    }



    @Override

    public void onPUnsubscribe(String pattern, int subscribedChannels) {

        System.out.println("onPUnsubscribe---pattern:"+pattern+",subscribedChannels:"+subscribedChannels);

    }



    @Override

    public void onPSubscribe(String pattern, int subscribedChannels) {

        System.out.println("onPSubscribe---pattern:"+pattern+",subscribedChannels:"+subscribedChannels);

    }

}
