# 📌 Quản lý Tình nguyện viên Chiến dịch Tình nguyện – Spring Core + Spring Data JPA

## 🚀 Mục tiêu

Xây dựng project Java không dùng Spring Boot, sử dụng **Spring Core + Spring Data JPA** để thực hiện CRUD cho các thực thể và quan hệ thực tế. Đề tài tập trung vào mô hình **quản lý tình nguyện viên** trong các chiến dịch hoạt động xã hội.

---

## ✅ Kỹ thuật yêu cầu

- Không sử dụng Spring Boot
- Sử dụng Spring Core + Spring Data JPA
- Java Config (không dùng XML)
- Tối thiểu 1 model (ở đây có đến 5)
- Tối thiểu 4 method CRUD
- Sử dụng annotation để config Entity
- Chạy với `AnnotationConfigApplicationContext`

---

## 🧱 Các Entity chính

### 1. `Volunteer`

- `id: Long`
- `fullName: String`
- `email: String`
- `phone: String`
- `joinedDate: Date`
- Quan hệ:
  - Many-to-Many với `Skill`
  - One-to-Many với `ParticipationLog`

---

### 2. `Campaign`

- `id: Long`
- `name: String`
- `startDate: Date`
- `endDate: Date`
- `location: String`
- Quan hệ:
  - One-to-Many với `ParticipationLog`

---

### 3. `Skill`

- `id: Long`
- `name: String` _(ví dụ: Chụp ảnh, MC, Hậu cần...)_
- Quan hệ:
  - Many-to-Many với `Volunteer`

---

### 4. `ParticipationLog` (Bảng trung gian mở rộng Volunteer – Campaign)

- `id: Long`
- `volunteer: Volunteer`
- `campaign: Campaign`
- `role: String` _(Leader, Member, Hỗ trợ hậu cần...)_
- `joinedDate: Date`
- `daysParticipated: Integer`

---

### 5. `SkillLevel` (Quan hệ mở rộng giữa Volunteer – Skill)

- `id: Long`
- `volunteer: Volunteer`
- `skill: Skill`
- `level: Enum (BEGINNER, INTERMEDIATE, ADVANCED)`

---

## 🔗 Quan hệ giữa các bảng

- `Volunteer` ⬌ `Campaign` thông qua `ParticipationLog` (`@OneToMany`)
- `Volunteer` ⬌ `Skill` thông qua `SkillLevel` (`@OneToMany`)
- Mọi quan hệ đều sử dụng `@JoinColumn`, `@ManyToOne`, `@OneToMany` rõ ràng (tránh dùng quan hệ N-N thuần)

---

## 📚 Các chức năng chính (CRUD + nâng cao)

| Chức năng                                         | Mô tả                                  |
| ------------------------------------------------- | -------------------------------------- |
| Thêm / Xem / Sửa / Xóa `Volunteer`                | Basic CRUD                             |
| Thêm / Xem / Sửa / Xóa `Campaign`                 | Basic CRUD                             |
| Thêm / Xem / Sửa / Xóa `Skill`                    | Basic CRUD                             |
| Thêm log tham gia Campaign (`ParticipationLog`)   | Ghi nhận vai trò + thời gian           |
| Gán kỹ năng và level cho Volunteer (`SkillLevel`) | Mỗi Volunteer có nhiều skill với level |
| Tìm volunteer theo kỹ năng cụ thể                 | Sử dụng query                          |
| Tìm volunteer đang tham gia campaign đang diễn ra | Dựa vào ngày bắt đầu/kết thúc          |

---

## 🧠 Kỹ thuật nâng cao (sẽ được áp dụng dần)

| Kỹ thuật                             | Ứng dụng                                |
| ------------------------------------ | --------------------------------------- |
| `@ManyToOne`, `@OneToMany`           | Các mối quan hệ chính                   |
| `@JoinColumn`, `@MappedBy`           | Điều hướng quan hệ                      |
| `@Enumerated(EnumType.STRING)`       | Lưu enum level kỹ năng                  |
| `@PrePersist`, `@PreUpdate`          | Auditing đơn giản                       |
| Java Config                          | Config DataSource, EntityManagerFactory |
| `AnnotationConfigApplicationContext` | Chạy chương trình                       |
| `@Query` với JPQL                    | Tìm kiếm nâng cao                       |
| Pagination & Sorting                 | (Có thể thêm sau)                       |

---

## 📁 Cấu trúc thư mục gợi ý

```plaintext
src/
└── main/
    ├── java/
    │   └── com/
    │       └── example/
    │           └── volunteer/
    │               ├── config/               <-- JavaConfig
    │               ├── entity/               <-- Volunteer, Campaign, Skill, ParticipationLog, SkillLevel
    │               ├── repository/           <-- Interface JpaRepository
    │               ├── service/              <-- (Tùy chọn nếu bạn tách logic xử lý)
    │               └── MainApp.java          <-- Chạy ứng dụng
    └── resources/
```

---
