package docker.image_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageResultCallback;
import docker.utils.DockerConf;

import java.util.concurrent.TimeUnit;

public class DockerPullImage {

    public static void main(String args[]) throws InterruptedException {

        DockerClient dockerClient = DockerConf.conf();

        //Before this, verify that you have entered the password in DockerConf class
        dockerClient.pullImageCmd("eclipse-mosquitto")
                .withTag("1.6.14")
                .exec(new PullImageResultCallback())
                .awaitCompletion(30, TimeUnit.SECONDS);

    }

}
