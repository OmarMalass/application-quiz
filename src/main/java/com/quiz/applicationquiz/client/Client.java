package com.quiz.applicationquiz.client;

import com.quiz.applicationquiz.sale.model.Sale;
import com.quiz.applicationquiz.sale.model.Transaction;
import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Table(name = "CLIENT")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private long ID;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<Sale> purchases = new ArrayList<>();
}
