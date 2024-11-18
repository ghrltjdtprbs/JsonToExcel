package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonToExcel_school {

    public static void main(String[] args) {
        // JSON 파일 경로
        String jsonFilePath = "/DataToExcel/src/main/java/org/example/school.json";

        try {
            // JSON 데이터 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            // Apache POI로 엑셀 파일 생성
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Schools");

            // 헤더 작성
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("학교명");
            headerRow.createCell(2).setCellValue("학교종류");
            headerRow.createCell(3).setCellValue("학교유형");
            headerRow.createCell(4).setCellValue("설립");
            headerRow.createCell(5).setCellValue("지역");
            headerRow.createCell(6).setCellValue("주소");
            headerRow.createCell(7).setCellValue("홈페이지 링크");

            // 데이터 추가
            int rowIndex = 1;
            for (JsonNode node : rootNode) {
                String schoolName = node.get("schoolName").asText();
                String campusName = node.get("campusName").asText();
                String schoolType = node.get("schoolGubun").asText();
                String schoolGubun = node.get("schoolType").asText();
                String estType = node.get("estType").asText();
                String region = node.get("region").asText();
                String adres = node.get("adres").asText();
                String link = node.get("link").asText();

                String combinedName = schoolName + " (" + campusName + ")";

                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(combinedName);
                row.createCell(1).setCellValue(schoolGubun);
                row.createCell(2).setCellValue(schoolType);
                row.createCell(3).setCellValue(estType);
                row.createCell(4).setCellValue(region);
                row.createCell(5).setCellValue(adres);
                row.createCell(6).setCellValue(link);
            }

            // 파일 저장
            String filePath = "schools.xlsx";
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            workbook.close();
            System.out.println("엑셀 파일이 생성되었습니다: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
