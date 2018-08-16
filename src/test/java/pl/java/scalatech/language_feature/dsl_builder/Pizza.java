package pl.java.scalatech.language_feature.dsl_builder;

import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import java.util.function.Consumer;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class Pizza {

    private PieType pieType;

    private List<Cheese> cheese = newArrayList();

    private List<String> indigrients = newArrayList();

    Pizza makePie(PieType type) {
        this.pieType = type;
        log.info("make pie {}", type);
        return this;
    }

    Pizza addMozarella(Cheese cheese) {
        this.cheese.add(cheese);
        log.info("add mozarella");
        return this;
    }

    Pizza addHam() {
        this.indigrients.add("ham");
        log.info("add ham");
        return this;
    }

    Pizza addMashrums() {
        this.indigrients.add("mashrums");
        log.info("add mashrums");
        return this;
    }

    Pizza executeOrder() {
        log.info("execute order");
        return this;
    }

    public static void make(Consumer<Pizza> cons) {
        log.info("++++ make..{}");
        Pizza pizza = new Pizza();
        cons.accept(pizza);
    }

}
