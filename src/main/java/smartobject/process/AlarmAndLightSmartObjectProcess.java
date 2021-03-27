package smartobject.process;

import smartobject.device.AlarmSmartObjectResource;
import smartobject.device.LightSmartObjectResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlarmAndLightSmartObjectProcess {

    private final static Logger logger = LoggerFactory.getLogger(AlarmAndLightSmartObjectProcess.class);

    public static void main (String args[]){

        AlarmSmartObjectResource alarmSmartObjectResource = new AlarmSmartObjectResource("smartDeviceAlarm-001", "001", 5683);
        logger.info("Starting Coap Server...");
        alarmSmartObjectResource.start();
        logger.info("Coap Server Started ! Available resources: ");
        alarmSmartObjectResource.getRoot().getChildren().stream().forEach(resource -> {
            logger.info("Resource {} -> URI: {} (Observable: {})", resource.getName(), resource.getURI(), resource.isObservable());
            if(!resource.getURI().equals("/.well-known")){
                resource.getChildren().stream().forEach(childResource -> {
                    logger.info("\t Resource {} -> URI: {} (Observable: {})", childResource.getName(), childResource.getURI(), childResource.isObservable());
                });
            }
        });

        LightSmartObjectResource lightSmartObjectResource = new LightSmartObjectResource("smartDeviceLight-001", "001", 5684);
        logger.info("Starting Coap Server...");
        lightSmartObjectResource.start();
        logger.info("Coap Server Started ! Available resources: ");
        lightSmartObjectResource.getRoot().getChildren().stream().forEach(resource -> {
            logger.info("Resource {} -> URI: {} (Observable: {})", resource.getName(), resource.getURI(), resource.isObservable());
        });

    }
}
