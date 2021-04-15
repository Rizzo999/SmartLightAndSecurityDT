package digitaltwin.mqtt;

public class MqttDigitalTwinProcess {

    public static void main(String args[]) {

        MqttDigitalTwin mqttDigitalTwin001 = new MqttDigitalTwin("device001");
        mqttDigitalTwin001.run();

        MqttDigitalTwin mqttDigitalTwin002 = new MqttDigitalTwin("device002");
        mqttDigitalTwin002.run();

        MqttDigitalTwin mqttDigitalTwin003 = new MqttDigitalTwin("device003");
        mqttDigitalTwin003.run();

        MqttDigitalTwin mqttDigitalTwin004 = new MqttDigitalTwin("device004");
        mqttDigitalTwin004.run();

    }
}
