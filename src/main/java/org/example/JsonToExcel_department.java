package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonToExcel_department {

    public static void main(String[] args) {
        // JSON 파일 경로
        String jsonFilePath = "/DataToExcel/src/main/java/org/example/department.json";

        try {
            // JSON 데이터 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath)); // 파일에서 JSON 읽기

            // Apache POI로 엑셀 파일 생성
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Schools");

            // 헤더 작성
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("학과명");
            headerRow.createCell(1).setCellValue("학과계열");
            headerRow.createCell(2).setCellValue("관련학과");

            // 데이터 추가
            int rowIndex = 1;
            for (JsonNode node : rootNode) {
                String mClass = node.get("mClass").asText();
                String lClass = node.get("lClass").asText();
                String facilName = node.get("facilName").asText();


                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(mClass);
                row.createCell(1).setCellValue(lClass);
                row.createCell(2).setCellValue(facilName);
            }

            // 파일 저장
            String filePath = "departments.xlsx";
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
