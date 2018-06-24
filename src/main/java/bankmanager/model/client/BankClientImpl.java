package bankmanager.model.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BankClientImpl implements BankClient{
    private static final Logger LOG = LoggerFactory.getLogger(BankClientImpl.class);

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(40)")
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String address;

    @Column(columnDefinition = "INT")
    private Integer age;

    public BankClientImpl(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankClientImpl)) return false;

        BankClientImpl that = (BankClientImpl) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(age, that.age)) return false;
        if (!name.equals(that.name)) return false;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "BankClientImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
