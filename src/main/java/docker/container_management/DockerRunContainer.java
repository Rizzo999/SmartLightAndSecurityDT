package docker.container_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.PortBinding;
import docker.utils.DockerConf;

public class DockerRunContainer {

    public static void main (String args[]) {

        // for default config
        //DockerClientConfig standard = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        DockerClient dockerClient = DockerConf.conf();



        //Create a container
        CreateContainerResponse container
                = dockerClient.createContainerCmd("eclipse-mosquitto:latest")
                .withName("broker1")
                //.withEnv()
                .withPortBindings(PortBinding.parse("1883:1883"))  //see setHostCofig()
                //.withBinds(Bind.parse("/home/andrea/Desktop/SmartLightAndSecurityDT/mosquitto-data/broker-test:/mosquitto/data"))  //for bind volume, but deprecated
                .exec();

        //TODO: replace deprecated methods

        //Start the container
        dockerClient.startContainerCmd(container.getId()).exec();

        //Stop or kill the container
        //dockerClient.stopContainerCmd(container.getId()).exec();
        //dockerClient.killContainerCmd(container.getId()).exec();


    }
}
