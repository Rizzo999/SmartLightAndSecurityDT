package docker.container_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import docker.utils.DockerConf;

import java.util.Scanner;
import java.util.Iterator;
import java.util.List;

/*
  With this class we can stop a container
  First of all take a look about all running containers (1st output)
  Then copy and paste the id of the container that you want stop and press enter
 */

public class DockerStopContainer {

    public static void main (String args[]){

        String containerId = null;

        DockerClient dockerClient = DockerConf.conf();

        List<Container> containers = dockerClient.listContainersCmd()
                .withShowSize(true)
                .withShowAll(true)
                .exec();

        Iterator it = containers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter container id that you want stop: ");
        containerId = scanner.nextLine();

        //Stop or kill the container
        dockerClient.stopContainerCmd(containerId).exec();
        //dockerClient.killContainerCmd(container.getId()).exec();


    }
}

