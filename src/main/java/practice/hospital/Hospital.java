package practice.hospital;


public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            float random = ((float) (Math.random() * (40 - 32) + 32));
            patientsTemperatures[i] = random;
        }
        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        StringBuilder patientsTemperatures = new StringBuilder();
        float averageTemperature = 0;
        float oneCharacter = (float) Math.pow(10, 1);
        float twoCharacter = (float) Math.pow(10, 2);
        int healthyPatients = 0;
        for (float temperatureDatum : temperatureData) {
            patientsTemperatures.append(Math.round(temperatureDatum * oneCharacter) / oneCharacter).append(" ");
            averageTemperature = (averageTemperature + temperatureDatum);
            if (temperatureDatum >
                    36.2 && temperatureDatum < 36.9 || temperatureDatum > 36.9 && temperatureDatum < 37.0 || temperatureDatum < 36.2 && temperatureDatum > 36.1) {
                healthyPatients++;
            }
        }

        return "Patient temperatures: " + patientsTemperatures.toString().trim() +
                "\nAverage temperature: " + Math.round(averageTemperature / temperatureData.length * twoCharacter) / twoCharacter +
                "\nNumber of healthy: " + healthyPatients;
    }
}
