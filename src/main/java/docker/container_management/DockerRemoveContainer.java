package docker.container_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import docker.utils.DockerConf;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DockerRemoveContainer {

    public static void main(String args[]) {

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
        System.out.print("Enter container id that you want remove: ");
        containerId = scanner.nextLine();

        dockerClient.removeContainerCmd(containerId).exec();

    }

}
