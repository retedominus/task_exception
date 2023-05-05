import model.PersonalData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчетство дата_рождения номер_телефона пол:");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if(data.length != 6) {
            System.err.println("Введено неверное количество данных!");
            System.exit(1);
        }

        String surname = data[0];
        String patronymic = data[2];
        String name = data[1];
        String dateOfBirth = data[3];
        long phoneNumber;
        char gender;

        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона");
            System.exit(1);
            return;
        }

        if (!data[5].equals("f") && !data[5].equals("m")) {
            System.err.println("Введено неверное обозначение пола (f/m)!");
            System.exit(1);
        }
        gender = data[5].charAt(0);

        PersonalData personalData = new PersonalData(surname, patronymic, name, dateOfBirth, phoneNumber, gender);
        String fileName = surname + ".txt";
        File file = new File(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            if(file.exists()) {
                writer.newLine();
            }
            writer.write(personalData.toString());
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл.");
            e.printStackTrace();
        }
    }
}

