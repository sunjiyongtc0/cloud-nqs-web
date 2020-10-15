package com.acsno.common.util.mqtt;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * 
 * Title:Server Description: 服务器向多个客户端推送主题，即不同客户端可向服务器订阅相同主题
 * 
 * @author yueli 2017年9月1日下午17:41:10
 */
public class WebPub {

    private MqttClient client;
    private MqttTopic topic11;
    private String probe_id;

    /**
     * 构造函数
     * 
     * @throws MqttException
     */
    public WebPub(String host,String probe_id) throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
    	this.probe_id = probe_id;
        client = new MqttClient(host, probe_id + "WebPub", new MemoryPersistence());
        connect();
    }

    /**
     * 用来连接服务器
     */
    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(MQTTUtil.userName);
        options.setPassword(MQTTUtil.passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
        	
        	client.setCallback(new MqttCallback() {
        		public void connectionLost(Throwable cause) {
        	        // 连接丢失后，一般在这里面进行重连
        	        //System.out.println("连接断开，可以做重连0");
        	    }
        	    public void deliveryComplete(IMqttDeliveryToken token) {}
        	    public void messageArrived(String topic, MqttMessage message) throws Exception {}
			});
            client.connect(options);
            topic11 = client.getTopic(probe_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param topic
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */
    public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException, MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! " + token.isComplete());
    }

    public void close() throws MqttException{
    	this.client.disconnectForcibly();
    	this.client.close();
    }
    public void send(String msg) throws MqttException{
        MqttMessage message = new MqttMessage();
        message.setQos(0);
        message.setRetained(false);
        message.setPayload(msg.getBytes());
        publish(this.topic11, message);
    }
    
    
    
    public MqttClient getClient() {
		return client;
	}

	public void setClient(MqttClient client) {
		this.client = client;
	}

	public MqttTopic getTopic11() {
		return topic11;
	}

	public void setTopic11(MqttTopic topic11) {
		this.topic11 = topic11;
	}

}