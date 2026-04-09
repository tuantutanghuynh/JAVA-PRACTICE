package hospitalsystem;

import java.util.Scanner;

/**
 * Điểm vào của chương trình Quản Lý Bệnh Viện.
 *
 * Menu-driven CLI theo đúng cấu trúc bài tập số 9:
 *   1. Thêm bệnh nhân
 *   2. Thêm bác sĩ
 *   3. Hiển thị tất cả
 *   4. Tìm theo ID
 *   5. Thuật toán: tìm BS giỏi nhất / đếm BN theo phòng
 *   6. LeetCode: kiểm tra trùng ID / tìm phòng thiếu
 *   7. Thoát
 *
 * Các kỹ thuật OOP sử dụng:
 *   - Interface (IHospitalPerson)
 *   - Abstract class (Person)
 *   - Kế thừa (Patient, Doctor extends Person)
 *   - Đa hình (Person[] chứa cả Patient và Doctor)
 *   - Mảng cố định (Person[] thay vì ArrayList)
 *
 * @author tangh
 */
public class HospitalSystem {

    public static void main(String[] args) {
        Scanner sc      = new Scanner(System.in); // một Scanner duy nhất cho cả chương trình
        Hospital hospital = new Hospital();

        while (true) {
            printMenu();
            System.out.print("Chon: ");
            String option = sc.nextLine().trim();

            switch (option) {

                case "1":
                    hospital.AddPatient(sc);
                    break;

                case "2":
                    hospital.AddDoctor(sc);
                    break;

                case "3":
                    hospital.Show();
                    break;

                case "4":
                    System.out.print("Nhap ID can tim: ");
                    String id = sc.nextLine();
                    hospital.FindById(id);
                    break;

                case "5":
                    handleAlgorithmMenu(sc, hospital);
                    break;

                case "6":
                    handleLeetCodeMenu(sc, hospital);
                    break;

                case "7":
                    System.out.println("Tam biet!");
                    sc.close();
                    return;

                default:
                    System.out.println("[Loi] Chon tu 1 den 7!");
            }
        }
    }

    // -------------------------------------------------------------------------
    // Sub-menu: Giải thuật
    // -------------------------------------------------------------------------

    /**
     * Sub-menu cho phần giải thuật cơ bản (Level 2).
     */
    private static void handleAlgorithmMenu(Scanner sc, Hospital hospital) {
        System.out.println("\n--- GIAI THUAT ---");
        System.out.println("A1. Tim bac si nhieu kinh nghiem nhat (theo chuyen khoa)");
        System.out.println("A2. Dem so benh nhan theo phong");
        System.out.print("Chon: ");
        String sub = sc.nextLine().trim().toUpperCase();

        switch (sub) {
            case "A1":
                // Thuật toán Max có điều kiện nhóm
                System.out.print("Nhap chuyen khoa (vd: Nhi / Noi / Ngoai): ");
                String specialty = sc.nextLine();
                hospital.FindMostExperiencedBySpecialty(specialty);
                break;

            case "A2":
                // Thuật toán Đếm có điều kiện
                System.out.print("Nhap so phong: ");
                try {
                    int room = Integer.parseInt(sc.nextLine().trim());
                    int cnt  = hospital.CountPatientsByRoom(room);
                    System.out.println("Phong " + room + " co " + cnt + " benh nhan.");
                } catch (NumberFormatException e) {
                    System.out.println("[Loi] So phong phai la so nguyen!");
                }
                break;

            default:
                System.out.println("[Loi] Chon A1 hoac A2!");
        }
    }

    // -------------------------------------------------------------------------
    // Sub-menu: LeetCode
    // -------------------------------------------------------------------------

    /**
     * Sub-menu cho 2 bài LeetCode Easy.
     */
    private static void handleLeetCodeMenu(Scanner sc, Hospital hospital) {
        System.out.println("\n--- LEETCODE ---");
        System.out.println("L1. #217 Contains Duplicate — kiem tra ID trung");
        System.out.println("L2. #268 Missing Number    — tim phong benh trong");
        System.out.print("Chon: ");
        String sub = sc.nextLine().trim().toUpperCase();

        switch (sub) {
            case "L1":
                // LeetCode #217: kiểm tra mảng ID có trùng không
                // Dùng nested loop O(n²) — so sánh từng cặp (i, j) với j > i
                hospital.CheckDuplicateIds();
                break;

            case "L2":
                // LeetCode #268: tìm số phòng thiếu trong dãy [1..maxRoom]
                // Công thức: missing = n*(n+1)/2 - sum(rooms[])
                System.out.print("Nhap so phong toi da cua benh vien (n): ");
                try {
                    int maxRoom = Integer.parseInt(sc.nextLine().trim());
                    hospital.ShowMissingRoom(maxRoom);
                } catch (NumberFormatException e) {
                    System.out.println("[Loi] Phai nhap so nguyen!");
                }
                break;

            default:
                System.out.println("[Loi] Chon L1 hoac L2!");
        }
    }

    // -------------------------------------------------------------------------
    // Helper
    // -------------------------------------------------------------------------

    private static void printMenu() {
        System.out.println("\n==============================");
        System.out.println("   QUAN LY BENH VIEN - Bai 9  ");
        System.out.println("==============================");
        System.out.println("1. Them benh nhan");
        System.out.println("2. Them bac si");
        System.out.println("3. Hien thi tat ca");
        System.out.println("4. Tim theo ID");
        System.out.println("5. Giai thuat (max theo nhom / dem theo phong)");
        System.out.println("6. LeetCode  (#217 trung ID / #268 phong trong)");
        System.out.println("7. Thoat");
        System.out.println("------------------------------");
    }
}
