package com.chuwa.vaccinationcenter.model;

import com.chuwa.vaccinationcenter.entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequireResponse {

    private VaccinationCenter center;
    private List<Citizen> citizens;

}
