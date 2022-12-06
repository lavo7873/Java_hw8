// Lam Vinh Vong

class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String ssn;
    private Address address;

    public Person() {
        firstName = "";
        lastName = "";
        age = 0;
        ssn = "";
        address = new Address();
    }

    public Person(String firstName, String lastName, int age, String ssn, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", ssn='" + ssn + '\'' +
                ", address=" + address +
                '}';
    }
}
