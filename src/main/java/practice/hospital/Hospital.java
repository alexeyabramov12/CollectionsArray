package practice.hospital;

import java.text.DecimalFormat;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float random = ((float) (Math.random() * ((40 - 32) + 1) + 32));
        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            patientsTemperatures[i] = random;
        }
        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
        String patientsTemperatures = "";
        float averageTemperature = 0;
        float oneCharacter = (float) Math.pow(10, 1);
        float twoCharacter = (float) Math.pow(10, 2);
        int healthyPatients = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            patientsTemperatures = patientsTemperatures + Math.round(temperatureData[i] * oneCharacter) / oneCharacter + " ";
            averageTemperature = (averageTemperature + temperatureData[i]);
            if (temperatureData[i] > 36.2 && temperatureData[i] < 36.9
                    || temperatureData[i] > 36.9 && temperatureData[i] < 37.0
                    || temperatureData[i] < 36.2 && temperatureData[i] > 36.1) {
                healthyPatients++;
            }
        }


        String report =
                "Температуры пациентов: " + patientsTemperatures.trim() +
                        "\nСредняя температура: " + Math.round(averageTemperature / temperatureData.length * twoCharacter) / twoCharacter +
                        "\nКоличество здоровых: " + healthyPatients;

        return report;
    }
}
