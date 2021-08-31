package spring.challenge.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fshlcNm;
    private String fshlcType;
    private String rdnmadr;
    private String lnmadr;
    private String latitude;
    private String longitude;
    private String fshlcPhoneNumber;
    private String waterAr;
    private String kdfsh;
    private String aceptncCo;
    private String wtrcFcltyType;
    private String useCharge;
    private String mainPoint;
    private String safentl;
    private String cvntl;
    private String cfrTrrsrt;
    private String phoneNumber;
    private String institutionNm;
    private String referenceDate;
}
