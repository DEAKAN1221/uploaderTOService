package ru.liga.uploader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.liga.uploader.entity.Event;
import ru.liga.uploader.entity.EventFile;
import ru.liga.uploader.repository.EventDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@SpringBootApplication
@Slf4j
public class UploaderApplication implements CommandLineRunner {


    @Autowired
    private EventDao eventDao;


    public static void main(String[] args) {
        SpringApplication.run(UploaderApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        getPathFiles();
        log.info("DOWNLOAD IS DONE");


    }


    private void getPathFiles() throws IOException {
        List<Event> eventList = eventDao.findAllByParams();
        List<String> fileNameList = eventList.stream()
                .flatMap(event -> event.getFiles().stream())
                .map(EventFile::getFileName)
                .filter(fileName -> fileName.endsWith("response.content.xml")).collect(Collectors.toList());

        FileOutputStream fos = new FileOutputStream("multiCompressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : fileNameList) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

}
