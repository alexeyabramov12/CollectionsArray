import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice.hospital.Hospital;

@DisplayName("Операции с массивами - получение среднего значения")
class HospitalTest {

    private static final float[] testHospitalData = new float[]{
        32.1F, 33.1F, 32.5F, 33.5F, 34.5F, 36.5F, 38.5F, 39.5F, 33.3F, 32.7F,
        36.9F, 36.5F, 34.3F, 37.5F, 32.5F, 32.5F, 32.4F, 34.5F, 35.4F, 32.5F,
        34.5F, 39.4F, 32.5F, 36.5F, 36.4F, 39.6F, 37.5F, 32.5F, 37.5F, 39.4F
    };

    @BeforeAll
    static void setUp() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Генерируемый массив не содержит температуры за рамками заданных предельных значений")
    void testCollectDataContainsCorrectEntries() {
        float[] testHospitalData = Hospital.generatePatientsTemperatures(100);
        long amountCorrectTemperatures = IntStream.range(0, testHospitalData.length)
            .mapToDouble(i -> testHospitalData[i])
            .filter(t -> t >= 32.)
            .filter(t -> t <= 40.)
            .count();

        assertEquals(100L, amountCorrectTemperatures,
            "Температуры выходят за предельные значения, actual - количество температур в требуемых диапазонах");
    }

    @DisplayName("Массив температур содержит переданное количество значений температур")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 10, 30, 500})
    void testTemperatureArrayLength(int countPatients) {
        int actual = Hospital.generatePatientsTemperatures(countPatients).length;
        assertEquals(countPatients, actual,
            String.format("Массив содержит %s элементов, а ожидается %s%n", actual, countPatients));
    }

    @Test
    @DisplayName("Метод корректно считает среднюю температуру и количество здоровых пациентов")
    void testGetReport() {
        String temperatures = String.join(" ",
            IntStream.range(0, testHospitalData.length)
                .mapToObj(i -> String.valueOf(testHospitalData[i])).toArray(String[]::new));

        String expected = "Patient temperatures: " + temperatures + System.lineSeparator() +
                          "Average temperature: 35.23" + System.lineSeparator() +
                          "Number of healthy: 5";

        assertEquals(expected, Hospital.getReport(testHospitalData)
                .replaceAll("\r\n", "\n")
                .replaceAll("\n", System.lineSeparator()),
            "Проверьте формат вывода, округление средней температуры и количество здоровых пациентов");
    }
}