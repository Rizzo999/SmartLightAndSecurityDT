package digitaltwin.mqtt;

import it.unimore.dipi.iot.wldt.engine.WldtConfiguration;
import it.unimore.dipi.iot.wldt.engine.WldtEngine;
import it.unimore.dipi.iot.wldt.exception.WldtConfigurationException;
import it.unimore.dipi.iot.wldt.processing.ProcessingPipeline;
import it.unimore.dipi.iot.wldt.worker.mqtt.Mqtt2MqttConfiguration;
import it.unimore.dipi.iot.wldt.worker.mqtt.Mqtt2MqttWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;

public class MqttDigitalTwin {

    private static final String TAG = "[WLDT-MQTT-Process]";

    private static final Logger logger = LoggerFactory.getLogger(MqttDigitalTwin.class);

    private static final String DT_DESTINATION_MQTT_ADDRESS = "127.0.0.1";

    private static final int DT_DESTINATION_MQTT_PORT = 1884;

    private static final String DT_SOURCE_MQTT_ADDRESS = "127.0.0.1";

    private static final int DT_SOURCE_MQTT_PORT = 1883;

    private String deviceId = null;

    public MqttDigitalTwin(String deviceId){
        this.deviceId = deviceId;
    }


    /*public static void main(String[] args)  {

        try{

            logger.info("{} Initializing WLDT-Engine ... ", TAG);

            //Manual creation of the WldtConfiguration
            WldtConfiguration wldtConfiguration = new WldtConfiguration();
            wldtConfiguration.setDeviceNameSpace("it.unimore.dipi.things");
            wldtConfiguration.setWldtBaseIdentifier("wldt");
            wldtConfiguration.setWldtStartupTimeSeconds(10);
            wldtConfiguration.setApplicationMetricsEnabled(false);
            wldtConfiguration.setApplicationMetricsReportingPeriodSeconds(10);
            wldtConfiguration.setMetricsReporterList(Collections.singletonList("csv"));

            WldtEngine wldtEngine = new WldtEngine(wldtConfiguration);

            Mqtt2MqttWorker mqtt2MqttWorker = new Mqtt2MqttWorker(wldtEngine.getWldtId(), getMqttExampleConfiguration());

            //Setup Processing Pipeline
            mqtt2MqttWorker.addProcessingPipeline(Mqtt2MqttWorker.DEFAULT_RESOURCE_TELEMETRY_PROCESSING_PIPELINE,
                    new ProcessingPipeline(new SenmlMqttProcessingStep(wldtEngine.getWldtId())));

            wldtEngine.addNewWorker(mqtt2MqttWorker);
            wldtEngine.startWorkers();

        }catch (Exception | WldtConfigurationException e){
            e.printStackTrace();
        }
    }*/

    //Replace main with a run method

    public void run() {
        try{

            logger.info("{} Initializing WLDT-Engine ... ", TAG);

            //Manual creation of the WldtConfiguration
            WldtConfiguration wldtConfiguration = new WldtConfiguration();
            wldtConfiguration.setDeviceNameSpace("it.unimore.dipi.things");
            wldtConfiguration.setWldtBaseIdentifier("wldt");
            wldtConfiguration.setWldtStartupTimeSeconds(10);
            wldtConfiguration.setApplicationMetricsEnabled(false);
            wldtConfiguration.setApplicationMetricsReportingPeriodSeconds(10);
            wldtConfiguration.setMetricsReporterList(Collections.singletonList("csv"));

            WldtEngine wldtEngine = new WldtEngine(wldtConfiguration);

            Mqtt2MqttWorker mqtt2MqttWorker = new Mqtt2MqttWorker(wldtEngine.getWldtId(), getMqttExampleConfiguration(deviceId));

            //Setup Processing Pipeline
            /*mqtt2MqttWorker.addProcessingPipeline(Mqtt2MqttWorker.DEFAULT_RESOURCE_TELEMETRY_PROCESSING_PIPELINE,
                    new ProcessingPipeline(new SenmlMqttProcessingStep(wldtEngine.getWldtId())));*/

            wldtEngine.addNewWorker(mqtt2MqttWorker);
            wldtEngine.startWorkers();

        }catch (Exception | WldtConfigurationException e){
            e.printStackTrace();
        }
    }

    /**
     * Example configuration for the MQTT-to-MQTT WLDT Worker
     * @return
     */

    private Mqtt2MqttConfiguration getMqttExampleConfiguration(String deviceId){

        Mqtt2MqttConfiguration mqtt2MqttConfiguration = new Mqtt2MqttConfiguration();

        mqtt2MqttConfiguration.setOutgoingClientQoS(0);
        mqtt2MqttConfiguration.setDestinationBrokerAddress(DT_DESTINATION_MQTT_ADDRESS);
        mqtt2MqttConfiguration.setDestinationBrokerPort(DT_DESTINATION_MQTT_PORT);
        mqtt2MqttConfiguration.setDestinationBrokerBaseTopic("wldt");
        mqtt2MqttConfiguration.setDeviceId(deviceId);
        mqtt2MqttConfiguration.setResourceIdList(Arrays.asList("presence", "contact"));
        mqtt2MqttConfiguration.setDeviceTelemetryTopic("presence_monitoring_device/{{device_id}}/telemetry");
        mqtt2MqttConfiguration.setResourceTelemetryTopic("presence_monitoring_device/{{device_id}}/telemetry/{{resource_id}}");
        mqtt2MqttConfiguration.setEventTopic("presence_monitoring_device/{{device_id}}/event");
        mqtt2MqttConfiguration.setBrokerAddress(DT_SOURCE_MQTT_ADDRESS);
        mqtt2MqttConfiguration.setBrokerPort(DT_SOURCE_MQTT_PORT);

        return mqtt2MqttConfiguration;
    }

}