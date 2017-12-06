package beans;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Agent {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String licenseNumber;
    private String phoneNumber;
    private String education;
    private String company;
    private String website;
    private boolean userStatus;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Agent getFromXml(String fileName) {
        XMLInputFactory f = XMLInputFactory.newInstance();
        File file = new File(fileName);
        XMLStreamReader streamReader = null;
        XmlMapper mapper = new XmlMapper();

        try {
            streamReader = f.createXMLStreamReader(new FileInputStream(file));
        } catch (XMLStreamException e) {
            //TODO: log error
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            return mapper.readValue(streamReader, Agent.class);
        } catch (IOException e) {
            //TODO: log error
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return userStatus == agent.userStatus &&
                Objects.equals(email, agent.email) &&
                Objects.equals(firstName, agent.firstName) &&
                Objects.equals(lastName, agent.lastName) &&
                Objects.equals(password, agent.password) &&
                Objects.equals(licenseNumber, agent.licenseNumber) &&
                Objects.equals(phoneNumber, agent.phoneNumber) &&
                Objects.equals(education, agent.education) &&
                Objects.equals(company, agent.company) &&
                Objects.equals(website, agent.website);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, firstName, lastName, password, licenseNumber, phoneNumber, education, company, website, userStatus);
    }
}
