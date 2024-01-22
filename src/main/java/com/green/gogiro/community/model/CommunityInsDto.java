package com.green.gogiro.community.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
@Schema(title = "커뮤니티 등록 Dto")
public class CommunityInsDto {
    @JsonIgnore
    @Min(value = 1)
    private int iboard;
    @JsonIgnore
    private int iuser;
    @Schema(title = "제목")
    @NotBlank
    @Size(min = 1, max = 50, message = "50자 이상 작성 할 수 없습니다.")
    private String title;
    @Schema(title = "내용")
    @NotBlank
    @Size(min = 1, max = 300, message = "300자 이상 작성 할 수 없습니다.")
    private String contents;
    @Schema(title = "사진")
    private List<String> pics = new ArrayList<>();

    @JsonIgnore
    private List<MultipartFile> files;
}
