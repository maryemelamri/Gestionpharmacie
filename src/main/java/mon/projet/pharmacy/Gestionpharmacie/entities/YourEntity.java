package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "your_table_name")
public class YourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String columnName1;
    private String columnName2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnName1() {
        return columnName1;
    }

    public void setColumnName1(String columnName1) {
        this.columnName1 = columnName1;
    }

    public String getColumnName2() {
        return columnName2;
    }

    public void setColumnName2(String columnName2) {
        this.columnName2 = columnName2;
    }
}

