package com.example.testTask.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "credit_bureau")
public class CreditBureau {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_bureau_id_generator")
    @SequenceGenerator(name = "credit_bureau_id_generator", sequenceName = "sq_credit_bureau_id", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String accountNumber;
    private String accountStatus;
    private BigDecimal currentBalance;
    private String dateOpened;
    private Integer daysInArrears;
    private String delinquencyCode;
    private Integer highestDaysInArrears;
    private Boolean isYourAccount;
    private BigDecimal lastPaymentAmount;
    private String lastPaymentDate;
    private String loadedAt;
    private BigDecimal originalAmount;
    private BigDecimal overdueBalance;
    private String overdueDate;
    private Integer productTypeId;

    @ManyToOne
    @JoinColumn(name = "reg_person_id")
    private RegPerson regPerson;
}

