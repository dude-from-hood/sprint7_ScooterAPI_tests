package courier;
import org.apache.commons.lang3.RandomStringUtils;

//Класс CourierGenerator отвечает за генерацию объектов курьера (Courier) с разными параметрами.
// Он содержит два метода: generic & random
public class CourierGenerator {
    public Courier generic() {
        return new Courier("Pavel", "1234", "Durov");
    }

    public Courier random() {
        return new Courier(RandomStringUtils.randomAlphanumeric(10), "1234", "Durov");
    }
}
