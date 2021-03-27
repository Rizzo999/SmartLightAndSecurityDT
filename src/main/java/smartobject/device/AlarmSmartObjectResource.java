package smartobject.device;

import smartobject.resource.coap.AlarmActuatorResource;
import org.eclipse.californium.core.CoapServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlarmSmartObjectResource extends CoapServer {

    private final static Logger logger = LoggerFactory.getLogger(AlarmSmartObjectResource.class);

    private String deviceId;
    private String piano;

    public AlarmSmartObjectResource(String deviceId, String piano, int port){  //in case we want create more objects in the same class

        super(/*5683*/ port) ;

        this.deviceId = String.format("dipi:iot:%s", deviceId);
        this.piano = piano;

        //Create Resources
        AlarmActuatorResource alarmActuatorResourceMain = new AlarmActuatorResource(deviceId,"alarm001");
        AlarmActuatorResource alarmActuatorResourceKitchen = new AlarmActuatorResource(deviceId,"alarm002");
        AlarmActuatorResource alarmActuatorResourceBedroom = new AlarmActuatorResource(deviceId,"alarm003");
        AlarmActuatorResource alarmActuatorResourceBathroom = new AlarmActuatorResource(deviceId,"alarm004");

        logger.info("Defining and adding resources ...");

        //Add resources to the sd
        this.add(alarmActuatorResourceMain);
        this.add(alarmActuatorResourceKitchen);
        this.add(alarmActuatorResourceBedroom);
        this.add(alarmActuatorResourceBathroom);

    }

    /*public static void main (String args[]){
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

    }*/

}
