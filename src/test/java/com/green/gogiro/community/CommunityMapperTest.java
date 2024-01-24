package com.green.gogiro.community;

import com.green.gogiro.common.Const;
import com.green.gogiro.community.model.CommunityDelDto;
import com.green.gogiro.community.model.CommunityInsDto;
import com.green.gogiro.community.model.CommunityUpdDto;
import com.green.gogiro.user.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CommunityMapperTest {
    @Autowired
    private CommunityMapper mapper;

    @Autowired
    private UserMapper userMapper;


    @Test
    void insCommunity() {
        int iuser = userMapper.selIuserForTest();
        CommunityInsDto dto = new CommunityInsDto();
        dto.setIuser(iuser);
        String title = "제목";
        dto.setTitle(title);
        String contents = "내용";
        dto.setContents(contents);
        List<String> pics = new ArrayList<>();
        pics.add("aa");
        pics.add("bb");
        dto.setPics(pics);

        assertEquals(Const.SUCCESS, mapper.insCommunity(dto));
        assertTrue(dto.getIboard() > 0);

        assertEquals(pics.size(), mapper.insCommunityPics(dto));

    }

    @Test
    void updCommunity() {
        CommunityUpdDto dto = mapper.selIuserIboardForTest();
        String title = "제목";
        dto.setTitle(title);
        String contents = "내용";
        dto.setContents(contents);

        List<String> pics = new ArrayList<>();
        pics.add("aa");
        pics.add("bb");
        dto.setPics(pics);

        assertEquals(Const.SUCCESS, mapper.updCommunity(dto));
        assertEquals(pics.size(), mapper.insCommunityPics(dto));

        List<Integer> icommuPics = new ArrayList<>();
    }

    @Test
    void delCommunityPic() {

    }

    @Test
    void selCommunityCount() {
    }

    @Test
    void beforeTitleNextTitle() {
    }

    @Test
    void selCommunityPics() {
    }

    @Test
    void selCommunity() {
    }

    @Test
    void selByCommunityPics() {
    }

    @Test
    void selPicCommunity() {
    }

    @Test
    void selCommunityComments() {
    }

    @Test
    void selDetailCommunity() {
    }

    @Test
    void entityCommunity() {
    }

    @Test
    void delCommunity() {
    }

    @Test
    void testDelCommunityPic() {
    }

    @Test
    void delCommunityAllComment() {
    }

    @Test
    void checkCommunity() {
    }

    @Test
    void insCommunityComment() {
    }

    @Test
    void delCommunityComment() {
    }
}