package com.Veggies.Application.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document
public class Vegetable implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;

    @Id
    String vegname;

    String price,quantity,expiry;



}
