package docker.image_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import docker.utils.DockerConf;

import java.io.File;

public class DockerBuild {

    public static void main(String args[]){

        DockerClient dockerClient = DockerConf.conf();

        String imageId = dockerClient.buildImageCmd()
                .withDockerfile(new File("/home/andrea/Desktop/SmartLightAndSecurityDT/Dockerfile"))
                .withPull(true)
                //.withNoCache(true)
                .withTag("alpine:git")
                .exec(new BuildImageResultCallback())
                .awaitImageId();

    }
}
