package docker.image_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import docker.utils.DockerConf;

import java.util.Iterator;
import java.util.List;

public class DockerListImages {

    public static void main (String args[]){

        DockerClient dockerClient = DockerConf.conf();

        //List<Image> images = dockerClient.listImagesCmd().exec();
        List<Image> images = dockerClient.listImagesCmd()
                .withShowAll(true).exec();

        //To list images, but only the repository, the tag, the id and the size
        Iterator it = images.iterator();
        while (it.hasNext()) {
            Image image = (Image)it.next();
            System.out.println("REPOSITORY: " + image.getRepoTags()[0] + " IMAGE-ID: " + image.getId() + "  IMAGE-SIZE: " + image.getSize()/1000000 /*Mbyte*/);
        }

        //To list all images
        /*Iterator it = images.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/



    }
}
