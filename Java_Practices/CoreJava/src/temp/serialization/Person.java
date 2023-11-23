package temp.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {

    private int id;
    private String name;
    private String email;
    private String contact;
    private String address;
    private String password;
    private Boolean isAdmin;

    public Person() {
    }

    public Person(int id, String name, String email, String contact, String address, String password, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(email);
        out.writeObject(contact);
        out.writeObject(address);
        out.write(id);
        out.writeBoolean(isAdmin);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        email = (String) in.readObject();
        contact = (String) in.readObject();
        address = (String) in.readObject();
        id = in.read();
        isAdmin = in.readBoolean();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
