package com.example.luxoft.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nacl_data")
public class NaceDetail {

    @CsvBindByName(column = "Order")
    @Id
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "level_id")
    @CsvBindByName(column = "Level")
    private String levelId;

    @Column(name = "code")
    @CsvBindByName(column = "Code")
    private String code;

    @Column(name = "parent")
    @CsvBindByName(column = "Parent")
    private String parent;

    @Column(name = "description")
    @CsvBindByName(column = "Description")
    private String description;

    @Column(name = "this_item_includes")
    @CsvBindByName(column = "This item includes")
    private String thisItemIncludes;

    @Column(name = "this_item_also_includes")
    @CsvBindByName(column = "This item also includes")
    private String thisItemAlsoIncludes;

    @Column(name = "rulings")
    @CsvBindByName(column = "Rulings")
    private String rulings;

    @Column(name = "this_item_excludes")
    @CsvBindByName(column = "This item excludes")
    private String thisItemExcludes;

    @Column(name = "reference_to_isic")
    @CsvBindByName(column = "Reference to ISIC Rev. 4")
    private String referenceToIsic;

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        return ((NaceDetail) o).orderId == (this.orderId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(orderId);
    }

}
