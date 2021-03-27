# SmartLightAndSecurityDT
Some demo using wldt library

The project contains two demo, the first for coap smart objects and the second for mqqt smart objects. 

You can run the first demo (coap) in theese steps: 
  1. run class AlarmAndLightSmartObjectProcess under package smartobject.process
  2. run class CoapDtExampleProcess under package digitaltwin.coap
  3. you can check if the mirroring operation was complited by verifying with a "coap-get" on coap://127.0.0.1:5783/alarm001 if the resource is present; coap-get
    is avaiable in class oapGetClientProcess under package consumer.coap
 
 You can run the second demo (mqtt) in theese steps:
  1. you need start the two mosquitto's brokers using the .yaml file with this command --> "docker-compose -f ./docker-compose.yaml up" (ps: you must be the              administrator to run docker commands, so docker-compose command too)
  2. run class PresenceMonitoringSmartObjectProcess under package smartobject.process, you can check if the client is right publishing the data looking logs on the      console
  3. run class MqttDigitalTwinProcess under package digitaltwin.mqtt, you can check if the dt is right receveing data from the physical object looking logs on the        console
  4. run class SimpleMqttTestConsumer under package consumer.mqtt, this test-class subscribes to the dt topics and we can check if it's right receiving data              from the dt. 
