package com.acsno.common.util.mqtt;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class WebSub{

	public final static Logger log =  Logger.getLogger(WebSub.class);
	
    private MqttClient client;
    private MqttConnectOptions options;
    private String host;
    private String probe_id;
    private String result = null;
    MqttCallback cb = null;
    
	/**
	 * 
	 * 添加: LiuQiang - 2019年12月21日 下午7:08:31<br>
	 * 修改: LiuQiang - 2019年12月21日 下午7:08:31<br>
	 * @param host
	 * @param probe_id
	 * @param cb 接收消息后的回调函数
	 */
	public WebSub(String host,String probe_id, MqttCallback cb) {
		this.host = host;
		this.probe_id = probe_id;
		this.cb = cb;
	}

	public String receiveMsg() throws Exception {
		try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(host, probe_id + "WebSub", new MemoryPersistence());
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置连接的用户名
            options.setUserName(MQTTUtil.userName);
            // 设置连接的密码
            options.setPassword(MQTTUtil.passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 设置回调
            client.setCallback(cb);
            MqttTopic topic = client.getTopic(probe_id + "/reply");
            // setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            options.setWill(topic, "close".getBytes(), 2, true);

            client.connect(options);
            // 订阅消息
            int[] Qos = { 1 };
            String[] topic1 = { probe_id + "/reply"};
            client.subscribe(topic1, Qos);
            
            Thread.sleep(100);
        } catch (Exception e) {
            log.error("实时测试返回错误 ",e);
            close();
        }
        return result;
    }

    public void close() throws MqttException{
    	if (this.client!=null){
    		this.client.disconnectForcibly();
        	this.client.close();
    	}
    }
    
}