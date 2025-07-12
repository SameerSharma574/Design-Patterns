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
        PeopleXMLBuilder builder = new PeopleXMLBuilder();
        builder.add("<People number=\"")
            .add(persons.size())
            .add("\">");

        for (Person person : persons) {
            builder.add(person);
        }
        builder.add("</People>");
        return builder.build();
    }
}