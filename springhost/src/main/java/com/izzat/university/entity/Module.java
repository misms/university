package com.izzat.university.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    @Column(name = "module_name")
    String moduleName;
    @Column(name = "module_details")
    String moduleDetails;

    public Module(Module m)
    {
        this.moduleDetails = m.getModuleDetails();
        this.moduleName = m.getModuleName();
        this.id = m.getId();
    }
}