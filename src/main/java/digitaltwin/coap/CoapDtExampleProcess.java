package digitaltwin.coap;

public class CoapDtExampleProcess {

    public static void main(String args[]) {

        CoapDtExample coapDtAlarm = new CoapDtExample(5683);
        coapDtAlarm.run();
        /*CoapDtExample coapDtLight = new CoapDtExample(5684);
        coapDtLight.run();*/

    }

}
