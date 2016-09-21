package com.vaadin.tests.components.datefield;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.tests.components.TestBase;
import com.vaadin.tests.components.TestDateField;
import com.vaadin.ui.AbstractDateField;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;

public class DateFieldMinResolution extends TestBase {

    @Override
    protected void setup() {

        final SimpleDateFormat dformat = new SimpleDateFormat(
                "dd/MM/yyyy HH:mm");

        Calendar cal = Calendar.getInstance();
        cal.set(2019, 1, 1, 1, 1);

        AbstractDateField df = new TestDateField("foo");
        df.setResolution(Resolution.MINUTE);
        df.setDateFormat(dformat.toPattern());
        df.setValue(cal.getTime());
        df.setImmediate(true);

        addComponent(df);

        final Label lbl = new Label(dformat.format(cal.getTime()));
        lbl.setCaption("Selected date");

        InlineDateField idf = new InlineDateField("bar");
        idf.setResolution(Resolution.MINUTE);
        idf.setDateFormat(dformat.toPattern());
        idf.setValue(cal.getTime());
        idf.setImmediate(true);

        idf.addValueChangeListener(
                event -> lbl.setValue(dformat.format(event.getValue())));

        addComponent(idf);
        addComponent(lbl);
    }

    @Override
    protected String getDescription() {
        return "When the time controls are visible the time should be directed directly to the textfield";
    }

    @Override
    protected Integer getTicketNumber() {
        return 5387;
    }

}
