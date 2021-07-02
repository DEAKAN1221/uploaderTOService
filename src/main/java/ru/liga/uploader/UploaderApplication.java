package ru.liga.uploader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rgu.artifacts.x.ps_passport_light_commons._1_0.PsPassportType;
import rgu.artifacts.x.ps_passport_package_light._1_0.GetPsPassportsPackageResponse;
import ru.liga.uploader.entity.FRGUService;
import ru.liga.uploader.repository.FRGUServiceDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class UploaderApplication implements CommandLineRunner {


    @Autowired
    private FRGUServiceDao frguServiceDao;

    @PersistenceContext
    private EntityManager entityManager;


    public static void main(String[] args) {
        SpringApplication.run(UploaderApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        fileConvert();
        log.info("DOWNLOAD IS DONE");


    }


    public void fileConvert() throws IOException {
        File baseDir = new File("/home/rataullin/content/");
        List<File> lst = Arrays.asList(baseDir.listFiles());
        for (File file : lst) {
            String dataString = readFile(file.getAbsolutePath(), StandardCharsets.UTF_8);
            GetPsPassportsPackageResponse response = MarshallUtil.unmarshalElement(dataString, GetPsPassportsPackageResponse.class);
            save(file, response);

        }
        System.out.println("That's all");
        System.out.println();
    }

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Transactional
    public void save(File file, GetPsPassportsPackageResponse response) {
        List<FRGUService> frguServiceList = new ArrayList<>();
        for (PsPassportType res : response.getPsPassportsPackage().getPsPassport()) {
            FRGUService frguService = new FRGUService();
            frguService.setCurrentSsn(response.getCurrentSsn());
            frguService.setPsPassportId(res.getId());
            frguService.setSsn(res.getSsn());
            frguService.setFullTitle(res.getFullTitle());
            frguService.setOrganizationId(res.getResponsibleRGUStateStructure() != null ? res.getResponsibleRGUStateStructure().getFullName() : null);
            frguService.setFunction(res.isIsFunction());
            frguService.setCreationDate(DateTimeHelper.ofLocalDate(res.getCreateDate()));
            frguService.setStartPublishedDate(DateTimeHelper.ofLocalDate(res.getStartPublishDate()));
            frguService.setAdministrativeLevel(res.getAdministrativeLevel() != null ? res.getAdministrativeLevel().getValue() : null);
            frguService.setFileName(file.getName());
            frguServiceList.add(frguService);
        }
        frguServiceDao.saveAll(frguServiceList);
    }

}


