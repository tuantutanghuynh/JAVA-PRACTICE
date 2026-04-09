/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practiceday7;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 *
 * @author tangh
 */
public class DemoDateTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dt);

        // format
        System.out.println(date.plusDays(5));

        Clock clock = Clock.systemDefaultZone();
        Instant now = clock.instant();
        System.out.println("now: " + now);

        Clock vnClock = Clock.system(ZoneId.of("Asia/Ho_Chi_Minh"));
        Clock usClock = Clock.system(ZoneId.of("America/New_York"));
        System.out.println("VN time: " + vnClock.instant());
        System.out.println("US time: " + usClock.instant());
    }
}
