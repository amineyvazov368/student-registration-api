🎓 Student Registration API

Bu layihə tələbə qeydiyyatı və imtahan seçimi prosesini idarə edən Spring Boot REST API sistemidir. Sistem tələbələrin birinci mərhələdən keçənlərini ikinci mərhələyə avtomatik keçirməyə, məlumatları PostgreSQL verilənlər bazasında saxlamağa və QR Code yaradaraq qeydiyyat linkini idarə etməyə imkan verir.

🚀 Texnologiyalar
Java 21
Spring Boot
Spring Data JPA
PostgreSQL (Aiven Cloud DB)
Hibernate
Maven
Lombok
QR Code Generator (ZXing və ya oxşar library)
📌 Funksionallıqlar
👨‍🎓 Tələbə qeydiyyatı
🧪 İmtahan mərhələlərinin idarə olunması
✅ Seçilmiş tələbələrin ikinci mərhələyə keçidi
🔗 QR Code yaradılması və URL saxlanması (second_exam_qr_url)
🗄️ PostgreSQL database inteqrasiyası (cloud Aiven)
📊 RESTful API endpoint-lər
⚙️ Service-based architecture (Controller → Service → Repository)
🧠 Sistem Məntiqi
Tələbələr ilk imtahana qeydiyyatdan keçirlər
Sistem nəticələrə görə top 10 və ya seçilmişləri filter edir
Seçilmiş tələbələr ikinci mərhələyə keçirilir
Hər tələbə üçün unikal QR Code URL yaradılır
URL database-də second_exam_qr_url sahəsində saxlanılır
📂 Layihə Strukturu
student-registration-api
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── config
 ├── util (QR generator və s.)
 └── StudentRegistrationApiApplication.java
🔌 API Nümunələri
📍 Tələbə yaratmaq
POST /api/students
📍 Tələbələri listləmək
GET /api/students
📍 Seçilmişləri ikinci mərhələyə keçirmək
POST /api/students/second-stage
🗄️ Database Konfiqurasiyası
spring:
  datasource:
    url: jdbc:postgresql://<host>:<port>/<db>
    username: <username>
    password: <password>
📸 QR Code Məntiqi

System hər seçilmiş tələbə üçün avtomatik QR code yaradır və:

URL generator service vasitəsilə link formalaşdırır
second_exam_qr_url column-da saxlayır
▶️ Layihəni işə salmaq
git clone https://github.com/amineyvazov368/student-registration-api
cd student-registration-api
mvn clean install
mvn spring-boot:run
📈 Gələcək Planlar
JWT Authentication əlavə etmək
Admin panel (React)
Email notification sistemi
Swagger API documentation
Docker support
👨‍💻 Müəllif

Amin Eyvazov
GitHub: amineyvazov368

⭐ Əgər bəyəndinsə

Repo-ya star verməyi unutma ⭐
