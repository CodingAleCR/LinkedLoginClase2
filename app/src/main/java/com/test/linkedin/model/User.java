package com.test.linkedin.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.hannesdorfmann.parcelableplease.annotation.ParcelablePlease;

/**
 * Created by chris on 1/19/17.
 */

@ParcelablePlease
public class User implements Parcelable{

    protected String firstName;
    protected String lastName;
    protected String country;
    protected String profession;
    protected String interest;
    protected String email;
    protected String skills;
    protected String imageURL;

    public User() {
    }

    public User(String firstName, String lastName, String country, String profession, String interest, String email, String skills, String imageURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.profession = profession;
        this.interest = interest;
        this.email = email;
        this.skills = skills;
        this.imageURL = imageURL;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null)
            return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null)
            return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (profession != null ? !profession.equals(user.profession) : user.profession != null)
            return false;
        if (interest != null ? !interest.equals(user.interest) : user.interest != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (skills != null ? !skills.equals(user.skills) : user.skills != null) return false;
        return imageURL != null ? imageURL.equals(user.imageURL) : user.imageURL == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        result = 31 * result + (interest != null ? interest.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + (imageURL != null ? imageURL.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", profession='" + profession + '\'' +
                ", interest='" + interest + '\'' +
                ", email='" + email + '\'' +
                ", skills='" + skills + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }


    @Override public int describeContents() {
        return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
        UserParcelablePlease.writeToParcel(this, dest, flags);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        public User createFromParcel(Parcel source) {
            User target = new User();
            UserParcelablePlease.readFromParcel(target, source);
            return target;
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };



}
