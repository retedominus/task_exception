package model;

public class PersonalData {
    private final String surname;
    private final String patronymic;
    private final String name;
    private final String dateOfBirth;
    private final long phoneNumber;
    private final char gender;

    public PersonalData(String surname, String patronymic, String name, String dateOfBirth,
                        long phoneNumber, char gender) {
        this.surname = surname;
        this.patronymic = patronymic;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return surname + " " + patronymic + " " + name + " " + dateOfBirth + " " + phoneNumber +
                " " + gender;
    }
}
