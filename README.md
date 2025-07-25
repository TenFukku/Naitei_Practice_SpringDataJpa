# 📌 Quản lý Tình nguyện viên Chiến dịch Tình nguyện – Spring Core + Spring Data JPA

## 🎯 **Tổng quan dự án**

- **Framework:** Spring Core + Spring Data JPA (không dùng Spring Boot)
- **Mục tiêu:** Xây dựng hệ thống quản lý tình nguyện viên với các chức năng CRUD, báo cáo, thống kê
- **Ngày thực hiện:** Hôm nay

---

## ✅ **Những gì đã hoàn thành hôm nay**

### **🛠️ Cấu hình (Configuration Layer)**

- Đã tạo các file cấu hình Java thuần:
  - `DatabaseConfig.java`: Cấu hình H2 Database (in-memory, tự động tạo/xóa bảng khi chạy)
  - `JpaConfig.java`: Cấu hình EntityManagerFactory, TransactionManager, bật show SQL
  - `AppConfig.java`: Quản lý bean, component scan, enable JPA repositories
- Đã sử dụng H2 Database để thuận tiện phát triển, không cần cài đặt ngoài

### **💻 MainApp (Console Application)**

- Đã xây dựng ứng dụng console menu-driven, giao diện tiếng Việt thân thiện
- Sử dụng `AnnotationConfigApplicationContext` để khởi tạo Spring context
- Kết nối đầy đủ Service/Repository/Entity

#### **Chức năng chính của MainApp:**

- **Quản lý Tình nguyện viên:**
  - Thêm, xem, tìm kiếm, xóa tình nguyện viên
  - Gán kỹ năng và mức độ cho từng tình nguyện viên
  - Xem kỹ năng của từng tình nguyện viên
- **Quản lý Chiến dịch:**
  - Thêm, xem, tìm kiếm, xóa chiến dịch
  - Thêm tình nguyện viên vào chiến dịch với vai trò cụ thể
  - Xem danh sách tham gia, thống kê số lượng
- **Quản lý Kỹ năng:**
  - Thêm, xem, tìm kiếm, xóa kỹ năng
  - Xem danh sách tình nguyện viên có kỹ năng hoặc kỹ năng cao cấp
- **Báo cáo & Thống kê:**
  - Thống kê tổng số tình nguyện viên, chiến dịch, kỹ năng
  - Thống kê tình nguyện viên đang hoạt động, chiến dịch đang diễn ra
  - Thống kê số người có kỹ năng cao cấp theo từng kỹ năng

#### **Cách sử dụng MainApp:**

1. **Build project:**
   - Sử dụng Maven: `mvn clean package`
2. **Chạy ứng dụng:**
   - Chạy class `org.example.MainApp` (có thể chạy từ IDE hoặc dòng lệnh)
3. **Sử dụng menu:**
   - Chọn các chức năng bằng số tương ứng
   - Nhập thông tin theo hướng dẫn trên màn hình
   - Dữ liệu sẽ được lưu tạm thời trong H2 (in-memory), sẽ mất khi tắt ứng dụng

---

## 📦 **Công nghệ & Dependency chính**

- Spring Core, Spring Context, Spring ORM
- Spring Data JPA
- Hibernate
- H2 Database (in-memory)
- Maven

---

## 🎯 **Kết luận**

- Đã hoàn thiện toàn bộ cấu hình, kết nối database, và xây dựng ứng dụng console hoàn chỉnh
- Đã kiểm thử các chức năng CRUD, báo cáo, thống kê
- Dự án tuân thủ đúng yêu cầu: **Spring Core + Spring Data JPA, không dùng Spring Boot**

---

**Sẵn sàng cho các bước phát triển tiếp theo hoặc triển khai thực tế!**
