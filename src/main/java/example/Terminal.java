package example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Terminal {
    public static void main(String[] args)
            throws IOException, InterruptedException {
        String userId = "3";
        String containerId;
        String projectName = "myProject";
        String containerName = "con101";
        String bindPort = "10002:10002";
        String dockerPath = "C:\\Program Files\\Docker\\Docker\\Resources\\bin\\docker.exe";
        String dockerImage = "ubuntu";
        String dockerVolumeForWindow = "/c/Users/SUNGON LEE/docker/" + userId + projectName + ":/home";
//        String dockerVolume = "C:\\Users\\SUNGON LEE\\docker" + userId + projectName + ":/home";

        // unix 에 맞게 변경 필요
        boolean success = new File("C:/Users/SUNGON LEE/docker/" + userId + projectName).mkdir();
        if (success) {
            System.out.println("mkdir success");
//            String command2 = dockerPath + " run " + " -it " + " -d " +
//                    " --name " + containerName +
//                    " -v " + dockerVolumeForWindow +
//                    " -p " + bindPort +
//                    " " + dockerImage;
            String[] command = new String[]{dockerPath,
                    "run", "-it", "-d",
                    "--name", containerName,
                    "-v", dockerVolumeForWindow,
                    "-p", bindPort,
                    dockerImage};
            Terminal runner = new Terminal();
//            runner.byProcessBuilder(command);
            runner.byProcessBuilder(new String[]{dockerPath, "ps"});
        } else {
            System.out.println("mkdir failed");
        }
//        builder.redirectErrorStream(true);
//        Process p = builder.start();
//        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String line;
//        while (true) {
//            line = r.readLine();
//            if (line == null) { break; }
//            System.out.println(line);
//        }
    }

    public void byRuntime(String[] command)
            throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        printStream(process);
    }

    public void byProcessBuilder(String[] command)
            throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        printStream(process);
    }

    private void printStream(Process process)
            throws IOException, InterruptedException {
        process.waitFor();
        try (InputStream psout = process.getInputStream()) {
            copy(psout, System.out);
        }
    }

    public void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        int n = 0;
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
    }
}