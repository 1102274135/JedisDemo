import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * <功能介绍>
 * <>
 *
 * @version v1
 * @Author laobai
 * @data 2019年8月1日
 */
public class Publisher {

    private Jedis publisherJedis;

    private String channel;



    public Publisher(Jedis publishJedis,String channel){

        this.publisherJedis=publishJedis;

        this.channel=channel;

    }

    public void startPublish(){

        try{

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while(true){

                System.out.println("请输入message:");

                String line = reader.readLine();

                if(!"quit".equals(line)){

                    publisherJedis.publish(channel, line);

                }else{

                    break;

                }

            }

        }catch(Exception e){

            e.printStackTrace();

        }
    }

}
