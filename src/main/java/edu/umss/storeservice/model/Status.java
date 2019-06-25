package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.StatusDto;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "status")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "GetAllStatus",
                procedureName = "GetAllStatus",
                resultClasses = Status.class
        ),
        @NamedStoredProcedureQuery(
                name = "DeletestatusById",
                procedureName = "DeletestatusById",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "GetstatusById",
                procedureName = "GetstatusById",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class)
                },
                resultClasses = Status.class
        ),
        @NamedStoredProcedureQuery(
                name = "SaveStatus",
                procedureName = "SaveStatus",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "createdAt", type = Date.class),

                },
                resultClasses = Status.class
        )
})
public class Status extends ModelBase<StatusDto>{
    private String name;


    @Basic
    @Column(name = "name", nullable = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(name, status.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name);
    }
}

