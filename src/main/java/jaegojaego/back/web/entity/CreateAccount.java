package jaegojaego.back.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
public class CreateAccount {

    @Id @Getter @Setter
    private String businessNumber;  //사업자 등록 번호
    @Getter @Setter
    private String businessname;    //대표자 성명
    @Getter @Setter
    private LocalDate openDate;     //개업일자
    @Getter @Setter
    private String shopName;    //상호
    @Getter @Setter
    private String shopAdress;  //매장주소
    @Getter @Setter
    private String email;   //이메일
    @Getter @Setter
    private String phoneNumber; //연락처
    @Getter @Setter
    private String id;  // 아이디
    @Getter @Setter
    private String pw;  // 비밀번호



}
