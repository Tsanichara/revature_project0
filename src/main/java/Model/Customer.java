package Model;

import java.util.Objects;

public class Customer {
    int id;
    String f_name;


    public Customer(int id, String f_name) {
        this.id = id;
        this.f_name = f_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", f_name='" + f_name + '\''  +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(f_name, customer.f_name);
    }


}
