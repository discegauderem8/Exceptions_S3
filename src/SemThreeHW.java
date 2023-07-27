import java.io.*;
import java.util.Scanner;

public class SemThreeHW {
    public static void main(String[] args) throws Exception {
        int result = 0;
        System.out.println("Введите ваши данные через пробел в формате: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
        try (Scanner scanner = new Scanner(System.in)) {
            String data = scanner.nextLine();
            String[] dataParsed = data.split(" ");
            if (dataParsed.length < 6) {
                result = -1;
            } else if (dataParsed.length > 6) {
                result = -2;
                throw new ArrayIndexOutOfBoundsException("Вы ввели слишком много данных");
            }
            String surname = dataParsed[0];
            String name = dataParsed[1];
            String patronymic = dataParsed[2];
            String dob = dataParsed[3];
            int phoneNumber = Integer.parseInt(dataParsed[4]);
            char gender = dataParsed[5].charAt(0);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(surname, true))) {
                bw.newLine();
                bw.write(surname + " ");
                bw.write(name + " ");
                bw.write(patronymic + " ");
                bw.write(dob + " ");
                bw.write(phoneNumber + " ");
                bw.write(gender);
                bw.flush();
            } catch (IOException e) {
                System.out.println("Ошибка при запись в файл типа: " + e.getMessage());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Произошла ошибка типа: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Ошибка! Вы ввели пустое значение: " + e.getMessage());
            result = -3;
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Вы ввели не число:" + e.getMessage());
            result = -3;
        } finally {
            if (result == -1) {
                System.out.println("Пояснение: вы ввели меньше данных, чем требуется. Код ошибки: " + result);
            } else if (result == -2) {
                System.out.println("Вы ввели больше данных, чем требуется. Код ошибки: " + result);
            } else if (result == -3){
                System.out.println("Вы ввели некорректные значения. Код ошибки: " + result);
            }
            else System.out.println("Успешно завершено. Код: " + result);
        }
    }
}
