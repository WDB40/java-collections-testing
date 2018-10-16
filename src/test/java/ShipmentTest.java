import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ShipmentTest {

    private Shipment shipment = new Shipment();

    @Test
    public void shouldAddItems() throws Exception{

        shipment.add(ProductFixtures.door);
        shipment.add(ProductFixtures.window);

        assertThat(shipment, contains(ProductFixtures.door, ProductFixtures.window));
    }

    @Test
    public void shouldReplaceItems() throws Exception{
        shipment.add(ProductFixtures.door);
        shipment.add(ProductFixtures.window);

        shipment.replace(ProductFixtures.door, ProductFixtures.floorPanel);

        assertThat(shipment, contains(ProductFixtures.floorPanel, ProductFixtures.window));
    }

    @Test
    public void shouldNotReplaceMissingItems() throws Exception {

        shipment.add(ProductFixtures.window);

        shipment.replace(ProductFixtures.door, ProductFixtures.floorPanel);

        assertThat(shipment, contains(ProductFixtures.window));
    }

    @Test
    public void shouldIdentifyVanRequirements() throws Exception {

        shipment.add(ProductFixtures.door);
        shipment.add(ProductFixtures.window);
        shipment.add(ProductFixtures.floorPanel);

        shipment.prepare();

        assertThat(shipment.getLightVanProducts(), contains(ProductFixtures.window));
        assertThat(shipment.getHeavyVanProducts(), contains(ProductFixtures.floorPanel, ProductFixtures.door));
    }

}