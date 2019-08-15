import redis.clients.jedis.Jedis;

import redis.clients.jedis.JedisPool;

import redis.clients.jedis.JedisPoolConfig;



public class TestMain {

    public static final String CHANNEL = "mychannel";

    public static final String CHANNEL2 = "mychanne2";

    public static final String HOST = "47.107.238.158";

    public static final int PORT = 6379;



    private final static JedisPoolConfig POOL_CONFIG = new JedisPoolConfig();

    private final static JedisPool JEDIS_POOL = new JedisPool(POOL_CONFIG, HOST, PORT, 0);



    public static void main(String[] args) {

        final Jedis subscriberJedis = JEDIS_POOL.getResource();

        final Jedis publisherJedis = JEDIS_POOL.getResource();

        final Subscriber subscriber = new Subscriber();

        new Thread(new Runnable() {

            public void run() {

                try {

                    System.out.println("Subscribing to mychannel,this thread will be block");
                    subscriberJedis.subscribe(subscriber, CHANNEL);
                    subscriberJedis.subscribe(subscriber,CHANNEL2);
                    System.out.println("subscription ended");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();

        new Publisher(publisherJedis, CHANNEL).startPublish();
        new Publisher(publisherJedis, CHANNEL2).startPublish();

        publisherJedis.close();
        subscriber.unsubscribe();

        subscriberJedis.close();

    }

}
