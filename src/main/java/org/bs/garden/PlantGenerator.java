package org.bs.garden;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.bs.garden.action.DaysFromFirstFrost;
import org.bs.garden.action.DaysFromLastFrost;
import org.bs.garden.action.Direction;
import org.bs.garden.action.FixedMonthDay;
import org.bs.garden.action.SoilTemperature;
import org.joda.time.MonthDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author bsneade
 */
public class PlantGenerator {
    
    private static final Logger LOG = LoggerFactory.getLogger(PlantGenerator.class);
    
    private final ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JodaModule());

    public static void main(final String[] args) {
        final PlantGenerator plantGenerator = new PlantGenerator();
        plantGenerator.generateBean();
        plantGenerator.generateBroadBean();
        plantGenerator.generateCabbage();
        plantGenerator.generateMelon();
        plantGenerator.generatePea();
    }
    
    private void write(final String prefix, final Object object) {
        try {
            final ObjectWriter objectWriter = objectMapper.writer().with(SerializationFeature.INDENT_OUTPUT);
            final File melonFile = File.createTempFile(prefix + "-", ".json");
            LOG.info("Writing {}", melonFile.getAbsolutePath());
            objectWriter.writeValue(melonFile, object);
            LOG.debug(objectWriter.writeValueAsString(object));
        } catch (final IOException ioe) {
            LOG.error("Could not write file for " + prefix, ioe);
        }
    }
    
    public void generateMelon() {
        final Plant melonPlant = new Plant();
        melonPlant.setName("Melon");
        
        {
            final SoilTemperature soilTemperature = new SoilTemperature("Sow", 18.3333d, Direction.GREATER_THAN);
            soilTemperature.setDescription("Sow seeds in spring when soil temperature reaches 18.3C (65F).  Plant on "
                    + "hills 4 to 5 feet apart, or in rows 5 to 6 feet apart with plants 2 feet asunder.");
            melonPlant.addAction(soilTemperature);
        }
        
        write("melon", melonPlant);
    }
    
    public void generatePea() {
        final Plant peaPlant = new Plant();
        peaPlant.setName("Pea");
        
        {
            final SoilTemperature soilTemperature = new SoilTemperature("Sow", 5d, Direction.GREATER_THAN);
            soilTemperature.setDescription("Sow the seeds as early as the soil can be worked.");
            peaPlant.addAction(soilTemperature);
        }
        
        write("pea", peaPlant);
    }
    
    public void generateBean() {
        final Plant plant = new Plant();
        plant.setName("Bean");
        
        {
            final DaysFromLastFrost daysFromLastFrost = new DaysFromLastFrost("Sow", 1);
            plant.addAction(daysFromLastFrost);
        }
        
        write("bean", plant);
    }
    
    public void generateCabbage() {
        final Plant plant = new Plant();
        plant.setName("Cabbage");
        
        {
            //set up the spring sow
            final DaysFromLastFrost daysFromLastFrost = new DaysFromLastFrost("Sow", 5*7* -1); //4-6 weeks before
            plant.addAction(daysFromLastFrost);
        }
        {
            //set up the fall sow
            final FixedMonthDay fixedMonthDay = new FixedMonthDay("Sow", MonthDay.parse("--09-12")); //late summer - 9/22 is the equinox, do a few days before hand
            plant.addAction(fixedMonthDay);
        
        }
        
        //TODO - need a transplant
        
        {
            //set up the fall harvest
            final DaysFromFirstFrost daysFromFirstFrost = new DaysFromFirstFrost("Sow", 2); //after the first frost
            plant.addAction(daysFromFirstFrost);
        }
        
        write("cabbage", plant);
    }
    
    public void generateBroadBean() {
        final Plant broadBeanPlant = new Plant();
        broadBeanPlant.setName("Broad Bean");
        
        {
            final FixedMonthDay fixedMonthDay = new FixedMonthDay("Sow", MonthDay.parse("--11-20"));
            fixedMonthDay.setZones(Arrays.asList("6a", "6b",
                    "7a", "7b",
                    "8a", "8b",
                    "9a", "9b",
                    "10a", "10b",
                    "11a", "11b",
                    "12a", "12b",
                    "13a", "13b"
                    ));
            broadBeanPlant.addAction(fixedMonthDay);
        }
        {
            final SoilTemperature soilTemperature = new SoilTemperature("Sow", 5d, Direction.GREATER_THAN);
            soilTemperature.setZones(Arrays.asList("1a", "1b",
                    "2a", "2b",
                    "3a", "3b",
                    "4a", "4b",
                    "5a", "5b",
                    "6a", "6b"
                    ));
            broadBeanPlant.addAction(soilTemperature);
        }
        
        write("broadBean", broadBeanPlant);
    }
}
