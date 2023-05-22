package classes.model.modelRequests;

import classes.database.dbservice.IDBservice;
import classes.database.entity.patient.EPatientCabs;
import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.patient.EPatientCovidProperties;
import classes.database.entity.patient.EPatientPage;
import classes.model.modelLogic.IModelLogic;
import classes.model.modelRequests.interfaces.IPatientsModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class PatientsModel implements IPatientsModel {
    @Inject
    IDBservice dbservice;
    @Inject
    IModelLogic modelLogic;

    public List<EPatientPage> getPatientList() throws Exception{
        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);

            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);

            ObjectMapper objectMapper = new ObjectMapper();
            List<EPatientPage> patientList = new ArrayList<>();

            EPatientPage ePatientPage = new EPatientPage();
            ePatientPage.contents.addAll(objectMapper.convertValue(decryptedPatientCovidList, List.class));
            ePatientPage.contents.addAll(objectMapper.convertValue(decryptedPatientCabsList, List.class));
            patientList.add(ePatientPage);


//            patientList.add(new EPatientPage());
//            for(int i = 0; i < decryptedPatientCovidList.size(); i++){
//                patientList.get(0).contents.add(objectMapper.convertValue(decryptedPatientCovidList.get(i), Map.class));
//                patientList.get(0).numberOfElements = i+1;
//            }
//            patientList.get(0).page = 1;



            // TODO Лучше возвращать List<Map<String, String>>. Ошибка каста в List<Map<String, String>>, посмотреть
            return patientList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }

    public EPatientCovid createPatientCovid(EPatientCovid ePatientCovid) throws Exception{
        try {
            // Получаем текущее время по МСК
            ZoneId moscowZone = ZoneId.of("Europe/Moscow");
            ZonedDateTime currentTime = ZonedDateTime.now(moscowZone);
            LocalTime currentLocalTime = currentTime.toLocalTime();

            // Закидываем текущее время в поле
            ePatientCovid.createdAt = currentLocalTime.toString();

            // Шифруем данные
            EPatientCovid encryptedPatientCovid = modelLogic.getEncryptedPatientCovid(ePatientCovid);

            // Добавляем шифрованные данные в БД
            boolean inserted = dbservice.insert(encryptedPatientCovid);

            if(inserted){
                ePatientCovid.description = "TODAY";
                return ePatientCovid;
            }
            throw new Exception("no instert");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("no insterted");
        }
    }

    public EPatientCabs createPatientCabs(EPatientCabs ePatientCabs) throws Exception{
        try {
            // Получаем текущее время по МСК
            ZoneId moscowZone = ZoneId.of("Europe/Moscow");
            ZonedDateTime currentTime = ZonedDateTime.now(moscowZone);
            LocalTime currentLocalTime = currentTime.toLocalTime();

            // Закидываем текущее время в поле
            ePatientCabs.createdAt = currentLocalTime.toString();

            // Шифруем данные
            EPatientCabs encryptedPatientCabs = modelLogic.getEncryptedPatientCabs(ePatientCabs);

            // Добавляем шифрованные данные в БД
            boolean inserted = dbservice.insert(encryptedPatientCabs);

            if(inserted){
                ePatientCabs.description = "TODAY";
                return ePatientCabs;
            }
            throw new Exception("no insterted");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("no instert");
        }
    }
    public Map<String, String> getOnePatient(String patientId) throws Exception{
        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);

            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);

            ObjectMapper objectMapper = new ObjectMapper();
            // TODO кастануть в одну мапу и пройтись одним циклом(сейчас два)
            for(EPatientCovid ePatientCovid : decryptedPatientCovidList){
                if (patientId.equals(ePatientCovid.id)){
                    return objectMapper.convertValue(ePatientCovid, Map.class);
                }
            }
            for(EPatientCabs ePatientCabs : decryptedPatientCabsList){
                if (patientId.equals(ePatientCabs.id)){
                    return objectMapper.convertValue(ePatientCabs, Map.class);
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }
    public boolean deleteOnePatient(String patientId) throws Exception{
        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);

            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);

            for(EPatientCovid ePatientCovid : decryptedPatientCovidList){
                if (patientId.equals(ePatientCovid.id)){
                    if(dbservice.delete("patientsCovid", patientId)) {
                        return true;
                    }
                }
            }
            for(EPatientCabs ePatientCabs : decryptedPatientCabsList){
                if (patientId.equals(ePatientCabs.id)){
                    if(dbservice.delete("patientsCabs", patientId)) {
                        return true;
                    }
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select or delete");
        }
    }
    public Map<String, String> updateOnePatient(String patientId, Map<String, String> newPatientData) throws Exception{
        try {
            // Достаём из БД данные ковида
            List<EPatientCovid> encryptedPatientCovidList = dbservice.selectPatientsCovid();
            // Расшифровка данных с БД ковида
            List<EPatientCovid> decryptedPatientCovidList = modelLogic.getDecryptedPatientCovidList(encryptedPatientCovidList);
            // Достаём из БД данные шунтирования
            List<EPatientCabs> encryptedPatientCabsList = dbservice.selectPatientsCabs();
            // Расшифровка данных с БД шунтирования
            List<EPatientCabs> decryptedPatientCabsList = modelLogic.getDecryptedPatientCabsList(encryptedPatientCabsList);

            // Ищем пациента по ид в списке ковид
            String entity = null;
            for(EPatientCovid ePatientCovid: decryptedPatientCovidList){
                if (patientId.equals(String.valueOf(ePatientCovid.id))) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    EPatientCovid newPatientCovid = objectMapper.convertValue(newPatientData, EPatientCovid.class);
                    // Шифровка новых данных для патча в БД
                    EPatientCovid newEncryptedPatientCovid = modelLogic.getEncryptedPatientCovid(newPatientCovid);
                    newEncryptedPatientCovid.id = patientId;
                    boolean updated = dbservice.updatePatientCovid(newEncryptedPatientCovid);
                    if (updated)
                        return newPatientData;
                    throw new Exception("not updated");
                }
            }
            for(EPatientCabs ePatientCabs: decryptedPatientCabsList){
                if (patientId.equals(String.valueOf(ePatientCabs.id))) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    EPatientCabs newPatientCabs = objectMapper.convertValue(newPatientData, EPatientCabs.class);
                    // Шифровка новых данных для патча в БД
                    EPatientCabs newEncryptedPatientCabs = modelLogic.getEncryptedPatientCabs(newPatientCabs);
                    newEncryptedPatientCabs.id = patientId;
                    boolean updated = dbservice.updatePatientCabs(newEncryptedPatientCabs);
                    if (updated)
                        return newPatientData;
                    throw new Exception("not updated");
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while update");
        }
    }
}
