# JsonToExcel

JsonToExcel은 JSON 데이터를 읽어 Excel 파일(`.xlsx`)로 변환하는 Java 프로그램입니다. JSON 데이터를 가공하여 다양한 형태로 저장하고 활용할 수 있도록 돕습니다.

## 🚀 주요 기능
- JSON 파일에서 데이터를 읽어옵니다.
- JSON 데이터 중 원하는 값을 Excel 형식으로 저장합니다.
- 결과 Excel 파일은 프로그램 루트 디렉터리에 생성됩니다.

## 🛠️ 사용법

1. **JSON 파일 준비**
   - JSON 데이터를 `.json` 파일로 저장합니다.
   - 예제 파일 (`school.json`) 내용
     ```json
     [
       {
         "campusName": "제1캠퍼스",
         "schoolName": "한영대학교"
       },
       {
         "campusName": "제1캠퍼스",
         "schoolName": "협성대학교"
       }
     ]
     ```

3. **프로그램 실행**
   - `JsonToExcel` 클래스를 실행합니다.
   - 프로그램이 실행되면 지정한 JSON 파일에서 데이터를 읽고, `.xlsx` 파일이 생성됩니다.

4. **출력 결과 확인**

   - 생성된 `.xlsx` 파일에서 데이터가 올바르게 저장되었는지 확인합니다.
   - 생성위치 : 프로젝트 루트 디렉터리

---
## 📂 결과 파일 및 실행 화면
### JSON 입력 파일
<img width="1223" alt="스크린샷 2024-11-18 오전 10 56 10" src="https://github.com/user-attachments/assets/2f62367f-8ac6-4f89-8baa-3c975b709202">

### 결과 Excel 파일
<img width="1428" alt="스크린샷 2024-11-18 오전 10 56 43" src="https://github.com/user-attachments/assets/0487af24-434a-4c4b-b8a7-83389853de9b">

---
## 📚 기술스택
- Java 21 
- Jackson
- Apache POI
- Gradle
