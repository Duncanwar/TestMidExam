/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author duncan
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book implements Serializable{
    @Id
    @Column(unique=true, nullable=false)
    private String isbn;
    private String title;
    private String authors;
    private String publicationYear;
    private LocalDate recordingDate ;
    private Double purchasingPrice;
    private Double sellingPrice;
    private String category;
    @Enumerated(value = EnumType.STRING)
    private BookStatus status;
    @ManyToOne
    private User borrowedBy;
}

enum BookStatus{
    BORROWED, IN_HOUSE;
}