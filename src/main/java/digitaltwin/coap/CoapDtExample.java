package digitaltwin.coap;

import it.unimore.dipi.iot.wldt.engine.WldtConfiguration;
import it.unimore.dipi.iot.wldt.engine.WldtEngine;
import it.unimore.dipi.iot.wldt.exception.WldtConfigurationException;
import it.unimore.dipi.iot.wldt.process.WldtCoapProcess;
import it.unimore.dipi.iot.wldt.worker.coap.Coap2CoapConfiguration;
import it.unimore.dipi.iot.wldt.worker.coap.Coap2CoapWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CoapDtExample {

    private static final String TAG = "[WLDT-Process]";

    private static final Logger logger = LoggerFactory.getLogger(WldtCoapProcess.class);

    private int port = 0;

    public CoapDtExample(int port) {
        this.port = port;
    }

    public void run(){
        try{

            logger.info("{} Initializing WLDT-Engine ... ", TAG);

            //Manual creation of the WldtConfiguration
            WldtConfiguration wldtConfiguration = new WldtConfiguration();
            wldtConfiguration.setDeviceNameSpace("it.unimore.dipi.things");
            wldtConfiguration.setWldtBaseIdentifier("wldt");
            wldtConfiguration.setWldtStartupTimeSeconds(10);
            wldtConfiguration.setApplicationMetricsEnabled(false);

            WldtEngine wldtEngine = new WldtEngine(wldtConfiguration);
            wldtEngine.addNewWorker(new Coap2CoapWorker(getCoapProtocolConfiguration(port)));
            wldtEngine.startWorkers();

        }catch (Exception | WldtConfigurationException e){
            e.printStackTrace();
        }

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

            WldtEngine wldtEngine = new WldtEngine(wldtConfiguration);
            wldtEngine.addNewWorker(new Coap2CoapWorker(getCoapProtocolConfiguration()));
            wldtEngine.startWorkers();

        }catch (Exception | WldtConfigurationException e){
            e.printStackTrace();
        }
    }*/

    /**
     * Example of the CoAP-to-CoAP Worker Configuration
     * @return
     */

    private Coap2CoapConfiguration getCoapProtocolConfiguration(int port){

        Coap2CoapConfiguration coap2CoapConfiguration = new Coap2CoapConfiguration();
        coap2CoapConfiguration.setResourceDiscovery(true);
        coap2CoapConfiguration.setDeviceAddress("127.0.0.1");
        coap2CoapConfiguration.setDevicePort(port);

        return coap2CoapConfiguration;
    }

}
