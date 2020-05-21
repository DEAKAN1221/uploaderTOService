package ru.liga.uploader;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.liga.uploader.entity.TemplateEntity;
import ru.liga.uploader.entity.WeaponEntity;
import ru.liga.uploader.repository.OrganizationMappingRepository;
import ru.liga.uploader.repository.TemplateRepository;
import ru.liga.uploader.repository.WeponRepository;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class UploaderApplication implements CommandLineRunner {


    @Autowired
    private  WeponRepository weponRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private OrganizationMappingRepository organizationMappingRepository;

    private int countWeapon = 0;

    public static void main(String[] args) {
        SpringApplication.run(UploaderApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        fileConvert();
        log.info("Total count is Weapons " + countWeapon);
        log.info("DOWNLOAD IS DONE");


    }


    private void fileConvert() {
//        File baseDir = new File(new File(".").getAbsolutePath());
        File baseDir = new File("/home/rataullin/Documents/migdemo/");

        File[] arrFiles = baseDir.listFiles((dir, name) ->
                new File(dir.getPath() + "/" + name).isDirectory() || name.endsWith(".xlsx"));

        baseDir.getName();

        try {
            for (File item : arrFiles) {
                if (item.isDirectory()) {
                    File[] subFiles = item.listFiles((dir, name) -> name.endsWith(".xlsx"));

                    for (File subItem : subFiles) {
                        setData(subItem);
                    }

                } else {
                    setData(item);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setData(File file) throws IOException {
        Long oldOrganizationId = Long.parseLong(file.getName().replace(".xlsx", ""));
        Long organizationId = organizationMappingRepository.findByOldOrganizationId(oldOrganizationId).getOrganizationId();
        log.info("start upload to " + oldOrganizationId);
        List<WeaponEntity> weaponEntities = new ArrayList<>();
        List<TemplateEntity> templateEntities = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        DataFormatter formatter = new DataFormatter();


        try {
            Workbook myXlsBook = new XSSFWorkbook(file.getPath());
            Sheet myExcelSheet;
            for (int i = 0; i < 2; i++) {
                switch (i) {
                    case (0):
                        myExcelSheet = myXlsBook.getSheetAt(i);
                        for (int j = 1; j < myExcelSheet.getLastRowNum() + 1; j++) {
                            Row row;
                            TemplateEntity templateEntity = new TemplateEntity();
                            row = myExcelSheet.getRow(j);
                            templateEntity.setShortName(row.getCell(1) != null
                                    && !row.getCell(1).getStringCellValue().isEmpty()
                                    ? row.getCell(1).getStringCellValue().toUpperCase() : null);
                            templateEntity.setCount(row.getCell(3) != null
                                    ? Long.valueOf(formatter.formatCellValue(row.getCell(3))) : 0);
                            templateEntity.setOrganizationId(organizationId);
                            templateEntities.add(templateEntity);
                        }
                        break;

                    case (1):
                        myExcelSheet = myXlsBook.getSheetAt(i);


                        for (int k = 1; k < myExcelSheet.getLastRowNum() + 1; k++) {
                            Row row;
                            WeaponEntity weaponEntity = new WeaponEntity();
                            row = myExcelSheet.getRow(k);
                            weaponEntity.setWeaponsName(row.getCell(0) != null
                                    && !formatter.formatCellValue(row.getCell(0)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(0)).toUpperCase() : null);
                            weaponEntity.setSeries(row.getCell(1) != null
                                    && !formatter.formatCellValue(row.getCell(1)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(1)) : null);
                            weaponEntity.setWeaponNumber(row.getCell(2) != null
                                    && !formatter.formatCellValue(row.getCell(2)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(2)) : null);
                            weaponEntity.setMakeYear(row.getCell(3) != null
                                    && !formatter.formatCellValue(row.getCell(3)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(3)) : null);
                            weaponEntity.setCategory(row.getCell(4) != null
                                    && !formatter.formatCellValue(row.getCell(4)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(4)) : null);
                            weaponEntity.setStoragePlace(row.getCell(5) != null
                                    && !formatter.formatCellValue(row.getCell(5)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(5)) : null);
                            weaponEntity.setOrganizationName(row.getCell(6) != null
                                    && !formatter.formatCellValue(row.getCell(6)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(6)) : null);
                            weaponEntity.setOwnerRank(row.getCell(7) != null
                                    && !formatter.formatCellValue(row.getCell(7)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(7)) : null);
                            weaponEntity.setOwnerName(row.getCell(8) != null
                                    && !formatter.formatCellValue(row.getCell(8)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(8)) : null);
                            weaponEntity.setSafe(row.getCell(9) != null
                                    && !formatter.formatCellValue(row.getCell(9)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(9)) : null);
                            weaponEntity.setCell(row.getCell(10) != null
                                    && !formatter.formatCellValue(row.getCell(10)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(10)) : null);
                            weaponEntity.setNote(row.getCell(11) != null
                                    && !formatter.formatCellValue(row.getCell(11)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(11)) : null);
                            weaponEntity.setReceiptCategory("OTHER");
                            weaponEntity.setSenderOrganization(row.getCell(13) != null
                                    && !formatter.formatCellValue(row.getCell(13)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(13)) : "Склад");
                            weaponEntity.setDocumentKind(row.getCell(14) != null
                                    && !formatter.formatCellValue(row.getCell(14)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(14)) : "Другое");
                            weaponEntity.setDocumentNumber(row.getCell(15) != null
                                    && !formatter.formatCellValue(row.getCell(15)).isEmpty()
                                    ? formatter.formatCellValue(row.getCell(15)) : "б/н");
                            weaponEntity.setDocumentDate(row.getCell(16) != null
                                    && !formatter.formatCellValue(row.getCell(16)).trim().isEmpty() ?
                            sdf.format(row.getCell(16).getDateCellValue()) : "01.01.1900");
                            weaponEntity.setKoActNumber(row.getCell(17) != null
                                    && !row.getCell(17).getStringCellValue().isEmpty()
                                    ? row.getCell(17).getStringCellValue() : null);
                            weaponEntity.setOrganizationId(organizationId);
                            weaponEntity.setSectionType("SERVICE");
                            countWeapon +=1;
                            weaponEntities.add(weaponEntity);
                        }
                        break;
                }
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        log.info(String.valueOf(templateEntities.size()) + " Organization " + oldOrganizationId);
        templateRepository.saveAll(templateEntities);
        log.info("complete " + "template sheet to " + oldOrganizationId);
        log.info(String.valueOf(weaponEntities.size()) + " Organization " + oldOrganizationId);
        weponRepository.saveAll(weaponEntities);
        log.info("complete " + "weapons sheet to " + oldOrganizationId);

    }

}
