package org.example.model;


public class Dentist {
    private int id;
    private Long license;
    private String name;
    private String lastName;

    public Dentist(int id, Long license, String name, String lastName) {
        this.id = id;
        this.license = license;
        this.name = name;
        this.lastName = lastName;
    }

    public Dentist(Long license, String name, String lastName) {
        this.license = license;
        this.name = name;
        this.lastName = lastName;
    }

    public Dentist(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getLicense() {
        return license;
    }

    public void setLicense(Long license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", license=" + license +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
