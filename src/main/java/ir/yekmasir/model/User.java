package ir.yekmasir.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Emertat
 * Date: 11/21/14
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;
    @Column(name = "Surame")
    private String Family;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }
}
