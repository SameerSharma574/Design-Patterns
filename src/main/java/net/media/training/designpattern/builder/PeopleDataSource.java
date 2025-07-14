package net.media.training.designpattern.builder;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: path
 * Date: Jul 19, 2011
 * Time: 10:04:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleDataSource {
    public static String getPeopleXml(List<Person> persons) {
        XMLBuilder builder = new XMLBuilder();
        builder.startElement("People")
            .addAttribute("number", persons.size());

        persons.forEach(person -> addPerson(builder, person));
        builder.endElement();
        return builder.build();
    }

    private static void addPerson(XMLBuilder xmlBuilder, Person person) {
        xmlBuilder
            .startElement("Person")
            .addAttribute("id", String.valueOf(person.getId()))
            .addAttribute("name", person.getName())
            .startElement("Address")
            .startElement("City")
            .addText(person.getCity())
            .endElement()
            .startElement("Country")
            .addText(person.getCountry())
            .endElement()
            .endElement() // ends Address
            .endElement();
    }
}