package com.vietlong.sandbox.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.time.LocalDate;

import com.vietlong.sandbox.model.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @GetMapping("/profile")
    public Employee getProfile() {
        return new Employee(
            1L,
            "Viet Long",
            LocalDate.of(2001, 1, 8),
            "Developer",
            "SECRET_123",              // Cái này sẽ bị ẩn đi
            Arrays.asList("Java", "Spring", "SQL", "TypeScript", "JavaScript", "React", "HTML", "CSS")
        );
    }

    @PostMapping("/update")
    public String updateProfile(@RequestBody Employee emp) {
        // Jackson tự động map JSON vào biến 'emp'
        return "Đã nhận nhân viên: " + emp.getFullName() + 
               ", Vị trí: " + emp.getPosition(); // Chú ý: position map từ 'job_role_xyz'
    }
}