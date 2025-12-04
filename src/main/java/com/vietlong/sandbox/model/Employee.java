package com.vietlong.sandbox.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Schema(description = "Employee model chứa thông tin nhân viên")
public class Employee {

    @Schema(description = "ID của nhân viên", example = "1")
    private Long id;

    @Schema(description = "Họ và tên nhân viên", example = "Viet Long")
    private String fullName;

    @Schema(description = "Ngày sinh dạng yyyy-MM-dd (ISO format)", example = "08/01/2001", type = "string", format = "date")
    private LocalDate dateOfBirth;

    @JsonProperty("job_role_xyz")
    @Schema(description = "Vị trí (job_role trên hệ thống cũ)", example = "Developer")
    private String position;

    @JsonIgnore
    @Schema(description = "Mã lương nội bộ (không xuất ra JSON)", accessMode = Schema.AccessMode.READ_ONLY, hidden = true)
    private String internalSalaryCode;

    @Schema(description = "Danh sách kỹ năng", example = "[\"Java\", \"Spring\", \"SQL\", \"TypeScript\", \"JavaScript\", \"React\", \"HTML\", \"CSS\"]")
    private List<String> skills;

}