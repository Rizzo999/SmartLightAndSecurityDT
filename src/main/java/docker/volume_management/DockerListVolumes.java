package docker.volume_management;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectVolumeResponse;
import com.github.dockerjava.api.command.ListVolumesResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Volume;
import docker.utils.DockerConf;

import java.util.Iterator;
import java.util.List;

public class DockerListVolumes {

    public static void main (String args[]){

        DockerClient dockerClient = DockerConf.conf();

        ListVolumesResponse volumesResponse = dockerClient.listVolumesCmd().exec();
        List<InspectVolumeResponse> volumes = volumesResponse.getVolumes();

        Iterator it = volumes.iterator();
        while (it.hasNext()) {

            System.out.println(it.next());

        }

    }
}
