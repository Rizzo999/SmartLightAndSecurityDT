package docker.image_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import docker.utils.DockerConf;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DockerRemoveImage {

    public static void main(String args[]) {

        String imageId;

        DockerClient dockerClient = DockerConf.conf();

        List<Image> images = dockerClient.listImagesCmd()
                .withShowAll(true).exec();

        Iterator it = images.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //Search the id of the image that you want remove, the copy-paste and press enter

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter image id that you want remove: ");
        imageId = scanner.nextLine();


        dockerClient.removeImageCmd(imageId).exec();

    }
}
